package application;


public class NodeGrade {
	double grade;
	NodeGrade left, right;
	int height;
	LinkedList list;

	public NodeGrade(Node node) {
		left = null;
		right = null;
		this.grade = node.std.grade;
		this.list = new LinkedList();
		list.add(node);
		height = 0;
	}
	public NodeGrade() {
	
	}
	@Override
	public String toString() {
		return "students with grade "+ this.grade+"\n"+list.toString();
	}
}
