/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package searchengine;

/**
 *
 * @author iremayvaz
 */
public class BinarySearchTree<T extends Comparable<T>> {
    BSTNode<T> root;

    //veri ekleme
    public void insert(T data, String fileName) {
        //eklenecek veri
        BSTNode<T> newNode = new BSTNode<>(data);

        if (root == null) {// root boşsa
            root = newNode;
            root.wordList.addFirst((T) fileName);// dosya adı linkedList'e eklendi.
        } else {// root doluysa
            BSTNode<T> temp = root;// roottan childlara gezinmek için
            //root boş değilse
            while (temp != null) {
                if (newNode.data.compareTo(temp.data) < 0) {// newNode, roottan küçük
                    if (temp.left == null) {// rootun solu boş
                        temp.left = newNode;// rootun soluna eklenmeli çünkü roottan küçük
                        temp.left.wordList.addFirst((T) fileName);
                        break;// döngüden çıkılmalı
                    }
                    temp = temp.left;// tempin solu doluysa solun soluna bakmak üzere tempi tempin solu olarak güncellenir.

                } else if (newNode.data.compareTo(temp.data) > 0) {// newNode, roottan büyük

                    if (temp.right == null) {// rootun sağı boş
                        temp.right = newNode;
                        temp.right.wordList.addFirst((T) fileName);
                        break;
                    }
                    temp = temp.right;

                } else {// newNode.data.compareTo(temp.data) == 0, eleman BST'de var

                    if (temp.wordList.head.fileName == fileName) {
                        temp.wordList.head.wordCounter++;// aynı dosyada aynı kelimeden kaç tane olduğunu tutabilmek için
                    } else {
                        temp.wordList.addFirst((T) fileName);
                    }
                    break;// bu yüzden eklenmesine gerek yok döngüden çıkış
                }

            }
        }
    }

    //veri çıktısı inorder (LNR)
    public void inorder() {
        System.out.println("inorder: ");
        inorder(root);
        System.out.println();
    }

    public void inorder(BSTNode<T> node) {// bir node alınır
        if (node != null) {// node boş değilse
            inorder(node.left);// önce sol ağaca bakılır
            System.out.print(node.data + " ");// sonra kendi
            inorder(node.right);// sonra sağ ağaca bakılır
        }
    }

    //veri çıktısı postorder (LRN)
    public void postorder() {
        System.out.println("postorder: ");
        postorder(root);
        System.out.println();
    }

    public void postorder(BSTNode<T> node) {
        if (node != null) {
            postorder(node.left);//alınan node un önce sol ağacına
            postorder(node.right);// sonra sağ ağacına
            System.out.print(node.data + " ");// en son da kendisi
        }
    }

    //veri çıktısı preorder (NLR)
    public void preorder() {
        System.out.println("preorder: ");
        preorder(root);
        System.out.println();
    }

    public void preorder(BSTNode<T> node) {
        if (node != null) {
            System.out.print(node.data + " ");// önce kendi
            preorder(node.left);// sonra sol ağacı
            preorder(node.right);// en son sağ ağacı
        }
    }

    // BST'de aranan kelimenin sahip olduğu linkedList'e erişme
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
