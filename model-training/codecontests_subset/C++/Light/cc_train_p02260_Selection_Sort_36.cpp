#include<iostream>
using namespace std;
int main()
{
	int i,j,a[200]={0},n,count=0;
	cin>>n;
	for(i=0;i<n;i++) cin>>a[i];
	for(i=0;i<n;i++)
	{
		int min=i;
		for(j=i;j<n;j++)
		{
			if(a[j]<a[min])
			min=j; 
		}
		if(min!=i)
		{
			int p=a[min];
			a[min]=a[i];
			a[i]=p;
			count++;
		}
	}
	for(i=0;i<n-1;i++) cout<<a[i]<<" ";
	cout<<a[n-1]<<endl;
	cout<<count<<endl;
	return 0;
}