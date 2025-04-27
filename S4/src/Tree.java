import java.util.Arrays;
import java.util.Iterator;

public class Tree implements Iterable<Tree> {

	private int value;

	private Tree parent;

	private Tree[] children;

	// *******************************************************
	// CONSTRUCTEURS
	// *******************************************************
	public Tree(int v, Tree[] chd) {
		value = v;
		children = chd;

		for (Tree child : chd) {
			child.parent = this;
		}
	}

	public Tree(int v) {
		this(v, new Tree[0]);
	}

	// *******************************************************
	// GETTERS
	// *******************************************************
	public int getValue() {
		return value;
	}

	public Tree getParent() {
		return parent;
	}

	public Tree[] getChildren() {
		return children;
	}

	// *******************************************************
	// ITERATEUR
	// *******************************************************
	public Iterator<Tree> iterator() {
		return Arrays.asList(children).iterator();
	}

	public int nbrChildren() {
		return children.length;
	}

	public boolean isLeaf() {
		return children.length == 0;
	}

	@Override
	public String toString() {
		return toString("", true);
	}

	private String toString(String prefix, boolean isRoot) {

		StringBuilder builder = new StringBuilder();
		builder.append(prefix);
		if (isRoot) {
			builder.append("Root: ");
		} else {
			builder.append("Node: ");
		}
		builder.append(value).append("\n");

		if (children != null && children.length > 0) {
			for (Tree child : children) {
				builder.append(child.toString(prefix + "  ", false));
			}
		} else {
			builder.append(prefix).append("  No children\n");
		}

		return builder.toString();
	}
}
