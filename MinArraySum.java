import java.util.*;


public class MinArraySum {

	public static void main(String args[]) throws Exception {
	    Scanner s = new Scanner(System.in);
	    System.out.println("Enter Input:");
	    Integer size = Integer.parseInt(s.nextLine());
	    setImpl uniqueValues = new setImpl();
	    Integer sum=0;
	    for(int i =0;i<size;i++)
	    {
	    	Integer nextVal = Integer.parseInt(s.nextLine());
	    	nextVal = getProperVal(nextVal, uniqueValues);
	    	uniqueValues.add(nextVal);
	    	sum += nextVal;
	    }
	    System.out.println("Output:");
	    System.out.println(sum);
	}

	private static Integer getProperVal(Integer val, setImpl uniqueValues) {
		if(uniqueValues.contains(val))
		{
			return getProperVal(++val, uniqueValues);
		}
		return val;
	}
}
class setImpl{
	static final int MAX = 1000;
	LinkedListImpl arraySet[] = new LinkedListImpl[MAX];
	
	void add(Integer value)
	{
		int mod = value % MAX;
		if(arraySet[mod]==null)
		{
			arraySet[mod] = new LinkedListImpl();
		}
		NodeImpl temp = arraySet[mod].head;
		while(temp!=null)
		{
			if(temp.data==value)
			{
				return;
			}
		}
		arraySet[mod].push(value);
	}
	boolean contains(int value)
	{
		int mod = value % MAX;
		if(arraySet[mod]!=null)
		{
			NodeImpl temp = arraySet[mod].head;
			while(temp!=null)
			{
				if(temp.data==value)
				{
					return true;
				}
			}
		}
		return false;
	}
	
}
class NodeImpl
{
    int data;
    NodeImpl next;
    NodeImpl(int d)
    { 
    	data = d;
    	next = null; 
    }
}
class LinkedListImpl
{
	NodeImpl head = null;
	 
    public void push(int new_data)
    {
    	NodeImpl new_node = new NodeImpl(new_data);
        new_node.next = head;
        head = new_node;
    }
}
