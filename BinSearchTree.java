/*
 * Binary Tree Interface in Bridges API Project 
 * Gurumanpreet Singh
 * Project #5
 * CMSC 256-901 Spring 2020
 * This program uses the Bridges API to visualize a Binary Tree 
 */
package cmsc256;

import bridges.base.BinTreeElement;
import bridges.connect.Bridges;

public class BinSearchTree<E> implements BinTreeInterface<E>{

	private int size = 0;
	private BinTreeElement<E> root;
	
	public BinSearchTree() {
		this.root = null;
	}
	
	public static void main (String[] args) {
		//connecting to the Bridges API
		Bridges bridges = new Bridges(0, "singhg24", "816756910631");
		//setting the title that will appear online in Bridges
		bridges.setTitle("Project 5 Gurumanpreet Singh");
		//setting the project description that will appear online in Bridges
		bridges.setDescription("Project 5 for CMSC 256 Spring 2020 by Gurumanpreet Singh");
		//creating instance of BinSearchTree that will have names added to it
		BinSearchTree <String> names = new BinSearchTree<>();
		//adding all the names of the nodes
		names.add("Frodo");
		names.add("Dori");
		names.add("Bilbo");
		names.add("Kili");
		names.add("Gandalf");
		names.add("Fili");
		names.add("Thorin");
		names.add("Nori ");		
		
		try {
			bridges.setDataStructure(names.getRoot());
			bridges.visualize();
		}catch(Exception e) {
			System.out.println("Unable to connect to Bridges.");    //if the connection to bridges cannot be made
		}
	}

	/** Returns the height of this binary tree */
	public int height() {
		return height(root);
	}
	public int height(BinTreeElement<E> root) {
		if (root == null) {
			return -1;
		}
		else {
			int leftHeight = height(root.getLeft());
			int rightHeight = height(root.getRight());
			if(leftHeight > rightHeight) {
				return (leftHeight + 1);
			}else {
				return (rightHeight + 1);
			}
		}
	}
	

	/** Returns true if the tree is a full binary tree */
	public boolean isFullBST() {
		return isFullBST(root);
	}
	public boolean isFullBST(BinTreeElement<E> root) {
		if(root != null) {
			if(root.getRight() == null && root.getLeft() == null) {
				return true;
			}else if (root.getRight() != null && root.getLeft() != null) {
				return isFullBST(root.getLeft()) && isFullBST(root.getLeft());
			}
		}
		//return size == Math.pow(2, height()) ? true : false;
		return false;
	}
	
	/** Returns the number of leaf nodes */
	public int getNumberOfLeaves() {
		return getNumberOfLeaves(root);
	}
	public int getNumberOfLeaves(BinTreeElement<E> root) {
		if (root == null) {
			return 0;
		}
		if(root.getLeft() == null && root.getRight() == null) {
			return 1;
		}else {
			return getNumberOfLeaves(root.getLeft()) + getNumberOfLeaves(root.getRight());
		}
	}
	
	/** Returns the number of non-leaf nodes */
	public int getNumberOfNonLeaves() {
		return getNumberOfNonLeaves(root);
	}
	public int getNumberOfNonLeaves(BinTreeElement<E> root) {
		if (root == null) {
			return 0;
		}
		if(root.getLeft() == null && root.getRight() == null) {
			return 0;
		}else {
			return 1 + getNumberOfNonLeaves(root.getLeft()) + getNumberOfNonLeaves(root.getRight());
		}
	}

	
	 /** Returns the root of this tree
     */
	@Override
	public BinTreeElement<E> getRoot() {
		return root;
	}

	/** Insert element into the binary tree
     * Return true if the element is inserted successfully
     */
	@Override
	public boolean add(E element) {
		boolean wasAdded = false;
		BinTreeElement<E> node = new BinTreeElement<>(element);
		node.setLabel(element.toString());
		if (root == null) {
			root = node;
			wasAdded = true;
		}else {
			wasAdded = addToParent(root, node);
		}
		if(wasAdded = true) {
			size++;
		}
		return wasAdded;
	}

	/**Returns true if the node is added to the parent successfully*/
	private boolean addToParent(BinTreeElement<E> parentNode, BinTreeElement<E> addNode) {
		int compare = parentNode.getValue().toString().compareTo(addNode.getValue().toString());
		boolean wasAdded = false;
		
		if (compare > 0) {
			// if parent has no left node, add new node as left
			if (parentNode.getLeft() == null) {
				parentNode.setLeft(addNode);
				wasAdded = true;
			}else{
				// otherwise, add to parentNode's left (recursive)
				wasAdded = addToParent(parentNode.getLeft(), addNode);
			}
		}else if (compare < 0) {
			// if parent has no right node, add new node as right
			if (parentNode.getRight() == null) {
				parentNode.setRight(addNode);
				wasAdded = true;
			}else{
				// otherwise, add to parentNode's right (recursive)
				wasAdded = addToParent(parentNode.getRight(), addNode);
			}
		}
		return wasAdded;		
	}
	
	/** Delete the specified element from the tree
    * Return true if the element is deleted successfully
    */
    @Override
	public boolean remove(E element) {
		boolean successfulRemoval = false;
		if (root == null) {
			return successfulRemoval;
		}
		if(root.getValue().toString().compareTo(element.toString()) == 0) {
			if(root.getLeft() == null) {
				root = root.getRight();
			}else if (root.getRight() == null) {
				root = root.getLeft();
			}else {
				BinTreeElement<E> ogRight = root.getRight();
				root = root.getLeft();
				addToParent(root, ogRight);
			}
			size--;
			successfulRemoval = true;
		}
		return successfulRemoval;
	}

	/** Returns the number of nodes in the tree*/
	@Override
	public int size() {
		return size;
	}

	/** Return true if the tree is empty
     */
	@Override
	public boolean isEmpty() {
		boolean isEmpty = false;
		if (root == null) {
			isEmpty = true;
		}
		return isEmpty;
	}

	/** Removes all nodes from the tree
     */
	@Override
	public void clear() {
		root = null;
		size = 0;
	}

	
	 /** Return true if the element is in the tree
     */
	@Override
	public boolean search(E e) {
		BinTreeElement<E> search = root;
		boolean contains = false;
		for(int i = 0; i < size; i++) {
			if(e.toString().compareTo(search.getValue().toString()) < 0) {
				search = search.getLeft();
			}else if (e.toString().compareTo(search.getValue().toString()) > 0) {
				search = search.getRight();
			}else {
				contains = true;
			}
		}
		return contains;
	}
	
	
	/** Inorder traversal from the root
     *  @returns a String representation of the traversal
     *           with two spaces between the String representation
     *           of each element
     */
	public String inorder() {
		return inorder(root);
	}

	public String inorder(BinTreeElement<E> element) {
		if (element != null) {
			return inorder(element.getLeft()) + element.getValue().toString() + "  " + inorder(element.getRight());
		}else {
			return "";
		}
	}

	/** Postorder traversal from the root
     *  @returns a String representation of the traversal
     *           with two spaces between the String representation
     *           of each element
     */
	public String postorder(BinTreeElement<E> element) {
		if (element != null) {
			return postorder(element.getLeft()) + postorder(element.getRight()) + element.getValue().toString() + "  ";
		}else {
			return "";
		}
	}
	@Override
	public String postorder() {
		return postorder(root);
	}

	/** Preorder traversal from the root
     *  @returns a String representation of the traversal
     *           with two spaces between the String representation
     *           of each element
     */
	@Override
	public String preorder() {
		return preorder(getRoot());
	}
	
	private String preorder(BinTreeElement<E> element) {
		if (element != null) {
			return element.getValue().toString() + "  " + preorder(element.getLeft()) + preorder(element.getRight());
		}else {
			return "";
		}
	}
}