import java.util.Scanner;

class Node
{
	private int data;
	private Node next;

	public int getData()
	{
		return data;
	}

	public void setData(int item)
	{
		data = item;
	}

	public Node getNext()
	{
		return next;
	}

	public void setNext(Node n)
	{
		next = n;
	}
}

class LinkedList
{
	private Node head;
	private Node ptr;
	public void insert(int item)
	{
		Node n = new Node();
		n.setData(item);
		if(head==null)
		{
			head = n;
		}
		else
		{
			ptr.setNext(n);
		}
		ptr = n;		
	}
	public void display()
	{
		Node temp = head;
		try
		{
			while(temp.getNext()!=null)
			{
				System.out.print(temp.getData()+" ");
				temp = temp.getNext();	
			}
			System.out.println(temp.getData());
		}
		catch(NullPointerException e)
		{
			System.out.println("Empty List");
		} 
	}
	public void delete(int item)
	{
		int check = 0;
		if(head==null)
		{
			System.out.println("Empty List");
		}
		else
		{
			if(head.getData()==item)
			{
				head = head.getNext();
				check = 1;
			}
			else
			{
				Node prev = head;
				Node temp = head.getNext();
				while(temp!=null)
				{
					if(temp.getData()==item)
					{
						prev.setNext(temp.getNext());
						check = 1;
						break;
					}
					prev = temp;
					temp = temp.getNext();
				}
			}
		}
		if(check==1)
		{
			System.out.println("Item is deleted");
		}
		else
		{
			System.out.println("Item not found.");
		}
	}
	public void clear()
	{
		head = null;
	}
	public int size()
	{
		Node temp = head;
		int count = 0;
		if(head==null)
		{
			return count;
		}
		else
		{
			while(temp.getNext()!=null)
			{
				count++;
				temp = temp.getNext();
			}
			return count+1;
		}
	}
	public void insertAt(int item,int loc)
	{
		Node n = new Node();
		n.setData(item);
		if(head==null)
		{
			head = n;
		}
		else if(loc==1)
		{
			n.setNext(head);
			head = n; 
		}
		else if(loc>size())
		{
			Node temp = head;
			while(temp.getNext()!=null)
			{
				temp = temp.getNext();
			}
			temp.setNext(n);
		}
		else
		{
			Node temp = head;
			int count = loc-1;
			while(count>1)
			{
				temp = temp.getNext();
				count--;
			}
			n.setNext(temp.getNext());
			temp.setNext(n);
		}
	}
	public void sort()
	{
		if(head==null)
		{
			// Empty List
		}
		else
		{
			insertAt(-8392,size()+1);
			Node ptr = head;
			while(ptr.getNext()!=null)
			{
				int min = ptr.getData();
				Node temp = ptr.getNext();
				Node store = ptr;
				while(temp.getNext()!=null)
				{
					if(min>temp.getData())
					{
						min = temp.getData();
						store = temp;	
					}
					temp = temp.getNext();	
				}
				store.setData(ptr.getData());
				ptr.setData(min);
				ptr = ptr.getNext();
			}
			delete(-8392);
		}
	}
}
class A
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		LinkedList l = new LinkedList();
		int item = 0;
		System.out.println("Enter i for every insertion.");
		String choice = sc.nextLine();
		while(choice.equals("i"))
		{
			System.out.print("Enter item : ");
			item = sc.nextInt();
			l.insert(item);
			String temp = sc.nextLine();
			choice = sc.nextLine();
		}			
		l.display();
		/*System.out.print("Enter item u want to delete : ");
		item = sc.nextInt();
		l.delete(item);
		l.display();
		System.out.println("Count : "+l.size());
		l.insertAt(4758,1);
		l.display();*/
		l.sort();
		l.display();
	}
}