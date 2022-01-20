import javax.swing.*;

public interface MealDiaryInterface {
    boolean createMeal(int userID, String imgPath, String mealName, String mealType, String foodGroup, String dateCreated, String dayCreated, String drink);
    boolean getMealDetails(int mealID);
    boolean updateMeal(String imgPath, int userID, int mealID);
    boolean updateMeal(int userID, int mealID, String mealName, String mealType, String foodGroup, String dateCreated, String dayCreated, String drink);
    boolean deleteMeal(int userID, int mealID);
    void searchMealList(int userID, String foodGroupSelect, String mealTypeSelect, JTable displayTable, JLabel totalMeal);
}
