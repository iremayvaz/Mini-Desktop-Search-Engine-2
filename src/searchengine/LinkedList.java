package searchengine;

public class LinkedList<T extends Comparable<T>> {

    LinkedListNode<T> head;

    // this class for to keep track of how many words are in which file for each BSTNode
    public void addFirst(T fileName) {
        LinkedListNode<T> newNode = new LinkedListNode<>(fileName);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // output of the linked list (fileName - frequency for that file)
    public String getLinkedListString() {
        String text = "";
        LinkedListNode<T> current = head;
        while (current != null) {
            text += "[" + current.fileName + " , " + current.wordCounter + "] | ";
            current = current.next;
        }
        return text;
    }
}
