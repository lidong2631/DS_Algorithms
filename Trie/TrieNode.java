public class TrieNode {
    boolean endOfWord;
    TrieNode[] children;

    public TrieNode() {
        //value = v;
        endOfWord = false;
        children = new TrieNode[26];
    }

    // public void setValue(int v) {
    //     this.value = v;
    // }

    // public int getValue() {
    //     return this.value;
    // }
}