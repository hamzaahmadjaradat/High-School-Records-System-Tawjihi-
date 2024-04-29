package application;

import java.util.ArrayList;
import java.util.Queue;

public class AVLTree {
	NodeID root;
	int count = 0;

	public AVLTree() {
		super();
	}

	public int height(NodeID N) {
		if (N == null)
			return 0;
		return N.height;
	}

	public int heightRoot() {
		if (root == null)
			return 0;
		return root.height;
	}

	public int max(int a, int b) {
		if (a > b)
			return a;
		else
			return b;
	}

	public Student max(Student a, Student b) {
		if (a.id > b.id)
			return a;
		else
			return b;
	}

	public NodeID rightRotate(NodeID root) {
		NodeID x = root.left;
		NodeID T2 = x.right;

		x.right = root;
		root.left = T2;

		root.height = max(height(root.left), height(root.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;

		return x;
	}

	public NodeID leftRotate(NodeID x) {
		NodeID y = x.right;
		NodeID T2 = y.left;

		y.left = x;
		x.right = T2;

		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;

		return y;
	}

	public int getBalance(NodeID N) {
		if (N == null)
			return 0;
		return height(N.left) - height(N.right);
	}

	public AVLTree(NodeID root) {
		super();
		this.root = root;
	}

	public NodeID search(double s) {
		NodeID n = findNode(s, this.root);
		if (n != null) {
			System.out.println("The student " + s + " is existing \n");
			return n;
		} else {
			System.out.println("The student " + s + " Not Found \n");
			return n;
		}

	}

	public AVLTree insert(Node key) {
		root = insert(root, key);
		return this;

	}

	private NodeID insert(NodeID node, Node key) {
		if (node == null) {
			return (new NodeID(key));
		}
		count++;
		if (key.std.id < node.data.std.id) {
			node.left = insert(node.left, key);
		} else if (key.std.id > node.data.std.id) {
			node.right = insert(node.right, key);
		} else
			return node;

		node.height = 1 + max(height(node.left), height(node.right));

		int balance = getBalance(node);

		if (balance > 1 && key.std.id < node.left.data.std.id) {
			return rightRotate(node);
		}

		if (balance < -1 && key.std.id > node.right.data.std.id) {
			return leftRotate(node);
		}

		if (balance > 1 && key.std.id > node.left.data.std.id) {

			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		if (balance < -1 && key.std.id < node.right.data.std.id) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;
	}
	public NodeID minValueNode(NodeID node) {
		NodeID current = node;
		while (current.left != null)
			current = current.left;

		return current;
	}

	public NodeID deleteNode(int key) {

		return deleteNode(root, key);

	}

	private NodeID deleteNode(NodeID root, double key) {
		if (root == null)
			return root;
		if (key < root.data.std.id)
			root.left = deleteNode(root.left, key);
		else if (key > root.data.std.id)
			root.right = deleteNode(root.right, key);
		else {

			if ((root.left == null) || (root.right == null)) {
				NodeID temp = null;
				if (temp == root.left)
					temp = root.right;
				else
					temp = root.left;

				if (temp == null) {
					temp = root;
					root = null;
				} else
					root = temp;
			} else {
				NodeID temp = minValueNode(root.right);
				root.data.std.id = temp.data.std.id;
				root.right = deleteNode(root.right, temp.data.std.id);
			}
		}

		if (root == null)
			return root;

		root.height = max(height(root.left), height(root.right)) + 1;

		int balance = getBalance(root);

		if (balance > 1 && getBalance(root.left) >= 0)
			return rightRotate(root);

		if (balance > 1 && getBalance(root.left) < 0) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}

		if (balance < -1 && getBalance(root.right) <= 0)
			return leftRotate(root);

		if (balance < -1 && getBalance(root.right) > 0) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}

		return root;
	}

	public NodeID findNode(double x, NodeID T) {
		if (T == null)
			return null;

		if (x < T.data.std.id)
			return (findNode(x, T.left));
		else if (x > T.data.std.id)
			return (findNode(x, T.right));
		else

			return T;
	}

	public void update(int oldID, String branch, double grade) {
		NodeID x = search(oldID);
		Student std = new Student(oldID, branch, grade);
		x.data.std = std;

	}

	public ArrayList<String> LevelTraversal() {
		Queue<NodeID> queue = new java.util.LinkedList<NodeID>();
		queue.add(root);
		ArrayList<String> list = new ArrayList<String>();
		while (!queue.isEmpty()) {
			NodeID tempNode = queue.poll();
			list.add(tempNode.data.std.toString());
			if (tempNode.left != null)
				queue.add(tempNode.left);
			if (tempNode.right != null)
				queue.add(tempNode.right);
		}
		return list;
	}

}