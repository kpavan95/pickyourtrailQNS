import java.util.Scanner;

public class SuperStack {
	public static void main(String args[]) throws Exception {
	    Scanner s = new Scanner(System.in);
	    System.out.println("Enter Input:");
	    Integer size = Integer.parseInt(s.nextLine());
	    StackImpl stack = new StackImpl();
	    for(int i =0;i<size;i++)
	    {
	    	String nextVal = s.nextLine();
	    	String input[] = nextVal.split(" ");
	    	switch (input[0]) 
            {
            case "push" :
            	stack.push(Integer.parseInt(input[1]));
                break;                         
            case "pop" :
            	stack.pop();
            	break;
            case "inc" :
            	stack.inc(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                break;                       
            default : 
                System.out.println("Wrong Value Entered");
                break;
            }
	    	System.out.println(stack.peek());
	    }
	}
}
class StackNode
{
    int data;
    StackNode next;
    StackNode(int d)
    { 
    	data = d;
    	next = null; 
    }
}
class StackImpl
{
	StackNode head = null;
	 
    public void push(int new_data)
    {
    	StackNode new_node = new StackNode(new_data);
        new_node.next = head;
        head = new_node;
    }
 
    public void pop()
    {
    	head = head.next;
    }
    
    public void inc(Integer count, Integer add)
    {
    	StackNode first = head;
    	StackNode second = head;
    	int i = 0;
    	while(i<count && first!=null)
    	{
    		i++;
    		first = first.next;
    	}
    	while (first != null)
        {
        	first = first.next;
            second = second.next;
        }
        while (second != null)
        {
        	second.data +=add;
        	second = second.next;
        }
    }
    
    public String peek()
    {
    	return head==null?"EMPTY":head.data+"";
    }
}