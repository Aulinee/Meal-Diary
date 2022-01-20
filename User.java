import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User implements UserInterface{
    private int userID;
    private String username;
    private String fullName;
    private int userAge;

    User(){
        userID = 0;
        username = null;
        fullName = null;
        userAge = 0;
    }

    User(String username){
        this.username = username;
        userID = 0;
        fullName = null;
        userAge = 0;
    }

    public void setUserID(int userID) { this.userID = userID; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setUsername(String username) { this.username = username; }
    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public int getUserID() {
        return userID;
    }
    public String getUsername() {
        return username;
    }
    public String getFullName() {
        return fullName;
    }
    public int getUserAge() {
        return userAge;
    }

    public boolean selectAccount(String username){
        MyConnection newCon = new MyConnection(); //Create new MyConnection object to connect with database
        boolean isUser = false;
        try{
            Statement stat = newCon.connectDB().createStatement();
            String sql = "select * from users";
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                String uUsername = rs.getString("username");
                if (username.equals(uUsername)){
                    isUser = true;

                    //Set user data
                    setUserID(rs.getInt("userID"));
                    setUsername(rs.getString("username"));
                    setFullName(rs.getString("fullName"));
                    setUserAge(rs.getInt("age"));
                }
            }
            newCon.connectDB().close();
        }catch (SQLException err){
            System.err.println("Got an exception!");
            System.err.println(err.getMessage());
        }

        return isUser;
    }

    public boolean addAccount(String newUsername, String newFullname, int newAge){
        MyConnection newCon = new MyConnection(); //Create new MyConnection object to connect with database
        boolean addAccountStatus = false;
        try {
            // the mysql insert statement
            String query = "insert into users (username, fullName, age)"
                    + " values (?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = newCon.connectDB().prepareStatement(query);
            preparedStmt.setString (1, newUsername);
            preparedStmt.setString (2, newFullname);
            preparedStmt.setInt (3, newAge);

            // execute the preparedstatement
            preparedStmt.execute();

            //change addAccountStatus to true for a successful query
            addAccountStatus = true;

            //Close database
            newCon.connectDB().close();
        }
        catch (Exception err)
        {
            System.err.println("Got an exception!");
            System.err.println(err.getMessage());
        }

        return addAccountStatus;
    }

    public boolean editAccount(String newUsername, String newFullname, int newAge){
        MyConnection newCon = new MyConnection(); //Create new MyConnection object to connect with database
        boolean updateStatus = false;
        try {
            // the mysql insert statement
            String query = "update users " + "SET username = ?, fullName = ?, age = ? "
                    + "WHERE userID = ?";

            //update class attribute
            setUsername(newUsername);
            setFullName(newFullname);
            setUserAge(newAge);

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = newCon.connectDB().prepareStatement(query);
            preparedStmt.setString (1, newUsername);
            preparedStmt.setString (2, newFullname);
            preparedStmt.setInt (3, newAge);
            preparedStmt.setInt (4, userID);

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

    public boolean deleteAccount(int userID){
        MyConnection newCon = new MyConnection(); //Create new MyConnection object to connect with database
        boolean deleteStatus = false;
        try {
            String sql = "delete from users " + "WHERE userID = ?";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = newCon.connectDB().prepareStatement(sql);
            preparedStmt.setInt (1, userID);

            // execute the preparedstatement
            preparedStmt.execute();

            //change updateStatus to true for a successful query
            deleteStatus = true;

            //close databases
            newCon.connectDB().close();

        }catch (SQLException err){
            System.err.println("Got an exception!");
            System.err.println(err.getMessage());
        }

        return deleteStatus;
    }


}
