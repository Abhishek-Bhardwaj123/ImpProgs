import java.util.Scanner;
class Node
{
	int info;
	Node left;
	Node right;
	public Node(int info)
	{
		this.info = info;
	}
}
class Tree
{
	Node root;
	public static Node insert(int info,Node root)
	{
		if(root==null)
		{
			Node n = new Node(info);
			return n;
		}
		else
		{
			if(root.info<info)
			{
				root.right = insert(info,root.right);
			}
			else
			{
				root.left = insert(info,root.left);
			}
			return root;			
		}
	}
	public static void inorder(Node root)
	{
		if(root!=null)
		{
			inorder(root.left);
			System.out.print(root.info+" ");
			inorder(root.right);
		}
	}
	public static int maxDepth(Node root)
	{
		if(root==null)
		{
			return 0;
		}
		else
		{
			int l = maxDepth(root.left)+1;
			int r = maxDepth(root.right)+1;
			if(l>r)
			{
				return l;
			}
			else
			{
				return r;
			}
		}
	}
	public static Node getParent(int info,Node parent,Node child)
	{
		if(child==null)
		{
			return null;
		}
		if(child.info==info)
		{
			return parent;
		}
		else
		{
			if(child.info<info)
			{
				return getParent(info,child,child.right);
			}
			else
			{
				return getParent(info,child,child.left);
			}
		}
	}
	public static Node search(Node root,int info)
	{
		if(root==null)
		{
			return null;
		}
		else if(root.info==info)
		{
			return root;
		}			
		else
		{
			if(root.info<info)
			{
				return search(root.right,info);
			}
			else
			{
				return search(root.left,info);
			}
		}
	}
	public void delete(int info)
	{
		root = deleteHelper(root,info);
	}
	public static Node deleteHelper(Node root,int info)
	{
		if(root==null)
		{
			return null;
		}
		else
		{
			if(root.info<info)
			{
				root.right = deleteHelper(root.right,info);
			}
			else if(root.info>info)
			{
				root.left = deleteHelper(root.left,info);
			}
			else
			{
				if(root.left==null)
				{
					return root.right;
				}
				else if(root.right==null)
				{
					return root.left;	
				}
				else
				{
					root.info = minVal(root.right);
					root.right = deleteHelper(root.right,root.info);
				}
			}
			return root;
		}
	}
	public static int minVal(Node root)
	{
		while(root.left!=null)
		{
			root = root.left;
		}
		return root.info;
	}
	public static int numOfChild(Node n)
	{
		if(n.left==null)
		{
			if(n.right==null)
			{
				return 0;
			}
			else
			{
				return 1;
			}
		}
		else
		{
			if(n.right==null)
			{
				return 1;
			}
			else
			{
				return 2;
			}
		}
	}
}
class BST
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		Tree t = new Tree();
		System.out.println("Enter number of elements : ");
		int size = sc.nextInt();
		System.out.println("Enter "+size+" elements :");
		for(int i=0;i<size;i++)
		{
			int num = sc.nextInt();
			t.root = Tree.insert(num,t.root);
		}
		System.out.println("Items inserted are :");
		Tree.inorder(t.root);
		System.out.println();
		for(int i=0;i<15;i++)
		{
			System.out.println("Enter item u want to delete : ");
			int num = sc.nextInt();
			t.delete(num);
			System.out.println();
			Tree.inorder(t.root);
			System.out.println();
		}
	}
}