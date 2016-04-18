https://en.wikipedia.org/wiki/Knapsack_problem

0-1 Knapsack

Recursive

public int knapsack(int w, int n, int[] wt, int[] val) {

	if (n == 0 || w == 0)
		return 0;
	if (wt[n-1] > w)
		return knapsack(w, n-1, wt, val);
	else
		return Math.max(val[n-1] + knapsack(w-wt[n-1], n-1, wt, val),
						knapsack(w, n-1, wt, val));
}

O(2^n)



DP

public int knapsack(int w, int n, int[] wt, int[] val) {

	int[][] k = new int[w+1][n+1];

	for (int i = 0; i < n+1; i++) {
		for (int j = 0; j < w+1; j++) {
			if (i == 0 || w == 0)
				k[i][w] = 0;
			else if (wt[i-1] <= w)
				k[i][w] = Math.max(val[i-1] + k[i-1][w-wt[i-1]], k[i-1][w]);
			else
				k[i][w] = k[i-1][w];
		}
	}
	return k[n][w];
}

O(nw)

http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/



Unbounded Knapsack

Recursive

public int M(int[] v, int[] w, int c) {

	int[] sol, mySol;
	int i, res;

	sol   = new int[v.length];
	mySol = new int[v.length];

	if (c == 0)
		return 0;
	for (i = 0; i < v.length; i++) {
		if (c >= w[i])
			sol[i] = M(v, w, c-w[i])
		else
			sol[i] = 0;
	}

	for (i = 0; i < v.length; i++) {
		if (c >= w[i])
			mySol[i] = sol[i] + v[i];
		else
			mySol[i] = 0;
	}

	for (i = 1; i < v.length; i++) {
		if (mySol[i] > res)
			res = mySol[i];
	}
	return res;
}


DP

public void int M(int[] v, int[] w, int weight) {
	
	int[] sol, mySol;
	int i, res;

	int[] res = new int[weight+1];
	int c;

	sol   = new int[v.length];
	mySol = new int[v.length];

	res[0] = 0;

	for (c = 1; c <= weight; c++) {
		for (i = 0; i < v.length; i++) {
			if (c >= w[i])
				sol[i] = res[c-w[i]];
			else
				sol[i] = 0;
		}

		for (i = 0; i < v.length; i++) {
			if (c >= w[i])
				mySol[i] = sol[i] + v[i];
			else
				mySol[i] = 0;
		}

		res[c] = mySol[0];
		for (i = 1; i < v.length; i++) {
			if (mySol[i] > res[c])
				res[c] = mySol[i];
		}
	}
	return res[weight];
}

O(nw)

http://www.mathcs.emory.edu/~cheung/Courses/323/Syllabus/DynProg/knapsack2.html



Bounded Knapsack