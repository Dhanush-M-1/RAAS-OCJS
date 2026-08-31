#include <bits/stdc++.h>
using namespace std;

// DATA TYPES
typedef long long ll;
typedef long double ld;
typedef unsigned long long ull;

// FUNCTIONS
#define F  		first
#define S  		second
#define PB 		push_back
#define MP 		make_pair
#define B  		begin 
#define I 		insert
#define E  		erase 
#define LB 		lower_bound
#define UB 		upper_bound
#define P 		pair

// DS
#define UMAP 	unordered_map
#define USET 	unordered_set
#define V  		vector
#define PQ 		priority_queue
#define DQ		deque

// LOOPS
#define FOR(i,a,b) 		for(ll i=a;i<=b;i++)	
#define FORR(i,a,b) 	for(ll i=a;i>=b;i--)	

// MOD
#define MOD_MUL(a,b) 	((a%MOD) * (b%MOD))%MOD
#define MOD_ADD(a,b) 	((a%MOD) + (b%MOD))%MOD
#define MOD_SUB(a,b) 	((a%MOD) - (b%MOD))%MOD
#define MOD 			1000000007

// GRAPH
map<ll,V<ll>>g;
map<ll,bool>g_visited;
map<ll,ll>g_parient;
map<ll,ll>g_distance;
void dfs(ll s){	g_visited[s] = true;	for(auto x:g[s])	if(!g_visited.count(x))	dfs(x);}
ll dijkitras(ll s,ll e){PQ<P<ll,ll>>ss;	ss.push({0,s});g_distance[s] = 0;	g_parient[s] = -1;	ll ans = -1;	while(!ss.empty()){auto x = ss.top();	ss.pop();	ll d = -x.first, ver = x.second;if(ver==e){	ans = d;break;}for(auto a:g[ver])if( !g_distance.count(a) or g_distance[a]>1+g_distance[ver]){ss.push({-(d+1),a});g_distance[a] = d+1;g_parient[a] = ver;}}return ans;}
V<ll> g_dijkistra_traversal(ll s,ll e){ll a = e;V<ll>v;while(a!=s){v.PB(a);a = g_parient[a];}	v.PB(a);ll g_n = v.size();FORR(i,v.size()/2,0)	swap(v[i],v[g_n-1-i]);	return v;}

#define COUNT1(x)  __builtin_popcountll(x)
#define COUNT0(x)  __builtin_ctzll(x)


// extended_euclidian 	=>	ax + by = gcd(a,b)
// diophentane 			=>	ax + by = c		[ condition c%gcd == 0 ]
// modulo_inverse		=>	(a*x)%m = 1 => ax +	my = 1

ll euclid(ll a,ll b){
	if(b==0)	return a;
	return euclid(b,a%b);
}

tuple<ll,ll,ll> euclidian_theorem(ll a, ll b){
	if(b==0){
		return {a,1,0};
	}
	ll g,x,y;
	tie(g,x,y) = euclidian_theorem(b,a%b);
	return {g,y,x - ((a*y)/b)};
}

pair<ll,ll> diophentane(ll a,ll b,ll c){
	ll g = euclid(a,b);
	ll x,y;
	if(c%g!=0)	return {0,0};
	tie(g,x,y) = euclidian_theorem(a,b);
	ll k = c/g;
	x = x*k;
	y = y*k;
	return {x,y};
}

ll modulo_inverse(ll a,ll m){
	ll g,x,y;
	tie(g,x,y) = euclidian_theorem(a,m);
	if(g!=1)	return 0;
	x = (x%m + m)%m;
	return x;
}

ll chinese_remainder_theorem(vector<ll>a, vector<ll>m){
	ll ans = 0;
	ll n = m.size();
	// pair gcd check
	for (ll i = 0; i < n; ++i)	for (ll j = i+1; j < n; ++j)	if(euclid(m[i],m[j])!=1)	return 0;
	
	ll mul_m = 1;	for (int i = 0; i < n; ++i)	mul_m *= m[i];

	for(ll i=0;i<n;i++){
		ll mk = mul_m/m[i];
		ll xk = a[i]*mk*modulo_inverse(mk,m[i]);
		ans += xk;
	}
	return ans%mul_m;
}

#define N  200001
ll all[N][10];

void fill_all(){
	FOR(i,0,9){
		all[0][i] = 1; 
	}
	
	FOR(i,1,N-1){
		FOR(j,0,8)
		all[i][j] = all[i-1][j+1];
		all[i][9] = all[i-1][0] + all[i-1][1];
		all[i][9] %= MOD;
	}
}

void solve(){
	ll n,m;	cin>>n>>m;
	ll ans =0;
	while(n){
		ans = MOD_ADD(ans,all[m][n%10]);
		n/=10;
	}
	cout<<ans<<"\n";
}

int main(){
    // for faster input 
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	// cout<<"code is running ;)\n";
	fill_all();
	ll t;	cin>>t;	while(t--)
	solve();
	
	return 0;
}