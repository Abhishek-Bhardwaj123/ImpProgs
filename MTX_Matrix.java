import java.util.Scanner;
class MTX_Matrix
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int A[][] = new int[size][size];
		int item = 1;
		int i = 0;
		int j = 0;
		if(size==1)
		{
			A[0][0] = 1;
		}
		else
		{
			R(i,j,item,A);
		}
		for(i=0;i<size;i++)
		{
			for(j=0;j<size;j++)
			{
				System.out.printf("%-5s",String.valueOf(A[i][j]));
			}
			System.out.println();
		}		
	}
	public static void R(int i,int j,int item,int A[][])
	{
		while(j<A.length&&A[i][j]==0)
		{
			A[i][j] = item;
			j++;
			item++;
		}
		if(A[++i][--j]==0)
		{
			D(i,j,item,A);	
		}
	}
	public static void D(int i,int j,int item,int A[][])
	{
		while(i<A.length&&A[i][j]==0)
		{
			A[i][j] = item;
			i++;
			item++;
		}
		if(A[--i][--j]==0)
		{
			L(i,j,item,A);	
		}
	}
	public static void L(int i,int j,int item,int A[][])
	{
		while(j>=0&&A[i][j]==0)
		{
			A[i][j] = item;
			j--;
			item++;
		}
		if(A[--i][++j]==0)
		{
			U(i,j,item,A);	
		}
	}
	public static void U(int i,int j,int item,int A[][])
	{
		while(i>=0&&A[i][j]==0)
		{
			A[i][j] = item;
			i--;
			item++;
		}
		if(A[++i][++j]==0)
		{
			R(i,j,item,A);	
		}
	}
}