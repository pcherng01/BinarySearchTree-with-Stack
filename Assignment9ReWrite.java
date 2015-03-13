package AssignmentNine;

import AssignmentNine.BinarySearchTree.TraversalOrder;


public class Assignment9ReWrite {
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		String[] keys = { "d", "b", "a", "f", "g", "e", "c" };
		String[] values = { "+", "-", "1", "*", "4", "3", "2" };
		
		BinarySearchTree t = new BinarySearchTree();
		
		for(int ii = 0; ii < keys.length; ++ii)
		{
		   t.insert(keys[ii], values[ii]);
		}
		
		//t.traverse(TraversalOrder.PREORDER);
		t.traverse(TraversalOrder.INORDER);
		//t.traverse(TraversalOrder.POSTORDER);
		
		//System.out.println("Is e present? " + t.isPresent("e"));
		//System.out.println("Is m present? " + t.isPresent("m"));
		
		//System.out.println("The value of the tree is " + t.evaluate());

	}
}
