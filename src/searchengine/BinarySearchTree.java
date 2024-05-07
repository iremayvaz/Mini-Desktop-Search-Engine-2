package searchengine;

public class BinarySearchTree<T extends Comparable<T>> {

    BSTNode<T> root;

    // insertion operation
    public void insert(T data, String fileName) {
        // BSTNode for new word to add BST
        BSTNode<T> newNode = new BSTNode<>(data);
        // check root whether it is null or not
        if (root == null) {
            // if it is null add newNode to root and assing root to it
            root = newNode;
            // add fileName to linkedList
            root.wordList.addFirst((T) fileName);
            // if it is not null
        } else {
            // temp node to traversal
            BSTNode<T> temp = root;
            while (temp != null) {
                // newNode data smaller to temp data we need to go left side of temp
                if (newNode.data.compareTo(temp.data) < 0) {
                    if (temp.left == null) {
                        // if the left side of temp is null add newNode to left of temp
                        temp.left = newNode;
                        temp.left.wordList.addFirst((T) fileName); // add fileName to linkedlist
                        return;
                    }
                    temp = temp.left; // go left side of temp
                } else if (newNode.data.compareTo(temp.data) > 0) {
                    // newNode data greater than temp data we need to go right side of temp
                    if (temp.right == null) {
                        // if the right side of temp is null add newNode to right of temp
                        temp.right = newNode;
                        temp.right.wordList.addFirst((T) fileName);
                        return;
                    }
                    temp = temp.right; // go right side of temp
                } else {
                    // we have the data so we do not need to add newNode
                    if (temp.wordList.head.fileName == fileName) {
                        // if data is from the same file just increase the counter for that file
                        temp.wordList.head.wordCounter++;
                    } else {
                        // if not add that file to linkedList
                        temp.wordList.addFirst((T) fileName);
                    }
                    // increase the total frequency of word
                    temp.frequency++;
                    return;
                }
            }
        }
    }

    // inorder traversal (LNR)
    public String inorder() {
        return inorder(root);
    }

    private String inorder(BSTNode<T> node) {
        if (node == null) {
            return "";
        }

        String left = inorder(node.left); // left
        String currentNode = node.data + ", " + node.frequency + "\n"; // node
        String right = inorder(node.right); // right

        return left + currentNode + right;
    }

    // postorder traversal (LRN)
    public String postorder() {
        return postorder(root);
    }

    public String postorder(BSTNode<T> node) {
        if (node == null) {
            return "";
        }

        String left = postorder(node.left); // left
        String right = postorder(node.right); // right
        String currentNode = node.data + ", " + node.frequency + "\n"; // node

        return left + right + currentNode;
    }

    // preorder traversal (NLR)
    public String preorder() {
        return preorder(root);
    }

    public String preorder(BSTNode<T> node) {
        if (node == null) {
            return "";
        }

        String currenNode = node.data + ", " + node.frequency + "\n"; // node
        String left = preorder(node.left); // left 
        String right = preorder(node.right); // right

        return currenNode + left + right;
    }

    // search a word from BST and getLinkedListString that word linkedlist (fileName - frequency)
    public String printWordsCount(T wanted) {
        BSTNode<T> temp = root;
        while (temp != null) {
            int compare = wanted.compareTo(temp.data);

            if (compare == 0) {
                return wanted + ", found " + temp.frequency + " times in :\n" + temp.wordList.getLinkedListString();
            } else if (compare < 0) {
                temp = temp.left;
            } else { // compare > 0
                temp = temp.right;
            }
        }
        return "";
    }
}
