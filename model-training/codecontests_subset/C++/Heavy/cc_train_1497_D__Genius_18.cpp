#pragma GCC optimize("O3")
#include <bits/stdc++.h>
#include <iostream>
using namespace std;
#define fastio                        \
    ios_base::sync_with_stdio(false); \
    cin.tie(NULL);                    \
    cout.tie(NULL)

#define f(i, a, b) for (ll i = a; i <= b; i++)
#define fr(i, a, b) for (ll i = a; i >= b; i--)
#define pb push_back
#define sz(a) ll(a.size())
#define F first
#define S second
#define mp make_pair
#define vi vector<ll>
#define vvi vector<vi>
#define pii pair<ll, ll>
#define all(p) p.begin(), p.end()
#define pvec(v, a, b)                   \
    {                                   \
        f(i, a, b) cout << v[i] << " "; \
        nl;                             \
    }
#define nl cout << "\n"
#define mii map<ll, ll>
#define deb(x) cout << #x << "=" << x << "\n"
#define deb2(x, y) cout << #x << "=" << x << "," << #y << "=" << y << endl
#define gout(x) cout << "Case #" << x << ": "
typedef long long ll;
const ll mod = LLONG_MAX;
const ll MAX = 2e5 + 7;

void solve()
{
    ll n;
    cin>>n;
    vi t(n),s(n),dp(n);
    f(i,0,n-1) cin>>t[i];
    f(i,0,n-1) cin>>s[i];

    f(i,0,n-1){
        fr(j,i-1,0){
            if(t[i]==t[j]) continue;
            ll cs = abs(s[i]-s[j]); 
            ll dpi = dp[i];
            dp[i] = max(dp[j]+cs,dp[i]);
            dp[j] = max(dp[j],dpi+cs);
        }
    }
    cout<<*max_element(all(dp));
nl;
}

int main()
{
    auto start = chrono::high_resolution_clock::now();
    fastio;
    ll tc;
    tc = 1;
    cin >> tc;
    while (tc--)
        solve();

    auto end = chrono::high_resolution_clock::now();
    //  Calculating total time taken by the program.
    double time_taken =
        chrono::duration_cast<chrono::nanoseconds>(end - start).count();

    time_taken *= 1e-9;

    // cout << "Time taken by program is : " << fixed << time_taken << setprecision(9);cout << " sec" << endl;
    return 0;
}