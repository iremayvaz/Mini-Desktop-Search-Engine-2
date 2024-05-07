
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
                    temp.frequency++;
                    return;
                }
            }
        }
    }

    // inorder traversal (LNR)
    public void inorder() {
        System.out.println("inorder: ");
        inorder(root);
        System.out.println();
    }
    
    public void inorder(BSTNode<T> node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " : " + node.frequency + " | ");
            inorder(node.right);
        }
    }

    // postorder traversal (LRN)
    public void postorder() {
        System.out.println("postorder: ");
        postorder(root);
        System.out.println();
    }

    public void postorder(BSTNode<T> node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " : " + node.frequency + " | ");
        }
    }

    //veri çıktısı preorder (NLR)
    // preorder traversal
    public void preorder() {
        System.out.println("preorder: ");
        preorder(root);
        System.out.println();
    }

    public void preorder(BSTNode<T> node) {
        if (node != null) {
            System.out.print(node.data + " : " + node.frequency +  " | ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // search a word from BST and print that word linkedlist (fileName - frequency)
    public void printWordsCount(T wanted) {
        BSTNode<T> temp = root;
        while (temp != null) {
            int compare = wanted.compareTo(temp.data);

            if (compare == 0) {
                temp.wordList.print();
                return;
            } else if (compare < 0) {
                temp = temp.left;
            } else { // compare > 0
                temp = temp.right;
            }
        }
        System.out.println("Data not found");
    }
}
