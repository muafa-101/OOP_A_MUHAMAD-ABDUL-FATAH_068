package Library;

public class Fiction extends Book {
        public Fiction(String Title, String author) {
            super(Title, author);
    }

    @Override
    public void displayInfo() {
            System.out.println("Fiction Book: " + getTitle() + " by " + getAuthor());
    }
}

