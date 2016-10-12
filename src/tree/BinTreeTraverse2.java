package tree;

import java.util.LinkedList;
import java.util.List;

public class BinTreeTraverse2 {

	private int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	public static List<Node> nodeList = null;

	public void createBinTree() {
		nodeList = new LinkedList<>();
		// 将一个数组的值依次转换为Node节点
		for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
			nodeList.add(new Node(array[nodeIndex]));
		}
		// 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
		for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
			// 左孩子
			nodeList.get(parentIndex).setLeftChild(
					nodeList.get(parentIndex * 2 + 1));
			// 右孩子
			nodeList.get(parentIndex).setRightChild(
					nodeList.get(parentIndex * 2 + 2));

		}
		// 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
		int lastParentIndex = array.length / 2 - 1;
		nodeList.get(lastParentIndex).setLeftChild(
				nodeList.get(lastParentIndex * 2 + 1));
		// 右孩子,如果数组的长度为奇数才建立右孩子
		if (array.length % 2 == 0) {
			nodeList.get(lastParentIndex).setRightChild(
					nodeList.get(lastParentIndex * 2 + 2));
		}
	}

	/**
	 * 前序遍历
	 * 
	 * @param node
	 */
	public static void preOrderTraverse(Node node) {

		if (node == null) {
			return;
		}
		System.out.print(node.getData() + "-");
		preOrderTraverse(node.getLeftChild());
		preOrderTraverse(node.getRightChild());

	}

	/**
	 * 中序遍历
	 * 
	 * @param node
	 */
	public static void inOrderTraverse(Node node) {
		if (node == null) {
			return;
		}
		preOrderTraverse(node.getLeftChild());
		System.out.print(node.getData() + "-");
		preOrderTraverse(node.getRightChild());
	}

	/**
	 * 后序遍历
	 * 
	 * @param node
	 */
	public static void postOrderTraverse(Node node) {
		if (node == null) {
			return;
		}
		preOrderTraverse(node.getLeftChild());
		preOrderTraverse(node.getRightChild());
		System.out.print(node.getData() + "-");
	}

	
	public static void main(String[] args) {
		BinTreeTraverse2 binTreeTraverse2 = new BinTreeTraverse2();
		binTreeTraverse2.createBinTree();
		Node root = nodeList.get(0);
		System.out.println("先序遍历：");
		preOrderTraverse(root);
		System.out.println();

		System.out.println("中序遍历：");
		inOrderTraverse(root);
		System.out.println();

		System.out.println("后序遍历：");
		postOrderTraverse(root);
	}
}
