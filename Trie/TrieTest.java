public class TrieTest {
    public static void main(String[] args) {
        String[] str = {"the", "a", "there", "answer", "any", "by", "bye", "their"};
        String[] output = {"Not present in trie", "Present in trie"};

        Trie t = new Trie();

        for(int i=0; i<str.length; i++)
            t.insert(str[i]);

        // System.out.println("the " + t.search("the"));
        // System.out.println("these " + t.search("these"));
        // System.out.println("their " + t.search("their"));
        // System.out.println("thaw " + t.search("thaw"));

        System.out.println("the " + output[t.search("the")]);
        System.out.println("these " + output[t.search("these")]);
        System.out.println("their " + output[t.search("their")]);
        System.out.println("thaw " + output[t.search("thaw")]);
    }
}

http://www.geeksforgeeks.org/trie-insert-and-search/

Compressed Tries http://www.mathcs.emory.edu/~cheung/Courses/323/Syllabus/Text/trie02.html