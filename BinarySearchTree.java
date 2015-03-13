package AssignmentNine;

public class BinarySearchTree {
	public BinarySearchTree()
	{
		mRoot = null;
	}
	
	public enum TraversalOrder
	{
		PREORDER,INORDER,POSTORDER
	}
	
	public void insert(String key, String value)
	{
		Node newNode = new Node(key,value);
		if(mRoot == null)
			mRoot = newNode;
		else
			mRoot.addNode(newNode);
	}
	public void traverse(TraversalOrder order)
	{
		if(order == TraversalOrder.INORDER)
		{
			System.out.println("INORDER");
			if(mRoot != null)
				mRoot.printInOrder(mRoot);
		}
		/*
		if(order == TraversalOrder.PREORDER)
		{
			System.out.println("PREORDER");
			if(mRoot != null)
				mRoot.printPreOrder();
		}
		
		if(order == TraversalOrder.POSTORDER)
		{
			System.out.println("POSTORDER");
			if(mRoot != null)
				mRoot.printPostOrder();
		}*/
	}
	private class Node
	{
		public Node(String pKey, String pValue)
		{
			mKey = pKey;
			mValue = pValue;
			mStack = new Stack();
		}
		
		public void addNode(Node pNewNode)
		{
			Node mCurrent = this;
			// Comparing the newly-added Node's key with the root's key
			if(pNewNode.mKey.charAt(0) < mCurrent.mKey.charAt(0))
			{
				// if the left child is null, add the new Node
				if(mCurrent.mLeftChild == null)
				{
					mLeftChild = pNewNode;
				}
				// if not left check if there is still a left child
				else
				{
					while(mCurrent.mLeftChild != null)
					{
						mCurrent = mCurrent.mLeftChild;
						if(pNewNode.mKey.charAt(0) < mCurrent.mKey.charAt(0))
						{
							if(mCurrent.mLeftChild == null)
							{
								mCurrent.mLeftChild = pNewNode;
							}
							mCurrent = mCurrent.mLeftChild;
						}
						else if(pNewNode.mKey.charAt(0) > mCurrent.mKey.charAt(0))
						{
							if(mCurrent.mRightChild == null)
							{
								mCurrent.mRightChild = pNewNode;
							}
							mCurrent = mCurrent.mRightChild;
						}
					}
				}
			}
			else if(pNewNode.mKey.charAt(0) > mCurrent.mKey.charAt(0))
			{
				if(mCurrent.mRightChild == null)
				{
					mRightChild = pNewNode;
				}
				else
				{
					while(mCurrent.mRightChild != null)
					{
						mCurrent = mCurrent.mRightChild;
						if(pNewNode.mKey.charAt(0) > mCurrent.mKey.charAt(0))
						{
							if(mCurrent.mRightChild == null)
							{
								mCurrent.mRightChild = pNewNode;
							}
							mCurrent = mCurrent.mRightChild;
						}
						else 
						{
							if(mCurrent.mLeftChild == null)
							{
								mCurrent.mLeftChild = pNewNode;
							}
							mCurrent = mCurrent.mLeftChild;
						}
					}
				}
			}
		}
		public void printInOrder(Node pNode)
		{
			// push the root on the stack
			Node current = (Node)pNode;
			mStack.push(current);
			while(current != null)
			{
				while(current.mLeftChild != null)
				{
					mStack.push(current.mLeftChild);
					current = current.mLeftChild;
				}
				while(current != this)
				{
					System.out.println(current.returnNode(current));
					mStack.pop();
					if(current.mRightChild != null)
					{
						System.out.println(current.returnNode(current));
						System.out.println(current.returnNode(current.mRightChild));
					}
					mStack.pop();
				}
				current = current.mRightChild;
			}
		}
		public String returnNode(Node pNode)
		{
			return "("+pNode.mKey+", "+pNode.mValue+")";
		}
		private Node mLeftChild;
		private Node mRightChild;
		private String mKey;
		private String mValue;
		private Stack mStack;
	}
	private Node mRoot;
}
