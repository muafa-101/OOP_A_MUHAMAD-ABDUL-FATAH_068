public class UserClass_Module_3 {
    String name;
    int nim;

    public UserClass_Module_3(String name, int nim) {
        this.name = name;
        this.nim = nim;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNIM(int nim) {
        this.nim = nim;
    }

    public int getNIM() {
        return nim;
    }

    public void displayinfo(String name, int NIM) {
        System.out.println("Name: " + this.name );
        System.out.println("NIM: " + this.nim);
    }
    public void login(UserClass_Module_3 user) {

    }
}
