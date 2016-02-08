Manacher Algorithm: Find largest palindromic substring in a given string efficiently.

public class Manacher {
    public String preProcess(String str) {
        int len = s.length();   //参照leetcode shortest palindrome 这种方式效率高
        int n = 2*len+3;
        char[] arr = new char[n];
        arr[0] = '^'; arr[1] = '#';
        for(int i=0; i<len; i++) {
            arr[2*i+2] = s.charAt(i);
            arr[2*i+3] = '#';
        }
        arr[2*len+2] = '$';
        return arr;

        //-----------------------------

        int len = str.length();
        if(len==0)
            return "^$";
        String s = "^";
        for(int i=0; i<len; i++) {  //将所有可能的奇数/偶数长度的回文子串都转换成了奇数长度 在每个字符的两边都插入一个特殊的符号#
            s+="#"+str.charAt(i);  //因为后面算p[i]都是按奇数回文串算的 也就是中间有一个点两边延伸 而偶数的话就没有中间的点了 
        }
        s+="#$";
        return s;
    }

    public String getLongestPalindrome(String str) {
        char[] s = preProcess(str).toCharArray();
        int N = s.length;
        int[] p = new int[N+1];
        int id = 0, mx = 0;
        for(int i=1; i<N-1; i++) {  //两个#之间 不要开头的^ 和结尾的$
            p[i] = mx>i ? Math.min(p[2*id-i], mx-i):1;  //算法关键公式 如果mx > i，那么P[i] >= MIN(P[2 * id - i], mx - i)
            while(s[i+p[i]]==s[i-p[i]])     //只要还满足回文串的条件 就可以一直延伸p[i]
                p[i]++;
            if(i+p[i]>mx) {     //更新mx id if necessary
                mx = i + p[i];
                id = i;
            }
        }

        int maxLen = 0;
        int centerIndex = 0;
        for(int i=1; i<N-1; i++) {  //取最大的p[i]
            if(p[i]>maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        int pos = (centerIndex - 1 - maxLen)/2; //enterIndex-1-maxLen是在p数组里开始的位置 由于里面插入了＃ 所以要除2才是原始数组的位置
        return str.substring(pos, pos+maxLen);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Manacher Algorithm Test\n");
        System.out.println("\nEnter String");
        String text = br.readLine();

        Manacher m = new Manacher();
        String longestPalindrome = m.getLongestPalindrome(text);
        System.out.println("\nLongest Palindrome: " + longestPalindrome);
    }
}

# a # b # a #
# a # b # b # a #

# a # b # c # d # a # d #

a b c d a d

http://www.sanfoundry.com/java-program-implement-manacher-algorithm/
http://www.felix021.com/blog/read.php?2040
http://articles.leetcode.com/2011/11/longest-palindromic-substring-part-ii.html