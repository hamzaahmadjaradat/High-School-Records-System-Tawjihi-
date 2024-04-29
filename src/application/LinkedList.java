package application;

public class LinkedList {
	private NodeLS first;
	int count = 0;

	public LinkedList() {
	}

	public LinkedList(NodeLS first) {
		super();
		this.first = first;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public NodeLS getFirst() {
		return first;
	}

	public void setFirst(NodeLS first) {
		this.first = first;
	}

	public void add(Node node) {
		NodeLS current = first;
		if (count == 0) {
			NodeLS temp1 = new NodeLS(node);
			first = temp1;
			count++;
		} else if (count == 1) {
			NodeLS temp2 = new NodeLS(node);
			current.next = temp2;
			count++;
		} else {
			while (current.next != null) {
				current = current.next;
			}
			current.next = new NodeLS(node);
			count++;

		}

	}

	public void update(int key, double grade, String branch) {
		Student std = new Student(key, branch, grade);
		Node node = new Node(std);
		delete(key);
		add(node);
	}

	public String print() {
		NodeLS current = first;
		String str = "";
		while (current != null) {
			str += "\t" + current.node.std.toString() + "\n";
			current = current.next;
		}
		return str;

	}

	public void delete(double key) {
		count--;
		NodeLS current = first;
		while (current.next != null) {
			if (current.node.std.id == key) {
				first = first.next;
				break;
			} else if (current.next.node.std.getId() == key) {
				current.next = current.next.next;
				break;
			}
			current = current.next;
		}
	}
}
