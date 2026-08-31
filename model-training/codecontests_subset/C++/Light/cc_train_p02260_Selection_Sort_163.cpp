#include<iostream>
using namespace std;
int main()
{	int A[100],n,i=0,j,key,change=0,change_2;
	cin>>n;
	while(i<n)
		cin>>A[i++];
	for(i=0;i<n;i++)
	{	key=i;
		for(j=i;j<n;j++)
		{	if(A[j]<A[key])
				key=j;
		}
		if(i!=key)
		{	change_2=A[i],A[i]=A[key];
			A[key]=change_2,change++;
		}	
	}
	for(i=0;i<n;i++)
	{	cout<<A[i];	
		if(i!=n-1)
			cout<<" ";
	}
	cout<<endl;
	cout<<change<<endl;
		
}
