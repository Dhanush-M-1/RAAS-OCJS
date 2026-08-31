#include <bits/stdc++.h>
#define forr(i,a,b) for(int i=(a);i<(b);i++)
#define forn(i,n) forr(i,0,n)
#define dforn(i,n) for(int i=n-1;i>=0;i--)
#define forall(it,v) for(auto it=v.begin();it!=v.end();it++)
#define sz(c) ((int)c.size())
#define rsz resize
#define pb push_back
#define mp make_pair
#define lb lower_bound
#define ub upper_bound
#define fst first
#define snd second

#ifdef ANARAP
//prueba
#else
//real
#endif

using namespace std;

typedef long long ll;
typedef pair<int,int> ii;

int main()
{
	#ifdef ANARAP
		freopen("input.in", "r", stdin);
		//freopen("output.out", "w", stdout);
		unsigned t0, t1; t0=clock();
	#endif
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int t; cin >> t;
	forn(T,t){
		int n; cin >> n;
		vector<ll> score(n),dp(n,0);
		vector<int> tag(n);
		forn(i,n) cin >> tag[i];
		forn(i,n) cin >> score[i];
		ll ans = 0;
		forr(j,1,n){
			dforn(i, j){
				if(tag[i] == tag[j]) continue;
				ll addScore = abs(score[i]-score[j]);
				ll dpj = dp[j], dpi = dp[i];
				dp[i] = max(dpi, dpj+addScore);
				dp[j] = max(dpj, dpi+addScore);
				ans = max({ans, dp[i], dp[j]});
			}
		}
		cout << ans << '\n';
		
	}
	
	
	#ifdef ANARAP
	t1 = clock();double time = (double(t1-t0)/CLOCKS_PER_SEC); cout << "Execution Time: " << time << endl;
	#endif
	return 0;
}

