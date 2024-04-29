package application;

import java.util.ArrayList;

public class DoubleLinkedList {
	Node first;
	AVLTree seatTree = new AVLTree();
	AVLtreeGrade gradeTree = new AVLtreeGrade();

	public DoubleLinkedList() {
		super();
		first = null;
	}

	public Node getFirst() {
		return first;

	}

	public String search3(int id) {
		Node current = first;
		if (first == null) {
			return null;
		} else if (current.std.id == id) {
			return null;
		} else {
			current = current.next;
			while (current != first) {
				if (current.std.id == id) {
					return null;
				}
				current = current.next;

			}
		}
		return "";

	}

	public String gradeCheacker(double grade) {
		if (grade > 100 || grade < 0) {
			return null;

		} return "lllll";

	}

	public void add(Student obj) {

		if (first == null) {
			Node temp = new Node();
			temp.std = obj;
			temp.next = temp.prev = temp;
			first = temp;
			seatTree.insert(first);
			gradeTree.insert(first);
			return;

		} else {
			Node last = first.prev;
			Node temp2 = new Node();
			temp2.std = obj;
			seatTree.insert(temp2);
			gradeTree.insert(temp2);
			temp2.next = first;
			first.prev = temp2;
			temp2.prev = last;
			last.next = temp2;

		}
		return;

	}

	public ArrayList<String> print() {
		Node current = first;
		ArrayList<String> str = new ArrayList<>();
		str.add(current.std.toString() + "\n");
		while (current.next != first) {
			str.add(current.next.std.toString() + "\n");
			current = current.next;
		}
		return str;
	}

	public Node search2(int id) {
		Node current = first;
		if (first == null) {
			return null;
		} else if (current.std.id == id) {
			return current;
		} else {
			current = current.next;
			while (current != first) {
				if (current.std.id == id) {
					return current;
				}
				current = current.next;

			}
		}
		return null;
	}

	public String deleteNode(int id) {
		Node temp2 = search2(id);
		if (temp2 == null) {
			System.out.println("search is wrong");
			return null;

		}

		if (first == null)
			return null;
		Node current = first;
		Node prev = null;
		if (current.std.id == id) {
			Node temp = current.prev;
			first = first.next;
			first.prev = temp;
			temp.next = first;
			gradeTree.deleteNode(id, temp2.std.grade);
			seatTree.deleteNode(id);
			return "deleted";

		}
		while (current.std.id != id) {
			if (current.next == first) {
				System.out.print("the value " + id + " is not found ");
				return null;
			}
			prev = current;
			current = current.next;

		}
		if (current.next == first) {
			prev.next = first;
			(first).prev = prev;
			gradeTree.deleteNode(id, temp2.std.grade);
			seatTree.deleteNode(id);

		} else {

			Node temp = current.next;
			prev.next = temp;
			temp.prev = prev;
			gradeTree.deleteNode(id, temp2.std.grade);
			seatTree.deleteNode(id);
		}
		return "deleted";
	}

	public void print2() {
		Node current = first;
		while (current.next != first) {
			System.out.println("" + current.std.toString());
			current = current.next;
		}
	}

	public void updateNode(int id, String branch, double grade) {
		Node x = search2(id);
		if (x == null) {
			System.out.println("problem in searching");
		}
		gradeTree.update(id, branch, grade, x.std.grade);
		seatTree.update(id, branch, grade);
		Student std = new Student(id, branch, grade);
		Node current = first;
		if (current.std.id == std.id) {
			current.std = std;
		} else {
			current = current.next;
			while (current != first) {
				if (current.std.id == std.id) {
					current.std = std;
					break;
				}
				current = current.next;
			}
		}
	}

	public ArrayList<Student> search(int searchValue) {

		Node temp = first;
		ArrayList<Student> list = new ArrayList<Student>();
		if (temp != null) {
			while (true) {
				if (temp.std.id == searchValue) {
					break;
				}
				temp = temp.next;
				if (temp == first) {
					System.out.println("not exited");
					list.add(null);
					break;
				}
			}
			list.add(temp.std);
			list.add(temp.next.std);
			list.add(temp.prev.std);
			return list;
		} else {
			System.out.println("The list is empty.");
		}
		return list;

	}

}
