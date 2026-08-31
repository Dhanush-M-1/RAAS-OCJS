#include <bits/stdc++.h>
using namespace std;

template<typename T>
void out(T x) { cout << x << endl; exit(0); }
#define watch(x) cout << (#x) << " is " << (x) << endl





using ll = long long;

const ll mod = 1e9+7;
const int maxn = 1e6 + 5;

struct dsu0 {
    vector<int> par, siz;
    int n;
    int cc;
    int largest;
    void init(int n) {
	assert(n>0);
	this->n=n;
	cc=n;
	par.resize(n+10);siz.resize(n+10);
	for (int i=0; i<n; i++) par[i]=i,siz[i]=1;
	largest=1;
    }
    int parent(int x) {
	assert(x>=0 && x<n);
	return par[x]==x?x:par[x]=parent(par[x]);
    }
    bool join(int x, int y) {
	x=parent(x);y=parent(y);
	if (x==y) return false;
	cc--;
	if (siz[x]<siz[y]) swap(x,y);
	siz[x]+=siz[y];par[y]=x;
	largest=max(largest,siz[x]);
	return true;
    }
};


ll n, d;
ll a[maxn];

vector<array<ll,3>> edges;


void solve(int l, int r) {
    if (l==r) return;
    if (l+1==r) {
	edges.push_back({d + a[l] + a[r], l, r});
	return;
    }
    int mid=(l+r)/2;
    int l0=l,r0=r;
    auto f = [&](ll i) {
	return a[i]-d*i;
    };
    auto g = [&](ll i) {
	return a[i]+d*i;
    };

    for (int i=l; i<=mid; i++) {
	if (f(i) < f(l0)) {
	    l0=i;
	}
    }
    for (int i=mid+1; i<=r; i++) {
	if (g(i) < g(r0)) {
	    r0 = i;
	}
    }

    //cout<<l<<" "<<r<<": "<<l0<<" "<<r0<<endl;

    for (int j=mid+1; j<=r; j++) {
	edges.push_back({f(l0)+g(j),l0,j});
    }
    for (int i=l; i<=mid; i++) {
	edges.push_back({f(i)+g(r0),i,r0});
    }

    solve(l,mid);
    solve(mid+1,r);
}

int main() {
    ios_base::sync_with_stdio(false); cin.tie(0);  cout.tie(0);

    cin>>n>>d;
    for (int i=0; i<n; i++) {
	cin>>a[i];
    }


    solve(0,n-1);


    sort(edges.begin(), edges.end());

    dsu0 dsu;
    dsu.init(n);

    ll res = 0;
    for (auto ed: edges) {
	ll wei = ed[0];
	int u = ed[1];
	int v = ed[2];
	//cout<<wei<<": "<<u<<","<<v<<endl;
	if (dsu.join(u,v)) {
	    res += wei;
	}
    }
    assert(dsu.cc==1);
    cout<<res<<endl;    
    return 0;
}
