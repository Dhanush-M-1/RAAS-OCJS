/*
ID: htc9811
LANG: C++
TASK:
*/

#include<stdio.h>
#include<string>
#include<math.h>
#include<stdlib.h>
#include<set>
#include<bitset>
#include<map>
#include<vector>
#include<string.h>
#include<algorithm>
#include<iostream>
#include<queue>
#include<deque>
#include<stack>
#include<cmath>
#include<ctime>
#include<complex>
#include<list>
#include<limits.h>
using namespace std;

const int N=2e5+5;
int n,cur;
long long a[N];
long long d,ans;

struct Seg{
	long long length;
	int x,y;
	Seg(){};
	Seg(long long length,int x,int y):length(length),x(x),y(y){};
};

struct UF{
	int p[N],rnk[N];
	void init(int n){
		memset(p,0,sizeof(p));
		memset(rnk,0,sizeof(rnk));
		for(int i=0;i<n;i++) p[i]=i;
		for(int i=0;i<n;i++) rnk[i]=0;
	}
	int fp(int x){
		return x==p[x]?x:p[x]=fp(p[x]);
	}
	void un(int x,int y){
		if(rnk[x]>rnk[y]) p[y]=x;
		if(rnk[x]<rnk[y]) p[x]=y;
		if(rnk[x]==rnk[y]) p[x]=y,rnk[y]++;
	}
};

inline bool comp(Seg &x,Seg &y){
	return x.length<y.length;
}

vector<Seg> seg;
UF uf;

void solve(int left,int right){
	if(left==right) return;
	int middle=(left+right)>>1;
	int pl=left;
	long long vl=a[left]-d*left;
	for(int i=left+1;i<=middle;i++){
		long long cv=a[i]-d*i;
		if(cv<vl){
			vl=cv;
			pl=i;
		}
	}
	int pr=middle+1;
	long long vr=a[middle+1]+d*(middle+1);
	for(int i=middle+2;i<=right;i++){
		long long cv=a[i]+d*i;
		if(cv<vr){
			vr=cv;
			pr=i;
		}
	}
	for(int i=left;i<=middle;i++) seg.push_back(Seg(a[i]-d*i+vr,i,pr));
	for(int i=middle+1;i<=right;i++) seg.push_back(Seg(a[i]+d*i+vl,pl,i));
	solve(left,middle);
	solve(middle+1,right);
}

int main(){
//	freopen("cc3.in","r",stdin);
//	freopen("cc1.out","w",stdout);
	scanf("%d%lld",&n,&d);
	uf.init(n);
	for(int i=0;i<n;i++) scanf("%lld",a+i);
	solve(0,n-1);
	sort(seg.begin(),seg.end(),comp);
	for(int i=1;i<n;i++){
		while(true){
			int nx=seg[cur].x;
			int ny=seg[cur].y;
			long long len=seg[cur].length;
			nx=uf.fp(nx);
			ny=uf.fp(ny);
			cur++;
			if(nx!=ny){
				uf.un(nx,ny);
//				printf("%lld\n",len);
				ans+=len;
				break;
			}
		}
	}
	printf("%lld\n",ans);
	return 0;
}