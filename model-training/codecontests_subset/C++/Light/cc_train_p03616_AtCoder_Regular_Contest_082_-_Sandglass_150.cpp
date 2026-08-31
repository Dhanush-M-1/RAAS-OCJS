#include <bits/stdc++.h>
//#include <math.h>
using namespace std;

#define INF 1.1e9
#define LINF 1.1e18
#define FOR(i,a,b) for (int i=(a);i<(b);++i)
#define REP(i,n) FOR(i,0,n)
#define ALL(v) (v).begin(),(v).end()
#define pb push_back
#define pf push_front
#define fi first
#define se second
#define BIT(x,n) bitset<n>(x)
#define PI 3.14159265358979323846

typedef long long ll;
typedef pair<int,int> P;
typedef pair<int,P> PP;

struct edge {
	int to, cost;
	edge(int t,int c):to(t),cost(c) {}
};
int dx[]={1,-1,0,0},dy[]={0,0,1,-1};

//-----------------------------------------------------------------------------

int X,A[100000],R[100000],T[100000];
int K,Q;
int dir=-1,l,u,m;
int t,dif,j;

void calc(int tmp) {
	t+=abs(tmp),dif+=tmp;
	l=max(0,min(X,l+tmp));
	u=max(0,min(X,u+tmp));
}

int main() {
	cin.tie(0);
	ios::sync_with_stdio(false);

	cin>>X>>K;
	REP(i,K) cin>>R[i];
	cin>>Q;
	REP(i,Q) cin>>T[i]>>A[i];

	u=X;
	REP(i,Q) {
		while(j<K&&R[j]<T[i]) calc((R[j++]-t)*dir),dir=-dir;
		calc((T[i]-t)*dir);
		cout<<max(l,min(u,A[i]+dif))<<endl;
	}

	return 0;
}
