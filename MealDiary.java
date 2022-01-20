import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MealDiary implements MealDiaryInterface{
    protected int mealID;
    protected String foodGroup;
    protected String imgPath;
    protected String mealType;
    protected String mealName;
    protected String dateCreated;
    protected String dayCreated;
    protected String drinkName;

    MealDiary(){
        mealID = 0;
        foodGroup = null;
        imgPath = null;
        mealType = null;
        mealName = null;
        dateCreated = null;
        dayCreated = null;
        drinkName = null;
    }

    public void setMealID(int mealID) {
        this.mealID = mealID;
    }

    //Function to set path to retrieve meal info()
    public void setImgPath(String imgPath){
        this.imgPath = imgPath;
    }

    //Function to set path for createMeal()
    public void setImgPath() {
        String imgPath = "";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
        fileChooser.addChoosableFileFilter(filter);

        int result = fileChooser.showSaveDialog(null);

        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = fileChooser.getSelectedFile();
            imgPath = selectedFile.getAbsolutePath();
            this.imgPath = imgPath;
        }
        else if(result == JFileChooser.CANCEL_OPTION){
            this.imgPath = getImgPath();
        }
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }
    public void setMealType(String mealType) {
        this.mealType = mealType;
    }
    public void setFoodGroup(String foodGroup) {
        this.foodGroup = foodGroup;
    }
    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }
    //created for manual taken date instead of current date
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
    public void setDayCreated(String dayCreated){
        this.dayCreated = dayCreated;
    }

    public int getMealID() {
        return mealID;
    }
    public String getMealName() {
        return mealName;
    }
    public String getFoodGroup() {
        return foodGroup;
    }
    public String getDrinkName() {
        return drinkName;
    }
    public String getMealType() {
        return mealType;
    }
    public String getDateCreated() {
        return dateCreated;
    }
    public String getDayCreated() {
        return dayCreated;
    }
    public String getImgPath() {
        return imgPath;
    }

    public boolean createMeal(int userID, String imgPath, String mealName, String mealType, String foodGroup, String dateCreated, String dayCreated, String drink){
        MyConnection newCon = new MyConnection(); //Create new MyConnection object to connect with database
        boolean addMealStatus = false;
        try
        {
            // the mysql insert statement
            String query = "insert into meals (image, mealName, mealType, foodGroup, dateCreated, dayCreated, drinkName, userID)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?)";

            //Read img from input stream using image path
            InputStream mealImg = new FileInputStream(new File(imgPath));

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = newCon.connectDB().prepareStatement(query);
            preparedStmt.setBlob (1, mealImg);
            preparedStmt.setString (2, mealName);
            preparedStmt.setString (3, mealType);
            preparedStmt.setString (4, foodGroup);
            preparedStmt.setString (5, dateCreated);
            preparedStmt.setString (6, dayCreated);
            preparedStmt.setString (7, drink);
            preparedStmt.setInt (8, userID);

            // execute the preparedstatement
            preparedStmt.execute();

            //change addMealStatus to true for a successful query
            addMealStatus = true;

            //close connection
            newCon.connectDB().close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return addMealStatus;
    }

    //Set meal details
    public boolean getMealDetails(int mealID){
        MyConnection newCon = new MyConnection(); //Create new MyConnection object to connect with database
        boolean getMealQuery = false;

        try{
            Statement stat = newCon.connectDB().createStatement();
            String sql = "select * from meals";
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                int selectedMealID = rs.getInt("mealID");
                if (selectedMealID == mealID){
                    //Set image path by saving the img locally from the database
                    File f = new File("img\\" + rs.getInt("mealID") + rs.getString("mealName") + ".JPG"); //image name by userID and mealName combination
                    String filename = f.getAbsolutePath(); //Will return full path to the img file

                    Blob imageBlob = rs.getBlob("image");
                    int blobLength = (int) imageBlob.length();
                    byte[] blobAsBytes = imageBlob.getBytes(1, blobLength);

                    //Save the image following variable filename path
                    BufferedImage image = ImageIO.read(new ByteArrayInputStream(blobAsBytes));
                    ImageIO.write(image, "JPEG", new File(filename));

                    //Set attribute data
                    setImgPath(filename); //Set imgPath
                    setMealID(rs.getInt("mealID"));
                    setMealName(rs.getString("mealName"));
                    setMealType(rs.getString("mealType"));
                    setFoodGroup(rs.getString("foodGroup"));
                    setDateCreated(rs.getString("dateCreated"));
                    setDayCreated(rs.getString("dayCreated"));
                    setDrinkName(rs.getString("drinkName"));

                    //change addMealQuery to true for a successful query
                    getMealQuery = true;
                }
            }
            //close connection
            newCon.connectDB().close();
        }catch (SQLException | IOException err){
            System.err.println("Got an exception!");
            System.err.println(err.getMessage());
        }
        return getMealQuery;
    }

    //Update meal picture
    public boolean updateMeal(String imgPath, int userID, int mealID){
        MyConnection newCon = new MyConnection(); //Create new MyConnection object to connect with database
        boolean updateStatus = false;
        try {
            // the mysql insert statement
            String query = "update meals " + "SET image = ? " + "WHERE userID = ? and mealID = ?";

            //Read img from input stream using image path
            InputStream mealImg = new FileInputStream(new File(imgPath));

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = newCon.connectDB().prepareStatement(query);
            preparedStmt.setBlob (1, mealImg);
            preparedStmt.setInt (2, userID);
            preparedStmt.setInt (3, mealID);

            // execute the preparedstatement
            preparedStmt.execute();

            //change updateStatus to true for a successful query
            updateStatus = true;

            //close databases
            newCon.connectDB().close();

        }catch (SQLException | FileNotFoundException err){
            System.err.println("Got an exception!");
            System.err.println(err.getMessage());
        }

        return updateStatus;
    }

    //Update meal description
    public boolean updateMeal(int userID, int mealID, String mealName, String mealType, String foodGroup, String dateCreated, String dayCreated, String drink){
        MyConnection newCon = new MyConnection(); //Create new MyConnection object to connect with database
        boolean updateStatus = false;
        try {
            // the mysql insert statement
            String query = "update meals " + "SET mealName = ?, mealType = ?, foodGroup = ?, dateCreated = ?, dayCreated = ?, drinkName = ? "
                    + "WHERE userID = ? and mealID = ?";

            //update class attribute
            setMealName(mealName);
            setMealType(mealType);
            setFoodGroup(foodGroup);
            setDateCreated(dateCreated);
            setDayCreated(dateCreated);
            setDrinkName(drink);

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = newCon.connectDB().prepareStatement(query);
            preparedStmt.setString (1, mealName);
            preparedStmt.setString (2, mealType);
            preparedStmt.setString (3, foodGroup);
            preparedStmt.setString (4, dateCreated);
            preparedStmt.setString (5, dayCreated);
            preparedStmt.setString (6, drink);
            preparedStmt.setInt (7, userID);
            preparedStmt.setInt (8, mealID);

            // execute the preparedstatement
            preparedStmt.execute();

            //change updateStatus to true for a successful query
            updateStatus = true;

            //close databases
            newCon.connectDB().close();

        }catch (SQLException err){
            System.err.println("Got an exception!");
            System.err.println(err.getMessage());
        }

        return updateStatus;
    }

    public boolean deleteMeal(int userID, int mealID){
        MyConnection newCon = new MyConnection(); //Create new MyConnection object to connect with database
        boolean deleteMealStatus = false;
        try {
            String sql = "delete from meals " + "WHERE userID = ? and mealID = ?";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = newCon.connectDB().prepareStatement(sql);
            preparedStmt.setInt (1, userID);
            preparedStmt.setInt (2, mealID);

            // execute the preparedstatement
            preparedStmt.execute();

            //change updateStatus to true for a successful query
            deleteMealStatus = true;

            //close databases
            newCon.connectDB().close();

        }catch (SQLException err){
            System.err.println("Got an exception!");
            System.err.println(err.getMessage());
        }

        return deleteMealStatus;
    }

    //Function to display meal list for each user using JTable aka search and filter function
    public void searchMealList(int userID, String foodGroupSelect, String mealTypeSelect, JTable displayTable, JLabel totalMeal){
        MyConnection newCon = new MyConnection(); //Create new MyConnection object to connect with database
        String[] columnNames = {"ID","Meal Name", "Type", "Food Group", "Date", "Day", "Drink Name"};

        //Set editable cell to false
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        model.setColumnIdentifiers(columnNames);
        displayTable.setModel(model);
        displayTable.getTableHeader().setReorderingAllowed(false); // not allow re-ordering of columns
        displayTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        displayTable.setRowSelectionAllowed(true);

        try {
            int mealCount = 0;
            Statement stat = newCon.connectDB().createStatement();
            String sql = "select * from meals where userID =" + userID;
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                int mealidsql = rs.getInt("mealID");
                String mealnamesql = rs.getString("mealName");
                String mealtypesql = rs.getString("mealType");
                String foodgroupsql = rs.getString("foodGroup");
                String datesql = rs.getString("dateCreated");
                String daysql = rs.getString("dayCreated");
                String drinksql = rs.getString("drinkName");

                String mealTypeRegex = "\\b" + mealTypeSelect + "\\b";
                Pattern mealTypePattern = Pattern.compile(mealTypeRegex);
                Matcher mealTypePatternMatch = mealTypePattern.matcher(mealtypesql);

                String foodGroupRegex = "\\b" + foodGroupSelect + "\\b";
                Pattern foodGroupPattern = Pattern.compile(foodGroupRegex);
                Matcher foodGroupPatternMatch = foodGroupPattern.matcher(foodgroupsql);

                if(foodGroupSelect.equals("All") && mealTypeSelect.equals("All")){
                    model.addRow(new Object[]{mealidsql,mealnamesql,mealtypesql,foodgroupsql,datesql,daysql,drinksql});
                    mealCount++;
                }else if(foodGroupSelect.equals("All")){
                    if(mealTypePatternMatch.lookingAt()){
                        model.addRow(new Object[]{mealidsql,mealnamesql,mealtypesql,foodgroupsql,datesql,daysql,drinksql});
                        mealCount++;
                    }
                }else if(mealTypeSelect.equals("All")){
                    if(foodGroupPatternMatch.lookingAt()){
                        model.addRow(new Object[]{mealidsql,mealnamesql,mealtypesql,foodgroupsql,datesql,daysql,drinksql});
                        mealCount++;
                    }
                }else {
                    if(mealTypePatternMatch.lookingAt() && foodGroupPatternMatch.lookingAt()){
                        model.addRow(new Object[]{mealidsql,mealnamesql,mealtypesql,foodgroupsql,datesql,daysql,drinksql});
                        mealCount++;
                    }
                }
            }

            if(mealCount <1) {
                displayTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                totalMeal.setText(mealCount + " Meal Record Found.");
            }
            else if(mealCount ==1) {
                totalMeal.setText(mealCount + " Meal Record Found.");
            }
            else {
                totalMeal.setText(mealCount + " Meal Record Found.");
            }

            //Close database
            newCon.connectDB().close();
        }catch (SQLException err){
            System.err.println("Got an exception!");
            System.err.println(err.getMessage());
        }

        //Adjust JTable row sizes' height according to the font of the data
        for (int row = 0; row < displayTable.getRowCount(); row++) {
            int maxHeight = 0;
            for (int column = 0; column < displayTable.getColumnCount(); column++) {
                TableCellRenderer cellRenderer = displayTable.getCellRenderer(row, column);
                Object valueAt = displayTable.getValueAt(row, column);
                Component tableCellRendererComponent = cellRenderer.getTableCellRendererComponent(displayTable, valueAt, false, false, row, column);
                int heightPreferable = tableCellRendererComponent.getPreferredSize().height;
                maxHeight = Math.max(heightPreferable, maxHeight);
            }
            displayTable.setRowHeight(row, maxHeight);
        }

        //Adjust JTable column sizes according to longest data in each column
        for (int i = 0; i < displayTable.getColumnCount(); i++) {
            DefaultTableColumnModel colModel = (DefaultTableColumnModel) displayTable.getColumnModel();
            TableColumn col = colModel.getColumn(i);
            int width;

            TableCellRenderer renderer = col.getHeaderRenderer();
            if (renderer == null) {
                renderer = displayTable.getTableHeader().getDefaultRenderer();
            }
            Component comp = renderer.getTableCellRendererComponent(displayTable, col.getHeaderValue(), false, false, 0, 0);
            width = comp.getPreferredSize().width;

            for (int r = 0; r < displayTable.getRowCount(); r++) {
                renderer = displayTable.getCellRenderer(r, i);
                comp = renderer.getTableCellRendererComponent(displayTable, displayTable.getValueAt(r, i), false, false, r, i);
                int currentWidth = comp.getPreferredSize().width;
                width = Math.max(width, currentWidth);
            }

            width += 2 * 2;

            //Add more 10 pixel for additional space
            col.setPreferredWidth(width+10);
            col.setWidth(width+10);
        }
    }
}
