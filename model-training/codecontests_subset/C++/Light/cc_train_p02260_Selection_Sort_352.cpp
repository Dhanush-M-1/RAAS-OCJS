#include<iostream>
using namespace std;

int main()
{
	int n=0;cin>>n;
	int a[100]={0};
	for(int i=0;i<n;i++)
	{
		cin>>a[i];
	}
	
	int cnt=0;
	for(int i=0;i<n;i++)
	{
		int minj=i,f=0;
		for(int j=i;j<n;j++)
		{
			if(a[j]<a[minj])
			{
				minj=j;
				f=1;
			}
		}
		swap(a[i],a[minj]);
		if(f==1)cnt++;
	}
	
	cout<<a[0];
	for(int i=1;i<n;i++)
	{
		cout<<" "<<a[i];
	}
	cout<<endl<<cnt<<endl;
	return 0;
}