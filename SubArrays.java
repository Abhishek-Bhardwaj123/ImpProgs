import java.util.Scanner;
class SubArrays
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int A[] = new int[size];
		for(int i=0;i<size;i++)
		{
			A[i] = sc.nextInt();
		}
		for(int i=0;i<size;i++)
		{
			for(int j=i;j<size;j++)
			{
				for(int k=i;k<=j;k++)
				{
					System.out.print(A[k]+" ");
				}
				System.out.println();
			}
		}
	}
}