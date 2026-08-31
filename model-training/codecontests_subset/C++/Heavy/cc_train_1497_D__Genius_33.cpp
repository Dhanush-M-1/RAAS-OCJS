# include<bits/stdc++.h>

using namespace std;
# define l long long 
# define db double 
# define rep(i,a,b) for(l i=a;i<b;i++)
# define vi vector<l>
# define vvi vector<vi>
# define vsi vector<set<l> >
# define pb push_back
# define mp make_pair
# define ss second
# define ff first
# define pii pair<l,l>
# define trvi(v,it) for(vi::iterator it=v.begin();it!=v.end();++it)
# define read(a) freopen(a,"r",stdin)
# define write(a) freopen(a,"w",stdout)
# define io ios::sync_with_stdio(false)

template<typename A, typename B> ostream& operator<<(ostream &os, const pair<A, B> &p) { return os << '(' << p.first << ' ' << p.second << ')'; }
template<typename T_container, typename T = typename enable_if<!is_same<T_container, string>::value, typename T_container::value_type>::type> ostream& operator<<(ostream &os, const T_container &v) { os << '{'; string sep; for (const T &x : v) os << sep << x, sep = ", "; return os << '}'; }
 

#ifdef KRISHNAN_DEBUG
void dbg_out() { cerr << endl; }
template<typename Head, typename... Tail> void dbg_out(Head H, Tail... T) { cerr << ' ' << H; dbg_out(T...); }
#define dbg(...) cerr << "(" << #__VA_ARGS__ << "):", dbg_out(__VA_ARGS__)
#else
#define dbg(...)
#endif

const bool MULTIPLE_TEST_CASES = true;

const l MOD=1e9+7;
const l N=1e5+5;
const l INF=1e12;

void solve() {
	int n;
	cin>>n;
	vector<int> tag(n);
	rep(i,0,n) {
		cin>>tag[i];
	}
	vector<l> score(n);
	rep(i,0,n) {
		cin>>score[i];
	}
	vector<l> dp(n,0);
	for(l big=0; big<n; big++) {
		for(l x = big-1; x>=0;x--) {
			if(tag[x]!=tag[big]) {
				l new_big = max(dp[big], dp[x]+abs(score[x]-score[big]));
				l new_x = max(dp[x], dp[big] + abs(score[x]-score[big]));
				dp[big] = new_big;
				dp[x] = new_x;
			}
		}
	}
	l ans = *max_element(dp.begin(), dp.end());
	cout<<ans<<"\n";
	return;
}


int main(){
	io;
	int t=1;
	if (MULTIPLE_TEST_CASES) cin>>t;
	rep(i,0,t) {
		solve();
	}

	return 0;
}
