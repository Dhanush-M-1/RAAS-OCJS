#include<bits/stdc++.h>
using namespace std;

#define sz(s) (int)s.size()
#define f first
#define s second
#define pb push_back
#define all(s) s.begin(), s.end()

#define vi vector<int>
#define vvi vector<vi>

#define ll long long
#define vll vector<ll>

#define ii pair<int, int>
#define vii vector<ii>
#define vvii vector<vii>

const int INF = 1e9 + 7;
const int mod = INF;
const int N = 1e6 + 7;
const int T = 1 << 20;

int c[N];
int b[N];
int d[N];

void solve(){
    int n;
    cin >> n;

    for(int i = 0; i < n; i++)
        cin >> c[i];
    for(int i = 0; i < n - 1; i++)
        cin >> b[i];

    int q;
    cin >> q;
    int shift = 100 * 100 + 7;

    for(int _ = 0; _ < q; _++){
        int zap;
        cin >> zap;
        // policz schodki
        d[0] = zap;
        int last = d[0];
        for(int i= 0; i < n - 1; i++){
            last += b[i];
            d[i + 1] = d[i] + last;
            d[i + 1] = min(d[i + 1], shift - 1);
        }

        vi dp(shift + shift);
        dp[shift] = 1;

        for(int i = 0; i < n; i++){
            vi dp2(shift + shift);
            for(int j = 0; j <= c[i]; j++)
                for(int k = 0; k < shift + shift; k++)
                    if(k + j < shift + shift and k + j >= d[i] + shift)
                        dp2[k + j] = (dp2[k + j] + dp[k]) % INF; 
            swap(dp, dp2);
        }
        
        int ans = 0;
        for(int i = 0; i < shift + shift; i++)
            ans = (ans + dp[i]) % INF; 
        cout << ans << '\n';
    }
}

signed main(){
    int test = 1;
    // cin >> test;

    for(int i = 0; i < test; i++)
        solve();
}