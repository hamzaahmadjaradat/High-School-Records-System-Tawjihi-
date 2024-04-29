package application;

public class NodeID {
	Node data;
	NodeID left, right;
	int height;
	public NodeID(Node data) {
		left = null;
		right = null;
		this.data = data;
		height = 1;
	}

}
