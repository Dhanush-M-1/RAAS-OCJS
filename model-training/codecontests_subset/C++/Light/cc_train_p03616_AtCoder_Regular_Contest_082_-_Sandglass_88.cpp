#include<iostream>
#include<cstring>
using namespace std;
int n,x,r[1000100];
int main()
{
ios::sync_with_stdio(false);
cin.tie(0);
cin >>x>>n;
for(int i=1;i<=n;i++)cin >>r[i];
int q,now=1,p=-1,low=x,high=0,ad=0;cin >>q;
while(q--)
{
	int t,a;cin >>t>>a;
	while((now<=n)&&(t>=r[now]))
	{
		int dlt=p*(r[now]-r[now-1]);
		ad+=dlt;low=min(x,max(dlt+low,0));high=min(x,max(dlt+high,0));
		now++,p*=-1;
	}
	cout <<min(x,max(0,min(low,max(a+ad,high))+p*(t-r[now-1])))<<'\n';
}
return 0;
}