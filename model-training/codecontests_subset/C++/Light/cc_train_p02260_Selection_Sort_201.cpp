#include<bits/stdc++.h>
using namespace std;
const int maxn=110;
int a[maxn];
int main()
{
	int n,temp,num=0;
	cin>>n;
	for(int i=1;i<=n;i++)
	{
		cin>>a[i];
	}
	for(int i=1;i<=n-1;i++)
	{
		int min=a[i];
		int mark=i;
		for(int j=i+1;j<=n;j++)
		{
			if(min>a[j])
			{
				mark=j;
				min=a[j];
			}
		} 
		if(mark!=i)
		{
			swap(a[mark],a[i]);
			num++;
		}
	}
	cout<<a[1];
	for(int i=2;i<=n;i++)
	{
			cout<<" "<<a[i];
	}
	cout<<endl;
	cout<<num<<endl;
	return 0;
}
