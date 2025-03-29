public class AdminClass_Module_3 extends UserClass_Module_3 {
    private String username;
    private String password;

    public AdminClass_Module_3(String name, String nim, String username, String password) {
        super(name, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login() {
        if (username.equals("admin") && password.equals("admin393")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void displayinfo() {
        if (login()) {
            System.out.println("Login Successful");
            super.displayinfo(); // menggunakan method displayInfo yang sudah diperbaiki.
        } else {
            System.out.println("Login Failed");
        }
    }
}