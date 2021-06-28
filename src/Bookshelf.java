import java.util.ArrayList;

public class Bookshelf {

    private ArrayList<Book> books;

    public Bookshelf() {
        this.books = new ArrayList<Book>();
    }

    public boolean loadBooks() {
        return true;
    }

    public boolean removeBook(String title, String author) {
        boolean bl = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getAuthor().equalsIgnoreCase(author) && books.get(i).getTitle().equalsIgnoreCase(title)) {
                bl = books.remove(books.get(i));
            }
        }
        return bl;
    }

    public boolean addBook(Book newBook) {
        boolean bl = books.add(newBook);
        return bl;
    }


}
