Degenerates to O(n)
When there are no branches, the tree becomes, in effect, a linked list.



Red-Black Rules
1 Every nodes is either red or black.

2 The root is always black.

3 If a node is red, its children must be black (although the converse is not necessarily true)

4 Every path from the root to a leaf, or to a null child, must contain the same number of black nodes (same black height)



Fixing Rule Violations

1 Change the colors of nodes

2 Perform rotations



It is impossible to create a tree that is unbalanced by two or more levels but is red-black correct. If one path is more than one node longer

than another, it must either have more black nodes, violating Rule 4, or it must have adjacent red nodes, violating Rule 3.


Color Flip

Rotations

If all the nodes are on the left of the root, you need to move some of them over to the right side.

1 Raise some nodes and lower others to help balance the tree.

2 Ensure that the characteristics of a binary search tree are not violated.


The Weird Crossover Node

Subtrees on the Move



Inserting a New Node

1 Color Flips on the Way Down
Every time the insertion routine encounters a black node that has two red children, it must change the children to black and the parent to red
(unless the parent is the root, which always remains black)

Color flip remains black heights unchanged.

Color flip are helpful because they make red leaf nodes into black leaf nodes. This makes it easier to attach new red nodes without violating
Rule 3

Although Rule 4 is not violated by a color flip, Rule 3 may be. The problem needs to be fixed before we continue down the path to insert the
new node. We can correct the situation with a rotation.

The root situation

Finally, just insert it.



Rotations After the Node is inserted

The insertion of the new node may cause the red-black rules to be violated. Therefore, following the insertion, we must check for rule

violations and take appropriate steps. P449
































