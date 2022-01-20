import javax.swing.*;

public interface UserInterface {
    boolean selectAccount(String username);
    boolean addAccount(String newUsername, String newFullname, int newAge);
    boolean editAccount(String newUsername, String newFullname, int newAge);
    boolean deleteAccount(int userID);
}
