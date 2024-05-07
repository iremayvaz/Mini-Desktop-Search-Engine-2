
package searchengine;

public class BSTNode<T extends Comparable<T>> {
    BSTNode<T> left;
    BSTNode<T> right;
    LinkedList<T> wordList; // linked list for word's (file name - frequency)
    T data; // word
    int frequency;

    public BSTNode(T data) {
        this.left = null;
        this.right = null;
        this.wordList = new LinkedList<>();// file name - frequency list
        this.data = data;
        this.frequency = 1;
    }
}
