package searchengine;

public class BSTNode<T extends Comparable<T>> {

    BSTNode<T> left;
    BSTNode<T> right;
    LinkedList<T> wordList; // linked list for word (file name - frequency)
    T data; // word
    int frequency; // total frequency of word 

    public BSTNode(T data) {
        this.left = null;
        this.right = null;
        this.wordList = new LinkedList<>();
        this.data = data;
        this.frequency = 1;
    }
}
