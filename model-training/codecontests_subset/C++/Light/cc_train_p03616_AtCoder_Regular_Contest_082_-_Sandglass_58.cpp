#include<bits/stdc++.h>

using namespace std;

const int N=100005;

int m,n,Q;
struct func{
	int a,b,w,t,k;
	int g(int x){
		if(x<=a)return w;
		if(x<=b)return w+x-a;
		return w+b-a;
	}
	void expand(int dt){
		t+=dt;w+=dt*k;k=-k;
		if(w+b-a<=0)a=b=m,w=0;else if(w<0)a-=w,w=0;
		if(w>=m)a=b=m,w=m;else if(w+b-a>m)b-=w+b-a-m;
	}
}f[N];
bool operator<(const int&a,const func&b){return a<b.t;}

int main(){
	scanf("%d%d",&m,&n);
	f[0]=(func){0,m,0,0,-1};
	for(int i=1,t;i<=n;i++)f[i]=f[i-1],scanf("%d",&t),f[i].expand(t-f[i].t);
	scanf("%d",&Q);
	for(int t,a,p,r;Q--;){
		scanf("%d%d",&t,&a);
		p=upper_bound(f,f+n+1,t)-f-1;
		r=f[p].g(a)+(t-f[p].t)*f[p].k;
		if(r<0)r=0;if(r>m)r=m;
		printf("%d\n",r);
	}
	return 0;
}