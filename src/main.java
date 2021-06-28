import Control.DBConnector;

public class main {
    public static void main(String[] args) {
        DBConnector db = new DBConnector();
        db.connect(DBConnector.ACTION.SELECT, "SELECT * FROM book");
        db.connect(DBConnector.ACTION.INSERT, "INSERT INTO book(title, author, isbn, date) VALUES ('The Stand', 'Steven King', '110as05x-aa', '11/22/1992')");
    }
}
