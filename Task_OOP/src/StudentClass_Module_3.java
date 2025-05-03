// 3. Student Class (as a subclass of UserClass_Module_3)
public class StudentClass_Module_3 extends UserClass_Module_3 {
    public StudentClass_Module_3(String name, String studentId) {
        super(name, studentId);
    }


    // Override the login() method to match the input name and student ID.
    @Override
    public boolean login() {
        //  Simulated student login.  In a real system, you'd check against a database.
        if (this.getName() != null && this.getStudentId() != null && !this.getName().isEmpty() && !this.getStudentId().isEmpty())
        {
            return true;
        }
        else {
            return false;
        }
    }

    // Override the displayInfo() method to display a successful login message.
    @Override
    public void displayInfo() {
        if (login()) {
            System.out.println("Student Login Successful!");
            super.displayInfo(); // Call superclass method
        } else {
            System.out.println("Student Login Failed!");
        }
    }
}