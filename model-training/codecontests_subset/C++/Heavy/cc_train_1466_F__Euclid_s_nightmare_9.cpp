#include<bits/stdc++.h>
using namespace std;
// #include <ext/pb_ds/assoc_container.hpp> 
// #include <ext/pb_ds/detail/standard_policies.hpp>
// using namespace __gnu_pbds;

#pragma GCC optimize("O3")
#ifdef LOCAL
#include "/Users/lbjlc/Desktop/coding/debug_utils.h"
#else
#define print(...) ;
#define printn(...) ;
#define printg(...) ;
#define fprint(...) ;
#define fprintn(...) ;
#endif

#define rep(i, a, b) for(auto i = (a); i < (b); i++)
#define rrep(i, a, b) for(auto i = (a); i > (b); i--)
#define all(v) (v).begin(), (v).end()
#define pb push_back
// #define mp make_pair
#define fi first
#define se second
#define maxi(x, y) x = max(x, y)
#define mini(x, y) x = min(x, y)
// long long fact(long long n) { if(!n) return 1; return n*fact(n-1); }
// #define endl '\n'
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
int get_random() {
    static uniform_int_distribution<int> dist(0, 1e9 + 6);
    return dist(rng);
}
#define solve_testcase int T;cin>>T;for(int t=1;t<=T;t++){solve(t);}


typedef unsigned long long ull;
typedef long long ll;
 
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
typedef pair<double, double> pdd;
 
typedef vector<int> vi;
typedef vector<vi> vvi;
typedef vector<vvi> vvvi;
typedef vector<pii> vpii;
typedef vector<pll> vpll;
typedef vector<pdd> vpdd;
typedef vector<long long> vll;
#define bd(type,op,val) bind(op<type>(), std::placeholders::_1, val)

template<class T>
void make_unique(T & v) {
    sort(v.begin(), v.end()); v.erase(unique(v.begin(), v.end()), v.end());
}
int geti() { int x; cin >> x; return x; }
long long getll() { long long x; cin >> x; return x; }
double getd() { double x; cin >> x; return x; }
// pair<int, int> a(geti(), geti()) does not work
// pair<int, int> a({geti(), geti()}) works, since it uses initializer.

const int MAXN = 5e5 + 100;

struct disjoint_set_union{
    int root[MAXN], size[MAXN];
    int l, r;
    void init(int _l, int _r) {
        l = _l; r = _r;
        for(int i = l; i <= r; i++) {
            root[i] = i;
            size[i] = 1;
        }
    }
    int find(int i) {
        if(root[i] != i)
            return root[i] = find(root[i]);
        else
            return i;
    }
    int same(int i, int j) {
        return find(i) == find(j);
    }
    void join(int i, int j) {
        if(same(i, j))
            return;
        // print("join",i,j);
        int ri = find(i);
        int rj = find(j);
        if(size[ri] >= size[rj]) {
            root[rj] = ri;
            size[ri] += size[rj];
        }
        else {
            root[ri] = rj;
            size[rj] += size[ri];
        }
    }
};

disjoint_set_union dsu;
int vis[MAXN]={};
ll mod=1e9+7;

ll mypow(ll x, ll n) {
	if(!n) return 1;
	ll res=mypow(x,n/2);
	if(n%2) return res*res%mod*x%mod;
	else return res*res%mod;
}

void solve(int tt) {
    // cout<<"Case #"<<tt<<": ";
}

int main(int argc, char * argv[]) {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    // solve_testcase;

    int n,m,k,x,y;
    cin>>n>>m;

    dsu.init(1,m);
    vi res;
    rep(i,0,n) {
    	cin>>k;
    	if(k==1) {
    		cin>>x;
    		int & tmp = vis[dsu.find(x)];
    		if(!tmp) {
    			tmp=1;
    			res.pb(i+1);
    		}
    		else if(tmp==2) {
    			tmp=1;
    			res.pb(i+1);
    		}
    	}
    	else {
    		cin>>x>>y;
    		if(dsu.same(x,y)) continue;

    		int t1 = vis[dsu.find(x)];
    		int t2 = vis[dsu.find(y)];
    		if(!t1&&!t2) {
    			dsu.join(x,y);
    			vis[dsu.find(x)]=2;
    			res.pb(i+1);
    		}
    		else if(t1&&!t2) {
    			int t=vis[dsu.find(x)];
    			dsu.join(x,y);
    			vis[dsu.find(x)]=t;
    			res.pb(i+1);
    		}
    		else if(!t1&&t2) {
    			int t=vis[dsu.find(y)];
    			dsu.join(x,y);
    			vis[dsu.find(y)]=t;
    			res.pb(i+1);
    		}
    		else if(t1==1&&t2==2) {
    			dsu.join(x,y);
    			vis[dsu.find(y)]=1;
    			res.pb(i+1);
    		}
    		else if(t1==2&&t2==1) {
    			dsu.join(x,y);
    			vis[dsu.find(x)]=1;
    			res.pb(i+1);
    		}
    		else if(t1==2&&t2==2) {
    			dsu.join(x,y);
    			// vis[dsu.find(x)]=1;
    			res.pb(i+1);
    		}
    	}
    }
    ll ans=1;
    rep(i,1,m+1) {
    	if(dsu.find(i)==i && vis[i]) {
    		print(i,vis[i],dsu.size[i]);
    		if(vis[i]==2)
    			ans *= mypow(2,dsu.size[i]-1);
    		else
    			ans *= mypow(2,dsu.size[i]);
    		ans %= mod;
    	}
    }
    cout<<ans<<' '<<res.size()<<endl;
    for(auto x:res)cout<<x<<' ';
	cout<<endl;



    return 0;
}











