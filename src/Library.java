import java.io.*;

public class Library implements Serializable {
    private TreeNode root;

    public Library() {
        root = null;
    }

    public void insert(Book book) {
        root = insertNode(root, book);
    }

    private TreeNode insertNode(TreeNode root, Book book) {
        if (root == null) {
            return new TreeNode(book);
        }

        int titleComparison = book.title.compareTo(root.book.title);

        if (titleComparison < 0) {
            root.left = insertNode(root.left, book);
        } else if (titleComparison > 0) {
            root.right = insertNode(root.right, book);
        } else {
            root.book.quantity += book.quantity;
        }

        return root;
    }

    public Book search(String title) {
        return searchNode(root, title);
    }

    private Book searchNode(TreeNode root, String title) {
        if (root == null || title.equals(root.book.title)) {
            return (root != null) ? root.book : null;
        }

        int titleComparison = title.compareTo(root.book.title);

        if (titleComparison < 0) {
            return searchNode(root.left, title);
        } else {
            return searchNode(root.right, title);
        }
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(this);
            System.out.println("Library data saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Library loadFromFile(String filename) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename)) ) {
            Library library = (Library) inputStream.readObject();
            System.out.println("Library data loaded from " + filename);
            return library;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}