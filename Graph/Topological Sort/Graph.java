<<<<<<< HEAD
import java.util.*;

//http://www.geeksforgeeks.org/topological-sorting/

class Graph {
	int v;
	List<List<Integer>> adj;
	Stack<Integer> stack;

	public Graph(int v) {
		this.v = v;
		adj = new ArrayList<List<Integer>>();
		for(int i=0; i<v; i++) {
			adj.add(new ArrayList<Integer>());
		}
		stack = new Stack<Integer>();
	}

	public void addEdge(int v, int w) {
		adj.get(v).add(w);
	}

	public void topologicalSort() {
		boolean[] visited = new boolean[v];
		for(int i=0; i<v; i++)
			visited[i] = false;
		for(int i=0; i<v; i++) {
			if(!visited[i])
				topologicalSortUtil(i, visited, stack);
		}

		while(!stack.empty()) {
			System.out.print(stack.peek() + " ");
			stack.pop();
		}
	}

	public void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
		visited[v] = true;
		List<Integer> item = adj.get(v);
		for(int i=0; i<item.size(); i++) {
			if(!visited[item.get(i)])
				topologicalSortUtil(item.get(i), visited, stack);
		}
		stack.push(v);
	}
=======
import java.util.*;

//http://www.geeksforgeeks.org/topological-sorting/

class Graph {
	int v;
	List<List<Integer>> adj;
	Stack<Integer> stack;

	public Graph(int v) {
		this.v = v;
		adj = new ArrayList<List<Integer>>();
		for(int i=0; i<v; i++) {
			adj.add(new ArrayList<Integer>());
		}
		stack = new Stack<Integer>();
	}

	public void addEdge(int v, int w) {
		adj.get(v).add(w);
	}

	public void topologicalSort() {
		boolean[] visited = new boolean[v];
		for(int i=0; i<v; i++)
			visited[i] = false;
		for(int i=0; i<v; i++) {
			if(!visited[i])
				topologicalSortUtil(i, visited, stack);
		}

		while(!stack.empty()) {
			System.out.print(stack.peek() + " ");
			stack.pop();
		}
	}

	public void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
		visited[v] = true;
		List<Integer> item = adj.get(v);
		for(int i=0; i<item.size(); i++) {
			if(!visited[item.get(i)])
				topologicalSortUtil(item.get(i), visited, stack);
		}
		stack.push(v);
	}
>>>>>>> efdafe9e8c74597bcfaaf5f773a006a58700c65b
}