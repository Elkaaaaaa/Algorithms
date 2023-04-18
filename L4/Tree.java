package L4;

public class Tree {
    private Node root;

    public boolean add(int value) {
        if (root != null) {
            boolean result = addNote(root, value);
            root = rebalane(root);
            root.color = Color.BLACK;
            return result;
        } else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }

    private boolean addNote(Node node, int value) {
        if (node.value == value) {
            return false;
        } else {
            if (node.value > 0) {
                if (node.left != null) {
                    boolean result = addNote(node.left, value);
                    node.left = rebalane(node.left);
                    return result;
                } else {
                    node.left = new Node();
                    node.left.color = Color.RED;
                    node.left.value = value;
                    return true;
                }
            } else {
                if (node.right != null) {
                    boolean result = addNote(node.right, value);
                    node.right = rebalane(node.right);
                    return result;
                } else {
                    node.right = new Node();
                    node.right.color = Color.RED;
                    node.right.value = value;
                    return true;
                }
            }
        }
    }

    private Node rebalane(Node node) {
        Node result = node;
        boolean check;
        do {
            check = false;
            if (result.right != null && result.right.color == Color.RED
                    && (result.left == null || result.left.color == Color.BLACK)) {
                check = true;
                result = rightSwap(result);
            }
            if (result.right != null && result.left.color == Color.RED && result.left.left == null
                    && result.left.left.color == Color.RED) {
                check = true;
                result = leftSwwap(result);
            }
            if (result.left != null && result.right != null && result.left.color == Color.RED
                    && result.right.color == Color.RED) {
                check = true;
                colorSwap(result);
            }
        } while (check);
        return result;
    }

    private Node leftSwwap(Node node) {
        Node left = node.left;
        Node betwen = node.right;
        left.right = node;
        node.left = betwen;
        left.color = node.color;
        node.color = Color.RED;
        return left;
    }

    private Node rightSwap(Node node) {
        Node right = node.right;
        Node betwen = node.left;
        right.left = node;
        node.right = betwen;
        right.color = node.color;
        node.color = Color.RED;
        return right;
    }

    private void colorSwap(Node node) {
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
    }

    private class Node {
        private int value;
        private Color color;
        private Node left;
        private Node right;
    }

    private enum Color {
        RED, BLACK;
    }
}