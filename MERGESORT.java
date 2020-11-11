import java.util.Scanner;
class MERGESORT
{
	public static void merge(int A[],int l,int m,int h)
	{
		int i = 0;
		int j = 0;
		int k = l;
		int a[] = new int[m-l+1];
		int b[] = new int[h-m];
		System.arraycopy(A,l,a,0,(m-l+1));
		System.arraycopy(A,(m+1),b,0,(h-m));
		while(i<a.length&&j<b.length)
		{
			if(a[i]<b[j])
			{
				A[k] = a[i];
				i++;
			}	
			else
			{
				A[k] = b[j];
				j++;
			}
			k++;
		}
		while(i<a.length)
		{
			A[k] = a[i];
			i++;
			k++;
		}
		while(j<b.length)
		{
			A[k] = b[j];
			j++;
			k++;
		}
	}
	public static void sort(int A[],int l,int h)
	{
		if(l<h)
		{
			sort(A,l,(l+h)/2);
			sort(A,(((l+h)/2)+1),h);
		}
		merge(A,l,(l+h)/2,h);
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array : ");
		int size = sc.nextInt();
		int A[] = new int[size];
		System.out.printf("Enter %d elements\n",size);	
		for(int i=0;i<size;i++)
		{
			A[i] = sc.nextInt();
		}
		sort(A,0,(A.length-1));
		System.out.println("\nAfter MERGESORT : ");
		for(int i : A)
		{
			System.out.printf("%d ",i);
		}		
	}
}