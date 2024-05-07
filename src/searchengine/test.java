
import searchengine.BinarySearchTree;


public class test {

    public static void main(String[] args) {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        
        bst.insert("first", "A");
        bst.insert("first", "A");
        bst.insert("into", "A");
        bst.insert("mud", "A");
        bst.insert("frequency", "A");
        bst.insert("first", "B");
        bst.insert("trail", "B");
        bst.insert("elimination", "B");
        bst.insert("bomb", "B");
        bst.insert("first", "C");
        bst.insert("trail", "C");
        
        bst.postorder();
        bst.inorder();
        bst.preorder();
        
        bst.printWordsCount("first");
    }
}