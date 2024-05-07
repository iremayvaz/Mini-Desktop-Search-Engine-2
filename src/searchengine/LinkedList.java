/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package searchengine;

/**
 *
 * @author iremayvaz
 */
public class LinkedList<T extends Comparable<T>> {
    LinkedListNode<T> head;

    //kelimelerin hangi dosyada kaç tane olduğunu her BSTNode'u için
    public void addFirst(T fileName) {
        LinkedListNode<T> newNode = new LinkedListNode<>(fileName);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    //wordList linkedList'inden wordCounter'ını arttıracağımız node'u buluyoruz.
    public LinkedListNode<T> findNode(T fileName) {
        LinkedListNode<T> temp = head;
        if (temp != null) {
            while (!temp.fileName.equals(fileName)) {
                temp = temp.next;
            }
        }
        return temp;
    }

    //wordList linkedList'in çıktısı
    public void print() {
        LinkedListNode<T> current = head;
        while (current != null) {
            System.out.print("[" + current.fileName + " , " + current.wordCounter + "] -> ");
            current = current.next;
        }
        System.out.print("null");
    }
}