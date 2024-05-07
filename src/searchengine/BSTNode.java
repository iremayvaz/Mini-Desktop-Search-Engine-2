/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package searchengine;

/**
 *
 * @author iremayvaz
 */
public class BSTNode<T extends Comparable<T>> {
    BSTNode<T> left;
    BSTNode<T> right;
    LinkedList<T> wordList;// kelime sayısı listesi
    T data;//kelime

    public BSTNode(T data) {
        this.left = null;
        this.right = null;
        this.wordList = new LinkedList<>();// dosya adı - kelime sıklığı listesi
        this.data = data;
    }
}
