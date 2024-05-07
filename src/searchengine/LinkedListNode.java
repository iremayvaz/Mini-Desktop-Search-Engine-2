
package searchengine;


public class LinkedListNode<T extends Comparable<T>> {
    LinkedListNode<T> next;
    T fileName; 
    int wordCounter; 

    public LinkedListNode(T fileName) {
        this.fileName = fileName;
        this.wordCounter = 1;
        this.next = null;
    }
}
