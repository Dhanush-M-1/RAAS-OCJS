#include<bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	int a[100];
	cin>>n;
	int t,ans=0;
	int min=10000000;
	for(int i=0;i<n;i++)
		cin>>a[i];
	for(int i=0;i<n;i++)
	{
		min=i;
		for(int j=i;j<n;j++)
			if(a[j]<a[min])
				min=j;
		t=a[i];
		a[i]=a[min];
		a[min]=t;
		if(i!=min)
			ans++;
	}
	for(int i=0;i<n-1;i++)
		cout<<a[i]<<' ';
	cout<<a[n-1]<<endl;
	cout<<ans<<endl;
}
