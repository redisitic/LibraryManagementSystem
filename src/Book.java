public class Book {
    int id;
    String title;
    String author;
    int pages;
    int quantity;
    String language;
    String description;

    Book(int id, String title, String author, int pages, int quantity, String language, String description){
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.quantity = quantity;
        this.language = language;
        this.description = description;
    }
}