#include<bits/stdc++.h>
using namespace std;
int r[1000100];
int main()
{//freopen("in.txt","r",stdin);
	int x,n;scanf("%d%d",&x,&n);
	for (int i=1;i<=n;i++) scanf("%d",&r[i]);
	int q,now=1,p=-1,low=x,high=0,ad=0,lst=0;scanf("%d",&q);
	while (q--)
	{
		int t,a;scanf("%d%d",&t,&a);
		while ((now<=n)&&(t>=r[now]))
		{
			int dlt=p*(r[now]-lst);
			ad+=dlt;low=min(x,max(dlt+low,0));high=min(x,max(dlt+high,0));
			lst=r[now];now++;p*=-1;
		}
		printf("%d\n",min(x,max(0,min(low,max(high,a+ad))+p*(t-lst))));
	}
}