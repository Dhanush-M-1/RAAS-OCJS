#include<bits/stdc++.h>
using namespace std;
#define MN 100005
int t,r[MN],a,v[MN],x,n,q;
int main(){
	cin>>x>>n;
	for(int i=1;i<=n;++i)scanf("%d",r+i);
	for(int i=1;i<=n;++i)v[i]=r[i]-r[i-1];
	cin>>q;int tl=0,h=x,l=0,hv=x,lv=0;r[n+1]=v[n+1]=1000000008;
	while(q--){
		scanf("%d%d",&t,&a);
		while(r[tl+1]<=t){
			if((++tl)&1){
				if(lv<v[tl])l+=v[tl]-lv;
				hv=max(0,hv-v[tl]);
				lv=max(0,lv-v[tl]);
			}else{
				if(hv+v[tl]>x)h-=v[tl]+hv-x;
				hv=min(x,hv+v[tl]);
				lv=min(x,lv+v[tl]);
			}
			h=max(0,h);l=min(l,x);
		}t-=r[tl];
		if(l>=a)a=lv;else if(h<=a)a=hv;else a+=lv-l;
		if(tl&1)printf("%d\n",min(x,a+t));else printf("%d\n",max(0,a-t));
	}
	return 0;
}