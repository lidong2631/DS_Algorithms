http://www.sanfoundry.com/java-program-ternary-search-tree/
http://www.geeksforgeeks.org/ternary-search-tree/
https://en.wikipedia.org/wiki/Ternary_search_tree
http://blog.csdn.net/suwei19870312/article/details/7467522

import java.util.Scanner;
import java.util.ArrayList;

// class TSTNode
class TSTNode {

    char data;
    boolean isEnd;
    TSTNode left, mid, right;

    public TSTNode(char data) {
        
        this.data  = data;
        this.isEnd = false;
        this.left  = null;
        this.mid   = null;
        this.right = null;
    }
}

// class TernarySearchTree
class TernarySearchTree {

    private TSTNode root;
    private List<String> l;

    public TernarySearchTree() {
        
        root = null;
    }

    public boolean isEmpty() {
        
        return root == null;
    }

    public void makeEmpty() {
        
        root = null;
    }

    public void insert(String word) {
        
        root = insert(root, word.toCharArray(), 0);
    }

    // insert
    public TSTNode insert(TSTNode r, char[] word, int p) {
        
        if (r == null)
            r = new TSTNode(word[p]);

        if (word[p] < r.data)
            r.left = insert(r.left, word, p);
        else if (word[p] > r.data)
            r.right = insert(r.right, word, p);
        else {
            if (p + 1 < word.length)
                r.mid = insert(r.mid, word, p + 1);
            else
                r.isEnd = true;
        }
        return r;
    }

    public void delete(String word) {
        delete(root, word.toCharArray(), 0);
    }

    // delete
    private void delete(TSTNode r, char[] word. int p) {
        
        if (r == null)
            return;

        if (word[p] < r.data)
            delete(r.left, word, p);
        else if (word[p] > r.data)
            delete(r.right, word, p);
        else {
            if (r.isEnd && p == word.length - 1)
                r.isEnd = false;
            else if (p + 1 < word.length)
                delete(r.mid, word, p + 1);
        }
    }

    public boolean search(String word) {
        
        return search(root, word.toCharArray(), 0);
    }

    private boolean search(TSTNode r, char[] word, int p) {

        if (r == null)
            return false;
        if (word[p] < r.data)
            return search(r.left, word, p);
        else if (word[p] > r.data)
            return search(r.right, word, p);
        else {
            if (r.isEnd && p == word.length - 1)
                return true;
            else if (p == word.length - 1)
                return false;
            else
                return search(r.mid, word, p + 1);
        }
    }

    public String toString() {

        l = new ArrayList<String>();
        traverse(root, "");
        return "\nTernary Search Tree :" + l;
    }

    private void traverse(TSTNode r, String str) {

        if (r != null) {
            traverse(r.left, str);

            str = str + r.data;                     // str that stored in l previously would be changed here
            if (r.isEnd)
                l.add(str);
            
            traverse(r.mid, str);
            str = str.substring(0, str.length() - 1);   // ?

            traverse(r.right, str);
        }
    }
}















