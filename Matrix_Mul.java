import java.util.Scanner;
class Matrix_Mul
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int m1 = 0;
		int n1 = 0;
		int m2 = 0;
		int n2 = 0;
		int common = 0;
		System.out.println("1st Matrix :");
		System.out.print("Enter number of Rows : ");
		m1 = sc.nextInt();
		System.out.print("Enter number of Coloumns : ");
		n1 = sc.nextInt();
		System.out.println("Enter Matrix elements :");
		int A[][] = new int[m1][n1];
		for(int i=0;i<A.length;i++)
		{
			for(int j=0;j<A[i].length;j++)
			{
				A[i][j] = sc.nextInt();
			}
		}
		System.out.println("\n2nd Matrix :");
		System.out.print("Enter number of Rows : ");
		m2 = sc.nextInt();
		System.out.print("Enter number of Coloumns : ");
		n2 = sc.nextInt();
		System.out.println("Enter Matrix elements :");
		int B[][] = new int[m2][n2];
		for(int i=0;i<B.length;i++)
		{
			for(int j=0;j<B[i].length;j++)
			{
				B[i][j] = sc.nextInt();
			}
		}	
		if(n1==m2)
		{
			common = n1;
			int C[][] = new int[m1][n2];
			for(int i=0;i<C.length;i++)
			{
				for(int j=0;j<C[i].length;j++)
				{
					for(int k=0;k<common;k++)
					{
						C[i][j]+=(A[i][k]*B[k][j]);
					}					
				}
			}
			System.out.println("\nMatrix Multiplication :");
			for(int i=0;i<C.length;i++)
			{
				for(int j=0;j<C[i].length;j++)
				{
					System.out.print(C[i][j]+" ");
				}
				System.out.println();
			}
		}	
		else
		{
			System.out.print("\nMatrix Multiplication is not possible");
		}	
	}
}