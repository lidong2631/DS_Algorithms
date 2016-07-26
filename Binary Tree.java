<<<<<<< HEAD
Binary Tree: Usually it combines the advantages of two other structures: an ordered array and a linked list. You can search a tree quickly as you can an ordered array, and you can also insert and delete items quickly, as you can with a linked list.
Slow insertion in an ordered array
Slow searching in a linked list

Tree terminology
Path

Root: The node at the top of the tree is called the root. There is only one root in a tree. For a collection of nodes and edges to be defined as a tree, there must be one (and only one!) path from the root to any other node.

Parent

Child

Leaf: A node that has no children is called a leaf node or simply a leaf. There can be only one root in a tree, but there can be many leaves.

Subtree

Visiting: A node is visited when program control arrives at the node, usually for the purpose of carrying out some operation on the node, such as checking the value of one of its data fields or displaying it. Merely passing over a node on the path from one node to another is not considered to be visiting the node.

Traversing: To traverse a tree means to visit all the nodes in some specified order. For example, you might visit all the nodes in order of ascending key value. There are other ways to traverse a tree, as we'll see later.'

Levels

Keys

Binary Trees: if every node in a tree can have at most two children, the tree is called a binary tree. In this chapter we'll focus on binary trees because they are the simplest and the most common. A node in a binary tree doesn't necessarily have the maximum of two children; it may have only a left child, or only a right child, or it can have no children at all(in which case it's a leaf). The kind of binary tree we'll be dealing with in this discussion is technically called a binary seach tree.

Binary search tree: A node's left child must have a key less than its parent, and a node's right child must have a key greater than or equal to its parent.

Unbalanced Trees: Some of the trees you generate are unbalanced; that is, they have most of their nodes on one side of the root or the other, as shown in Figure 8.6. Individual subtrees may also be unbalanced. Trees become unbalanced because of the order in which the data item are inserted. If these key values are inserted randomly, the tree will be more or less balanced. However, if an ascending sequence (like 11, 18, 33, 42, 65 and so on) or a descending sequence is generated, all the values will be right children (if ascending) or left children (if descending) and the tree will be unbalanced.
If a tree is created by data items whose key values arrive in random order, the problem of unbalanced trees may not be too much of a problem for larger trees because the chances of a long run of numbers in sequence is small. But key values can arrive in strict sequence; for example, when a data-entry person arranges a stack of personnel files into order of ascending employee number before enteringthe data. When this happens, tree efficiency can be seriuos degraded.



class Node
{
	int iData;					//data used as key value
	double fData;				//other data
	node leftChild;				//this node's left child
	node rightChild				//this node's right child

	public void displayNode()
	{

	}
}


class Tree
{
	private Node root;

	public void find(int key)
	{

	}

	public void insert(int id, double dd)
	{

	}

	public void delete(int id)
	{

	}
	//various other methods
}	//end class Tree


class TreeApp
{
	public static void main(String[] args)
	{
		Tree theTree = new Tree;			//make a tree

		theTree.insert(50, 1.5);			//insert 3 nodes
		theTree.insert(25, 1.7);
		theTree.insert(75, 1.9);

		node Found = theTree.find(25);		//find node with key 25
		if(found!=null)
			System.out.println("Found the node with key 25");
		else
			System.out.println("Could not find node with key 25");
	}	//end main()
}	//end class TreeApp



Finding a node:

public Node find(int key)			//find node with given key
{									//assumes non-empty tree
	Node current = root;			//start at root

	while(current.iData!=key)
	{
		if(key<current.iData)
			current = current.leftChild;
		else current = current.rightChild;
		if(current == null)
			return null;
	}
	return current;
}

Tree Efficiency: the time required to find a node depends on how many levels down it is situated. This is O(logN) time.



Inserting a node:

public void insert(int id, double dd)
{
	Node newNode = new Node();				//make new node
	newNode.iData = id;
	newNode.dData = dd;

	if(root == null)
		root = newNode;
	else
	{
		Node current = root;
		Node parent;
		while(true)
		{
			parent = current;
			if(id < current.iData)
			{
				current = current.leftChild;
				if(current == null)
				{
					parent.leftChild = newNode;
					return;
				}
			}	//end if go left
			else
			{
				current = current.rightChild;
				if(current == null)
				{
					parent.rightChild = newNode;
					return;
				}
			}	//end else go right
		}	//end while
	}	//end else not root
}	//end insert()



Traversing the Tree: Traversing a tree means visiting each node in a specified order. There are three simple ways to traverse a tree. They are called preorder, inorder, and postorder. The order most commonly used for binary search trees is inorder.

Inorder Traversal: An inorder traversal of a binary search tree will cause all the nodes to be visited in ascending order, based on their key values. If you want to create a sorted list of the data in a binary tree, this is one way to do it.

The simplest way to carry out a traversal  is the use of recursion. A recursive method to traverse the entire tree is called with a node as an argument. Initially, this node is the root. The method needs to do only three things:

1. Call itself to traverse the node's left subtree.'

2. Visit the node.

3. Call itself to traverse the node's right subtree.'

Traversals work with any binary tree, not just with binary search tree. The traversal mechanism does not pay any attention to the key values of the nodes; it only concerns itself with whether a node has children.

inOrder() method:

private void inOrder(node localRoot)
{
	if(localRoot!=null)
	{													//For each node, the routine traverses the node's left subtree
		inOrder(localRoot.leftChild);					//visit the node, and traverses the right subtree
		System.out.print(localRoot.iData + " ");
		inOrder(localRoot.rightChild);
	}
}

This method is initially called with the root as an argument:
inOrder(root);

After that, it is on its own, calling itself recursively until there are no more nodes to visit.



Preorder and Postorder Traversals

Preorder() method:

1. Visit the node.

2. Call itself to traverse the node's left subtree.'

3. Call itself to traverse the node's right subtree.'

private void preOrder(Node localRoot)
{
	if(localRoot!=null)
	{
		System.out.print(localRoot.iData + " ");
		preOrder(localRoot.leftChild);
		preOrder(localRoot.rightChild);
	}
}



Postorder() method:

1. Call itself to traverse the node's left subtree.'

2. Call itself to traverse the node's right subtree.'

3. Visit the node.



private void postOrder(Node localRoot)
{
	if(localRoot!=null)
	{
		postOrder(localRoot.leftChild);
		postOrder(localRoot.rightChild);
		System.out.print(localRoot.iData + " ");
	}
}



Finding maximum and minimum values: very easy to implement. For the minimum, go to the left child of the root; then go to the left child of that child, and so on, until you come to a node that has no left child.

public Node minimum()
{
	Node current, last;
	current = root;
	while(current!=null)
	{
		last = current;
		current = current.leftChild;
	}
	return last;
}
For the maximum value in the tree, follow the same procedure, but go from right child to right child until you find a node with no right child.




Deleting a node: most complicated common operation required for binary search trees.
There are three cases to consider:

1. The node to be deleted is a leaf (has no children)

2. The node to be deleted has one child.

3. The node to be deleted has two children.


Case 1: The node to be deleted has no children
To delete a leaf node, you simply change the appropriate child field in the node's parent to point to null,' instead of to the node. The node will still exist, but it will no longer be part of the tree.
Because of Java's garbage collection feature,' we do not need to worry about explicitly deleting the node itself. When Java realizes that nothing in the program refers to the free() or delete() to remove the node from memory. (In C and C++ you would need to execute free() or delete() to remove the node from memory.)

public boolean delete(int key)		//delete node with given key
{									//assumes non-empty list
	Node current = root;
	Node parent = root;
	boolean isLeftChild = true;

	while(current.iData!=key)
	{
		parent = current;
		if(key < current.iData)				//go left
		{
			isLeftChild = true;
			current = current.leftChild;
		}
		else								//go right
		{
			isLeftChild = false;
			current = current.rightChild;
		}
		if(current == null)
			return false;
	}	//end while
	//found node to delete
	//continues...
	if(current.leftChild==null&&current.rightChild==null)
	{
		if(current==root)
			root = null;
		else if(isLeftChild)
			parent.leftChild = null;		//disconnect
		else parent.rightChild = null;
	}
}




Case 2: The node to be deleted has one child
The node has only two connections: to its parent and to its only child. You want to "snip" the node out of this sequence by connecting its parent directly ot its child. This process involves changing the appropriate reference in the parent (leftChild or rightChild) to point to the deleted node's child.'
There are four variations: The child of the node to be deleted may be either a left or right child, and for each of these cases the node to be deleted may be either the left or right child of its parent.
There is a specialized situation: the node to be deleted may be the root, in which case it has no parent and is simply replaced by the appropriate subtree. 

//delete() continued...
//if no right child, replace with left subtree
else if(current.rightChild==null)
	if(current==root)
		root = current.leftChild;
	else if(isLeftChild)							//left child of parent
		parent.leftChild = current.leftChild;
	else											//right child of parent
		parent.rightChild = current.leftChild;

//if no left child, replace with right subtree
else if(current.leftChild==null)
	if(current==root)
		root = current.rightChild;
	else if(isLeftChild)
		parent.leftChild = current.rightChild;
	else
		parent.rightChild = current.rightChild;



Case 3: The node to be deleted has two children
If the deleted node has two children, you cannot just replace it with one of these children, at least if the child has its own children. Why not? Examine Figure 8.15, and imagine deleting node 25 and replacing it with its right subtree, whose root is 35. Which left child would 35 have? The deleted node's left child,' 15, or the new node's left child, 30? In either case 30 would be in the wrong place, but we cannot just throw it away.
We need another approach. Remember that in a binary search tree the nodes are arranged in order of ascending keys. For each node, the node with the next-highest key is called its inorder successor, or simply its successor.

Here's the trick: To delete a node with two children, replace the node with its inorder successor.

How to find a successor?
First, the program goes to the original node's right child, which must have a key larger than the node. Then it goes to this right child's left child (if it has one), and to this left child's left child, and so on, following down the path of left children. Then last left child in this path is the successor of the original node.
If the right child of the original node has no left children, this right child is the successor.'

//returns node with next-hiest value after delNode
//goes to right child, then right child's left descendants

private node getSuccessor(node delNode)
{
	Node successorParent = delNode;
	Node successor = delNode;
	Node current = delNode.rightChild;

	while(current!=null)						//until no more left child
	{
		successorParent = successor;
		successor = current;
		current = current.leftChild;
	}

	if(successor!=delNode.rightChild)				//if successor not right child, make connections
	{
		successorParent.leftChild = successor.rightChild;
		successor.rightChild = delNode.rightChild;
	}
	return successor;
}

The getSuccessor() routine carries out two additional operations in addition to finding the successor.
As we've seen,' the successor node can occupy one of two possible positions relative to current, the node to be deleted.
The successor can be current's right child, or it can be one of this right child's left descendants.



1. Successor is Right Child of delNode
	If successor is the right child of current, things are simplified somewhat because we can simply move the subtree of which successor is the root and plug it in where the 
	deleted node was. This operation requires only two steps:
	1. Unplug current from the rightChild field of its parent (or leftChild field if appropriate), and set this field to point to successor

	2. Unplug current's left child from current,' and plug it into the leftChild field of successor.

	Here are the code statements that carry out these steps, excepted from delete():
	1. parent.rightChild = successor;

	2. successor.leftChild = current.leftChild;

	//delete() continued
	else //two children, so replace with inorder successor
		{
			//get successor of node to delete (current)
			Node successor = getSuccessor(current);

			//connect parent of current to successor instead
			if(current == root)
				root = successor;
			else if(isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;
			//connect successor to current's left child
			successor.leftChild = current.leftChild;
		}	//end else two children
	//(successor cannot have a left child)
	return true;
	} //end delete()

	Notice that this is - finally - the end of the delete() routine. let's review the code for these two steps:'
		Step 1: If the node to be deleted, current, is the root, it has no parent so we merely set the root to the successor. Otherwise, the node to be deleted can be either 
		a left or right child, so we set the appropriate field in its parent to point to successor. When delete() returns and current goes out of scope, the node referred to
		by current will have no references to it, so it will be discarded during Java's next garbage collection.'

		Step 2: We set the left child of successor to point to current's left child.'

	What happens if the successor has children of its own? First of all, a successor node is guaranteed not to have a left child. This is true whether the successor is the
	right child of the node to be deleted or one of this right child's left children.'

	On the other hand, the successor may very well have a right child. This is not much of a problem when the successor is the right child of the node to be deleted. When we
	move the successor, its right subtree simply follows along with it. There's no conflict with the right child of the node being deleted because the successor is thi right child.'


2. Successor Is Left Descendant of Right Child of delNode
If successor is a left descendants of the right child of the node to be deleted, four steps are required to perform the deletion:

	1. Plug the right child of successor into the leftChild field of the successor's parent.'

	2. Plug the right child of the node to be deleted into the rightChild field of successor.

	3. Unplug current from the rightChild field of its parent, and set this field to point to successor.

	4. Unplug current's left child from current, and plug it into the leftChild field of successor.'

Steps 1 and 2 are handled in the getSuccessor() routine, while 3 and 4 are carried out in delete(). Figure 8.20 shows the connections affected by these four steps.

Here's the code for these four steps:'

1. successorParent.leftChild = successor.rightChild;

2. successor.rightChild = delNode.rightChild;

3. parent.rightChild = successor;

4. successor.leftChild = current.leftChild;

Steps 1 and 2 are carried out in the if statement that ends the getSuccessor() method shown earlier:

if(successor != delNode.rightChild)						//if successor not right child, make connections
{
	successorParent.leftChild = successor.rightChild;
	successor.rightChild = delNode.rightChild;
}

These steps are more convenient to perform here than in delete(), because in getSuccessor() we can easily figure out where the successor's parent is while we're descending
the tree to find the successor.
Steps 3 and 4 we've seen already; they're the same as steps 1 and 2 in the case where the successor is the right child of the node to be deleted, and the code is in the 
if statement at the end of delete().

Is Deletion Necessary?
If you've come this far, you can see that deletion is fairly involved. In fact, it's so complicated that some programmers try to sidestep it altogether. They add a new boolean
field to the node class, called something like isDeleted. To delete a node, they simply set this field to true. Then other operations, like find(), check this field to be
sure the node is not marked as deleted before working with it. This way, deleting a node does not change the structure of the tree. Of course, it also means that memory
can fill up with "deleted" nodes.
This approach is a bit of a cop-out, but it may be appropriate where there won't be many deletion in a tree. (If ex-emplyees remain in the personnel file forever, for example)


Efficiency
The time needed to carry out the common tree operations is proportional to the base 2 log of N. In Big O notation we say such operations take O(logN) time.

If the tree isn't full, analysis is diffcult. We can say that for a tree with a given number of levels, average search time will be shorter for the non-full tree than the
full tree because fewer searches will proceed to lower levels.

A tree provides high efficiency for all the common data storage operations.

Duplicate Keys
  As in other data structures, the problem of duplicate keys must be addressed. In the code shown for insert(), and in the Workshop applet, a node with a duplicate key will
  be inserted as the right child of its twin.
  The problem is that the find() routine will find only the first of two (or more) duplicate nodes. The find() routine could be modified to check an additional data item,
  to distinguish data items even when the keys were the same, but this would be (at least somewhat) time-consuming.
  One option is to simply forbid duplicate keys. When duplicate keys are excluded by the nature of the data (employee ID numbers), there's no problem.' Otherwise, you need
  to modify the insert() routine to check for equality during the insertion process, and abort the insertion if a duplicate is found.


The complete tree.java program
P405

=======
Binary Tree: Usually it combines the advantages of two other structures: an ordered array and a linked list. You can search a tree quickly as you can an ordered array, and you can also insert and delete items quickly, as you can with a linked list.
Slow insertion in an ordered array
Slow searching in a linked list

Tree terminology
Path

Root: The node at the top of the tree is called the root. There is only one root in a tree. For a collection of nodes and edges to be defined as a tree, there must be one (and only one!) path from the root to any other node.

Parent

Child

Leaf: A node that has no children is called a leaf node or simply a leaf. There can be only one root in a tree, but there can be many leaves.

Subtree

Visiting: A node is visited when program control arrives at the node, usually for the purpose of carrying out some operation on the node, such as checking the value of one of its data fields or displaying it. Merely passing over a node on the path from one node to another is not considered to be visiting the node.

Traversing: To traverse a tree means to visit all the nodes in some specified order. For example, you might visit all the nodes in order of ascending key value. There are other ways to traverse a tree, as we'll see later.'

Levels

Keys

Binary Trees: if every node in a tree can have at most two children, the tree is called a binary tree. In this chapter we'll focus on binary trees because they are the simplest and the most common. A node in a binary tree doesn't necessarily have the maximum of two children; it may have only a left child, or only a right child, or it can have no children at all(in which case it's a leaf). The kind of binary tree we'll be dealing with in this discussion is technically called a binary seach tree.

Binary search tree: A node's left child must have a key less than its parent, and a node's right child must have a key greater than or equal to its parent.

Unbalanced Trees: Some of the trees you generate are unbalanced; that is, they have most of their nodes on one side of the root or the other, as shown in Figure 8.6. Individual subtrees may also be unbalanced. Trees become unbalanced because of the order in which the data item are inserted. If these key values are inserted randomly, the tree will be more or less balanced. However, if an ascending sequence (like 11, 18, 33, 42, 65 and so on) or a descending sequence is generated, all the values will be right children (if ascending) or left children (if descending) and the tree will be unbalanced.
If a tree is created by data items whose key values arrive in random order, the problem of unbalanced trees may not be too much of a problem for larger trees because the chances of a long run of numbers in sequence is small. But key values can arrive in strict sequence; for example, when a data-entry person arranges a stack of personnel files into order of ascending employee number before enteringthe data. When this happens, tree efficiency can be seriuos degraded.



class Node
{
	int iData;					//data used as key value
	double fData;				//other data
	node leftChild;				//this node's left child
	node rightChild				//this node's right child

	public void displayNode()
	{

	}
}


class Tree
{
	private Node root;

	public void find(int key)
	{

	}

	public void insert(int id, double dd)
	{

	}

	public void delete(int id)
	{

	}
	//various other methods
}	//end class Tree


class TreeApp
{
	public static void main(String[] args)
	{
		Tree theTree = new Tree;			//make a tree

		theTree.insert(50, 1.5);			//insert 3 nodes
		theTree.insert(25, 1.7);
		theTree.insert(75, 1.9);

		node Found = theTree.find(25);		//find node with key 25
		if(found!=null)
			System.out.println("Found the node with key 25");
		else
			System.out.println("Could not find node with key 25");
	}	//end main()
}	//end class TreeApp



Finding a node:

public Node find(int key)			//find node with given key
{									//assumes non-empty tree
	Node current = root;			//start at root

	while(current.iData!=key)
	{
		if(key<current.iData)
			current = current.leftChild;
		else current = current.rightChild;
		if(current == null)
			return null;
	}
	return current;
}

Tree Efficiency: the time required to find a node depends on how many levels down it is situated. This is O(logN) time.



Inserting a node:

public void insert(int id, double dd)
{
	Node newNode = new Node();				//make new node
	newNode.iData = id;
	newNode.dData = dd;

	if(root == null)
		root = newNode;
	else
	{
		Node current = root;
		Node parent;
		while(true)
		{
			parent = current;
			if(id < current.iData)
			{
				current = current.leftChild;
				if(current == null)
				{
					parent.leftChild = newNode;
					return;
				}
			}	//end if go left
			else
			{
				current = current.rightChild;
				if(current == null)
				{
					parent.rightChild = newNode;
					return;
				}
			}	//end else go right
		}	//end while
	}	//end else not root
}	//end insert()



Traversing the Tree: Traversing a tree means visiting each node in a specified order. There are three simple ways to traverse a tree. They are called preorder, inorder, and postorder. The order most commonly used for binary search trees is inorder.

Inorder Traversal: An inorder traversal of a binary search tree will cause all the nodes to be visited in ascending order, based on their key values. If you want to create a sorted list of the data in a binary tree, this is one way to do it.

The simplest way to carry out a traversal  is the use of recursion. A recursive method to traverse the entire tree is called with a node as an argument. Initially, this node is the root. The method needs to do only three things:

1. Call itself to traverse the node's left subtree.'

2. Visit the node.

3. Call itself to traverse the node's right subtree.'

Traversals work with any binary tree, not just with binary search tree. The traversal mechanism does not pay any attention to the key values of the nodes; it only concerns itself with whether a node has children.

inOrder() method:

private void inOrder(node localRoot)
{
	if(localRoot!=null)
	{													//For each node, the routine traverses the node's left subtree
		inOrder(localRoot.leftChild);					//visit the node, and traverses the right subtree
		System.out.print(localRoot.iData + " ");
		inOrder(localRoot.rightChild);
	}
}

This method is initially called with the root as an argument:
inOrder(root);

After that, it is on its own, calling itself recursively until there are no more nodes to visit.



Preorder and Postorder Traversals

Preorder() method:

1. Visit the node.

2. Call itself to traverse the node's left subtree.'

3. Call itself to traverse the node's right subtree.'

private void preOrder(Node localRoot)
{
	if(localRoot!=null)
	{
		System.out.print(localRoot.iData + " ");
		preOrder(localRoot.leftChild);
		preOrder(localRoot.rightChild);
	}
}



Postorder() method:

1. Call itself to traverse the node's left subtree.'

2. Call itself to traverse the node's right subtree.'

3. Visit the node.



private void postOrder(Node localRoot)
{
	if(localRoot!=null)
	{
		postOrder(localRoot.leftChild);
		postOrder(localRoot.rightChild);
		System.out.print(localRoot.iData + " ");
	}
}



Finding maximum and minimum values: very easy to implement. For the minimum, go to the left child of the root; then go to the left child of that child, and so on, until you come to a node that has no left child.

public Node minimum()
{
	Node current, last;
	current = root;
	while(current!=null)
	{
		last = current;
		current = current.leftChild;
	}
	return last;
}
For the maximum value in the tree, follow the same procedure, but go from right child to right child until you find a node with no right child.




Deleting a node: most complicated common operation required for binary search trees.
There are three cases to consider:

1. The node to be deleted is a leaf (has no children)

2. The node to be deleted has one child.

3. The node to be deleted has two children.


Case 1: The node to be deleted has no children
To delete a leaf node, you simply change the appropriate child field in the node's parent to point to null,' instead of to the node. The node will still exist, but it will no longer be part of the tree.
Because of Java's garbage collection feature,' we do not need to worry about explicitly deleting the node itself. When Java realizes that nothing in the program refers to the free() or delete() to remove the node from memory. (In C and C++ you would need to execute free() or delete() to remove the node from memory.)

public boolean delete(int key)		//delete node with given key
{									//assumes non-empty list
	Node current = root;
	Node parent = root;
	boolean isLeftChild = true;

	while(current.iData!=key)
	{
		parent = current;
		if(key < current.iData)				//go left
		{
			isLeftChild = true;
			current = current.leftChild;
		}
		else								//go right
		{
			isLeftChild = false;
			current = current.rightChild;
		}
		if(current == null)
			return false;
	}	//end while
	//found node to delete
	//continues...
	if(current.leftChild==null&&current.rightChild==null)
	{
		if(current==root)
			root = null;
		else if(isLeftChild)
			parent.leftChild = null;		//disconnect
		else parent.rightChild = null;
	}
}




Case 2: The node to be deleted has one child
The node has only two connections: to its parent and to its only child. You want to "snip" the node out of this sequence by connecting its parent directly ot its child. This process involves changing the appropriate reference in the parent (leftChild or rightChild) to point to the deleted node's child.'
There are four variations: The child of the node to be deleted may be either a left or right child, and for each of these cases the node to be deleted may be either the left or right child of its parent.
There is a specialized situation: the node to be deleted may be the root, in which case it has no parent and is simply replaced by the appropriate subtree. 

//delete() continued...
//if no right child, replace with left subtree
else if(current.rightChild==null)
	if(current==root)
		root = current.leftChild;
	else if(isLeftChild)							//left child of parent
		parent.leftChild = current.leftChild;
	else											//right child of parent
		parent.rightChild = current.leftChild;

//if no left child, replace with right subtree
else if(current.leftChild==null)
	if(current==root)
		root = current.rightChild;
	else if(isLeftChild)
		parent.leftChild = current.rightChild;
	else
		parent.rightChild = current.rightChild;



Case 3: The node to be deleted has two children
If the deleted node has two children, you cannot just replace it with one of these children, at least if the child has its own children. Why not? Examine Figure 8.15, and imagine deleting node 25 and replacing it with its right subtree, whose root is 35. Which left child would 35 have? The deleted node's left child,' 15, or the new node's left child, 30? In either case 30 would be in the wrong place, but we cannot just throw it away.
We need another approach. Remember that in a binary search tree the nodes are arranged in order of ascending keys. For each node, the node with the next-highest key is called its inorder successor, or simply its successor.

Here's the trick: To delete a node with two children, replace the node with its inorder successor.

How to find a successor?
First, the program goes to the original node's right child, which must have a key larger than the node. Then it goes to this right child's left child (if it has one), and to this left child's left child, and so on, following down the path of left children. Then last left child in this path is the successor of the original node.
If the right child of the original node has no left children, this right child is the successor.'

//returns node with next-hiest value after delNode
//goes to right child, then right child's left descendants

private node getSuccessor(node delNode)
{
	Node successorParent = delNode;
	Node successor = delNode;
	Node current = delNode.rightChild;

	while(current!=null)						//until no more left child
	{
		successorParent = successor;
		successor = current;
		current = current.leftChild;
	}

	if(successor!=delNode.rightChild)				//if successor not right child, make connections
	{
		successorParent.leftChild = successor.rightChild;
		successor.rightChild = delNode.rightChild;
	}
	return successor;
}

The getSuccessor() routine carries out two additional operations in addition to finding the successor.
As we've seen,' the successor node can occupy one of two possible positions relative to current, the node to be deleted.
The successor can be current's right child, or it can be one of this right child's left descendants.



1. Successor is Right Child of delNode
	If successor is the right child of current, things are simplified somewhat because we can simply move the subtree of which successor is the root and plug it in where the 
	deleted node was. This operation requires only two steps:
	1. Unplug current from the rightChild field of its parent (or leftChild field if appropriate), and set this field to point to successor

	2. Unplug current's left child from current,' and plug it into the leftChild field of successor.

	Here are the code statements that carry out these steps, excepted from delete():
	1. parent.rightChild = successor;

	2. successor.leftChild = current.leftChild;

	//delete() continued
	else //two children, so replace with inorder successor
		{
			//get successor of node to delete (current)
			Node successor = getSuccessor(current);

			//connect parent of current to successor instead
			if(current == root)
				root = successor;
			else if(isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;
			//connect successor to current's left child
			successor.leftChild = current.leftChild;
		}	//end else two children
	//(successor cannot have a left child)
	return true;
	} //end delete()

	Notice that this is - finally - the end of the delete() routine. let's review the code for these two steps:'
		Step 1: If the node to be deleted, current, is the root, it has no parent so we merely set the root to the successor. Otherwise, the node to be deleted can be either 
		a left or right child, so we set the appropriate field in its parent to point to successor. When delete() returns and current goes out of scope, the node referred to
		by current will have no references to it, so it will be discarded during Java's next garbage collection.'

		Step 2: We set the left child of successor to point to current's left child.'

	What happens if the successor has children of its own? First of all, a successor node is guaranteed not to have a left child. This is true whether the successor is the
	right child of the node to be deleted or one of this right child's left children.'

	On the other hand, the successor may very well have a right child. This is not much of a problem when the successor is the right child of the node to be deleted. When we
	move the successor, its right subtree simply follows along with it. There's no conflict with the right child of the node being deleted because the successor is thi right child.'


2. Successor Is Left Descendant of Right Child of delNode
If successor is a left descendants of the right child of the node to be deleted, four steps are required to perform the deletion:

	1. Plug the right child of successor into the leftChild field of the successor's parent.'

	2. Plug the right child of the node to be deleted into the rightChild field of successor.

	3. Unplug current from the rightChild field of its parent, and set this field to point to successor.

	4. Unplug current's left child from current, and plug it into the leftChild field of successor.'

Steps 1 and 2 are handled in the getSuccessor() routine, while 3 and 4 are carried out in delete(). Figure 8.20 shows the connections affected by these four steps.

Here's the code for these four steps:'

1. successorParent.leftChild = successor.rightChild;

2. successor.rightChild = delNode.rightChild;

3. parent.rightChild = successor;

4. successor.leftChild = current.leftChild;

Steps 1 and 2 are carried out in the if statement that ends the getSuccessor() method shown earlier:

if(successor != delNode.rightChild)						//if successor not right child, make connections
{
	successorParent.leftChild = successor.rightChild;
	successor.rightChild = delNode.rightChild;
}

These steps are more convenient to perform here than in delete(), because in getSuccessor() we can easily figure out where the successor's parent is while we're descending
the tree to find the successor.
Steps 3 and 4 we've seen already; they're the same as steps 1 and 2 in the case where the successor is the right child of the node to be deleted, and the code is in the 
if statement at the end of delete().

Is Deletion Necessary?
If you've come this far, you can see that deletion is fairly involved. In fact, it's so complicated that some programmers try to sidestep it altogether. They add a new boolean
field to the node class, called something like isDeleted. To delete a node, they simply set this field to true. Then other operations, like find(), check this field to be
sure the node is not marked as deleted before working with it. This way, deleting a node does not change the structure of the tree. Of course, it also means that memory
can fill up with "deleted" nodes.
This approach is a bit of a cop-out, but it may be appropriate where there won't be many deletion in a tree. (If ex-emplyees remain in the personnel file forever, for example)


Efficiency
The time needed to carry out the common tree operations is proportional to the base 2 log of N. In Big O notation we say such operations take O(logN) time.

If the tree isn't full, analysis is diffcult. We can say that for a tree with a given number of levels, average search time will be shorter for the non-full tree than the
full tree because fewer searches will proceed to lower levels.

A tree provides high efficiency for all the common data storage operations.

Duplicate Keys
  As in other data structures, the problem of duplicate keys must be addressed. In the code shown for insert(), and in the Workshop applet, a node with a duplicate key will
  be inserted as the right child of its twin.
  The problem is that the find() routine will find only the first of two (or more) duplicate nodes. The find() routine could be modified to check an additional data item,
  to distinguish data items even when the keys were the same, but this would be (at least somewhat) time-consuming.
  One option is to simply forbid duplicate keys. When duplicate keys are excluded by the nature of the data (employee ID numbers), there's no problem.' Otherwise, you need
  to modify the insert() routine to check for equality during the insertion process, and abort the insertion if a duplicate is found.


The complete tree.java program
P405

>>>>>>> efdafe9e8c74597bcfaaf5f773a006a58700c65b
