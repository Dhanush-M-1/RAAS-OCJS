#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef pair<int, int> pii;
#define FOR(i, n) for(int (i)=0; (i)<(n); (i)++)
#define FOR1(i, n) for(int (i)=1; (i)<=(n); (i)++)
#define FORI(i, n) for(int (i)=n-1; (i)>=0; (i)--)
template<class T, class U> void umin(T& x, const U& y){ x = min(x, (T)y);}
template<class T, class U> void umax(T& x, const U& y){ x = max(x, (T)y);}
template<class T, class U> void init(vector<T> &v, U x, size_t n) { v=vector<T>(n, (T)x); }
template<class T, class U, typename... W> void init(vector<T> &v, U x, size_t n, W... m) { v=vector<T>(n);  for(auto& a : v) init(a, x, m...); }

const int m = 2e5;
const ll MOD = 1e9+7;
int dp[10][m+1];
int main(int argc, char** argv) {
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0); cout << setprecision(15);
    if (argc == 2 && atoi(argv[1]) == 123456789) freopen("d:\\code\\cpp\\contests\\stdin", "r", stdin);
    int T = 1;
    cin >> T;

    FOR(x, 10) dp[x][0] = 1;
    FOR1(i, m){
        FOR(x, 9){
            dp[x][i] = dp[x+1][i-1];
        }
        dp[9][i] = (dp[1][i-1] + dp[0][i-1]) % MOD;
    }

    FOR1(t, T){
        int n, m;
        cin >> n >> m;
        ll sol = 0;
        while(n){
            int d = n%10;
            sol += dp[d][m];
            n /= 10;
        }
        sol %= MOD;
        cout << sol << endl;
    }
    if (argc == 2 && atoi(argv[1]) == 123456789) cout << clock()*1.0/CLOCKS_PER_SEC << " sec\n";
    return 0;
}

