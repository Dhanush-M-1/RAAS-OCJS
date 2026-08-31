#include<iostream>
int main()
{
	const int MAX=100;
	using namespace std;
	int n,i,j,index,temp,A[MAX],count;
	count=0;
	cin>>n;
	for(i=0;i<n;i++)
		cin>>A[i];
	for(i=0;i<n;i++)
	{
		index=i;
		for(j=i;j<n;j++)
			if(A[j]<A[index])
				index=j;
		temp=A[index];
		A[index]=A[i];
		A[i]=temp;
		if(index!=i)
			count++;
	}
	for(i=0;i<n;i++)
		if(i<n-1)
			cout<<A[i]<<' ';
		else
			cout<<A[i];
	cout<<endl<<count<<endl;
	return 0;
}
