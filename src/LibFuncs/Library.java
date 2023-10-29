package LibFuncs;

public class Library{
    private static Library instance;
    private TreeNode root;

    private Library() {
        root = null;
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
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
}