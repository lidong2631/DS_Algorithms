Longest Common Substring

经典动态规划题
使用dp[i][j]表示 以x[i]和y[j]结尾的最长公共子串的长度 因为要求子串连续 所以对于X[i]与Y[j]来讲 它们要么与之前的公共子串构成新的公共子串

要么就是不构成公共子串 状态转移方程
1 x[i]==y[j] dp[i][j] = dp[i-1][j-1]+1
2 x[i]!=y[j] dp[i][j] = 0

public int LCSubStr(char[] x, char[] y, int m, int n) {
    int[][] lcs = new int[m+1][n+1];
    int res = 0;

    lcs[0][0] = 0;
    for(int i=0; i<m; i++) {
        for(int j=0; j<n; j++) {
            lcs[i＋1][j＋1] = (x[i]==y[j])?lcs[i][j]+1:0;
            res = Math.max(res, lcs[i][j]);
        }
    }
    return res;
}

O(m*n) O(m*n)
http://www.geeksforgeeks.org/longest-common-substring/
http://en.wikipedia.org/wiki/Longest_common_substring_problem
http://www.sanfoundry.com/java-program-longest-common-substring-algorithm/


用滚动数组优化空间 类似于unique path那题那种

public int LCSubStr(char[] x, char[] y, int m, int n) {
    int[] lcs = new int[n+1];
    int res = 0;

    lcs[0] = 0;
    for(int i=0; i<m; i++) {
        for(int j=0; j<n; j++) {
            lcs[j＋1] = (x[i]==y[j])?lcs[j]+1:0;
            res = Math.max(res, lcs[j＋1]);
        }
    }
    return res;
}

O(m*n) O(n)


动态规划的解法还有更优化空间的方法是沿对角线扫 见
http://www.hankcs.com/program/algorithm/implementation-and-application-of-nlp-longest-common-subsequence-longest-common-subsequence-of-java.html
http://blog.iderzheng.com/longest-common-substring-problem-optimization/


这道题还有一个解法使用suffix tree 要了解一下suffix tree