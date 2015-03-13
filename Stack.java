package AssignmentNine;

public class Stack
{
	public Stack()
	{
		mHelperSLL = new SinglyLinkedList();
	}
	
	public void push(String pKey, String pValue)
	{
		mHelperSLL.appendRear(pKey,pValue);
		mLastNodesKey = pKey;
		mLastNodesValue = pValue;
		mCount++;
	}
	
	public String pop()
	{
		mLastNodesKey = mHelperSLL.getLastNodesKey();
		mLastNodesValue = mHelperSLL.getLastNodesValue();
		mHelperSLL.remove(mLastNodesKey);
		mCount--;
		return mLastNodesKey;
	}
	
	public Object peek()
	{
		return (Node)mHelperSLL.getLastNode();
	}
	
	public boolean isEmpty()
	{
		return (mCount==0)?true:false;
	}
	private class SinglyLinkedList
	{
		public SinglyLinkedList()
		{
			mFront = null;
		}
		public Node appendRear(String pWord, String pValue)
		{
			Node newNode = new Node(pWord,pValue);
			mLast = newNode;
			
			if(mFront == null)
			{
				mFront = newNode;
				return mLast;
			}
			else
			{
				Node current = mFront;
				while(current.mNext != null)
				{
					current = current.mNext;
				}
				current.mNext = newNode;
				return mLast;
			}
		}
		public void remove(String pKey)
		{
			Node previous = null, current = mFront;
			
			while(current != null)
			{
				if(current.mKey.equals(pKey))
				{
					if(current == mFront)
					{
						mFront = mFront.mNext;
					}
					else
					{
						if(mLast.mKey.equals(pKey))
						{
							mLast = previous;
						}
						previous.mNext = current.mNext;
					}
					break;
				}
				else
				{
					previous = current;
					current = current.mNext;
				}
			}
		}
		public String getLastNodesKey()
		{
			return mLast.mKey;
		}
		public String getLastNodesValue()
		{
			return mLast.mValue;
		}
		private class Node
		{
			public Node(String pKey, String pValue)
			{
				mNext = null;
				mKey = pKey;
				mValue = pValue;
			}
			private Node mNext;
			private String mKey;
			private String mValue;
		}
		
		private Node mFront;
		private Node mLast;
	}
	private SinglyLinkedList mHelperSLL;
	private String mLastNodesKey;
	private String mLastNodesValue;
	private int mCount;
}
