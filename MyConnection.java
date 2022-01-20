import javax.swing.*;
import java.sql.*;

public class MyConnection implements DatabaseConnection{
    private String host;
    private String userName;
    private String userPass;

    MyConnection() {
        host = "jdbc:mysql://localhost:3306/mealdiary?useTimezone=true&serverTimezone=UTC";
        userName = "root";
        userPass = "";
    }

    public void setHost(String host) {
        this.host = host;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public Connection connectDB(){
        Connection connectionStatus = null;
        try{
            connectionStatus = DriverManager.getConnection(host, userName, userPass);

        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "You are not connected with mysql database!!",
                    "Connection Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
        }

        return connectionStatus;
    }
}
