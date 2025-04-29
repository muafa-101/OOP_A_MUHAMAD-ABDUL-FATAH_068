package Library;

public abstract class Book {
    private String Title;
    private String author;

    public Book(String title, String author) {
        this.Title = title;
        this.author = author;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return author;
    }

    public abstract void displayInfo();
}

