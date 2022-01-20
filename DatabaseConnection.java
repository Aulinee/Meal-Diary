import java.sql.Connection;

public interface DatabaseConnection {
    Connection connectDB();
    void setHost(String host);
    void setUserName(String userName);
    void setUserPass(String userPass);
}
