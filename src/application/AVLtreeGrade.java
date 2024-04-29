package application;

import java.util.ArrayList;
import java.util.Queue;

public class AVLtreeGrade {
	NodeGrade root;
	int count = 0;

	public AVLtreeGrade() {
		super();
	}

	public int height(NodeGrade N) {
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

	public void update(int oldID, String branch, double grade, double oldGrade) {
		deleteNode(oldID, oldGrade);
		Student std = new Student(oldID, branch, grade);
		Node temp = new Node(std);
		insert(temp);
	}

	public NodeGrade rightRotate(NodeGrade root) {
		NodeGrade x = root.left;
		NodeGrade T2 = x.right;

		x.right = root;
		root.left = T2;

		root.height = max(height(root.left), height(root.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;

		return x;
	}

	public NodeGrade leftRotate(NodeGrade x) {
		NodeGrade y = x.right;
		NodeGrade T2 = y.left;

		y.left = x;
		x.right = T2;

		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;

		return y;
	}

	public int getBalance(NodeGrade N) {
		if (N == null)
			return 0;
		return height(N.left) - height(N.right);
	}

	public AVLtreeGrade(NodeGrade root) {
		super();
		this.root = root;
	}

	public NodeGrade search(double s) {
		NodeGrade n = findNode(s, this.root);
		if (n != null) {
			return n;
		} else {
			return n;
		}

	}

	public AVLtreeGrade insert(Node key) {
		NodeGrade node = search(key.std.grade);
		if (node == null) {
			root = insert(root, key);
		} else {
			node.list.add(key);
		}
		return this;
	}

	private NodeGrade insert(NodeGrade node, Node key) {
		if (node == null)
			return new NodeGrade(key);
		if (key.std.grade < node.grade)
			node.left = insert(node.left, key);
		else if (key.std.grade > node.grade)
			node.right = insert(node.right, key);
		else
			return node;

		node.height = 1 + max(height(node.left), height(node.right));

		int balance = getBalance(node);

		if (balance > 1 && key.std.grade < node.left.grade)
			return rightRotate(node);

		if (balance < -1 && key.std.grade > node.right.grade)
			return leftRotate(node);

		if (balance > 1 && key.std.grade > node.left.grade) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		if (balance < -1 && key.std.grade < node.right.grade) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;
	}

	public NodeGrade minValueNode(NodeGrade node) {
		NodeGrade current = node;
		while (current.left != null)
			current = current.left;

		return current;
	}

	public NodeGrade deleteNode(int studentId, double grade) {
		return deleteNode(root, grade, studentId);
	}

	private NodeGrade deleteNode(NodeGrade root, double studentGrade, double studentId) {
		if (root == null)
			return root;
		if (studentGrade < root.grade)
			root.left = deleteNode(root.left, studentGrade, studentId);
		else if (studentGrade > root.grade)
			root.right = deleteNode(root.right, studentGrade, studentId);
		else {
			if (root.list.count == 1) {
				if ((root.left == null) || (root.right == null)) {
					NodeGrade temp = null;
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
					NodeGrade temp = minValueNode(root.right);

					root.grade = temp.grade;
					root.right = deleteNode(root.right, temp.grade, studentId);
				}
			} else {
				root.list.delete(studentId);
				return root;
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

	NodeGrade findNode(double x, NodeGrade T) {
		if (T == null)
			return null;
		if (x < T.grade)
			return (findNode(x, T.left));
		else if (x > T.grade)
			return (findNode(x, T.right));
		else
			return T;
	}

	public String printGrade(double grade) {
		NodeGrade node = search(grade);
		if (node == null) {
			return "";
		}
		return node.list.print();

	}

	public ArrayList<String> LevelTraversal() {
		Queue<NodeGrade> queue = new java.util.LinkedList<NodeGrade>();
		queue.add(root);
		ArrayList<String> list = new ArrayList<String>();
		while (!queue.isEmpty()) {
			NodeGrade tempNode = queue.poll();
			list.add("Students with the grade " + "" + tempNode.grade + "\n" + tempNode.list.print());
			if (tempNode.left != null)
				queue.add(tempNode.left);
			if (tempNode.right != null)
				queue.add(tempNode.right);
		}
		return list;
	}

}
