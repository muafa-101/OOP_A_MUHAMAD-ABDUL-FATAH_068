
// 1. User Class (as a superclass)
public class UserClass_Module_3 {
    private String name;       // Encapsulated attribute
    private String studentId;  // Encapsulated attribute

    // Constructor to initialize name and studentId
    public UserClass_Module_3(String name, String studentId) {
        this.name = name;
<<<<<<< HEAD
        this.nim = nim;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
=======
        this.studentId = studentId;
>>>>>>> a1ad0308844ea5f42962a3e22fe2ea8fcd4b0aca
    }


    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for studentId
    public String getStudentId() {
        return studentId;
    }

    // Setter for studentId
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    // login() method to be overridden by subclasses
    public boolean login() {
        System.out.println("User login method called (should be overridden)");
        return false; // Default implementation
    }

    // displayInfo() method to display user information
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Student ID: " + studentId);
    }
}
