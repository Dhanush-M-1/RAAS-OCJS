#include <bits/stdc++.h>
using namespace std;

#define fastio ios_base::sync_with_stdio(false); cin.tie(0);
#define ll long long
#define vf(i, v) for(auto i : v)
#define all(a) a.begin(), a.end()
#define add push_back
#define fr first
#define sc second
#define pii pair<int, int>
#define pll pair<long long, long long>
#define plb pair<long long, bool>
#define filein(a) freopen(a, "r", stdin);
#define fileout(a) freopen(a, "w", stdout);

const ll LINF = 2e18;
const int INF = 2e9;
const int N = 1e5 + 5;

ll n, tag[N], score[N], ans = 0, h;
ll dp[N];

void solve(){
	ans = 0;

	cin >> n;
	for(int i = 1; i <= n; i++){
		cin >> tag[i];
	}
	for(int i = 1; i <= n; i++){
		cin >> score[i];
	}
	for(int i = 2; i <= n; i++){
		for(int j = i - 1; j > 0; j--){
			if(tag[i] == tag[j]){
				continue;
			}
			h = dp[i];
			
			dp[i] = max(dp[i], dp[j] + abs(score[i] - score[j]));
			dp[j] = max(dp[j], h + abs(score[i] - score[j]));
			
			ans = max(ans, max(dp[i], dp[j]));
		}
	}
	cout << ans << endl;
	for(int i = 0; i <= n; i++){
		dp[i] = 0;
	}
}

void precalc(){
	return;
}

int main(){
	fastio;
	precalc();
	int t = 1;
	// filein("");
	// fileout("");
	
	cin >> t;
	while(t--){
		solve();
	}
	
	return 0;
}

/*

 [[]]_                                          /^^\
( `_´)                                         ('_' )
<,︻╦╤─ օ - - -                       - - - օ ─╤╦︻,>
 /  \                                           /  \
[][][][][][][][][][][][][][][][][][][][][][][][][][][]

*/