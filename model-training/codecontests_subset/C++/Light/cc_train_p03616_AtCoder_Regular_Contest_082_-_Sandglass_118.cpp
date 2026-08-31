#include<bits/stdc++.h>
using namespace std;
#define N 1111116

int n,m,x,mx,mn,k,b,a[N],ans[N];
pair<int,int> q[N];

int read(){
	int x=0,f=1;char ch=getchar();
	for (;!isdigit(ch);ch=getchar()) if (ch=='-')  f=-f;
	for (;isdigit(ch);ch=getchar()) x=x*10+ch-'0';
	return x*f;
}

int main(){
	x=read();n=read();
	for (int i=1;i<=n;i++)
		q[i]=make_pair(read(),0);
	m=read();
	for (int i=1;i<=m;i++){
		q[n+i]=make_pair(read(),i);
		a[i]=read();
	}
	sort(q+1,q+n+m+1);
	mn=0;mx=x;k=-1;b=0;
	for (int i=1;i<=n+m;i++){
		mn+=k*(q[i].first-q[i-1].first);
		mn=min(max(mn,0),x);
		mx+=k*(q[i].first-q[i-1].first);
		mx=min(max(mx,0),x);
		b+=k*(q[i].first-q[i-1].first);
		if (!q[i].second) k=-k;
		else ans[q[i].second]=min(max(a[q[i].second]+b,mn),mx);
	}
	for (int i=1;i<=m;i++)
		printf("%d\n",ans[i]);
	return 0;
}