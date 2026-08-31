#include<iostream>
using namespace std;
int main()
{
	long i,n,m,ans=1,a=0,aa=-1,mod=1e9+7,f[114514];
	cin>>n>>m;
	f[0]=f[1]=1;
	for(i=2;i<114514;i++)f[i]=(f[i-1]+f[i-2])%mod;
	for(i=0;i<m;i++)
	{
		cin>>a;
		if(a-aa==1)
		{
			cout<<0<<endl;
			return 0;
		}
		ans=(ans*f[a-aa-2])%mod;
		aa=a;
	}
	a=n;
	ans=(ans*f[a-aa-1])%mod;
	cout<<ans<<endl;
	return 0;
}