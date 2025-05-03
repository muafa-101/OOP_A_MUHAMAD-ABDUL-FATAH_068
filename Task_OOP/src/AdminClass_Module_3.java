public class AdminClass_Module_3 extends UserClass_Module_3 {
    private String username;
    private String password;
    private static String defaultUsername = "admin";
    private static String defaultPassword = "admin123";

    public AdminClass_Module_3(String username, String password) {
        super("", ""); // call empty value to name and nim
        this.username = username;
        this.password = password;
    }

    // Override login()
    @Override
    public boolean login() {
        if (this.username.equals(defaultUsername) && this.password.equals(defaultPassword)) {
            return true;
        } else {
            return false;
        }
    }

    // Override displayInfo()
    @Override
    public void displayInfo() {
        if (login()) {
            System.out.println("Admin Login Successful!");
        } else {
            System.out.println("Admin Login Failed!");
        }
    }

    public void changeUsername(String newUsername) {
        defaultUsername = newUsername;
        System.out.println("Username changed successfully!");
    }

    public void changePassword(String newPassword) {
        defaultPassword = newPassword;
        System.out.println("Password changed successfully!");
    }
}