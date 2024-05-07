/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package searchengine;

/**
 *
 * @author iremayvaz
 */
public class LinkedListNode<T extends Comparable<T>> {
    LinkedListNode<T> next;
    T fileName;//data
    int wordCounter;//key

    public LinkedListNode(T fileName) {
        this.fileName = fileName;
        this.wordCounter = 1;
        this.next = null;
    }
}
