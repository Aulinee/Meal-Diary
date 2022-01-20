import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GUI extends JFrame implements ActionListener{
    //Create class object
    User user;
    MealDiary meal;
    MealDiary breakfast;
    MealDiary lunch;
    MealDiary dinner;

    //Login component
    DefaultListModel userListModel;
    Panel loginPanel;
    JButton signInButton;
    JButton signUpButton;
    JList<String> userList;

    //Sign Up Component
    JTextField addAgeSignUpTextField;
    JTextField addFullNameTextField;
    JTextField addUsernameSignUpTextField;
    JButton createAccountButton;
    JPanel signUpPanel;
    JButton signUpPageLoginButton;

    //Main Component Attribute
    JButton createMealMainMenuButton;
    JLabel greetingMainMenuLabel1;
    JLabel createMealMainMenuTitleLabel;
    JButton logoutMainMenuButton;
    JComboBox<String> mainMenuDropdown;
    JPanel mainMenuPanel;
    JTable mainMenuTable;
    JButton profileMainMenuButton;
    JButton viewMainMenuButton;

    //Profile Info Component
    JLabel ageProfileInfoLabel;
    JTextField ageProfileInfoTextField;
    JButton createMealProfileInfoButton;
    JButton deleteAccountProfileInfoButton;
    JTextField fullnameProfileInfoTextField;
    JButton logOutProfileInfoButton;
    JButton mainMenuProfileInfoButton;
    JTextField usernameProfileInfoTextField;
    JButton viewMenuProfileInfoButton;
    JComboBox<String> profileInfoMealTypeComboBox;
    JPanel profileInfoPanel;
    JButton updateInfoProfileInfoOKButton;
    JComboBox<String> updateInfoProfileInfoUpdateTypeComboBox;

    //Create meal component
    JButton createMealDetailsCreateMealButton;
    JPanel createMealPanel;
    JCheckBox dairyMealDetailsCreateMealCheckBox;
    com.toedter.calendar.JDateChooser dateMealDetailsCreateMealDateChooser;
    JTextField drinkMealDetailsCreateMealTextField;
    JCheckBox fruitsMealDetailsCreateMealCheckBox;
    JCheckBox grainMealDetailsCreateMealCheckBox;
    JButton logOutCreateMealButton;
    JButton mainMenuProfileInfoButton1;
    JLabel mealImageCreateMealLabel;
    JTextField mealNameMealDetailsCreateMealTextField;
    JTextField mealTypeCreateMealTextField;
    JButton profileInfoCreateMealButton;
    JCheckBox proteinFoodsMealDetailsCreateMealCheckBox;
    JButton uploadImageCreateMealButton;
    JCheckBox vegetablesMealDetailsCreateMealCheckBox;
    JButton viewMenuCreateMealButton;

    //View Meals Component Attribute
    JButton createMealViewMealButton;
    JButton deleteMealButton;
    JButton editMealButton;
    JComboBox<String> foodGroupSearchDropdown;
    JButton logoutViewMealButton;
    JButton mainMenuViewMealButton;
    JComboBox<String> mealTypeSearchDropdown;
    JButton profileViewMealButton;
    JButton searchMealButton;
    JLabel searchMealQueryLabel;
    JTable searchMealTable;
    JComboBox<String> viewMealDropdown;
    JPanel viewMealPanel;

    //Edit Meals Component Attribute
    JButton createMealEditMealButton;
    JTextField dateEditTextField;
    JTextField dayEditTextField;
    JTextField drinkEditTextField;
    JButton editDateBtn;
    JButton editDrinkBtn;
    JButton editFoodgroupBtn;
    JButton editImageBtn;
    JLabel editImageIconLabel;
    JComboBox<String> editMealDropdown;
    JButton editMealNameBtn;
    JPanel editMealPanel;
    JButton editMealTypeBtn;
    JTextField editMealTypeTextField;
    JLabel mealTypeEditLabel;
    JTextField foodGroupEditTextField;
    JButton logoutEditMealBtn;
    JButton mainEditMealBtn;
    JTextField mealNameEditTextField;
    JButton profileEditMealBtn;
    JButton searchEditMealBtn;

    GUI(){
        initComponents();
    }

    private void initComponents(){
        //Login component
        Panel leftLoginBarPanel;
        JLabel mainLoginDescLabel;
        JLabel mainLoginTitleLabel;
        JPanel rightLoginBarPanel;
        JScrollPane scrollPaneMainLogin;
        JLabel selectUserTitle;
        JLabel signUpDescLabel;
        JLabel userListLoginTitleLabel;

        //Sign Up Component
        JLabel addAgeSignUpLabel;
        JLabel addFullNameSignUpLabel;
        JPanel addNewUserPanel;
        JLabel addUsernameSignUpLabel;
        JPanel leftSignUpBarPanel;
        JLabel signUpPageDescLabel;
        JLabel mainLoginTitleLabel1;
        JLabel newUserSignUpQuoteLabel;
        JLabel newUserSignUpTitleLabel;
        JPanel rightSignUpBarPanell;
        JLabel signInDescLabel;
        JPanel signUpPageNamePanel;
        JLabel signUpPageTitleLabel;

        //Main Component Attribute
        JLabel greetingMainMenuLabel2;
        JLabel mainMenuOptionLabel;
        JLabel mainMenuQuote1Label;
        JLabel mainMenuQuote2Label;
        JScrollPane mainMenuScrollPane;
        JLabel mainMenuTitleLabel;
        JPanel sidebarMainMenuPanel;

        //Profile Info Component
        JLabel fullnameProfileInfoLabel;
        JPanel leftProfileInfoBarPanel;
        JLabel mainProfileInfoDescLabel;
        JLabel mainProfileInfoTitleLabel1;
        JLabel profileInfoCreateMeaTitlelLabel;
        JPanel profileInfoPageNamePanel;
        JLabel profileInfoUserQuoteLabel;
        JLabel profileInfoUserTitleLabel;
        JLabel profilePageTitleLabel;
        JPanel rightProfileInfoBarPanel;
        JLabel updateInfoProfileInfoQuoteLabel;
        JLabel updateInfoProfileInfoTitleLabel;
        JPanel userProfileInfoPanel;
        JLabel usernameProfileInfoLabel;

        //Create meal component
        JPanel createMealPageNamePanel;
        JLabel createMealPageTitleLabel;
        JLabel dateMealDetailsCreateMealLabel;
        JLabel drinkMealDetailsCreateMealLabel;
        JLabel foodGroupMealDetailsCreateMealLabel;
        JPanel leftCreateMealBarPanel;
        JLabel mainCreateMealDescLabel;
        JLabel mainCreateMealTitleLabel;
        JPanel mealDetailsCreateMealPanel;
        JLabel mealDetailsCreateMealTitleLabel;
        JPanel mealImageCreateMealPanel;
        JLabel mealNameMealDetailsCreateMealLabel;
        JLabel mealTypeCreateMealLabel;
        JPanel mealTypeCreateMealPanel;
        JPanel rightCreateMealBarPanel;

        //View Meals Component Attribute
        JLabel createMealViewMealTitleLabel;
        JLabel editMealLabel;
        JLabel searchCategoryLabel1;
        JLabel searchCategoryLabel2;
        JScrollPane searchMealScrollPane;
        JPanel sidebarViewMeal;
        JLabel viewMealSearchLabel1;
        JLabel viewMealSearchLabel2;
        JLabel viewMealSearchLabel3;
        JLabel viewMealsTitleLabel1;
        JLabel viewMealsTitleLabel2;
        JLabel viewMealsTitleLabel3;
        JPanel viewMealsTitlePanel3;

        //Edit Meals Component Attribute
        JLabel createMealEditMealTitleLabel;
        JLabel dateEditLabel;
        JLabel dayEditLabel;
        JLabel drinkEditLabel;
        JPanel editImagePanel;
        JLabel editMealDetailsLabel;
        JPanel editMealDetailsPanel;
        JPanel editMealDetailsPanel2;
        JLabel editMealTitleLabel1;
        JLabel editMealTitleLabel2;
        JLabel editMealTitleLabel3;
        JPanel editMealTitllePanel3;
        JLabel foodGroupEditLabel;
        JLabel mealNameEditLabel;
        JPanel sidebarEditMeal;

        /*===========Login Component===================*/
        userListModel = new DefaultListModel();
        loginPanel = new Panel();
        leftLoginBarPanel = new Panel();
        mainLoginTitleLabel = new JLabel();
        mainLoginDescLabel = new JLabel();
        signUpDescLabel = new JLabel();
        signUpButton = new JButton();
        rightLoginBarPanel = new JPanel();
        userListLoginTitleLabel = new JLabel();
        scrollPaneMainLogin = new JScrollPane();
        userList = new JList<>(userListModel);
        selectUserTitle = new JLabel();
        signInButton = new JButton();

        /*===========Sign up Component===================*/
        signUpPanel = new JPanel();
        leftSignUpBarPanel = new JPanel();
        signUpPageDescLabel = new JLabel();
        signInDescLabel = new JLabel();
        signUpPageLoginButton = new JButton();
        signUpPageNamePanel = new JPanel();
        signUpPageTitleLabel = new JLabel();
        mainLoginTitleLabel1 = new JLabel();
        rightSignUpBarPanell = new JPanel();
        newUserSignUpTitleLabel = new JLabel();
        newUserSignUpQuoteLabel = new JLabel();
        createAccountButton = new JButton();
        addNewUserPanel = new JPanel();
        addUsernameSignUpLabel = new JLabel();
        addFullNameSignUpLabel = new JLabel();
        addAgeSignUpLabel = new JLabel();
        addUsernameSignUpTextField = new JTextField();
        addFullNameTextField = new JTextField();
        addAgeSignUpTextField = new JTextField();

        /*===========Main Menu Component===================*/
        mainMenuPanel = new JPanel();
        sidebarMainMenuPanel = new JPanel();
        mainMenuTitleLabel = new JLabel();
        mainMenuQuote1Label = new JLabel();
        mainMenuQuote2Label = new JLabel();
        createMealMainMenuTitleLabel = new JLabel();
        mainMenuDropdown = new JComboBox<>();
        createMealMainMenuButton = new JButton();
        mainMenuOptionLabel = new JLabel();
        profileMainMenuButton = new JButton();
        viewMainMenuButton = new JButton();
        logoutMainMenuButton = new JButton();
        greetingMainMenuLabel1 = new JLabel();
        greetingMainMenuLabel2 = new JLabel();
        mainMenuScrollPane = new JScrollPane();
        mainMenuTable = new JTable();

        /*===========Create Meal Component===================*/
        createMealPanel = new JPanel();
        leftCreateMealBarPanel = new JPanel();
        mainCreateMealDescLabel = new JLabel();
        mainCreateMealTitleLabel = new JLabel();
        createMealPageNamePanel = new JPanel();
        createMealPageTitleLabel = new JLabel();
        mainMenuProfileInfoButton1 = new JButton();
        profileInfoCreateMealButton = new JButton();
        viewMenuCreateMealButton = new JButton();
        logOutCreateMealButton = new JButton();
        rightCreateMealBarPanel = new JPanel();
        mealTypeCreateMealPanel = new JPanel();
        mealTypeCreateMealLabel = new JLabel();
        uploadImageCreateMealButton = new JButton();
        mealTypeCreateMealTextField = new JTextField();
        mealImageCreateMealPanel = new JPanel();
        mealImageCreateMealLabel = new JLabel();
        mealDetailsCreateMealTitleLabel = new JLabel();
        mealDetailsCreateMealPanel = new JPanel();
        mealNameMealDetailsCreateMealLabel = new JLabel();
        mealNameMealDetailsCreateMealTextField = new JTextField();
        drinkMealDetailsCreateMealLabel = new JLabel();
        drinkMealDetailsCreateMealTextField = new JTextField();
        dateMealDetailsCreateMealLabel = new JLabel();
        foodGroupMealDetailsCreateMealLabel = new JLabel();
        grainMealDetailsCreateMealCheckBox = new JCheckBox();
        fruitsMealDetailsCreateMealCheckBox = new JCheckBox();
        vegetablesMealDetailsCreateMealCheckBox = new JCheckBox();
        dairyMealDetailsCreateMealCheckBox = new JCheckBox();
        proteinFoodsMealDetailsCreateMealCheckBox = new JCheckBox();
        createMealDetailsCreateMealButton = new JButton();
        dateMealDetailsCreateMealDateChooser = new com.toedter.calendar.JDateChooser();

        /*===========Profile Info Component===================*/
        profileInfoPanel = new JPanel();
        leftProfileInfoBarPanel = new JPanel();
        mainProfileInfoDescLabel = new JLabel();
        mainProfileInfoTitleLabel1 = new JLabel();
        profileInfoCreateMeaTitlelLabel = new JLabel();
        profileInfoPageNamePanel = new JPanel();
        profilePageTitleLabel = new JLabel();
        profileInfoMealTypeComboBox = new JComboBox<>();
        createMealProfileInfoButton = new JButton();
        mainMenuProfileInfoButton = new JButton();
        viewMenuProfileInfoButton = new JButton();
        logOutProfileInfoButton = new JButton();
        rightProfileInfoBarPanel = new JPanel();
        profileInfoUserTitleLabel = new JLabel();
        profileInfoUserQuoteLabel = new JLabel();
        userProfileInfoPanel = new JPanel();
        usernameProfileInfoLabel = new JLabel();
        fullnameProfileInfoLabel = new JLabel();
        ageProfileInfoLabel = new JLabel();
        usernameProfileInfoTextField = new JTextField();
        fullnameProfileInfoTextField = new JTextField();
        ageProfileInfoTextField = new JTextField();
        deleteAccountProfileInfoButton = new JButton();
        updateInfoProfileInfoTitleLabel = new JLabel();
        updateInfoProfileInfoQuoteLabel = new JLabel();
        updateInfoProfileInfoOKButton = new JButton();
        updateInfoProfileInfoUpdateTypeComboBox = new JComboBox<>();

        /*===========View Meals Component===================*/
        viewMealPanel = new JPanel();
        sidebarViewMeal = new JPanel();
        viewMealsTitleLabel1 = new JLabel();
        viewMealsTitleLabel2 = new JLabel();
        viewMealsTitlePanel3 = new JPanel();
        viewMealsTitleLabel3 = new JLabel();
        createMealViewMealTitleLabel = new JLabel();
        viewMealDropdown = new JComboBox<>();
        createMealViewMealButton = new JButton();
        mainMenuViewMealButton = new JButton();
        profileViewMealButton = new JButton();
        logoutViewMealButton = new JButton();
        viewMealSearchLabel1 = new JLabel();
        viewMealSearchLabel2 = new JLabel();
        viewMealSearchLabel3 = new JLabel();
        searchCategoryLabel1 = new JLabel();
        mealTypeSearchDropdown = new JComboBox<>();
        searchCategoryLabel2 = new JLabel();
        foodGroupSearchDropdown = new JComboBox<>();
        searchMealScrollPane = new JScrollPane();
        searchMealTable = new JTable();
        searchMealButton = new JButton();
        editMealLabel = new JLabel();
        editMealButton = new JButton();
        deleteMealButton = new JButton();
        searchMealQueryLabel = new JLabel();

        /*===========Edit Meals Component===================*/
        editMealPanel = new JPanel();
        sidebarEditMeal = new JPanel();
        editMealTitleLabel1 = new JLabel();
        editMealTitleLabel2 = new JLabel();
        editMealTitllePanel3 = new JPanel();
        editMealTitleLabel3 = new JLabel();
        createMealEditMealTitleLabel = new JLabel();
        editMealDropdown = new JComboBox<>();
        createMealEditMealButton = new JButton();
        mainEditMealBtn = new JButton();
        searchEditMealBtn = new JButton();
        profileEditMealBtn = new JButton();
        logoutEditMealBtn = new JButton();
        editMealDetailsPanel = new JPanel();
        mealTypeEditLabel = new JLabel();
        editMealTypeTextField = new JTextField();
        editMealTypeBtn = new JButton();
        editImagePanel = new JPanel();
        editImageIconLabel = new JLabel();
        editImageBtn = new JButton();
        editMealDetailsLabel = new JLabel();
        editMealDetailsPanel2 = new JPanel();
        mealNameEditLabel = new JLabel();
        mealNameEditTextField = new JTextField();
        editMealNameBtn = new JButton();
        foodGroupEditLabel = new JLabel();
        foodGroupEditTextField = new JTextField();
        editFoodgroupBtn = new JButton();
        drinkEditLabel = new JLabel();
        drinkEditTextField = new JTextField();
        editDrinkBtn = new JButton();
        dateEditLabel = new JLabel();
        dateEditTextField = new JTextField();
        dayEditLabel = new JLabel();
        dayEditTextField = new JTextField();
        editDateBtn = new JButton();

        //Default setting for JFrame
        setTitle("Meal Diary");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 650));
        setMaximumSize(new Dimension(1000, 600));
        setMinimumSize(null);
        setResizable(false);

        /*===========Login Component Specification===================*/
        loginPanel.setMaximumSize(new Dimension(1000, 600));
        loginPanel.setPreferredSize(new Dimension(1000, 600));

        leftLoginBarPanel.setBackground(new Color(72, 129, 241));
        leftLoginBarPanel.setPreferredSize(new Dimension(350, 600));

        mainLoginTitleLabel.setFont(new Font("Segoe UI", 1, 55)); // NOI18N
        mainLoginTitleLabel.setForeground(new Color(255, 255, 255));
        mainLoginTitleLabel.setText("Meal Diary");

        mainLoginDescLabel.setFont(new Font("Segoe UI", 2, 20)); // NOI18N
        mainLoginDescLabel.setForeground(new Color(255, 255, 255));
        mainLoginDescLabel.setText("Your daily food tracking app.");

        signUpDescLabel.setFont(new Font("Segoe UI", 0, 15)); // NOI18N
        signUpDescLabel.setForeground(new Color(255, 255, 255));
        signUpDescLabel.setText("Haven't sign up? Sign up here");

        signUpButton.setBackground(new Color(110, 165, 248));
        signUpButton.setFont(new Font("Segoe UI", 1, 20)); // NOI18N
        signUpButton.setForeground(new Color(255, 255, 255));
        signUpButton.setText("Sign up");
        signUpButton.setBorder(null);
        signUpButton.setBorderPainted(false);
        signUpButton.setFocusPainted(false);
        signUpButton.addActionListener(this);

        GroupLayout leftLoginBarPanelLayout = new GroupLayout(leftLoginBarPanel);
        leftLoginBarPanel.setLayout(leftLoginBarPanelLayout);
        leftLoginBarPanelLayout.setHorizontalGroup(
                leftLoginBarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(leftLoginBarPanelLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(leftLoginBarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(leftLoginBarPanelLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(signUpButton, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(signUpDescLabel))
                                .addContainerGap(85, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, leftLoginBarPanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(leftLoginBarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, leftLoginBarPanelLayout.createSequentialGroup()
                                                .addComponent(mainLoginDescLabel)
                                                .addGap(44, 44, 44))
                                        .addGroup(GroupLayout.Alignment.TRAILING, leftLoginBarPanelLayout.createSequentialGroup()
                                                .addComponent(mainLoginTitleLabel)
                                                .addGap(31, 31, 31))))
        );
        leftLoginBarPanelLayout.setVerticalGroup(
                leftLoginBarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(leftLoginBarPanelLayout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(mainLoginTitleLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mainLoginDescLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(signUpDescLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(signUpButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89))
        );

        rightLoginBarPanel.setBackground(new Color(255, 255, 255));

        userListLoginTitleLabel.setBackground(new Color(255, 255, 255));
        userListLoginTitleLabel.setFont(new Font("Segoe UI", 1, 30)); // NOI18N
        userListLoginTitleLabel.setForeground(new Color(19, 46, 86));
        userListLoginTitleLabel.setText("USER'S LIST");

        userList.setBorder(BorderFactory.createCompoundBorder(null, BorderFactory.createLineBorder(new Color(72, 129, 241), 2)));
        userList.setFont(new Font("Segoe UI", 1, 30)); // NOI18N

        DefaultListCellRenderer renderer = new DefaultListCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        displayAccountList(userListModel); //Load user list model
        userList.setCellRenderer(renderer);
        userList.setSelectionBackground(new Color(72, 129, 241));
        scrollPaneMainLogin.setViewportView(userList);

        selectUserTitle.setFont(new Font("Segoe UI", 0, 17)); // NOI18N
        selectUserTitle.setForeground(new Color(102, 102, 102));
        selectUserTitle.setText("Select Your Username");

        signInButton.setBackground(new Color(19, 46, 86));
        signInButton.setFont(new Font("Segoe UI", 1, 15)); // NOI18N
        signInButton.setForeground(new Color(255, 255, 255));
        signInButton.setText("Sign In");
        signInButton.setBorder(null);
        signInButton.setBorderPainted(false);
        signInButton.setFocusPainted(false);
        signInButton.addActionListener(this);

        GroupLayout rightLoginBarPanelayout = new GroupLayout(rightLoginBarPanel);
        rightLoginBarPanel.setLayout(rightLoginBarPanelayout);
        rightLoginBarPanelayout.setHorizontalGroup(
                rightLoginBarPanelayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(rightLoginBarPanelayout.createSequentialGroup()
                                .addContainerGap(58, Short.MAX_VALUE)
                                .addGroup(rightLoginBarPanelayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, rightLoginBarPanelayout.createSequentialGroup()
                                                .addComponent(scrollPaneMainLogin, GroupLayout.PREFERRED_SIZE, 540, GroupLayout.PREFERRED_SIZE)
                                                .addGap(51, 51, 51))
                                        .addGroup(GroupLayout.Alignment.TRAILING, rightLoginBarPanelayout.createSequentialGroup()
                                                .addComponent(selectUserTitle)
                                                .addGap(235, 235, 235))
                                        .addGroup(GroupLayout.Alignment.TRAILING, rightLoginBarPanelayout.createSequentialGroup()
                                                .addComponent(signInButton, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                                .addGap(253, 253, 253))
                                        .addGroup(GroupLayout.Alignment.TRAILING, rightLoginBarPanelayout.createSequentialGroup()
                                                .addComponent(userListLoginTitleLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
                                                .addGap(229, 229, 229))))
        );
        rightLoginBarPanelayout.setVerticalGroup(
                rightLoginBarPanelayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(rightLoginBarPanelayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(userListLoginTitleLabel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPaneMainLogin, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(selectUserTitle)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(signInButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(34, Short.MAX_VALUE))
        );

        GroupLayout loginPanelLayout = new GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
                loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addComponent(leftLoginBarPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(rightLoginBarPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
                loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(leftLoginBarPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rightLoginBarPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        /*===========Sign up Component Specification===================*/
        signUpPanel.setMaximumSize(new Dimension(1000, 650));
        signUpPanel.setPreferredSize(new Dimension(1000, 650));

        leftSignUpBarPanel.setBackground(new Color(72, 129, 241));
        leftSignUpBarPanel.setPreferredSize(new Dimension(350, 650));

        signUpPageDescLabel.setFont(new Font("Segoe UI", 0, 20)); // NOI18N
        signUpPageDescLabel.setForeground(new Color(255, 255, 255));
        signUpPageDescLabel.setText("Your daily food tracking app.");

        signInDescLabel.setFont(new Font("Segoe UI", 0, 15)); // NOI18N
        signInDescLabel.setForeground(new Color(255, 255, 255));
        signInDescLabel.setText("Already have an account? Sign in here.");

        signUpPageLoginButton.setBackground(new Color(110, 165, 248));
        signUpPageLoginButton.setFont(new Font("Segoe UI", 1, 20)); // NOI18N
        signUpPageLoginButton.setForeground(new Color(255, 255, 255));
        signUpPageLoginButton.setText("Sign in");
        signUpPageLoginButton.setBorder(null);
        signUpPageLoginButton.setBorderPainted(false);
        signUpPageLoginButton.setFocusPainted(false);
        signUpPageLoginButton.addActionListener(this);

        signUpPageNamePanel.setBackground(new Color(193, 214, 246));

        signUpPageTitleLabel.setFont(new Font("Segoe UI Semibold", 0, 30)); // NOI18N
        signUpPageTitleLabel.setForeground(new Color(19, 46, 86));
        signUpPageTitleLabel.setText("Sign Up Page");

        GroupLayout signUpPageNamePanelLayout = new GroupLayout(signUpPageNamePanel);
        signUpPageNamePanel.setLayout(signUpPageNamePanelLayout);
        signUpPageNamePanelLayout.setHorizontalGroup(
                signUpPageNamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(signUpPageNamePanelLayout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(signUpPageTitleLabel)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        signUpPageNamePanelLayout.setVerticalGroup(
                signUpPageNamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(signUpPageNamePanelLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(signUpPageTitleLabel)
                                .addContainerGap(25, Short.MAX_VALUE))
        );

        mainLoginTitleLabel1.setFont(new Font("Segoe UI", 1, 55)); // NOI18N
        mainLoginTitleLabel1.setForeground(new Color(255, 255, 255));
        mainLoginTitleLabel1.setText("Meal Diary");

        GroupLayout leftSignUpBarPanelLayout = new GroupLayout(leftSignUpBarPanel);
        leftSignUpBarPanel.setLayout(leftSignUpBarPanelLayout);
        leftSignUpBarPanelLayout.setHorizontalGroup(
                leftSignUpBarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(signUpPageNamePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, leftSignUpBarPanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(signInDescLabel)
                                .addGap(45, 45, 45))
                        .addGroup(leftSignUpBarPanelLayout.createSequentialGroup()
                                .addGroup(leftSignUpBarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(leftSignUpBarPanelLayout.createSequentialGroup()
                                                .addGap(85, 85, 85)
                                                .addComponent(signUpPageLoginButton, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(leftSignUpBarPanelLayout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addGroup(leftSignUpBarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(leftSignUpBarPanelLayout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(signUpPageDescLabel))
                                                        .addComponent(mainLoginTitleLabel1))))
                                .addContainerGap(41, Short.MAX_VALUE))
        );
        leftSignUpBarPanelLayout.setVerticalGroup(
                leftSignUpBarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(leftSignUpBarPanelLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(mainLoginTitleLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(signUpPageDescLabel)
                                .addGap(36, 36, 36)
                                .addComponent(signUpPageNamePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                                .addComponent(signInDescLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(signUpPageLoginButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89))
        );

        rightSignUpBarPanell.setBackground(new Color(255, 255, 255));

        newUserSignUpTitleLabel.setBackground(new Color(255, 255, 255));
        newUserSignUpTitleLabel.setFont(new Font("Segoe UI", 1, 35)); // NOI18N
        newUserSignUpTitleLabel.setForeground(new Color(19, 46, 86));
        newUserSignUpTitleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        newUserSignUpTitleLabel.setText("New User");

        newUserSignUpQuoteLabel.setFont(new Font("Segoe UI", 2, 15)); // NOI18N
        newUserSignUpQuoteLabel.setText("Add new user to your device.");

        createAccountButton.setBackground(new Color(19, 46, 86));
        createAccountButton.setFont(new Font("Segoe UI", 1, 15)); // NOI18N
        createAccountButton.setForeground(new Color(255, 255, 255));
        createAccountButton.setText("Create Account");
        createAccountButton.setBorder(null);
        createAccountButton.addActionListener(this);

        addNewUserPanel.setBackground(new Color(234, 251, 251));

        addUsernameSignUpLabel.setFont(new Font("Segoe UI Semibold", 0, 25)); // NOI18N
        addUsernameSignUpLabel.setText("Username:");

        addFullNameSignUpLabel.setFont(new Font("Segoe UI Semibold", 0, 25)); // NOI18N
        addFullNameSignUpLabel.setText("Full name:");

        addAgeSignUpLabel.setFont(new Font("Segoe UI Semibold", 0, 25)); // NOI18N
        addAgeSignUpLabel.setText("Age:");

        addUsernameSignUpTextField.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        addFullNameTextField.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        addAgeSignUpTextField.setFont(new Font("Segoe UI", 0, 18)); // NOI18N

        GroupLayout addNewUserPanelLayout = new GroupLayout(addNewUserPanel);
        addNewUserPanel.setLayout(addNewUserPanelLayout);
        addNewUserPanelLayout.setHorizontalGroup(
                addNewUserPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(addNewUserPanelLayout.createSequentialGroup()
                                .addGroup(addNewUserPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(addNewUserPanelLayout.createSequentialGroup()
                                                .addGap(63, 63, 63)
                                                .addGroup(addNewUserPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(addNewUserPanelLayout.createSequentialGroup()
                                                                .addComponent(addUsernameSignUpLabel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(addUsernameSignUpTextField, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(addNewUserPanelLayout.createSequentialGroup()
                                                                .addComponent(addFullNameSignUpLabel)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(addFullNameTextField, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(addNewUserPanelLayout.createSequentialGroup()
                                                .addGap(130, 130, 130)
                                                .addComponent(addAgeSignUpLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(addAgeSignUpTextField, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(91, Short.MAX_VALUE))
        );
        addNewUserPanelLayout.setVerticalGroup(
                addNewUserPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(addNewUserPanelLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(addNewUserPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(addUsernameSignUpLabel)
                                        .addComponent(addUsernameSignUpTextField))
                                .addGap(15, 15, 15)
                                .addGroup(addNewUserPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(addFullNameSignUpLabel)
                                        .addComponent(addFullNameTextField))
                                .addGap(18, 18, 18)
                                .addGroup(addNewUserPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(addAgeSignUpLabel)
                                        .addComponent(addAgeSignUpTextField))
                                .addGap(51, 51, 51))
        );

        GroupLayout rightSignUpBarPanellLayout = new GroupLayout(rightSignUpBarPanell);
        rightSignUpBarPanell.setLayout(rightSignUpBarPanellLayout);
        rightSignUpBarPanellLayout.setHorizontalGroup(
                rightSignUpBarPanellLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(rightSignUpBarPanellLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(addNewUserPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 34, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, rightSignUpBarPanellLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(createAccountButton, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
                        .addGroup(rightSignUpBarPanellLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(rightSignUpBarPanellLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(newUserSignUpQuoteLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(newUserSignUpTitleLabel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
                                .addGap(396, 396, 396))
        );
        rightSignUpBarPanellLayout.setVerticalGroup(
                rightSignUpBarPanellLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(rightSignUpBarPanellLayout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(newUserSignUpTitleLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newUserSignUpQuoteLabel)
                                .addGap(43, 43, 43)
                                .addComponent(addNewUserPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(createAccountButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout signUpPanelLayout = new GroupLayout(signUpPanel);
        signUpPanel.setLayout(signUpPanelLayout);
        signUpPanelLayout.setHorizontalGroup(
                signUpPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(signUpPanelLayout.createSequentialGroup()
                                .addComponent(leftSignUpBarPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(rightSignUpBarPanell, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        signUpPanelLayout.setVerticalGroup(
                signUpPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(leftSignUpBarPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(rightSignUpBarPanell, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        /*===========Main Page Component Specification===================*/
        mainMenuPanel.setBackground(new Color(255, 255, 255));
        mainMenuPanel.setMaximumSize(new Dimension(1000, 650));
        mainMenuPanel.setMinimumSize(new Dimension(1000, 650));

        sidebarMainMenuPanel.setBackground(new Color(79, 129, 241));
        sidebarMainMenuPanel.setMaximumSize(new Dimension(350, 650));
        sidebarMainMenuPanel.setPreferredSize(new Dimension(350, 620));
        sidebarMainMenuPanel.setMinimumSize(new Dimension(350, 650));

        mainMenuTitleLabel.setFont(new Font("Segoe UI", 1, 55)); // NOI18N
        mainMenuTitleLabel.setForeground(new Color(255, 255, 255));
        mainMenuTitleLabel.setText("Meal Diary");

        mainMenuQuote1Label.setFont(new Font("Segoe UI", 2, 17)); // NOI18N
        mainMenuQuote1Label.setForeground(new Color(255, 255, 255));
        mainMenuQuote1Label.setText("ongoing process");

        mainMenuQuote2Label.setFont(new Font("Segoe UI", 2, 17)); // NOI18N
        mainMenuQuote2Label.setForeground(new Color(255, 255, 255));
        mainMenuQuote2Label.setText("Making changes in food habits is an  ");

        createMealMainMenuTitleLabel.setFont(new Font("Segoe UI", 0, 27)); // NOI18N
        createMealMainMenuTitleLabel.setForeground(new Color(255, 255, 255));
        createMealMainMenuTitleLabel.setText("Create Meal");

        mainMenuDropdown.setBackground(new Color(255, 255, 255));
        mainMenuDropdown.setFont(new Font("Segoe UI", 0, 15)); // NOI18N
        mainMenuDropdown.setModel(new DefaultComboBoxModel<>(new String[] { "Breakfast", "Lunch", "Dinner"}));
        mainMenuDropdown.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        mainMenuDropdown.setFocusable(false);

        createMealMainMenuButton.setBackground(new Color(19, 46, 86));
        createMealMainMenuButton.setFont(new Font("Segoe UI", 1, 15)); // NOI18N
        createMealMainMenuButton.setForeground(new Color(255, 255, 255));
        createMealMainMenuButton.setText("OK");
        createMealMainMenuButton.setBorder(null);
        createMealMainMenuButton.setFocusable(false);
        createMealMainMenuButton.addActionListener(this);

        mainMenuOptionLabel.setFont(new Font("Segoe UI", 0, 27)); // NOI18N
        mainMenuOptionLabel.setForeground(new Color(255, 255, 255));
        mainMenuOptionLabel.setText("Other Options");

        profileMainMenuButton.setBackground(new Color(110, 165, 248));
        profileMainMenuButton.setFont(new Font("Segoe UI", 0, 20)); // NOI18N
        profileMainMenuButton.setForeground(new Color(255, 255, 255));
        profileMainMenuButton.setText("Profile Info");
        profileMainMenuButton.setBorder(null);
        profileMainMenuButton.setFocusable(false);
        profileMainMenuButton.addActionListener(this);

        viewMainMenuButton.setBackground(new Color(110, 165, 248));
        viewMainMenuButton.setFont(new Font("Segoe UI", 0, 20)); // NOI18N
        viewMainMenuButton.setForeground(new Color(255, 255, 255));
        viewMainMenuButton.setText("View Meals");
        viewMainMenuButton.setBorder(null);
        viewMainMenuButton.setFocusable(false);
        viewMainMenuButton.addActionListener(this);

        logoutMainMenuButton.setBackground(new Color(110, 165, 248));
        logoutMainMenuButton.setFont(new Font("Segoe UI", 0, 20)); // NOI18N
        logoutMainMenuButton.setForeground(new Color(255, 255, 255));
        logoutMainMenuButton.setText("Logout");
        logoutMainMenuButton.setBorder(null);
        logoutMainMenuButton.setFocusable(false);
        logoutMainMenuButton.addActionListener(this);

        GroupLayout sidebarMainMenuPanelLayout = new GroupLayout(sidebarMainMenuPanel);
        sidebarMainMenuPanel.setLayout(sidebarMainMenuPanelLayout);
        sidebarMainMenuPanelLayout.setHorizontalGroup(
                sidebarMainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(sidebarMainMenuPanelLayout.createSequentialGroup()
                                .addGroup(sidebarMainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(sidebarMainMenuPanelLayout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addGroup(sidebarMainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(mainMenuTitleLabel)
                                                        .addGroup(sidebarMainMenuPanelLayout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(mainMenuQuote2Label))))
                                        .addGroup(sidebarMainMenuPanelLayout.createSequentialGroup()
                                                .addGap(108, 108, 108)
                                                .addComponent(mainMenuQuote1Label))
                                        .addGroup(sidebarMainMenuPanelLayout.createSequentialGroup()
                                                .addGap(94, 94, 94)
                                                .addComponent(createMealMainMenuTitleLabel))
                                        .addGroup(sidebarMainMenuPanelLayout.createSequentialGroup()
                                                .addGap(85, 85, 85)
                                                .addComponent(mainMenuOptionLabel))
                                        .addGroup(sidebarMainMenuPanelLayout.createSequentialGroup()
                                                .addGap(62, 62, 62)
                                                .addComponent(mainMenuDropdown, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(createMealMainMenuButton, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(sidebarMainMenuPanelLayout.createSequentialGroup()
                                                .addGap(74, 74, 74)
                                                .addGroup(sidebarMainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(viewMainMenuButton, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(logoutMainMenuButton, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(38, Short.MAX_VALUE))
                        .addGroup(sidebarMainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(sidebarMainMenuPanelLayout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addComponent(profileMainMenuButton, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(81, Short.MAX_VALUE)))
        );
        sidebarMainMenuPanelLayout.setVerticalGroup(
                sidebarMainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(sidebarMainMenuPanelLayout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(mainMenuTitleLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mainMenuQuote2Label)
                                .addGap(0, 0, 0)
                                .addComponent(mainMenuQuote1Label)
                                .addGap(36, 36, 36)
                                .addComponent(createMealMainMenuTitleLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(sidebarMainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(mainMenuDropdown, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(sidebarMainMenuPanelLayout.createSequentialGroup()
                                                .addComponent(createMealMainMenuButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(0, 0, 0)))
                                .addGap(35, 35, 35)
                                .addComponent(mainMenuOptionLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                .addComponent(viewMainMenuButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(logoutMainMenuButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))
                        .addGroup(sidebarMainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, sidebarMainMenuPanelLayout.createSequentialGroup()
                                        .addContainerGap(409, Short.MAX_VALUE)
                                        .addComponent(profileMainMenuButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                        .addGap(147, 147, 147)))
        );

        greetingMainMenuLabel1.setFont(new Font("Segoe UI", 1, 35)); // NOI18N

        greetingMainMenuLabel2.setFont(new Font("Segoe UI", 1, 35)); // NOI18N
        greetingMainMenuLabel2.setText("Here is your past's meal.");

        mainMenuScrollPane.setBorder(BorderFactory.createLineBorder(new Color(10, 119, 210), 3));
        mainMenuScrollPane.setForeground(new Color(255, 255, 255));
        mainMenuScrollPane.setFont(new Font("Tahoma", 1, 15)); // NOI18N
        mainMenuScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        mainMenuTable.setAutoCreateRowSorter(true);
        mainMenuTable.setBackground(new Color(232, 240, 243));
        mainMenuTable.setBorder(BorderFactory.createLineBorder(new Color(72, 129, 241)));
        mainMenuTable.setFont(new Font("Segoe UI", 0, 15)); // NOI18N
        mainMenuTable.setGridColor(new Color(72, 129, 241));
        mainMenuTable.setSelectionBackground(Color.lightGray);
        mainMenuTable.setShowGrid(true);
        mainMenuScrollPane.setViewportView(mainMenuTable);

        GroupLayout mainMenuPanelLayout = new GroupLayout(mainMenuPanel);
        mainMenuPanel.setLayout(mainMenuPanelLayout);
        mainMenuPanelLayout.setHorizontalGroup(
                mainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainMenuPanelLayout.createSequentialGroup()
                                .addComponent(sidebarMainMenuPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addGroup(mainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(mainMenuScrollPane,560,560,560)
                                        .addComponent(greetingMainMenuLabel2, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(greetingMainMenuLabel1, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 50, Short.MAX_VALUE))
        );

        mainMenuPanelLayout.setVerticalGroup(
                mainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainMenuPanelLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(greetingMainMenuLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(greetingMainMenuLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mainMenuScrollPane, 400,400,400)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(mainMenuPanelLayout.createSequentialGroup()
                                .addComponent(sidebarMainMenuPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        /*===========Create Meal Component Specification===================*/
        createMealPanel.setMaximumSize(new Dimension(1000, 650));
        createMealPanel.setMinimumSize(new Dimension(1000, 650));

        leftCreateMealBarPanel.setBackground(new Color(72, 129, 241));
        leftCreateMealBarPanel.setPreferredSize(new Dimension(350, 650));

        mainCreateMealDescLabel.setFont(new Font("Segoe UI", 2, 20)); // NOI18N
        mainCreateMealDescLabel.setForeground(new Color(255, 255, 255));
        mainCreateMealDescLabel.setText("Add your meal for the day.");

        mainCreateMealTitleLabel.setFont(new Font("Segoe UI", 1, 55)); // NOI18N
        mainCreateMealTitleLabel.setForeground(new Color(255, 255, 255));
        mainCreateMealTitleLabel.setText("Meal Diary");

        createMealPageNamePanel.setBackground(new Color(193, 214, 246));
        createMealPageNamePanel.setMaximumSize(new Dimension(350, 88));
        createMealPageNamePanel.setMinimumSize(new Dimension(350, 88));

        createMealPageTitleLabel.setFont(new Font("Segoe UI Semibold", 0, 30)); // NOI18N
        createMealPageTitleLabel.setForeground(new Color(19, 46, 86));
        createMealPageTitleLabel.setText("Create Meal Page");

        GroupLayout createMealPageNamePanelLayout = new GroupLayout(createMealPageNamePanel);
        createMealPageNamePanel.setLayout(createMealPageNamePanelLayout);
        createMealPageNamePanelLayout.setHorizontalGroup(
                createMealPageNamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(createMealPageNamePanelLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(createMealPageTitleLabel)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        createMealPageNamePanelLayout.setVerticalGroup(
                createMealPageNamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(createMealPageNamePanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(createMealPageTitleLabel)
                                .addContainerGap(23, Short.MAX_VALUE))
        );

        mainMenuProfileInfoButton1.setBackground(new Color(110, 165, 248));
        mainMenuProfileInfoButton1.setFont(new Font("Segoe UI", 1, 20)); // NOI18N
        mainMenuProfileInfoButton1.setForeground(new Color(255, 255, 255));
        mainMenuProfileInfoButton1.setText("Main Menu");
        mainMenuProfileInfoButton1.setBorder(null);
        mainMenuProfileInfoButton1.setBorderPainted(false);
        mainMenuProfileInfoButton1.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        mainMenuProfileInfoButton1.setFocusPainted(false);
        mainMenuProfileInfoButton1.addActionListener(this);

        profileInfoCreateMealButton.setBackground(new Color(110, 165, 248));
        profileInfoCreateMealButton.setFont(new Font("Segoe UI", 1, 20)); // NOI18N
        profileInfoCreateMealButton.setForeground(new Color(255, 255, 255));
        profileInfoCreateMealButton.setText("Profile Info");
        profileInfoCreateMealButton.setBorder(null);
        profileInfoCreateMealButton.setBorderPainted(false);
        profileInfoCreateMealButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        profileInfoCreateMealButton.setFocusPainted(false);
        profileInfoCreateMealButton.addActionListener(this);

        viewMenuCreateMealButton.setBackground(new Color(110, 165, 248));
        viewMenuCreateMealButton.setFont(new Font("Segoe UI", 1, 20)); // NOI18N
        viewMenuCreateMealButton.setForeground(new Color(255, 255, 255));
        viewMenuCreateMealButton.setText("View Meal");
        viewMenuCreateMealButton.setBorder(null);
        viewMenuCreateMealButton.setBorderPainted(false);
        viewMenuCreateMealButton.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        viewMenuCreateMealButton.setFocusPainted(false);
        viewMenuCreateMealButton.addActionListener(this);

        logOutCreateMealButton.setBackground(new Color(110, 165, 248));
        logOutCreateMealButton.setFont(new Font("Segoe UI", 1, 20)); // NOI18N
        logOutCreateMealButton.setForeground(new Color(255, 255, 255));
        logOutCreateMealButton.setText("Log Out");
        logOutCreateMealButton.setBorder(null);
        logOutCreateMealButton.setBorderPainted(false);
        logOutCreateMealButton.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        logOutCreateMealButton.setFocusPainted(false);
        logOutCreateMealButton.addActionListener(this);

        GroupLayout leftCreateMealBarPanelLayout = new GroupLayout(leftCreateMealBarPanel);
        leftCreateMealBarPanel.setLayout(leftCreateMealBarPanelLayout);
        leftCreateMealBarPanelLayout.setHorizontalGroup(
                leftCreateMealBarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(createMealPageNamePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(leftCreateMealBarPanelLayout.createSequentialGroup()
                                .addGroup(leftCreateMealBarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(leftCreateMealBarPanelLayout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(mainCreateMealTitleLabel))
                                        .addGroup(leftCreateMealBarPanelLayout.createSequentialGroup()
                                                .addGap(80, 80, 80)
                                                .addGroup(leftCreateMealBarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(viewMenuCreateMealButton, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(profileInfoCreateMealButton, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(logOutCreateMealButton, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(mainMenuProfileInfoButton1, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(leftCreateMealBarPanelLayout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addComponent(mainCreateMealDescLabel)))
                                .addContainerGap(41, Short.MAX_VALUE))
        );
        leftCreateMealBarPanelLayout.setVerticalGroup(
                leftCreateMealBarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(leftCreateMealBarPanelLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(mainCreateMealTitleLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mainCreateMealDescLabel)
                                .addGap(36, 36, 36)
                                .addComponent(createMealPageNamePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(mainMenuProfileInfoButton1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(profileInfoCreateMealButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(viewMenuCreateMealButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(logOutCreateMealButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(50, Short.MAX_VALUE))
        );

        rightCreateMealBarPanel.setBackground(new Color(255, 255, 255));
        rightCreateMealBarPanel.setMaximumSize(new Dimension(649, 600));
        rightCreateMealBarPanel.setMinimumSize(new Dimension(649, 600));
        rightCreateMealBarPanel.setPreferredSize(new Dimension(649, 600));

        mealTypeCreateMealPanel.setBackground(new Color(234, 251, 251));

        mealTypeCreateMealLabel.setFont(new Font("Segoe UI Semibold", 0, 23)); // NOI18N
        mealTypeCreateMealLabel.setText("Meal Type:");

        uploadImageCreateMealButton.setBackground(new Color(110, 165, 248));
        uploadImageCreateMealButton.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        uploadImageCreateMealButton.setForeground(new Color(255, 255, 255));
        uploadImageCreateMealButton.setText("Upload");
        uploadImageCreateMealButton.setBorder(null);
        uploadImageCreateMealButton.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        uploadImageCreateMealButton.addActionListener(this);

        mealTypeCreateMealTextField.setFont(new Font("Segoe UI", 0, 15)); // NOI18N
        mealTypeCreateMealTextField.setText("No Data");

        mealImageCreateMealPanel.setBackground(new Color(255, 255, 255));
        mealImageCreateMealPanel.setBorder(BorderFactory.createLineBorder(new Color(72, 129, 241), 2));

        GroupLayout mealImageCreateMealPanelLayout = new GroupLayout(mealImageCreateMealPanel);
        mealImageCreateMealPanel.setLayout(mealImageCreateMealPanelLayout);
        mealImageCreateMealPanelLayout.setHorizontalGroup(
                mealImageCreateMealPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mealImageCreateMealLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mealImageCreateMealPanelLayout.setVerticalGroup(
                mealImageCreateMealPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mealImageCreateMealLabel, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
        );

        GroupLayout mealTypeCreateMealPanelLayout = new GroupLayout(mealTypeCreateMealPanel);
        mealTypeCreateMealPanel.setLayout(mealTypeCreateMealPanelLayout);
        mealTypeCreateMealPanelLayout.setHorizontalGroup(
                mealTypeCreateMealPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mealTypeCreateMealPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(mealTypeCreateMealPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(mealTypeCreateMealPanelLayout.createSequentialGroup()
                                                .addComponent(mealTypeCreateMealLabel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(mealTypeCreateMealTextField, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 324, Short.MAX_VALUE))
                                        .addGroup(mealTypeCreateMealPanelLayout.createSequentialGroup()
                                                .addComponent(mealImageCreateMealPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(uploadImageCreateMealButton, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        mealTypeCreateMealPanelLayout.setVerticalGroup(
                mealTypeCreateMealPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, mealTypeCreateMealPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(mealTypeCreateMealPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(mealTypeCreateMealPanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(uploadImageCreateMealButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(mealTypeCreateMealPanelLayout.createSequentialGroup()
                                                .addGroup(mealTypeCreateMealPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(mealTypeCreateMealLabel)
                                                        .addComponent(mealTypeCreateMealTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(mealImageCreateMealPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );

        mealDetailsCreateMealTitleLabel.setBackground(new Color(255, 255, 255));
        mealDetailsCreateMealTitleLabel.setFont(new Font("Segoe UI Semibold", 1, 22)); // NOI18N
        mealDetailsCreateMealTitleLabel.setForeground(new Color(19, 46, 86));
        mealDetailsCreateMealTitleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        mealDetailsCreateMealTitleLabel.setText("Meal Details");

        mealDetailsCreateMealPanel.setBackground(new Color(234, 251, 251));
        mealDetailsCreateMealPanel.setMaximumSize(new Dimension(649, 600));
        mealDetailsCreateMealPanel.setMinimumSize(new Dimension(649, 600));

        mealNameMealDetailsCreateMealLabel.setFont(new Font("Segoe UI Semibold", 0, 18)); // NOI18N
        mealNameMealDetailsCreateMealLabel.setText("Meal Name:");

        mealNameMealDetailsCreateMealTextField.setFont(new Font("Segoe UI", 0, 15)); // NOI18N

        drinkMealDetailsCreateMealLabel.setFont(new Font("Segoe UI Semibold", 0, 18)); // NOI18N
        drinkMealDetailsCreateMealLabel.setText("Drink:");

        drinkMealDetailsCreateMealTextField.setFont(new Font("Segoe UI", 0, 15)); // NOI18

        dateMealDetailsCreateMealLabel.setFont(new Font("Segoe UI Semibold", 0, 18)); // NOI18N
        dateMealDetailsCreateMealLabel.setText("Date:");

        foodGroupMealDetailsCreateMealLabel.setFont(new Font("Segoe UI Semibold", 0, 18)); // NOI18N
        foodGroupMealDetailsCreateMealLabel.setText("Food Group:");

        grainMealDetailsCreateMealCheckBox.setBackground(new Color(234, 251, 251));
        grainMealDetailsCreateMealCheckBox.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        grainMealDetailsCreateMealCheckBox.setText("Grain");

        fruitsMealDetailsCreateMealCheckBox.setBackground(new Color(234, 251, 251));
        fruitsMealDetailsCreateMealCheckBox.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        fruitsMealDetailsCreateMealCheckBox.setText("Fruits");

        vegetablesMealDetailsCreateMealCheckBox.setBackground(new Color(234, 251, 251));
        vegetablesMealDetailsCreateMealCheckBox.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        vegetablesMealDetailsCreateMealCheckBox.setText("Vegetables");

        dairyMealDetailsCreateMealCheckBox.setBackground(new Color(234, 251, 251));
        dairyMealDetailsCreateMealCheckBox.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        dairyMealDetailsCreateMealCheckBox.setText("Dairy");

        proteinFoodsMealDetailsCreateMealCheckBox.setBackground(new Color(234, 251, 251));
        proteinFoodsMealDetailsCreateMealCheckBox.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        proteinFoodsMealDetailsCreateMealCheckBox.setText("Protein foods");

        createMealDetailsCreateMealButton.setBackground(new Color(19, 46, 86));
        createMealDetailsCreateMealButton.setFont(new Font("Segoe UI", 1, 15)); // NOI18N
        createMealDetailsCreateMealButton.setForeground(new Color(255, 255, 255));
        createMealDetailsCreateMealButton.setText("Create");
        createMealDetailsCreateMealButton.setBorder(null);
        createMealDetailsCreateMealButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        createMealDetailsCreateMealButton.addActionListener(this);

        dateMealDetailsCreateMealDateChooser.setDateFormatString("yyyy-MM-dd EEE");

        GroupLayout mealDetailsCreateMealPanelLayout = new GroupLayout(mealDetailsCreateMealPanel);
        mealDetailsCreateMealPanel.setLayout(mealDetailsCreateMealPanelLayout);
        mealDetailsCreateMealPanelLayout.setHorizontalGroup(
                mealDetailsCreateMealPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mealDetailsCreateMealPanelLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(mealDetailsCreateMealPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(mealDetailsCreateMealPanelLayout.createSequentialGroup()
                                                .addGroup(mealDetailsCreateMealPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(mealDetailsCreateMealPanelLayout.createSequentialGroup()
                                                                .addComponent(foodGroupMealDetailsCreateMealLabel)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(grainMealDetailsCreateMealCheckBox, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(vegetablesMealDetailsCreateMealCheckBox)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(dairyMealDetailsCreateMealCheckBox, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(mealDetailsCreateMealPanelLayout.createSequentialGroup()
                                                                .addGap(190, 190, 190)
                                                                .addComponent(createMealDetailsCreateMealButton, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fruitsMealDetailsCreateMealCheckBox, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(proteinFoodsMealDetailsCreateMealCheckBox))
                                        .addGroup(mealDetailsCreateMealPanelLayout.createSequentialGroup()
                                                .addGroup(mealDetailsCreateMealPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(mealNameMealDetailsCreateMealLabel)
                                                        .addComponent(drinkMealDetailsCreateMealLabel))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(mealDetailsCreateMealPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(drinkMealDetailsCreateMealTextField, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(mealNameMealDetailsCreateMealTextField, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
                                                .addGap(36, 36, 36)
                                                .addGroup(mealDetailsCreateMealPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(dateMealDetailsCreateMealLabel))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(mealDetailsCreateMealPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(dateMealDetailsCreateMealDateChooser, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mealDetailsCreateMealPanelLayout.setVerticalGroup(
                mealDetailsCreateMealPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mealDetailsCreateMealPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(mealDetailsCreateMealPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(dateMealDetailsCreateMealDateChooser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(mealDetailsCreateMealPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(mealNameMealDetailsCreateMealLabel)
                                                .addComponent(mealNameMealDetailsCreateMealTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(dateMealDetailsCreateMealLabel)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(mealDetailsCreateMealPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(drinkMealDetailsCreateMealLabel)
                                        .addComponent(drinkMealDetailsCreateMealTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(mealDetailsCreateMealPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(foodGroupMealDetailsCreateMealLabel)
                                        .addComponent(grainMealDetailsCreateMealCheckBox)
                                        .addComponent(vegetablesMealDetailsCreateMealCheckBox)
                                        .addComponent(dairyMealDetailsCreateMealCheckBox)
                                        .addComponent(fruitsMealDetailsCreateMealCheckBox)
                                        .addComponent(proteinFoodsMealDetailsCreateMealCheckBox))
                                .addGap(18, 18, 18)
                                .addComponent(createMealDetailsCreateMealButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout rightCreateMealBarPanelLayout = new GroupLayout(rightCreateMealBarPanel);
        rightCreateMealBarPanel.setLayout(rightCreateMealBarPanelLayout);
        rightCreateMealBarPanelLayout.setHorizontalGroup(
                rightCreateMealBarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, rightCreateMealBarPanelLayout.createSequentialGroup()
                                .addContainerGap(27, Short.MAX_VALUE)
                                .addGroup(rightCreateMealBarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(mealDetailsCreateMealPanel, GroupLayout.PREFERRED_SIZE, 588, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(mealTypeCreateMealPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32))
                        .addGroup(rightCreateMealBarPanelLayout.createSequentialGroup()
                                .addGap(254, 254, 254)
                                .addComponent(mealDetailsCreateMealTitleLabel, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        rightCreateMealBarPanelLayout.setVerticalGroup(
                rightCreateMealBarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(rightCreateMealBarPanelLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(mealTypeCreateMealPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mealDetailsCreateMealTitleLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mealDetailsCreateMealPanel, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        GroupLayout createMealPanelLayout = new GroupLayout(createMealPanel);
        createMealPanel.setLayout(createMealPanelLayout);
        createMealPanelLayout.setHorizontalGroup(
                createMealPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(createMealPanelLayout.createSequentialGroup()
                                .addComponent(leftCreateMealBarPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(rightCreateMealBarPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        createMealPanelLayout.setVerticalGroup(
                createMealPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(leftCreateMealBarPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(rightCreateMealBarPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        /*===========Profile Info Component Specification===================*/
        profileInfoPanel.setMaximumSize(new Dimension(1000, 600));
        profileInfoPanel.setMinimumSize(new Dimension(1000, 600));
        profileInfoPanel.setPreferredSize(new Dimension(1000, 650));

        leftProfileInfoBarPanel.setBackground(new Color(72, 129, 241));
        leftProfileInfoBarPanel.setPreferredSize(new Dimension(350, 650));

        mainProfileInfoDescLabel.setFont(new Font("Segoe UI", 2, 20)); // NOI18N
        mainProfileInfoDescLabel.setForeground(new Color(255, 255, 255));
        mainProfileInfoDescLabel.setText("A place for your profile details.");

        mainProfileInfoTitleLabel1.setFont(new Font("Segoe UI", 1, 55)); // NOI18N
        mainProfileInfoTitleLabel1.setForeground(new Color(255, 255, 255));
        mainProfileInfoTitleLabel1.setText("Meal Diary");

        profileInfoCreateMeaTitlelLabel.setFont(new Font("Segoe UI Semibold", 0, 26)); // NOI18N
        profileInfoCreateMeaTitlelLabel.setForeground(new Color(255, 255, 255));
        profileInfoCreateMeaTitlelLabel.setText("Create Meal");

        profileInfoPageNamePanel.setBackground(new Color(193, 214, 246));
        profileInfoPageNamePanel.setMaximumSize(new Dimension(350, 88));
        profileInfoPageNamePanel.setMinimumSize(new Dimension(350, 88));
        profileInfoPageNamePanel.setPreferredSize(new Dimension(350, 88));

        profilePageTitleLabel.setFont(new Font("Segoe UI Semibold", 0, 30)); // NOI18N
        profilePageTitleLabel.setForeground(new Color(19, 46, 86));
        profilePageTitleLabel.setText("Profile Info Page");

        GroupLayout profileInfoPageNamePanelLayout = new GroupLayout(profileInfoPageNamePanel);
        profileInfoPageNamePanel.setLayout(profileInfoPageNamePanelLayout);
        profileInfoPageNamePanelLayout.setHorizontalGroup(
                profileInfoPageNamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(profileInfoPageNamePanelLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(profilePageTitleLabel)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        profileInfoPageNamePanelLayout.setVerticalGroup(
                profileInfoPageNamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(profileInfoPageNamePanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(profilePageTitleLabel)
                                .addContainerGap(23, Short.MAX_VALUE))
        );

        profileInfoMealTypeComboBox.setFont(new Font("Segoe UI", 0, 15)); // NOI18N
        profileInfoMealTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Breakfast", "Lunch", "Dinner" }));
        profileInfoMealTypeComboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        profileInfoMealTypeComboBox.setFocusable(false);

        createMealProfileInfoButton.setBackground(new Color(19, 46, 86));
        createMealProfileInfoButton.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        createMealProfileInfoButton.setForeground(new Color(255, 255, 255));
        createMealProfileInfoButton.setText("OK");
        createMealProfileInfoButton.setBorder(null);
        createMealProfileInfoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        createMealProfileInfoButton.setFocusable(false);
        createMealProfileInfoButton.addActionListener(this);

        mainMenuProfileInfoButton.setBackground(new Color(110, 165, 248));
        mainMenuProfileInfoButton.setFont(new Font("Segoe UI", 1, 20)); // NOI18N
        mainMenuProfileInfoButton.setForeground(new Color(255, 255, 255));
        mainMenuProfileInfoButton.setText("Main Menu");
        mainMenuProfileInfoButton.setBorder(null);
        mainMenuProfileInfoButton.setBorderPainted(false);
        mainMenuProfileInfoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mainMenuProfileInfoButton.setFocusPainted(false);
        mainMenuProfileInfoButton.addActionListener(this);

        viewMenuProfileInfoButton.setBackground(new Color(110, 165, 248));
        viewMenuProfileInfoButton.setFont(new Font("Segoe UI", 1, 20)); // NOI18N
        viewMenuProfileInfoButton.setForeground(new Color(255, 255, 255));
        viewMenuProfileInfoButton.setText("View Meal");
        viewMenuProfileInfoButton.setBorder(null);
        viewMenuProfileInfoButton.setBorderPainted(false);
        viewMenuProfileInfoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        viewMenuProfileInfoButton.setFocusPainted(false);
        viewMenuProfileInfoButton.addActionListener(this);

        logOutProfileInfoButton.setBackground(new Color(110, 165, 248));
        logOutProfileInfoButton.setFont(new Font("Segoe UI", 1, 20)); // NOI18N
        logOutProfileInfoButton.setForeground(new Color(255, 255, 255));
        logOutProfileInfoButton.setText("Log Out");
        logOutProfileInfoButton.setBorder(null);
        logOutProfileInfoButton.setBorderPainted(false);
        logOutProfileInfoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logOutProfileInfoButton.setFocusPainted(false);
        logOutProfileInfoButton.addActionListener(this);

        GroupLayout leftProfileInfoBarPanelLayout = new GroupLayout(leftProfileInfoBarPanel);
        leftProfileInfoBarPanel.setLayout(leftProfileInfoBarPanelLayout);
        leftProfileInfoBarPanelLayout.setHorizontalGroup(
                leftProfileInfoBarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(profileInfoPageNamePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(leftProfileInfoBarPanelLayout.createSequentialGroup()
                                .addGroup(leftProfileInfoBarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(leftProfileInfoBarPanelLayout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addGroup(leftProfileInfoBarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(leftProfileInfoBarPanelLayout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(mainProfileInfoDescLabel))
                                                        .addComponent(mainProfileInfoTitleLabel1)))
                                        .addGroup(leftProfileInfoBarPanelLayout.createSequentialGroup()
                                                .addGap(97, 97, 97)
                                                .addComponent(profileInfoCreateMeaTitlelLabel))
                                        .addGroup(leftProfileInfoBarPanelLayout.createSequentialGroup()
                                                .addGap(47, 47, 47)
                                                .addComponent(profileInfoMealTypeComboBox, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(createMealProfileInfoButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(leftProfileInfoBarPanelLayout.createSequentialGroup()
                                                .addGap(73, 73, 73)
                                                .addGroup(leftProfileInfoBarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(viewMenuProfileInfoButton, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(mainMenuProfileInfoButton, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(logOutProfileInfoButton, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(41, Short.MAX_VALUE))
        );
        leftProfileInfoBarPanelLayout.setVerticalGroup(
                leftProfileInfoBarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(leftProfileInfoBarPanelLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(mainProfileInfoTitleLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mainProfileInfoDescLabel)
                                .addGap(36, 36, 36)
                                .addComponent(profileInfoPageNamePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(profileInfoCreateMeaTitlelLabel)
                                .addGap(4, 4, 4)
                                .addGroup(leftProfileInfoBarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(leftProfileInfoBarPanelLayout.createSequentialGroup()
                                                .addComponent(createMealProfileInfoButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(2, 2, 2))
                                        .addComponent(profileInfoMealTypeComboBox))
                                .addGap(32, 32, 32)
                                .addComponent(mainMenuProfileInfoButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(viewMenuProfileInfoButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(logOutProfileInfoButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85))
        );

        rightProfileInfoBarPanel.setBackground(new Color(255, 255, 255));

        profileInfoUserTitleLabel.setBackground(new Color(255, 255, 255));
        profileInfoUserTitleLabel.setFont(new Font("Segoe UI", 1, 35)); // NOI18N
        profileInfoUserTitleLabel.setForeground(new Color(19, 46, 86));
        profileInfoUserTitleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        profileInfoUserTitleLabel.setText("More About You.");

        profileInfoUserQuoteLabel.setFont(new Font("Segoe UI", 2, 15)); // NOI18N
        profileInfoUserQuoteLabel.setText("User's Information");

        userProfileInfoPanel.setBackground(new Color(234, 251, 251));

        usernameProfileInfoLabel.setFont(new Font("Segoe UI Semibold", 0, 25)); // NOI18N
        usernameProfileInfoLabel.setText("Username:");

        fullnameProfileInfoLabel.setFont(new Font("Segoe UI Semibold", 0, 25)); // NOI18N
        fullnameProfileInfoLabel.setText("Full name:");

        ageProfileInfoLabel.setFont(new Font("Segoe UI Semibold", 0, 25)); // NOI18N
        ageProfileInfoLabel.setText("Age:");

        usernameProfileInfoTextField.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        fullnameProfileInfoTextField.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        ageProfileInfoTextField.setFont(new Font("Segoe UI", 0, 18)); // NOI18N

        usernameProfileInfoTextField.setEditable(false);
        fullnameProfileInfoTextField.setEditable(false);
        ageProfileInfoTextField.setEditable(false);

        deleteAccountProfileInfoButton.setBackground(new Color(110, 165, 248));
        deleteAccountProfileInfoButton.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        deleteAccountProfileInfoButton.setForeground(new Color(255, 255, 255));
        deleteAccountProfileInfoButton.setText("Delete Account");
        deleteAccountProfileInfoButton.setBorder(null);
        deleteAccountProfileInfoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deleteAccountProfileInfoButton.addActionListener(this);

        GroupLayout userProfileInfoPanelLayout = new GroupLayout(userProfileInfoPanel);
        userProfileInfoPanel.setLayout(userProfileInfoPanelLayout);
        userProfileInfoPanelLayout.setHorizontalGroup(
                userProfileInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, userProfileInfoPanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deleteAccountProfileInfoButton, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
                        .addGroup(userProfileInfoPanelLayout.createSequentialGroup()
                                .addGroup(userProfileInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(userProfileInfoPanelLayout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addGroup(userProfileInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(userProfileInfoPanelLayout.createSequentialGroup()
                                                                .addComponent(usernameProfileInfoLabel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(usernameProfileInfoTextField, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(userProfileInfoPanelLayout.createSequentialGroup()
                                                                .addComponent(fullnameProfileInfoLabel)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(fullnameProfileInfoTextField, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(userProfileInfoPanelLayout.createSequentialGroup()
                                                .addGap(105, 105, 105)
                                                .addComponent(ageProfileInfoLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(ageProfileInfoTextField, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(101, Short.MAX_VALUE))
        );
        userProfileInfoPanelLayout.setVerticalGroup(
                userProfileInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(userProfileInfoPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(deleteAccountProfileInfoButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addGroup(userProfileInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(usernameProfileInfoLabel)
                                        .addComponent(usernameProfileInfoTextField))
                                .addGap(15, 15, 15)
                                .addGroup(userProfileInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(fullnameProfileInfoLabel)
                                        .addComponent(fullnameProfileInfoTextField))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(userProfileInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(ageProfileInfoLabel)
                                        .addComponent(ageProfileInfoTextField))
                                .addGap(25, 25, 25))
        );

        updateInfoProfileInfoTitleLabel.setBackground(new Color(255, 255, 255));
        updateInfoProfileInfoTitleLabel.setFont(new Font("Segoe UI", 1, 35)); // NOI18N
        updateInfoProfileInfoTitleLabel.setForeground(new Color(19, 46, 86));
        updateInfoProfileInfoTitleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        updateInfoProfileInfoTitleLabel.setText("Update Info");

        updateInfoProfileInfoQuoteLabel.setFont(new Font("Segoe UI", 2, 15)); // NOI18N
        updateInfoProfileInfoQuoteLabel.setText("Choose which info you want to update.");

        updateInfoProfileInfoOKButton.setPreferredSize(new Dimension(40, 31));
        updateInfoProfileInfoOKButton.setMinimumSize(new Dimension(40, 31));
        updateInfoProfileInfoOKButton.setMaximumSize(new Dimension(40, 31));

        updateInfoProfileInfoOKButton.setFocusable(false);
        updateInfoProfileInfoOKButton.setBackground(new Color(19, 46, 86));
        updateInfoProfileInfoOKButton.setFont(new Font("Segoe UI", 1, 13)); // NOI18N
        updateInfoProfileInfoOKButton.setForeground(new Color(255, 255, 255));
        updateInfoProfileInfoOKButton.setText("OK");
        updateInfoProfileInfoOKButton.setBorder(null);
        updateInfoProfileInfoOKButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        updateInfoProfileInfoOKButton.addActionListener(this);

        updateInfoProfileInfoUpdateTypeComboBox.setPreferredSize(new Dimension(98, 31));
        updateInfoProfileInfoUpdateTypeComboBox.setMinimumSize(new Dimension(98, 31));
        updateInfoProfileInfoUpdateTypeComboBox.setMaximumSize(new Dimension(98, 31));
        updateInfoProfileInfoUpdateTypeComboBox.setFont(new Font("Segoe UI", 0, 15)); // NOI18N
        updateInfoProfileInfoUpdateTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Username", "Full Name", "Age" }));
        updateInfoProfileInfoUpdateTypeComboBox.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        updateInfoProfileInfoUpdateTypeComboBox.setFocusable(false);

        GroupLayout rightProfileInfoBarPanelLayout = new GroupLayout(rightProfileInfoBarPanel);
        rightProfileInfoBarPanel.setLayout(rightProfileInfoBarPanelLayout);
        rightProfileInfoBarPanelLayout.setHorizontalGroup(
                rightProfileInfoBarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, rightProfileInfoBarPanelLayout.createSequentialGroup()
                                .addContainerGap(42, Short.MAX_VALUE)
                                .addGroup(rightProfileInfoBarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(updateInfoProfileInfoTitleLabel, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(updateInfoProfileInfoQuoteLabel, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(profileInfoUserQuoteLabel, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(profileInfoUserTitleLabel, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(rightProfileInfoBarPanelLayout.createSequentialGroup()
                                                .addComponent(updateInfoProfileInfoUpdateTypeComboBox, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(updateInfoProfileInfoOKButton))
                                        .addComponent(userProfileInfoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40))
        );
        rightProfileInfoBarPanelLayout.setVerticalGroup(
                rightProfileInfoBarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(rightProfileInfoBarPanelLayout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(profileInfoUserTitleLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(profileInfoUserQuoteLabel)
                                .addGap(18, 18, 18)
                                .addComponent(userProfileInfoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(updateInfoProfileInfoTitleLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateInfoProfileInfoQuoteLabel)
                                .addGap(18, 18, 18)
                                .addGroup(rightProfileInfoBarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(rightProfileInfoBarPanelLayout.createSequentialGroup()
                                                .addComponent(updateInfoProfileInfoOKButton)
                                                .addGap(2, 2, 2))
                                        .addComponent(updateInfoProfileInfoUpdateTypeComboBox))
                                .addGap(76, 76, 76))
        );

        GroupLayout profileInfoPanelLayout = new GroupLayout(profileInfoPanel);
        profileInfoPanel.setLayout(profileInfoPanelLayout);
        profileInfoPanelLayout.setHorizontalGroup(
                profileInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(profileInfoPanelLayout.createSequentialGroup()
                                .addComponent(leftProfileInfoBarPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(rightProfileInfoBarPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        profileInfoPanelLayout.setVerticalGroup(
                profileInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(leftProfileInfoBarPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(rightProfileInfoBarPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        /*===========View Meals Page Component Specification===================*/
        viewMealPanel.setMaximumSize(new Dimension(1000, 650));
        viewMealPanel.setPreferredSize(new Dimension(1000, 650));

        viewMealPanel.setBackground(new Color(255, 255, 255));

        sidebarViewMeal.setBackground(new Color(72, 129, 241));
        sidebarViewMeal.setMaximumSize(new Dimension(350, 650));
        sidebarViewMeal.setMinimumSize(new Dimension(350, 650));
        sidebarViewMeal.setName(""); // NOI18N

        viewMealsTitleLabel1.setFont(new Font("Segoe UI", 1, 55)); // NOI18N
        viewMealsTitleLabel1.setForeground(new Color(255, 255, 255));
        viewMealsTitleLabel1.setText("Meal Diary");

        viewMealsTitleLabel2.setFont(new Font("Segoe UI", 2, 17)); // NOI18N
        viewMealsTitleLabel2.setForeground(new Color(255, 255, 255));
        viewMealsTitleLabel2.setText("List of history meals.");

        viewMealsTitleLabel3.setBackground(new Color(255, 255, 255));
        viewMealsTitleLabel3.setFont(new Font("Segoe UI Semibold", 0, 30)); // NOI18N
        viewMealsTitleLabel3.setForeground(new Color(19, 46, 86));
        viewMealsTitleLabel3.setText("Meal Detail Page");

        viewMealsTitlePanel3.setBackground(new Color(193,214,246));
        GroupLayout viewMealsTitlePanel3Layout = new GroupLayout(viewMealsTitlePanel3);
        viewMealsTitlePanel3.setLayout(viewMealsTitlePanel3Layout);
        viewMealsTitlePanel3Layout.setHorizontalGroup(
                viewMealsTitlePanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(viewMealsTitlePanel3Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(viewMealsTitleLabel3)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        viewMealsTitlePanel3Layout.setVerticalGroup(
                viewMealsTitlePanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(viewMealsTitlePanel3Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(viewMealsTitleLabel3)
                                .addContainerGap(29, Short.MAX_VALUE))
        );

        createMealViewMealTitleLabel.setFont(new Font("Segoe UI", 0, 27)); // NOI18N
        createMealViewMealTitleLabel.setForeground(new Color(255, 255, 255));
        createMealViewMealTitleLabel.setText("Create Meal");

        viewMealDropdown.setBackground(new Color(255, 255, 255));
        viewMealDropdown.setFont(new Font("Segoe UI", 0, 15)); // NOI18N
        viewMealDropdown.setModel(new DefaultComboBoxModel<>(new String[] { "Breakfast", "Lunch", "Dinner" }));
        viewMealDropdown.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        viewMealDropdown.setFocusable(false);

        createMealViewMealButton.setBackground(new Color(19, 46, 86));
        createMealViewMealButton.setFont(new Font("Segoe UI", 1, 15)); // NOI18N
        createMealViewMealButton.setForeground(new Color(255, 255, 255));
        createMealViewMealButton.setText("OK");
        createMealViewMealButton.setBorder(null);
        createMealViewMealButton.setFocusable(false);
        createMealViewMealButton.addActionListener(this);

        mainMenuViewMealButton.setBackground(new Color(110, 165, 248));
        mainMenuViewMealButton.setFont(new Font("Segoe UI Semibold", 0, 20)); // NOI18N
        mainMenuViewMealButton.setForeground(new Color(255, 255, 255));
        mainMenuViewMealButton.setText("Main Menu");
        mainMenuViewMealButton.setBorder(null);
        mainMenuViewMealButton.setFocusable(false);
        mainMenuViewMealButton.addActionListener(this);

        profileViewMealButton.setBackground(new Color(110, 165, 248));
        profileViewMealButton.setFont(new Font("Segoe UI Semibold", 0, 20)); // NOI18N
        profileViewMealButton.setForeground(new Color(255, 255, 255));
        profileViewMealButton.setText("Profile Info");
        profileViewMealButton.setBorder(null);
        profileViewMealButton.setFocusable(false);
        profileViewMealButton.addActionListener(this);

        logoutViewMealButton.setBackground(new Color(110, 165, 248));
        logoutViewMealButton.setFont(new Font("Segoe UI Semibold", 0, 20)); // NOI18N
        logoutViewMealButton.setForeground(new Color(255, 255, 255));
        logoutViewMealButton.setText("Logout");
        logoutViewMealButton.setBorder(null);
        logoutViewMealButton.setFocusable(false);
        logoutViewMealButton.addActionListener(this);

        GroupLayout sidebarViewMealLayout = new GroupLayout(sidebarViewMeal);
        sidebarViewMeal.setLayout(sidebarViewMealLayout);
        sidebarViewMealLayout.setHorizontalGroup(
                sidebarViewMealLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(viewMealsTitlePanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(sidebarViewMealLayout.createSequentialGroup()
                                .addGroup(sidebarViewMealLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(sidebarViewMealLayout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addComponent(viewMealsTitleLabel1))
                                        .addGroup(sidebarViewMealLayout.createSequentialGroup()
                                                .addGap(88, 88, 88)
                                                .addComponent(createMealViewMealTitleLabel))
                                        .addGroup(sidebarViewMealLayout.createSequentialGroup()
                                                .addGap(58, 58, 58)
                                                .addComponent(viewMealDropdown, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(createMealViewMealButton, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(sidebarViewMealLayout.createSequentialGroup()
                                                .addGap(69, 69, 69)
                                                .addGroup(sidebarViewMealLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(mainMenuViewMealButton, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(profileViewMealButton, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(logoutViewMealButton, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(35, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, sidebarViewMealLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(viewMealsTitleLabel2)
                                .addGap(98, 98, 98))
        );
        sidebarViewMealLayout.setVerticalGroup(
                sidebarViewMealLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(sidebarViewMealLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(viewMealsTitleLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(viewMealsTitleLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(viewMealsTitlePanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(createMealViewMealTitleLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(sidebarViewMealLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(viewMealDropdown, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(createMealViewMealButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addComponent(mainMenuViewMealButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(profileViewMealButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(logoutViewMealButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(74, Short.MAX_VALUE))
        );

        viewMealSearchLabel1.setFont(new Font("Segoe UI Semibold", 1, 35)); // NOI18N
        viewMealSearchLabel1.setForeground(new Color(0, 0, 0));
        viewMealSearchLabel1.setText("Search Your Past Meals");

        viewMealSearchLabel2.setFont(new Font("Segoe UI", 2, 17)); // NOI18N
        viewMealSearchLabel2.setForeground(new Color(0, 0, 0));
        viewMealSearchLabel2.setText("Use the search category to find history meals.");

        viewMealSearchLabel3.setFont(new Font("Segoe UI Semibold", 1, 20)); // NOI18N
        viewMealSearchLabel3.setForeground(new Color(0, 0, 0));
        viewMealSearchLabel3.setText("Search by:");

        searchCategoryLabel1.setFont(new Font("Segoe UI Semibold", 0, 15)); // NOI18N
        searchCategoryLabel1.setForeground(new Color(0, 0, 0));
        searchCategoryLabel1.setText("Meal Type ");

        mealTypeSearchDropdown.setBackground(new Color(255, 255, 255));
        mealTypeSearchDropdown.setFont(new Font("Segoe UI", 0, 15)); // NOI18N
        mealTypeSearchDropdown.setForeground(new Color(0, 0, 0));
        mealTypeSearchDropdown.setModel(new DefaultComboBoxModel<>(new String[] { "All", "Breakfast", "Lunch", "Dinner" }));
        mealTypeSearchDropdown.setBorder(null);
        mealTypeSearchDropdown.setFocusable(false);

        searchCategoryLabel2.setFont(new Font("Segoe UI Semibold", 0, 15)); // NOI18N
        searchCategoryLabel2.setForeground(new Color(0, 0, 0));
        searchCategoryLabel2.setText("Food Group");

        foodGroupSearchDropdown.setBackground(new Color(255, 255, 255));
        foodGroupSearchDropdown.setFont(new Font("Segoe UI", 0, 15)); // NOI18N
        foodGroupSearchDropdown.setForeground(new Color(0, 0, 0));
        foodGroupSearchDropdown.setModel(new DefaultComboBoxModel<>(new String[] { "All", "Fruits", "Vegetables", "Grains", "Protein Foods", "Dairy" }));
        foodGroupSearchDropdown.setBorder(null);
        foodGroupSearchDropdown.setFocusable(false);

        searchMealScrollPane.setBorder(BorderFactory.createLineBorder(new Color(10, 119, 210), 3));
        searchMealScrollPane.setForeground(new Color(255, 255, 255));
        searchMealScrollPane.setFont(new Font("Tahoma", 1, 15)); // NOI18N
        searchMealScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        searchMealTable.setAutoCreateRowSorter(true);
        searchMealTable.setBackground(new Color(232, 240, 243));
        searchMealTable.setBorder(BorderFactory.createLineBorder(new Color(72, 129, 241)));
        searchMealTable.setFont(new Font("Segoe UI", 0, 15)); // NOI18N
        searchMealTable.setGridColor(new Color(72, 129, 241));
        searchMealTable.setSelectionBackground(Color.lightGray);
        searchMealTable.setShowGrid(true);

        searchMealScrollPane.setViewportView(searchMealTable);

        searchMealButton.setBackground(new Color(19, 46, 86));
        searchMealButton.setFont(new Font("Segoe UI", 1, 15)); // NOI18N
        searchMealButton.setForeground(new Color(255, 255, 255));
        searchMealButton.setText("Search");
        searchMealButton.setBorder(null);
        searchMealButton.setFocusable(false);
        searchMealButton.addActionListener(this);

        editMealLabel.setFont(new Font("Segoe UI", 2, 17)); // NOI18N
        editMealLabel.setForeground(new Color(0, 0, 0));
        editMealLabel.setText("Select meal in the table to edit or delete.");

        editMealButton.setBackground(new Color(19, 46, 86));
        editMealButton.setFont(new Font("Segoe UI", 1, 15)); // NOI18N
        editMealButton.setForeground(new Color(255, 255, 255));
        editMealButton.setText("Edit");
        editMealButton.setBorder(null);
        editMealButton.setFocusable(false);
        editMealButton.addActionListener(this);

        deleteMealButton.setBackground(new Color(19, 46, 86));
        deleteMealButton.setFont(new Font("Segoe UI", 1, 15)); // NOI18N
        deleteMealButton.setForeground(new Color(255, 255, 255));
        deleteMealButton.setText("Delete");
        deleteMealButton.setBorder(null);
        deleteMealButton.setFocusable(false);
        deleteMealButton.addActionListener(this);

        searchMealQueryLabel.setBackground(new Color(153, 204, 255));
        searchMealQueryLabel.setFont(new Font("Segoe UI", 2, 14)); // NOI18N
        searchMealQueryLabel.setForeground(new Color(0, 0, 0));
        searchMealQueryLabel.setText("0 Meal Record found.");
        searchMealQueryLabel.setOpaque(true);

        GroupLayout viewMealPanelLayout = new GroupLayout(viewMealPanel);
        viewMealPanel.setLayout(viewMealPanelLayout);
        viewMealPanelLayout.setHorizontalGroup(
                viewMealPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(viewMealPanelLayout.createSequentialGroup()
                                .addComponent(sidebarViewMeal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(viewMealPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(viewMealPanelLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(viewMealPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(viewMealPanelLayout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addGroup(viewMealPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(viewMealPanelLayout.createSequentialGroup()
                                                                                .addComponent(searchCategoryLabel1)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(mealTypeSearchDropdown, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(searchCategoryLabel2)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(foodGroupSearchDropdown, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(searchMealButton, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addGroup(viewMealPanelLayout.createSequentialGroup()
                                                                                .addComponent(viewMealSearchLabel3)
                                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addGroup(viewMealPanelLayout.createSequentialGroup()
                                                                                .addGroup(viewMealPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(searchMealQueryLabel)
                                                                                        .addComponent(searchMealScrollPane, GroupLayout.PREFERRED_SIZE, 592, GroupLayout.PREFERRED_SIZE))
                                                                                .addContainerGap(34, Short.MAX_VALUE))))
                                                        .addGroup(viewMealPanelLayout.createSequentialGroup()
                                                                .addGroup(viewMealPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(viewMealSearchLabel1)
                                                                        .addComponent(viewMealSearchLabel2))
                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                        .addGroup(viewMealPanelLayout.createSequentialGroup()
                                                .addGroup(viewMealPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(viewMealPanelLayout.createSequentialGroup()
                                                                .addGap(177, 177, 177)
                                                                .addComponent(editMealLabel))
                                                        .addGroup(viewMealPanelLayout.createSequentialGroup()
                                                                .addGap(226, 226, 226)
                                                                .addComponent(editMealButton, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(deleteMealButton, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap())))
        );
        viewMealPanelLayout.setVerticalGroup(
                viewMealPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(viewMealPanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(viewMealSearchLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(viewMealSearchLabel2)
                                .addGap(20, 20, 20)
                                .addComponent(viewMealSearchLabel3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(viewMealPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchCategoryLabel1)
                                        .addComponent(mealTypeSearchDropdown, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchCategoryLabel2)
                                        .addComponent(foodGroupSearchDropdown, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchMealButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchMealQueryLabel)
                                .addGap(4, 4, 4)
                                .addComponent(searchMealScrollPane, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editMealLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(viewMealPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(editMealButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deleteMealButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(viewMealPanelLayout.createSequentialGroup()
                                .addComponent(sidebarViewMeal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        /*===========Edit Meals Page Component Specification===================*/
        editMealPanel.setBackground(new Color(255, 255, 255));
        editMealPanel.setMaximumSize(new Dimension(1000, 600));
        editMealPanel.setMinimumSize(new Dimension(1000, 600));

        sidebarEditMeal.setBackground(new Color(72, 129, 241));
        sidebarEditMeal.setMaximumSize(new Dimension(350, 600));
        sidebarEditMeal.setMinimumSize(new Dimension(350, 600));
        sidebarEditMeal.setPreferredSize(new Dimension(350, 600));

        editMealTitleLabel1.setFont(new Font("Segoe UI", 1, 55)); // NOI18N
        editMealTitleLabel1.setForeground(new Color(255, 255, 255));
        editMealTitleLabel1.setText("Meal Diary");

        editMealTitleLabel2.setFont(new Font("Segoe UI", 2, 17)); // NOI18N
        editMealTitleLabel2.setForeground(new Color(255, 255, 255));
        editMealTitleLabel2.setText("Make changes to your meal record.");

        editMealTitleLabel3.setBackground(new Color(193,214,246));
        editMealTitleLabel3.setFont(new Font("Segoe UI Semibold", 0, 30)); // NOI18N
        editMealTitleLabel3.setForeground(new Color(19, 46, 86));
        editMealTitleLabel3.setText("Edit Meal Page");

        editMealTitllePanel3.setBackground(new Color(193,214,246));

        GroupLayout editMealTitllePanel3Layout = new GroupLayout(editMealTitllePanel3);
        editMealTitllePanel3.setLayout(editMealTitllePanel3Layout);
        editMealTitllePanel3Layout.setHorizontalGroup(
                editMealTitllePanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(editMealTitllePanel3Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(editMealTitleLabel3)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        editMealTitllePanel3Layout.setVerticalGroup(
                editMealTitllePanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(editMealTitllePanel3Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(editMealTitleLabel3)
                                .addContainerGap(29, Short.MAX_VALUE))
        );

        createMealEditMealTitleLabel.setFont(new Font("Segoe UI", 0, 27)); // NOI18N
        createMealEditMealTitleLabel.setForeground(new Color(255, 255, 255));
        createMealEditMealTitleLabel.setText("Create Meal");

        editMealDropdown.setBackground(new Color(255, 255, 255));
        editMealDropdown.setFont(new Font("Segoe UI", 0, 15)); // NOI18N
        editMealDropdown.setModel(new DefaultComboBoxModel<>(new String[] { "Breakfast", "Lunch", "Dinner" }));
        editMealDropdown.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        editMealDropdown.setFocusable(false);

        createMealEditMealButton.setBackground(new Color(19, 46, 86));
        createMealEditMealButton.setFont(new Font("Segoe UI", 1, 15)); // NOI18N
        createMealEditMealButton.setForeground(new Color(255, 255, 255));
        createMealEditMealButton.setText("OK");
        createMealEditMealButton.setBorder(null);
        createMealEditMealButton.setFocusable(false);
        createMealEditMealButton.addActionListener(this);

        mainEditMealBtn.setBackground(new Color(110, 165, 248));
        mainEditMealBtn.setFont(new Font("Segoe UI Semibold", 0, 20)); // NOI18N
        mainEditMealBtn.setForeground(new Color(255, 255, 255));
        mainEditMealBtn.setText("Main Menu");
        mainEditMealBtn.setBorder(null);
        mainEditMealBtn.setFocusable(false);
        mainEditMealBtn.addActionListener(this);

        searchEditMealBtn.setBackground(new Color(110, 165, 248));
        searchEditMealBtn.setFont(new Font("Segoe UI Semibold", 0, 20)); // NOI18N
        searchEditMealBtn.setForeground(new Color(255, 255, 255));
        searchEditMealBtn.setText("Search Meals");
        searchEditMealBtn.setBorder(null);
        searchEditMealBtn.setFocusable(false);
        searchEditMealBtn.addActionListener(this);

        profileEditMealBtn.setBackground(new Color(110, 165, 248));
        profileEditMealBtn.setFont(new Font("Segoe UI Semibold", 0, 20)); // NOI18N
        profileEditMealBtn.setForeground(new Color(255, 255, 255));
        profileEditMealBtn.setText("Profile Info");
        profileEditMealBtn.setBorder(null);
        profileEditMealBtn.setFocusable(false);
        profileEditMealBtn.addActionListener(this);

        logoutEditMealBtn.setBackground(new Color(110, 165, 248));
        logoutEditMealBtn.setFont(new Font("Segoe UI Semibold", 0, 20)); // NOI18N
        logoutEditMealBtn.setForeground(new Color(255, 255, 255));
        logoutEditMealBtn.setText("Logout");
        logoutEditMealBtn.setBorder(null);
        logoutEditMealBtn.setFocusable(false);
        logoutEditMealBtn.addActionListener(this);

        GroupLayout sidebarEditMealLayout = new GroupLayout(sidebarEditMeal);
        sidebarEditMeal.setLayout(sidebarEditMealLayout);
        sidebarEditMealLayout.setHorizontalGroup(
                sidebarEditMealLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(editMealTitllePanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(sidebarEditMealLayout.createSequentialGroup()
                                .addGroup(sidebarEditMealLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(sidebarEditMealLayout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addGroup(sidebarEditMealLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(editMealTitleLabel1)
                                                        .addGroup(sidebarEditMealLayout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(editMealTitleLabel2))))
                                        .addGroup(sidebarEditMealLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addGroup(sidebarEditMealLayout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(mainEditMealBtn, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(GroupLayout.Alignment.LEADING, sidebarEditMealLayout.createSequentialGroup()
                                                        .addGap(69, 69, 69)
                                                        .addGroup(sidebarEditMealLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(searchEditMealBtn, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                                                .addComponent(profileEditMealBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(logoutEditMealBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGroup(sidebarEditMealLayout.createSequentialGroup()
                                                .addGap(88, 88, 88)
                                                .addComponent(createMealEditMealTitleLabel))
                                        .addGroup(sidebarEditMealLayout.createSequentialGroup()
                                                .addGap(58, 58, 58)
                                                .addComponent(editMealDropdown, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(createMealEditMealButton, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(35, Short.MAX_VALUE))
        );
        sidebarEditMealLayout.setVerticalGroup(
                sidebarEditMealLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(sidebarEditMealLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(editMealTitleLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editMealTitleLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editMealTitllePanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(createMealEditMealTitleLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(sidebarEditMealLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(editMealDropdown, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(createMealEditMealButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(mainEditMealBtn, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchEditMealBtn, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(profileEditMealBtn, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(logoutEditMealBtn, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        editMealDetailsPanel.setBackground(new Color(234, 251, 251));

        mealTypeEditLabel.setBackground(new Color(255, 255, 255));
        mealTypeEditLabel.setFont(new Font("Segoe UI Semibold", 0, 25)); // NOI18N
        mealTypeEditLabel.setForeground(new Color(19, 46, 86));
        mealTypeEditLabel.setText("Meal Type:");

        editMealTypeTextField.setEditable(false);
        editMealTypeTextField.setFont(new Font("Segoe UI", 0, 20)); // NOI18N
        editMealTypeTextField.setText("No Data");
        editMealTypeTextField.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));

        editMealTypeBtn.setBackground(new Color(19, 46, 86));
        editMealTypeBtn.setFont(new Font("Segoe UI", 1, 15)); // NOI18N
        editMealTypeBtn.setForeground(new Color(255, 255, 255));
        editMealTypeBtn.setText("Edit");
        editMealTypeBtn.setBorder(null);
        editMealTypeBtn.setFocusable(false);
        editMealTypeBtn.addActionListener(this);

        editMealPanel.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        editImagePanel.setBackground(new Color(255, 255, 255));

        GroupLayout editImagePanelLayout = new GroupLayout(editImagePanel);
        editImagePanel.setLayout(editImagePanelLayout);
        editImagePanelLayout.setHorizontalGroup(
                editImagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(editImageIconLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
        );
        editImagePanelLayout.setVerticalGroup(
                editImagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(editImageIconLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        editImageBtn.setBackground(new Color(19, 46, 86));
        editImageBtn.setFont(new Font("Segoe UI", 1, 15)); // NOI18N
        editImageBtn.setForeground(new Color(255, 255, 255));
        editImageBtn.setText("Edit Image");
        editImageBtn.setBorder(null);
        editImageBtn.setFocusable(false);
        editImageBtn.addActionListener(this);

        GroupLayout editMealDetailsPanelLayout = new GroupLayout(editMealDetailsPanel);
        editMealDetailsPanel.setLayout(editMealDetailsPanelLayout);
        editMealDetailsPanelLayout.setHorizontalGroup(
                editMealDetailsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(editMealDetailsPanelLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(editMealDetailsPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(editMealDetailsPanelLayout.createSequentialGroup()
                                                .addComponent(mealTypeEditLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(editMealTypeTextField, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(editImagePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(editMealDetailsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(editImageBtn, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                        .addGroup(editMealDetailsPanelLayout.createSequentialGroup()
                                                .addComponent(editMealTypeBtn, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        editMealDetailsPanelLayout.setVerticalGroup(
                editMealDetailsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(editMealDetailsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(editMealDetailsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(editMealDetailsPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(editMealTypeTextField, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                                                .addComponent(mealTypeEditLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(editMealTypeBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(editMealDetailsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(editImagePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(editMealDetailsPanelLayout.createSequentialGroup()
                                                .addGap(0, 210, Short.MAX_VALUE)
                                                .addComponent(editImageBtn, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );

        editMealDetailsLabel.setBackground(new Color(255, 255, 255));
        editMealDetailsLabel.setFont(new Font("Segoe UI", 1, 25)); // NOI18N
        editMealDetailsLabel.setText("Meal Details");

        editMealDetailsPanel2.setBackground(new Color(234, 251, 251));

        mealNameEditLabel.setBackground(new Color(255, 255, 255));
        mealNameEditLabel.setFont(new Font("Segoe UI Semibold", 0, 20)); // NOI18N
        mealNameEditLabel.setForeground(new Color(19, 46, 86));
        mealNameEditLabel.setText("Meal Name:");

        mealNameEditTextField.setEditable(false);
        mealNameEditTextField.setFont(new Font("Segoe UI Semibold", 1, 11)); // NOI18N
        mealNameEditTextField.setText("No data");

        editMealNameBtn.setBackground(new Color(19, 46, 86));
        editMealNameBtn.setFont(new Font("Segoe UI", 1, 15)); // NOI18N
        editMealNameBtn.setForeground(new Color(255, 255, 255));
        editMealNameBtn.setText("Edit");
        editMealNameBtn.setBorder(null);
        editMealNameBtn.setFocusable(false);
        editMealNameBtn.addActionListener(this);

        foodGroupEditLabel.setBackground(new Color(255, 255, 255));
        foodGroupEditLabel.setFont(new Font("Segoe UI Semibold", 0, 20)); // NOI18N
        foodGroupEditLabel.setForeground(new Color(19, 46, 86));
        foodGroupEditLabel.setText("Food Group:");

        foodGroupEditTextField.setEditable(false);
        foodGroupEditTextField.setFont(new Font("Segoe UI Semibold", 1, 11)); // NOI18N
        foodGroupEditTextField.setText("No data");

        editFoodgroupBtn.setBackground(new Color(19, 46, 86));
        editFoodgroupBtn.setFont(new Font("Segoe UI", 1, 15)); // NOI18N
        editFoodgroupBtn.setForeground(new Color(255, 255, 255));
        editFoodgroupBtn.setText("Edit");
        editFoodgroupBtn.setBorder(null);
        editFoodgroupBtn.setFocusable(false);
        editFoodgroupBtn.addActionListener(this);

        drinkEditLabel.setBackground(new Color(255, 255, 255));
        drinkEditLabel.setFont(new Font("Segoe UI Semibold", 0, 20)); // NOI18N
        drinkEditLabel.setForeground(new Color(19, 46, 86));
        drinkEditLabel.setText("Drink Name:");

        drinkEditTextField.setEditable(false);
        drinkEditTextField.setFont(new Font("Segoe UI Semibold", 1, 11)); // NOI18N
        drinkEditTextField.setText("No data");

        editDrinkBtn.setBackground(new Color(19, 46, 86));
        editDrinkBtn.setFont(new Font("Segoe UI", 1, 15)); // NOI18N
        editDrinkBtn.setForeground(new Color(255, 255, 255));
        editDrinkBtn.setText("Edit");
        editDrinkBtn.setBorder(null);
        editDrinkBtn.setFocusable(false);
        editDrinkBtn.addActionListener(this);

        dateEditLabel.setBackground(new Color(255, 255, 255));
        dateEditLabel.setFont(new Font("Segoe UI Semibold", 0, 20)); // NOI18N
        dateEditLabel.setForeground(new Color(19, 46, 86));
        dateEditLabel.setText("Date:");

        dateEditTextField.setEditable(false);
        dateEditTextField.setFont(new Font("Segoe UI Semibold", 1, 11)); // NOI18N
        dateEditTextField.setText("No data");

        dayEditLabel.setBackground(new Color(255, 255, 255));
        dayEditLabel.setFont(new Font("Segoe UI Semibold", 0, 20)); // NOI18N
        dayEditLabel.setForeground(new Color(19, 46, 86));
        dayEditLabel.setText("Day:");

        dayEditTextField.setEditable(false);
        dayEditTextField.setFont(new Font("Segoe UI Semibold", 1, 11)); // NOI18N
        dayEditTextField.setText("No data");

        editDateBtn.setBackground(new Color(19, 46, 86));
        editDateBtn.setFont(new Font("Segoe UI", 1, 15)); // NOI18N
        editDateBtn.setForeground(new Color(255, 255, 255));
        editDateBtn.setText("Edit");
        editDateBtn.setBorder(null);
        editDateBtn.setFocusable(false);
        editDateBtn.addActionListener(this);

        GroupLayout editMealDetailsPanel2Layout = new GroupLayout(editMealDetailsPanel2);
        editMealDetailsPanel2.setLayout(editMealDetailsPanel2Layout);
        editMealDetailsPanel2Layout.setHorizontalGroup(
                editMealDetailsPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(editMealDetailsPanel2Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(editMealDetailsPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(editMealDetailsPanel2Layout.createSequentialGroup()
                                                .addComponent(mealNameEditLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(mealNameEditTextField, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(editMealNameBtn, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                                .addGap(39, 39, 39)
                                                .addGroup(editMealDetailsPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(dateEditLabel)
                                                        .addComponent(dayEditLabel))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(editMealDetailsPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(dayEditTextField, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(dateEditTextField, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(editMealDetailsPanel2Layout.createSequentialGroup()
                                                .addGroup(editMealDetailsPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(editMealDetailsPanel2Layout.createSequentialGroup()
                                                                .addComponent(foodGroupEditLabel)
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(foodGroupEditTextField, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(editMealDetailsPanel2Layout.createSequentialGroup()
                                                                .addComponent(drinkEditLabel)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(drinkEditTextField, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(editMealDetailsPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(editFoodgroupBtn, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(editMealDetailsPanel2Layout.createSequentialGroup()
                                                                .addComponent(editDrinkBtn, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(editDateBtn, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)))))
                                .addGap(19, 19, 19))
        );
        editMealDetailsPanel2Layout.setVerticalGroup(
                editMealDetailsPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(editMealDetailsPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(editMealDetailsPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(editMealDetailsPanel2Layout.createSequentialGroup()
                                                .addGroup(editMealDetailsPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(dateEditLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(dateEditTextField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(editMealDetailsPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(dayEditLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(dayEditTextField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(editDateBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(6, 6, 6))
                                        .addGroup(editMealDetailsPanel2Layout.createSequentialGroup()
                                                .addGroup(editMealDetailsPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(mealNameEditLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(mealNameEditTextField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(editMealNameBtn, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(editMealDetailsPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(editFoodgroupBtn, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(editMealDetailsPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(foodGroupEditLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(foodGroupEditTextField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addGroup(editMealDetailsPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(drinkEditLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(drinkEditTextField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(editDrinkBtn, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(32, Short.MAX_VALUE))
        );

        GroupLayout editMealPanelLayout = new GroupLayout(editMealPanel);
        editMealPanel.setLayout(editMealPanelLayout);
        editMealPanelLayout.setHorizontalGroup(
                editMealPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(editMealPanelLayout.createSequentialGroup()
                                .addComponent(sidebarEditMeal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(editMealPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(editMealPanelLayout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(editMealDetailsLabel)
                                                .addGap(241, 241, 241))
                                        .addGroup(editMealPanelLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(editMealPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(editMealDetailsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(editMealDetailsPanel2, GroupLayout.PREFERRED_SIZE, 604, GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(28, Short.MAX_VALUE))))
        );
        editMealPanelLayout.setVerticalGroup(
                editMealPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(editMealPanelLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(editMealDetailsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addComponent(editMealDetailsLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editMealDetailsPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))
                        .addComponent(sidebarEditMeal, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );

        //Layout for jframe
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(loginPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(signUpPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mainMenuPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(profileInfoPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(createMealPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(viewMealPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editMealPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(loginPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(signUpPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mainMenuPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(profileInfoPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(createMealPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(viewMealPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(editMealPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        loginPanel.setVisible(true);
        signUpPanel.setVisible(false);
        mainMenuPanel.setVisible(false);
        createMealPanel.setVisible(false);
        profileInfoPanel.setVisible(false);
        viewMealPanel.setVisible(false);
        editMealPanel.setVisible(false);
        setVisible(true); //Set frame visibility
        pack();
    }

    //Methode To Resize The ImageIcon
    public ImageIcon ResizeImage(JLabel image , String imgPath){
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(image.getWidth(), image.getHeight(),Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }

    public void displayAccountList(DefaultListModel userList){
        MyConnection newCon = new MyConnection(); //Create new MyConnection object to connect with database
        String details; //Display this if no user
        try {
            Statement stat = newCon.connectDB().createStatement();
            String sql = "select * from users";
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                details = rs.getString("Username");
                userList.addElement(details);
            }

            //Close database
            newCon.connectDB().close();
        }catch (SQLException err){
            System.err.println("Got an exception!");
            System.err.println(err.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Sign in button redirect to main page
        if(e.getSource() == signInButton){
            user = new User(); //Create new user object
            meal = new MealDiary(); //create new meal object
            String userChosen = userList.getSelectedValue(); //Get account selection value from Jlist

            //Check for successful account selection query
            try {
                //If selectAccount return true
                if(user.selectAccount(userChosen)){
                    //display meal list in main menu table
                    meal.searchMealList(user.getUserID(), "All", "All", mainMenuTable, searchMealQueryLabel);

                    greetingMainMenuLabel1.setText("Hello, " + user.getUsername() + ".");

                    //Set panel visibility
                    loginPanel.setVisible(false);
                    mainMenuPanel.setVisible(true);

                    //Set user profile information in respective textfield
                    usernameProfileInfoTextField.setText(user.getUsername());
                    fullnameProfileInfoTextField.setText(user.getFullName());
                    ageProfileInfoTextField.setText(String.valueOf(user.getUserAge()));
                }
            }catch (Exception NullPointerException){
                JOptionPane.showMessageDialog(null, "Please choose your username from the list before sign in!",
                        "Sign In", JOptionPane.ERROR_MESSAGE);
            }
        }
        //Sign up button in login page
        else if(e.getSource() == signUpButton){
            //Set panel visibility
            loginPanel.setVisible(false);
            signUpPanel.setVisible(true);
        }
        //Sign up page to login
        else if(e.getSource() == signUpPageLoginButton){
            //Set panel visibility
            signUpPanel.setVisible(false);
            loginPanel.setVisible(true);
        }
        //Create account button
        else if(e.getSource() == createAccountButton){
            user = new User();
            try{
                //Get new info in textfield
                String newUsername = addUsernameSignUpTextField.getText();
                String newName = addFullNameTextField.getText();
                String newAge = addAgeSignUpTextField.getText();

                //Check for addAccount query
                if(user.addAccount(newUsername, newName, Integer.parseInt(newAge))){
                    JOptionPane.showMessageDialog (null, "Account Create Successfully", "Create New Account", JOptionPane.INFORMATION_MESSAGE);
                    //Clear text field
                    addUsernameSignUpTextField.setText("");
                    addFullNameTextField.setText("");
                    addAgeSignUpTextField.setText("");

                    //Update user list in login table
                    userListModel.removeAllElements();
                    displayAccountList(userListModel);

                    //Set visibility of the page
                    signUpPanel.setVisible(false);
                    loginPanel.setVisible(true);
                }
            }catch (Exception err){
                System.out.println(err);
                JOptionPane.showMessageDialog(null, "Please re-enter your age using number only!",
                        "Create New Account", JOptionPane.ERROR_MESSAGE);
            }
        }
        //Update Profile Button
        else if(e.getSource() == updateInfoProfileInfoOKButton){
            String editProfile = String.valueOf(updateInfoProfileInfoUpdateTypeComboBox.getSelectedItem()); //Choose edit option
            String message;
            try{
                //Message in JOptionpane
                if(editProfile.equals("Username")){
                    message = "Enter Your New Username";

                }else if(editProfile.equals("Full Name")){
                    message = "Enter Your New Full Name";
                }else{
                    message = "Enter Your New Age";
                }
                String newInfo = JOptionPane.showInputDialog(null, message, "Edit Profile", JOptionPane.PLAIN_MESSAGE);

                //Check for empty input
                if(!newInfo.equals("")){
                    //Check for successful edit query and correct dropdown selection
                    if(editProfile.equals("Username") && user.editAccount(newInfo, user.getFullName(), user.getUserAge())){
                        usernameProfileInfoTextField.setText(newInfo); //Set new info in respective textfield
                    }else if(editProfile.equals("Full Name") && user.editAccount(user.getUsername(), newInfo, user.getUserAge())){
                        fullnameProfileInfoTextField.setText(newInfo); //Set new info in respective textfield
                    }else if(editProfile.equals("Age") && user.editAccount(user.getUsername(), user.getFullName(), Integer.parseInt(newInfo))){
                        ageProfileInfoTextField.setText(newInfo); //Set new info in respective textfield
                    }
                }else {
                    //Loop JOptionPane if input still empty string
                    while(newInfo.equals("")){
                        message = "Your input cannot be empty!\nPlease re-enter your input again.";
                        newInfo = JOptionPane.showInputDialog(null,message, "Edit Profile", JOptionPane.PLAIN_MESSAGE);
                    }
                }
                JOptionPane.showMessageDialog(null, "Your updated info: " + newInfo); //To show updated detail after edit
            }catch (Exception err){
                JOptionPane.showMessageDialog(null,"Please re-enter your meal details correctly.", "Edit Profile", JOptionPane.ERROR_MESSAGE);
            }
        }
        //Delete Account Button
        else if(e.getSource() == deleteAccountProfileInfoButton){
            //Prompt JOptionPane to ask for confirmation
            int result = JOptionPane.showConfirmDialog(null,"Are you do want to delete your account?", "View Meals",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            //If user click yes button
            if(result == JOptionPane.YES_OPTION){
                //check for successful query
                if(user.deleteAccount(user.getUserID())){
                    userListModel.removeAllElements();
                    displayAccountList(userListModel);

                    profileInfoPanel.setVisible(false);
                    loginPanel.setVisible(true);
                }else{
                    //Prompt JOptionPane for fail query
                    JOptionPane.showMessageDialog(null,"Please try to delete again!", "Edit Profile", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        //Upload new food image button
        else if(e.getSource() == uploadImageCreateMealButton){
            //declare mealdiary object
            breakfast = new BreakfastDiary();
            lunch = new LunchDiary();
            dinner = new DinnerDiary();

            //Set image path to upload it to database based on its meal type category
            if(mealTypeCreateMealTextField.getText().equals("Breakfast")){
                //declare mealdiary object
                breakfast = new BreakfastDiary();

                breakfast.setImgPath(); //set image path
                mealImageCreateMealLabel.setIcon(ResizeImage(mealImageCreateMealLabel, breakfast.getImgPath())); //set image path
            }else if(mealTypeCreateMealTextField.getText().equals("Lunch")){
                //declare mealdiary object
                lunch = new LunchDiary();

                lunch.setImgPath(); //set image path
                mealImageCreateMealLabel.setIcon(ResizeImage(mealImageCreateMealLabel, lunch.getImgPath())); //set image path
            }else{
                //declare mealdiary object
                dinner = new DinnerDiary();

                dinner.setImgPath(); //set image path
                mealImageCreateMealLabel.setIcon(ResizeImage(mealImageCreateMealLabel, dinner.getImgPath())); //set image path
            }
        }
        //Create new meal button
        else if(e.getSource() == createMealDetailsCreateMealButton){
            //Create variable to store user input in textField
            String newMealName = mealNameMealDetailsCreateMealTextField.getText();
            String newDrinkName = drinkMealDetailsCreateMealTextField.getText();
            String newMealType = mealTypeCreateMealTextField.getText();

            //Get date and day of meal created
            final Date[] newMealDate = {new Date()};
            SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd"); //Set date format
            SimpleDateFormat dayformatter = new SimpleDateFormat("EEE"); // Set day format

            dateMealDetailsCreateMealDateChooser.setDate(newMealDate[0]); //To set date to current date by default
            newMealDate[0] = dateMealDetailsCreateMealDateChooser.getDate(); //To retrieve the chosen date

            //Trim the date chosen following format that has been set
            String trimNewMealDate = dateformatter.format(newMealDate[0]);
            String trimNewMealDay = dayformatter.format(newMealDate[0]);

            //Get food group string using string builder to string
            StringBuilder newFoodGroup = new StringBuilder();
            //Check state of checkbox using boolean
            boolean[] checkbox = {fruitsMealDetailsCreateMealCheckBox.isSelected(), vegetablesMealDetailsCreateMealCheckBox.isSelected(), grainMealDetailsCreateMealCheckBox.isSelected(),
                    proteinFoodsMealDetailsCreateMealCheckBox.isSelected(), dairyMealDetailsCreateMealCheckBox.isSelected()};

            //Append the string if checkbox boolean is true
            for(int i=0; i < 5; i++){
                if (checkbox[i]){
                    if(i == 0){
                        newFoodGroup.append("Fruits,");
                    }else if(i==1){
                        newFoodGroup.append("Vegetables,");
                    }else if(i==2){
                        newFoodGroup.append("Grains,");
                    }else if(i==3){
                        newFoodGroup.append("Protein Foods,");
                    }else{
                        newFoodGroup.append("Dairy,");
                    }
                }
            }
            //Enter new info and check for successful query
            try{
                //Check for successful query using JOptionPane
                if(mealTypeCreateMealTextField.getText().equals("Breakfast")){
                    //Create new boolean variable to check successful query
                    boolean newBreakfast = breakfast.createMeal(user.getUserID(), breakfast.getImgPath(), newMealName, newMealType,
                            newFoodGroup.toString(), trimNewMealDate, trimNewMealDay, newDrinkName);
                    if(newBreakfast){
                        JOptionPane.showMessageDialog(null,"Meal Successfully Create!", "Create Meal Page", JOptionPane.INFORMATION_MESSAGE);
                        //Destructor for object
                        breakfast = null;

                        //Set empty textfield and checkbox
                        mealImageCreateMealLabel.setIcon(null);
                        mealNameMealDetailsCreateMealTextField.setText("");
                        drinkMealDetailsCreateMealTextField.setText("");
                        fruitsMealDetailsCreateMealCheckBox.setSelected(false);
                        vegetablesMealDetailsCreateMealCheckBox.setSelected(false);
                        grainMealDetailsCreateMealCheckBox.setSelected(false);
                        proteinFoodsMealDetailsCreateMealCheckBox.setSelected(false);
                        dairyMealDetailsCreateMealCheckBox.setSelected(false);
                    }
                }else if(mealTypeCreateMealTextField.getText().equals("Lunch")){
                    //Create new boolean variable to check successful query
                    boolean newLunch = lunch.createMeal(user.getUserID(), lunch.getImgPath(), newMealName, newMealType,
                            newFoodGroup.toString(), trimNewMealDate, trimNewMealDay, newDrinkName);
                    if(newLunch){
                        JOptionPane.showMessageDialog(null,"Meal Successfully Create!", "Create Meal Page", JOptionPane.INFORMATION_MESSAGE);
                        //Destructor for object
                        lunch = null;

                        //Set empty textfield and checkbox
                        mealImageCreateMealLabel.setIcon(null);
                        mealNameMealDetailsCreateMealTextField.setText("");
                        drinkMealDetailsCreateMealTextField.setText("");
                        fruitsMealDetailsCreateMealCheckBox.setSelected(false);
                        vegetablesMealDetailsCreateMealCheckBox.setSelected(false);
                        grainMealDetailsCreateMealCheckBox.setSelected(false);
                        proteinFoodsMealDetailsCreateMealCheckBox.setSelected(false);
                        dairyMealDetailsCreateMealCheckBox.setSelected(false);
                    }

                }else if(mealTypeCreateMealTextField.getText().equals("Dinner")){
                    //Create new boolean variable to check successful query
                    boolean newDinner =  dinner.createMeal(user.getUserID(), dinner.getImgPath(), newMealName, newMealType,
                            newFoodGroup.toString(), trimNewMealDate, trimNewMealDay, newDrinkName);
                    if(newDinner){
                        JOptionPane.showMessageDialog(null,"Meal Successfully Create!", "Create Meal Page", JOptionPane.INFORMATION_MESSAGE);
                        //Destructor for object
                        dinner = null;

                        //Set empty textfield and checkbox
                        mealImageCreateMealLabel.setIcon(null);
                        mealNameMealDetailsCreateMealTextField.setText("");
                        drinkMealDetailsCreateMealTextField.setText("");
                        fruitsMealDetailsCreateMealCheckBox.setSelected(false);
                        vegetablesMealDetailsCreateMealCheckBox.setSelected(false);
                        grainMealDetailsCreateMealCheckBox.setSelected(false);
                        proteinFoodsMealDetailsCreateMealCheckBox.setSelected(false);
                        dairyMealDetailsCreateMealCheckBox.setSelected(false);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,"Cannot create new meal details. Please try again!", "Create Meal Page", JOptionPane.ERROR_MESSAGE);
                }
            }catch (Exception err){
                System.out.println(err);
                JOptionPane.showMessageDialog(null,"Please re-enter your meal details correctly.", "Create Meal Page", JOptionPane.ERROR_MESSAGE);
            }
        }
        //Search and filter submit button
        else if(e.getSource() == searchMealButton){
            meal.searchMealList(user.getUserID(),String.valueOf(foodGroupSearchDropdown.getSelectedItem()), String.valueOf(mealTypeSearchDropdown.getSelectedItem()), searchMealTable, searchMealQueryLabel);
            //Refresh the panel page
            viewMealPanel.setVisible(false);
            viewMealPanel.setVisible(true);
        }
        //Redirect to Edit Meal page
        else if(e.getSource() == editMealButton){
            //Create variable to store chosen mealID and mealType
            int selectedMealID = 0;
            String selectedMealType = null;

            //Retrieve mealID value in selected jTable cell
            int columnMealID = 0; //MealID column at the first column
            int columnMealType = 2; //MealType column at the first column
            int[] rows = searchMealTable.getSelectedRows(); //contain all row in generated JTable

            //Using for loop to to extract chosen mealID and mealType
            for (int row : rows) {
                selectedMealID = (int) searchMealTable.getValueAt(row, columnMealID);
                selectedMealType = (String) searchMealTable.getValueAt(row, columnMealType);
            }

            if(selectedMealID == 0 || selectedMealType == null){
                JOptionPane.showMessageDialog(null,"Please select your meal before edit it!", "View Meals", JOptionPane.INFORMATION_MESSAGE);
            }else{
                viewMealPanel.setVisible(false);
                editMealPanel.setVisible(true);

                if(selectedMealType.equals("Breakfast")){
                    breakfast = new BreakfastDiary();
                    breakfast.getMealDetails(selectedMealID);

                    //Set data from breakfastDiary in the textfield
                    editImageIconLabel.setIcon(ResizeImage(editImageIconLabel, breakfast.getImgPath()));
                    mealNameEditTextField.setText(breakfast.getMealName());
                    editMealTypeTextField.setText(breakfast.getMealType());
                    foodGroupEditTextField.setText(breakfast.getFoodGroup());
                    dateEditTextField.setText(breakfast.getDateCreated());
                    dayEditTextField.setText(breakfast.getDayCreated());
                    drinkEditTextField.setText(breakfast.getDrinkName());

                }else if(selectedMealType.equals("Lunch")){
                    lunch = new LunchDiary();
                    lunch.getMealDetails(selectedMealID);

                    //Set data from lunchDiary in the textfield
                    editImageIconLabel.setIcon(ResizeImage(editImageIconLabel, lunch.getImgPath()));
                    mealNameEditTextField.setText(lunch.getMealName());
                    editMealTypeTextField.setText(lunch.getMealType());
                    foodGroupEditTextField.setText(lunch.getFoodGroup());
                    dateEditTextField.setText(lunch.getDateCreated());
                    dayEditTextField.setText(lunch.getDayCreated());
                    drinkEditTextField.setText(lunch.getDrinkName());

                }else{
                    dinner = new DinnerDiary();
                    dinner.getMealDetails(selectedMealID);

                    //Set data from dinnerDiary in the textfield
                    editImageIconLabel.setIcon(ResizeImage(editImageIconLabel, dinner.getImgPath()));
                    mealNameEditTextField.setText(dinner.getMealName());
                    editMealTypeTextField.setText(dinner.getMealType());
                    foodGroupEditTextField.setText(dinner.getFoodGroup());
                    dateEditTextField.setText(dinner.getDateCreated());
                    dayEditTextField.setText(dinner.getDayCreated());
                    drinkEditTextField.setText(dinner.getDrinkName());
                }
            }
        }
        //Edit meal type button
        else if(e.getSource() == editMealTypeBtn){
            try{
                Object [] mealtype = {"Breakfast", "Lunch", "Dinner"};
                JComboBox comboBox = new JComboBox(mealtype);

                Object [] message = {"Please choose your new meal type: ", comboBox};
                int mealID;

                //Set selected index in jcombobox
                if(editMealTypeTextField.getText().equals("Breakfast")){
                    mealID = breakfast.getMealID();
                    comboBox.setSelectedIndex(0);

                }else if (editMealTypeTextField.getText().equals("Lunch")){
                    mealID = lunch.getMealID();
                    comboBox.setSelectedIndex(1);
                }else{
                    mealID = dinner.getMealID();
                    comboBox.setSelectedIndex(2);
                }

                //JOption pane
                JOptionPane.showMessageDialog(null, message,"Edit Meal Type", JOptionPane.QUESTION_MESSAGE);

                String selectedMealType = (String) comboBox.getItemAt(comboBox.getSelectedIndex());

                if(selectedMealType.equals("Breakfast")){
                    breakfast = new BreakfastDiary();
                    breakfast.updateMeal(user.getUserID(), mealID, mealNameEditTextField.getText(), selectedMealType,
                            foodGroupEditTextField.getText(), dateEditTextField.getText(), dayEditTextField.getText(), drinkEditTextField.getText());
                    editMealTypeTextField.setText(selectedMealType);
                }else if(selectedMealType.equals("Lunch")){
                    lunch = new LunchDiary();
                    lunch.updateMeal(user.getUserID(), mealID, mealNameEditTextField.getText(), selectedMealType,
                            foodGroupEditTextField.getText(), dateEditTextField.getText(), dayEditTextField.getText(), drinkEditTextField.getText());
                    editMealTypeTextField.setText(selectedMealType);
                }else{
                    dinner = new DinnerDiary();
                    dinner.updateMeal(user.getUserID(), mealID, mealNameEditTextField.getText(), selectedMealType,
                            foodGroupEditTextField.getText(), dateEditTextField.getText(), dayEditTextField.getText(), drinkEditTextField.getText());
                    editMealTypeTextField.setText(selectedMealType);
                }

            }catch (Exception err){
                System.out.println(err);
            }
        }
        //Edit meal image button
        else if(e.getSource() == editImageBtn){
            if(editMealTypeTextField.getText().equals("Breakfast")){
                breakfast.setImgPath(); //Open JFileChooser
                breakfast.updateMeal(breakfast.getImgPath(), user.getUserID(), breakfast.getMealID());
                editImageIconLabel.setIcon(ResizeImage(editImageIconLabel, breakfast.getImgPath())); //Set a new image after edited
            }else if(editMealTypeTextField.getText().equals("Lunch")){
                System.out.println(lunch.getMealID());
                lunch.setImgPath(); //Open JFileChooser
                lunch.updateMeal(lunch.getImgPath(), user.getUserID(), lunch.getMealID());
                editImageIconLabel.setIcon(ResizeImage(editImageIconLabel, lunch.getImgPath())); //Set a new image after edited
            }else {
                dinner.setImgPath(); //Open JFileChooser
                dinner.updateMeal(dinner.getImgPath(), user.getUserID(), dinner.getMealID());
                editImageIconLabel.setIcon(ResizeImage(editImageIconLabel, dinner.getImgPath())); //Set a new image after edited
            }
        }
        //Edit Meal Name Button
        else if(e.getSource() ==  editMealNameBtn){
            try{
                String message = "Enter New Meal Name";
                String name = JOptionPane.showInputDialog(null, message, "Edit name", JOptionPane.PLAIN_MESSAGE);

                if(!name.equals("")){
                    if(editMealTypeTextField.getText().equals("Breakfast")){
                        breakfast.updateMeal(user.getUserID(), breakfast.getMealID(), name, editMealTypeTextField.getText(),
                                foodGroupEditTextField.getText(), dateEditTextField.getText(), dayEditTextField.getText(), drinkEditTextField.getText());
                    }else if(editMealTypeTextField.getText().equals("Lunch")){
                        lunch.updateMeal(user.getUserID(), lunch.getMealID(), name, editMealTypeTextField.getText(),
                                foodGroupEditTextField.getText(), dateEditTextField.getText(), dayEditTextField.getText(), drinkEditTextField.getText());
                    }else {
                        dinner.updateMeal(user.getUserID(), dinner.getMealID(), name, editMealTypeTextField.getText(),
                                foodGroupEditTextField.getText(), dateEditTextField.getText(), dayEditTextField.getText(), drinkEditTextField.getText());
                    }
                    mealNameEditTextField.setText(name);
                }else {
                    while(name.equals("")){
                        message = "Your new meal name cannot be empty!\nPlease re-enter your new meal name again.";
                        name = JOptionPane.showInputDialog(null,message, "Edit name", JOptionPane.PLAIN_MESSAGE);
                    }
                }

                JOptionPane.showMessageDialog(null, "Your new meal name: " + name);
            }catch (Exception err){
                System.out.println(err);
            }
        }
        //Edit Foodgroup
        else if(e.getSource() == editFoodgroupBtn){
            String messages = "Choose your new food group: ";
            JCheckBox fruitCheckBox = new JCheckBox();
            JCheckBox vegetableCheckbox = new JCheckBox();
            JCheckBox grainCheckbox = new JCheckBox();
            JCheckBox proteinCheckbox = new JCheckBox();
            JCheckBox dairyCheckbox = new JCheckBox();

            fruitCheckBox.setText("Fruits");
            vegetableCheckbox.setText("Vegetables");
            grainCheckbox.setText("Grains");
            proteinCheckbox.setText("Protein Foods");
            dairyCheckbox.setText("Dairy");

            Object[] paneComponent = {messages, fruitCheckBox, vegetableCheckbox, grainCheckbox, proteinCheckbox, dairyCheckbox};

            int option = JOptionPane.showConfirmDialog(null, paneComponent, "Edit food group", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                StringBuilder newFoodGroup = new StringBuilder();
                //To check for empty checkbox
                if(!fruitCheckBox.isSelected() && !vegetableCheckbox.isSelected() && !grainCheckbox.isSelected() && !proteinCheckbox.isSelected() &&
                        !dairyCheckbox.isSelected()){
                    int emptyFieldPopUp = JOptionPane.showConfirmDialog(null, "Please choose at least one foodgroup!", "Add Meal Details", JOptionPane.DEFAULT_OPTION);
                    System.out.println(emptyFieldPopUp);
                }else {
                    boolean[] checkbox = {fruitCheckBox.isSelected(), vegetableCheckbox.isSelected(), grainCheckbox.isSelected(), proteinCheckbox.isSelected(),
                            dairyCheckbox.isSelected()};
                    for(int i=0; i < 5; i++){
                        if (checkbox[i]){
                            if(i == 0){
                                newFoodGroup.append("Fruits,");
                            }else if(i==1){
                                newFoodGroup.append("Vegetables,");
                            }else if(i==2){
                                newFoodGroup.append("Grains,");
                            }else if(i==3){
                                newFoodGroup.append("Protein Foods,");
                            }else{
                                newFoodGroup.append("Dairy,");
                            }
                        }
                    }
                }
                if(editMealTypeTextField.getText().equals("Breakfast")){
                    breakfast.updateMeal(user.getUserID(), breakfast.getMealID(), mealNameEditTextField.getText(), editMealTypeTextField.getText(),
                            newFoodGroup.toString(), dateEditTextField.getText(), dayEditTextField.getText(), drinkEditTextField.getText());
                }else if(editMealTypeTextField.getText().equals("Lunch")){
                    lunch.updateMeal(user.getUserID(), lunch.getMealID(), mealNameEditTextField.getText(), editMealTypeTextField.getText(),
                            newFoodGroup.toString(), dateEditTextField.getText(), dayEditTextField.getText(), drinkEditTextField.getText());
                }else {
                    dinner.updateMeal(user.getUserID(), dinner.getMealID(), mealNameEditTextField.getText(), editMealTypeTextField.getText(),
                            newFoodGroup.toString(), dateEditTextField.getText(), dayEditTextField.getText(), drinkEditTextField.getText());
                }
                foodGroupEditTextField.setText(newFoodGroup.toString());
                JOptionPane.showMessageDialog(null, "Your new food group: " + newFoodGroup);
            }
        }
        //Edit Drink Button
        else if(e.getSource() == editDrinkBtn){
            try{
                String message = "Enter New Drink Name";
                String name = JOptionPane.showInputDialog(null, message, "Edit name", JOptionPane.PLAIN_MESSAGE);

                if(!name.equals("")){
                    if(editMealTypeTextField.getText().equals("Breakfast")){
                        breakfast.updateMeal(user.getUserID(), breakfast.getMealID(), mealNameEditTextField.getText(), editMealTypeTextField.getText(),
                                foodGroupEditTextField.getText(), dateEditTextField.getText(), dayEditTextField.getText(), name);
                    }else if(editMealTypeTextField.getText().equals("Lunch")){
                        lunch.updateMeal(user.getUserID(), lunch.getMealID(), mealNameEditTextField.getText(), editMealTypeTextField.getText(),
                                foodGroupEditTextField.getText(), dateEditTextField.getText(), dayEditTextField.getText(), name);
                    }else {
                        dinner.updateMeal(user.getUserID(), dinner.getMealID(), mealNameEditTextField.getText(), editMealTypeTextField.getText(),
                                foodGroupEditTextField.getText(), dateEditTextField.getText(), dayEditTextField.getText(), name);
                    }
                    drinkEditTextField.setText(name);
                }else {
                    while(name.equals("")){
                        message = "Your new drink name cannot be empty!\nPlease re-enter your new drink name again.";
                        name = JOptionPane.showInputDialog(null,message, "Edit name", JOptionPane.PLAIN_MESSAGE);
                    }
                }
                JOptionPane.showMessageDialog(null, "Your new drink name: " + name);
            }catch (Exception ignored){
            }
        }
        //Edit date and day of meal created
        else if(e.getSource() == editDateBtn){
            try{
                JDateChooser mealDateJD = new JDateChooser();
                Date newMealDate1 = new Date();

                mealDateJD.setDate(newMealDate1);
                mealDateJD.setDateFormatString("yyyy-MM-dd EEE");

                String message ="Choose new meal date:\n";
                Object[] params = {message,mealDateJD};
                int result = JOptionPane.showConfirmDialog(null,params,"New meal date", JOptionPane.OK_CANCEL_OPTION);

                newMealDate1 = mealDateJD.getDate();

                SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat dayformatter = new SimpleDateFormat("EEE");

                String trimMealDate = dateformatter.format(newMealDate1);
                String trimMealDay = dayformatter.format(newMealDate1);

                if(result == JOptionPane.OK_OPTION){
                    if(editMealTypeTextField.getText().equals("Breakfast")){
                        breakfast.updateMeal(user.getUserID(), breakfast.getMealID(), mealNameEditTextField.getText(), editMealTypeTextField.getText(),
                                foodGroupEditTextField.getText(), trimMealDate, trimMealDay, drinkEditTextField.getText());
                    }else if(editMealTypeTextField.getText().equals("Lunch")){
                        lunch.updateMeal(user.getUserID(), lunch.getMealID(), mealNameEditTextField.getText(), editMealTypeTextField.getText(),
                                foodGroupEditTextField.getText(), trimMealDate, trimMealDay, drinkEditTextField.getText());
                    }else {
                        dinner.updateMeal(user.getUserID(), dinner.getMealID(), mealNameEditTextField.getText(), editMealTypeTextField.getText(),
                                foodGroupEditTextField.getText(), trimMealDate, trimMealDay, drinkEditTextField.getText());
                    }
                    dateEditTextField.setText(trimMealDate);
                    dayEditTextField.setText(trimMealDay);
                }

                JOptionPane.showMessageDialog(null, "Your new meal date: " + trimMealDate + " " + trimMealDay);
            }catch (Exception ignored){
            }
        }
        //Delete existing meal button
        else if(e.getSource() == deleteMealButton){
            //Delete function
            viewMealPanel.setVisible(false);
            viewMealPanel.setVisible(true);

            //Retrieve mealID value in selected jTable cell
            int mealIDCol = 0; //MealID column at the first column
            int mealTypeCol = 2; //Meal type column
            int[] rows = searchMealTable.getSelectedRows();
            String selectedMealID = null;
            String selectedMealType = null;

            for (int row : rows) {
                selectedMealID = searchMealTable.getValueAt(row, mealIDCol).toString();
                selectedMealType = searchMealTable.getValueAt(row, mealTypeCol).toString();
            }

            if(selectedMealID == null){
                JOptionPane.showConfirmDialog(null,"Please select your meal before delete it!", "View Meals",
                        JOptionPane.OK_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
            }else{
                //Ask confirmation through JOptionPane
                int result = JOptionPane.showConfirmDialog(null,"Are you do want to delete this meal info?", "View Meals",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION){
                    if(selectedMealType.equals("Breakfast")){
                        breakfast.deleteMeal(user.getUserID(), Integer.parseInt(selectedMealID)); //Delete function
                    }else if(selectedMealType.equals("Lunch")){
                        lunch.deleteMeal(user.getUserID(), Integer.parseInt(selectedMealID)); //Delete function
                    }else{
                        dinner.deleteMeal(user.getUserID(), Integer.parseInt(selectedMealID)); //Delete function
                    }
                    //Refresh Page
                    meal.searchMealList(user.getUserID(), String.valueOf(foodGroupSearchDropdown.getSelectedItem()), String.valueOf(mealTypeSearchDropdown.getSelectedItem()), searchMealTable, searchMealQueryLabel);
                    viewMealPanel.setVisible(false);
                    viewMealPanel.setVisible(true);
                }
            }
        }
        //Redirect to main menu page
        else if(e.getSource() == mainMenuProfileInfoButton1 || e.getSource() == mainMenuProfileInfoButton || e.getSource() == mainEditMealBtn
        || e.getSource() == mainMenuViewMealButton){
            meal.searchMealList(user.getUserID(), "All", "All", mainMenuTable, searchMealQueryLabel);
            signUpPanel.setVisible(false);
            createMealPanel.setVisible(false);
            profileInfoPanel.setVisible(false);
            viewMealPanel.setVisible(false);
            editMealPanel.setVisible(false);

            mainMenuPanel.setVisible(true);
        }
        //Redirect to create meal page
        else if(e.getSource() == createMealMainMenuButton || e.getSource() == createMealEditMealButton ||
                e.getSource() == createMealViewMealButton || e.getSource() == createMealProfileInfoButton){

            profileInfoPanel.setVisible(false);
            viewMealPanel.setVisible(false);
            mainMenuPanel.setVisible(false);
            editMealPanel.setVisible(false);

            createMealPanel.setVisible(true);
            String newMealType;

            if(e.getSource() == createMealMainMenuButton){
                newMealType = String.valueOf(mainMenuDropdown.getSelectedItem());
            }else if(e.getSource() == createMealEditMealButton){
                newMealType = String.valueOf(editMealDropdown.getSelectedItem());
            }else if(e.getSource() == createMealViewMealButton){
                newMealType = String.valueOf(viewMealDropdown.getSelectedItem());
            }else{
                newMealType = String.valueOf(profileInfoMealTypeComboBox.getSelectedItem());
            }

            if(newMealType.equals("Breakfast")){
                breakfast = new BreakfastDiary();
                mealTypeCreateMealTextField.setText("Breakfast");
            }else if(newMealType.equals("Lunch")){
                lunch = new LunchDiary();
                mealTypeCreateMealTextField.setText("Lunch");
            }else{
                dinner = new DinnerDiary();
                mealTypeCreateMealTextField.setText("Dinner");
            }
            mealTypeCreateMealTextField.setEditable(false);
        }
        //Redirect to user profile page
        else if(e.getSource() == profileMainMenuButton || e.getSource() == profileInfoCreateMealButton || e.getSource() == profileEditMealBtn
        || e.getSource() == profileViewMealButton){
            signUpPanel.setVisible(false);
            mainMenuPanel.setVisible(false);
            createMealPanel.setVisible(false);
            editMealPanel.setVisible(false);
            loginPanel.setVisible(false);
            viewMealPanel.setVisible(false);

            usernameProfileInfoTextField.setText(user.getUsername());
            fullnameProfileInfoTextField.setText(user.getFullName());
            ageProfileInfoTextField.setText(String.valueOf(user.getUserAge()));

            profileInfoPanel.setVisible(true);
        }
        //Redirect to view meal page
        else if(e.getSource() == viewMainMenuButton || e.getSource() == viewMenuCreateMealButton || e.getSource() == viewMenuProfileInfoButton
        || e.getSource() == searchEditMealBtn){
            signUpPanel.setVisible(false);
            mainMenuPanel.setVisible(false);
            createMealPanel.setVisible(false);
            profileInfoPanel.setVisible(false);
            editMealPanel.setVisible(false);
            loginPanel.setVisible(false);

            meal.searchMealList(user.getUserID(),"All", "All", searchMealTable, searchMealQueryLabel);
            viewMealPanel.setVisible(true);
        }
        //Logout button redirect to login page
        else if(e.getSource() == logoutMainMenuButton || e.getSource() == logOutCreateMealButton || e.getSource() == logOutProfileInfoButton
        || e.getSource() == logoutEditMealBtn || e.getSource() == logoutViewMealButton){
            //Update user list in login table
            userListModel.removeAllElements();
            displayAccountList(userListModel);

            //Set visibility of panel
            mainMenuPanel.setVisible(false);
            createMealPanel.setVisible(false);
            profileInfoPanel.setVisible(false);
            viewMealPanel.setVisible(false);
            editMealPanel.setVisible(false);

            //Logout button will redirect to login panel
            loginPanel.setVisible(true);

            //Desctructor
            user = null;
            breakfast = null;
            lunch = null;
            dinner = null;
        }
    }

}
