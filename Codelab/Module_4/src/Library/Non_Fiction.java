package Library;

public class Non_Fiction extends Book {
    public Non_Fiction(String Title, String author) {
        super(Title, author);
    }

    @Override
    public void displayInfo() {
        System.out.println("Non-Fiction Book: " + getTitle() + " by " + getAuthor());
    }
}
