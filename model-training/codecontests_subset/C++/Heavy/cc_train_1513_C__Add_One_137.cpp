#pragma GCC optimize("Ofast")
#include "bits/stdc++.h"
#define rep(i,j,n) for(int i=(j);i<=((int)n);++i)
#define rev(i,n,j) for(int i=(n);i>=((int)j);--i)
typedef long long int ll;
#define int long long int
const ll INFL=0x3f3f3f3f3f3f3f3fLL;
const int INF=0x3f3f3f3f;
const int mod=1000000007;
#define endl "\n"
#define mem(a,val) memset(a,val,sizeof(a))
#define all(c) (c).begin(),(c).end()
#define tr(container, it) for(__typeof(container.begin()) it = container.begin(); it != container.end(); it++)
#define present(container, element) (container.find(element) != container.end())
#define pb push_back
#define FAST ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#define readmat(a, n, m) int a[n + 5][m + 5] = {}; rep(i, 1, n) {rep(j, 1, m) cin >> a[i][j];}
#define printmat(a, n, m) rep (i, 1, n) {rep (j, 1, m) cout << a[i][j] << " "; cout << endl;} cout << endl;
#define printarr(a, n) rep(i, 1, n) cout << a[i] << " "; cout << endl;
typedef std::map< int,int> mii;
typedef std::vector< int > vi;
typedef std::vector< vi > vvi;
typedef std::pair< int,int > ii;
using namespace std;
#define cerr cout
#define error(args...) { string _s = #args; replace(_s.begin(), _s.end(), ',', ' '); stringstream _ss(_s); istream_iterator<string> _it(_ss); err(_it, args); }
void err(istream_iterator<string> it) {}
template<typename T, typename... Args>
void err(istream_iterator<string> it, T a, Args... args) {
    cout << *it << " = " << a << endl;
    err(++it, args...);}
const int N = 2e5+5, M = 2e5;
vector <int>g[N];


int dp[15][N];
void pre()
{
	for(int i = 0; i <10; ++i) 
	{
		int cnt[11]={0};
		int ncnt[11]={0};
		cnt[i]=1;
		for(int j = 1; j <=M; ++j) 
		{
			for(int k = 0; k <10; ++k) 
			{
				ncnt[k]=0;
			}
			for(int k = 0; k <10; ++k) 
			{
				if (k!=9)
				{
					ncnt[k+1]=(cnt[k]%mod);
				}
				else
				{
					ncnt[0]=(ncnt[0]+cnt[k])%mod;
					ncnt[1]=(ncnt[1]+cnt[k])%mod;
				}
			}
			int s=0;
			for(int k = 0; k <10; ++k) 
			{
				cnt[k]=(ncnt[k]%mod);
				s=(s+cnt[k])%mod;
			}
			dp[i][j]=s;
		}
	}

}

	
void solve()
{
	string n;
	int m;
	cin>>n>>m;
	mii x;
	for(auto &i : n) 
	{
		x[i-'0']++;
	}

	int ans=0;
	for(auto &[i,j] : x) 
	{
		ans=(ans+(dp[i][m]*j)%mod)%mod;
	}

	cout<<ans<<endl;

  

}



signed main()
{
  FAST;
#ifdef LOCAL
    freopen("C:\\Users\\hp\\Documents\\input.txt", "r", stdin);
    freopen("C:\\Users\\hp\\Documents\\output.txt", "w", stdout);
    std::chrono::time_point<std::chrono::high_resolution_clock> start, end;
    start = std::chrono::high_resolution_clock::now();
#endif
pre();
int t;
cin>>t;
while(t--) 
{
    solve();
}

#ifdef LOCAL
    end = std::chrono::high_resolution_clock::now();
    ll elapsed_time = std::chrono::duration_cast<std::chrono::milliseconds>(end-start).count();
    cout<<endl;
    cout << "\nElapsed Time: " << elapsed_time << "ms\n";
#endif

return 0;

}

// vector string set map first second continue break return upper_bound lower_bound length void sort
// stack queue pop size erase empty insert
// #Hala BBCF

