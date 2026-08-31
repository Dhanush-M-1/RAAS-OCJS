#include <bits/stdc++.h>

#ifdef NON_SUBMIT
#define TEST(n) (n)
#else
#define TEST(n) ((void)0)
#endif

using namespace std;

int N, D;
vector<int> A, color;
vector<tuple<long long,int,int>> E;

int find_(int a)
{
	if(a==color[a]) return a;
	return color[a]=find_(color[a]);
}

void union_(int a, int b)
{
	a=find_(a);
	b=find_(b);
	color[a]=color[b]=min(a,b);
}

void solve(int s, int e)
{
	int m=(s+e)>>1, l=s, r=e;
	if(s>=e) return;
	for(int i=s;i<=e;i++) {
		if(i<=m && A[i]-1LL*i*D<A[l]-1LL*l*D) l=i;
		else if(i>m && A[i]+1LL*i*D<A[r]+1LL*r*D) r=i;
	}
	for(int i=s;i<=e;i++) {
		if(i<=m) E.emplace_back(A[i]+A[r]+1LL*(r-i)*D,i,r);
		else E.emplace_back(A[l]+A[i]+1LL*(i-l)*D,l,i);
	}
	solve(s,m);
	solve(m+1,e);
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	TEST(freopen("input.txt", "r", stdin));
	TEST(freopen("output.txt", "w", stdout));
	TEST(freopen("debug.txt", "w", stderr));
	int u, v;
	long long w, ans=0;
	cin>>N>>D;
	A.resize(N); color.resize(N);
	for(int i=0;i<N;i++) cin>>A[color[i]=i];
	solve(0,N-1);
	sort(E.begin(),E.end());
	for(auto e: E) {
		tie(w,u,v)=e;
		if(find_(u)!=find_(v)) {
			union_(u,v);
			ans+=w;
		}
	}
	cout<<ans<<'\n';
	return 0;
}