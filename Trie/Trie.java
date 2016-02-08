public class Trie {
    private TrieNode root;
    //private int count;

    public Trie() {
        root = new TrieNode();
        //count = 0;
    }

    public void insert(String str) {
        TrieNode p = root;
        //count++;

        for(int i=0; i<str.length(); i++) {
            int index = str.charAt(i)-'a';
            if(p.children[index]==null)
                p.children[index] = new TrieNode();
            p = p.children[index];
        }
        p.endOfWord = true;    //mark last node as leaf
        //p.setValue(count);  //mark last node as leaf
    }

    public int search(String str) {
        TrieNode p = root;

        for(int i=0; i<str.length(); i++) {
            int index = str.charAt(i)-'a';
            if(p.children[index]==null)
                return 0;
            p = p.children[index];
        }
        if(p!=null && p.endOfWord)
            return 1;
        return 0;
    }
}