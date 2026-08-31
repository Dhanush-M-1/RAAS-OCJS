#include<iostream>
#define abs(a) (a<0?-(a):a)
using namespace std;
int main()
{
	int n,m,a[50],b[50],c[50],d[50];
	cin>>n>>m;
	for(int i=0;i<n;i++)cin>>a[i]>>b[i];
	for(int i=0;i<m;i++)cin>>c[i]>>d[i];
	for(int i=0;i<n;i++)
	{
		int v=1e9,p=0;
		for(int j=0;j<m;j++)
		{
			if(v>abs(a[i]-c[j])+abs(b[i]-d[j]))p=j,v=abs(a[i]-c[j])+abs(b[i]-d[j]);
		}
		cout<<p+1<<endl;
	}
}
