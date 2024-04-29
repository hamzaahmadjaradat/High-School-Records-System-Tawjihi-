package application;

import java.util.ArrayList;

public class TawjihiDS {

	DoubleLinkedList list = new DoubleLinkedList();

	public TawjihiDS() {
	}
	public String getBranch() {
		return list.first.std.branch.trim();
		
	}

	public void insert(Student std) {
		 list.add(std);
	}

	public String delete(int id) {
		return list.deleteNode(id);

	}

	public void update(Student std) {
		list.updateNode(std.id, std.branch, std.grade);

	}

	public ArrayList<Student> find(int id) {
		return list.search(id);
	}

	public String getAll(double grade) {
		return list.gradeTree.printGrade(grade);
	}

	public ArrayList<String> printDoubly() {
		return list.print();
	}
	public ArrayList<String> printTree1() {
		return list.seatTree.LevelTraversal();
	}
	public ArrayList<String> printTree2() {
		return list.gradeTree.LevelTraversal();
	}

}
