public class KnuthMorrisPratt {

    public void KMPSearch(char[] pattern, char[] str) {
        int M = pattern.length;
        int N = str.length;

        int j = 0;
        int[] lps = new int[M];
        computeLPS(pattern, M, lps);

        int i = 0;
        while(i<N) {
            if(pattern[j]==str[i]) {    //if match both go forward 1 step
                i++;
                j++;
            }
            if(j==M) {
                System.out.println("Found pattern at index " + (i-j));
                j = lps[j-1];
            }
            else if(i<N && patter[j]!=str[i]) { //mismatch after j matches
                //Do not match lps[0..lps[j-1]] characters, they will match anyway
                if(j!=0)
                    j = lps[j-1];
                else
                    i++;
            }
        }
    }

    public void computerLPS(char[] pattern, int M, int[] lps) {
        int len = 0;    //length of the previous longest prefix suffix
        int i = 1;
        lps[0] = 0; //lps[0] is always 0

        while(i<M) {    //the loop calculates lps[i] for i=1 to M-1
            if(pattern[i] = pattern[len]) { //if match both len and i plus 1
                len++;
                lps[i] = len;
                i++;
            }
            else {  //not match
                if(len!=0) {
                    len = lps[len-1];   //This is trick. Consider AAACAAAA and i = 7
                    //also note we do not increment 1 here
                }
                else {      //if len==0
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}

ex  ABCDAB ABCDABCDABDE
    ABCDABD

The worst case complexity of Naive algorithm is O(m(n-m+1)). Time complexity of KMP algorithm is O(n) in worst case.

http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html



KMP算法的出现是因为原始暴力法在字符匹配时效率不高 即当失配时 暴力法会将原字符串后移一位继续跟待匹配字符串比较而没有利用到前面比较的信息 

KMP算法正是利用了前面匹配了的信息来提高效率 KMP算法会先计算出待匹配字符串中每个子串的longest prefix suffix 然后利用这个信息在失配发生时直接将字符串跳到

后缀中跟前缀相同的字符开始比较



下面是暴力法code
http://www.geeksforgeeks.org/searching-for-patterns-set-1-naive-pattern-searching/

Slide the pattern over text one by one and check for a match. If a match is found, then slides by 1 again to check for subsequent matches

public void search(char[] pattern, char[] str) {
    int M = pattern.length;
    int N = str.length;

    for(int i=0; i<N-M; i++) {  //A loop to slide pattern[] one by one
        int j = 0;
        for(; j<M; j++) {   //for current index i, check for pattern match
            if(str[i+j]!=pattern[j])
                break;
        }
        if(j==M)
            System.out.println("Pattern found at index " + i);
    }
}


What is the best case?
The best case occurs when the first character of the pattern is not present in text at all
str[] = "AABCCAADDEE"
pattern[] = "FAA"

The number of comparisons in best case is O(n)


What is the worst case?
The worst case of Naive Pattern Searching occurs in following scenarios

1 When all characters of the text and pattern are same
str[] = "AAAAAAAAAAAAA"
pattern[] = "AAAAA"

2 Worst case also occurs when only the last character is different
str[] = "AAAAAAAAAAAAB"
pattern[] = "AAAAB"

Number of comparisons in worst case is O(m*(n-m+1)). Although strins which have repeated characters are not likely to appear in English text,

they may well occur in other applications(Binary texts). KMP matching algorithms improves the worst case to O(n)
























