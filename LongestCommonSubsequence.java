public int lcs(char[] x, char[] y, int m, int n) {
    int[][] L = new int[m+1][n+1];
    L[0][0] = 0;

    for(int i=0; i<m; i++) {
        for(int j=0; j<n; j++) {
            if(x[i]==y[j])
                L[i][j] = L[i-1][j-1]+1;
            else
                L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
        }
    }
    return L[m][n];
}

O(m*n) O(m*n)
http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
http://www.cnblogs.com/huangxincheng/archive/2012/11/11/2764625.html



Print Longest Common Subsequence
Following is detailed algorithm to print the LCS. It uses the same 2D table L[][].

1) Construct L[m+1][n+1] using the steps discussed in previous post.

2) The value L[m][n] contains length of LCS. Create a character array lcs[] of length equal to the length of lcs.

2) Traverse the 2D array starting from L[m][n]. Do following for every cell L[i][j]
    a) If characters (in X and Y) corresponding to L[i][j] are same (Or X[i-1] == Y[j-1]), then include this character as part of LCS.
    b) Else compare values of L[i-1][j] and L[i][j-1] and go in direction of greater value.



int index = L[m][n];
char[] lcs = new char[index];

int i=m, j=n;
while(i>0 && j>0) {
    if(x[i-1]==y[j-1]) {
        lcs[index-1] = x[i-1];
        i--; j--; index--;
    }
    else if(L[i-1][j]>L[i][j-1])
        i--;
    else
        j--;
}

http://www.geeksforgeeks.org/printing-longest-common-subsequence/