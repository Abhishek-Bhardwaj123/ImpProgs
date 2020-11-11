import java.util.Scanner;
class Sq_Matrix_Diagonals
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		if(size%2==0)
		{
			System.out.println("Even size matrix not possible.");
		}
		else
		{
			int k = size-2;
			for(int i=0;i<size;i++)
			{
				if(i==0||i==(size-1))
				{
					for(int j=0;j<size;j++)
					{
						System.out.print("*");
					}
				}
				else
				{
					for(int j=0;j<size;j++)
					{
						if(j==0||j==(size-1))
						{
							System.out.print("*");
						}
						// This sequence of if ladder is important
						else if(j==k)
						{
							System.out.print("*");
							k--;		
						}
						else if(i==j)
						{
							System.out.print("*");
						}
						else
						{
							System.out.print(" ");
						}
					}
				}
				System.out.println();
			}
		}
	}
}