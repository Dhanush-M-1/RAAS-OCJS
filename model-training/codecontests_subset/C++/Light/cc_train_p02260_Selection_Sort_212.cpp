#include<iostream>
using namespace std;

int a[105];
int selectionSort(int n,int a[])
{
	int i,j,minj,sum=0;
	for(i=0;i<n;i++)
	{
		minj=i;
		for(j=i;j<n;j++)
		{
			if(a[j]<a[minj])
			minj=j;
		}
		if(a[i]>a[minj])
		{
		
		swap(a[i],a[minj]);
		sum++;
	}
	}
	return sum;
}

int main()
{
	int n,i,ans=0;
	cin>>n;
	for(i=0;i<n;i++)
	{
		cin>>a[i];
	}
	ans=selectionSort(n,a);
	for(i=0;i<n;i++)
	{
		if(i!=0)
		cout<<" ";
		cout<<a[i];
	}
	cout<<endl;
	cout<<ans<<endl;
}
