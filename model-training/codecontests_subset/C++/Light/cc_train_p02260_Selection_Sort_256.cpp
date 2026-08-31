#include<iostream>
#include<cmath>
using namespace std;
int a[100],n,t;
void xzsort(int n)
{
	int i,j,minn,mini;
	for(i=0;i<n-1;i++)
	{
		mini=i;
		minn=a[i];
		for(j=i+1;j<n;j++)
		{
			if(a[j]<minn)
			{
				minn=a[j];
				mini=j;
			}
		}
		if(i!=mini)
		{
		t++;
		swap(a[i],a[mini]);
		}
	}
}
int main()
{
	cin>>n;
	for(int i=0;i<n;i++)
	cin>>a[i];
	xzsort(n);
	for(int i=0;i<n-1;i++)
	cout<<a[i]<<" ";
	cout<<a[n-1]<<endl;
	cout<<t<<endl;
	return 0;
 } 
