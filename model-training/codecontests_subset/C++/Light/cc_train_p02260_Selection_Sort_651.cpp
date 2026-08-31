#include<iostream>
using namespace std;
int main()
{
	int n,A[100],flag = 0;
	cin>>n;
	for(int i=0 ; i<n ; i++)
	{
		cin>>A[i];
	}
	for(int i=0 ; i<n ; i++)
	{
		int minJ = i;
		for(int j=i+1 ; j<n ; j++)
		{
			if(A[j] < A[minJ])
			{
				minJ = j;
			}
		}
		if(minJ != i) flag++;
		int temp = A[i];
		A[i] = A[minJ];
		A[minJ] = temp;
		
	}
	for(int i=0 ; i<n ; i++)
	{
		cout<<A[i];
		if(i != n-1)
		{
			cout<<" ";
		}
	}
	cout<<endl<<flag<<endl;
}

