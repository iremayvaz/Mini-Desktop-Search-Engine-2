package searchengine;

public class LinkedListNode<T extends Comparable<T>> {

    LinkedListNode<T> next;
    // file name
    T fileName;
    // counter for frequency of word in this file
    int wordCounter;

    public LinkedListNode(T fileName) {
        this.fileName = fileName;
        this.wordCounter = 1;
        this.next = null;
    }
}
