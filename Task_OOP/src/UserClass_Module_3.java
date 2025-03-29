public class UserClass_Module_3 {
    private String name;
    private String nim; // konsisten menggunakan String

    public UserClass_Module_3(String name, String nim) {
        this.name = name;
        this.nim = nim;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNim(String nim) { // perbaikan nama method setter
        this.nim = nim;
    }

    public String getNim() { // perbaikan nama method getter dan tipe kembalian
        return nim;
    }

    public boolean login() {
        return false;
    }

    public void displayinfo() { // perbaikan method displayInfo
        System.out.println("Name: " + this.name);
        System.out.println("NIM: " + this.nim);
    }
}