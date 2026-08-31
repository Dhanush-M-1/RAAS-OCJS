#include<cstdio>
#include<cstring>
#include<algorithm>
#define N 100010
using namespace std;

int n, m, t[N], w[N], a[N], l, r, lx, rx, sum, x, y, now, q;

int main(){
	scanf("%d%d", &m, &n);
	for(int i=1; i<=n; i++)scanf("%d", &t[i]);
	scanf("%d", &q);
	for(int i=1; i<=q; i++)scanf("%d%d", &w[i], &a[i]);
	t[0]=0; t[n+1]=w[q]+1; now=0;
	l=0; lx=0; r=m; rx=m; sum=0;
	while(now<q&&w[now+1]<t[1]){now++; printf("%d\n", max(0, a[now]-w[now]));}
	for(int i=1; i<=n; i++){
		x=t[i]-t[i-1];
		if(i&1){
			if(l+1<=r-1&&l+1+sum-x<=0)l=min(m, x-sum);
			if(l>=r)l=m; lx=max(0, lx-x);
			if(l==m)r=1; rx=max(0, rx-x);
			sum-=x;
		}else{
			if(l+1<=r-1&&r-1+sum+x>=m)r=max(0, m-x-sum);
			if(r<=l)r=0; rx=min(m, rx+x);
			if(!r)l=m; lx=min(m, lx+x);
			sum+=x;
		}
		while(now<q&&w[now+1]<t[i+1]){
			now++;
			if(a[now]<=l)y=lx;
			if(l<a[now]&&a[now]<r)y=a[now]+sum;
			if(a[now]>=r)y=rx;
			if(i&1)printf("%d\n", min(m, y+w[now]-t[i]));
			else printf("%d\n", max(0, y-(w[now]-t[i])));
		}
	}
	return 0;
}