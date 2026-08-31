#include <bits/stdc++.h>

using namespace std;

typedef long long int ll;
typedef vector<int> vi;
typedef pair<int, int> pii;

typedef vector<ll> vl;
typedef pair<ll, ll> pll;

#define St first
#define Nd second
#define Pb push_back
#define print_pair(p) "{" << (p).St << ", " << (p).Nd << "} "
#define list_format(i, n) (i!=n? " ":"\n")
#define endl "\n"
#define sz(a) (int)a.size()
#define ALL(a) a.begin(), a.end()

#define REP(i,a,b) for(int i = a; i <= b; i++)
#define REV(i,a,b) for(int i = a; i >= b; i--)

#define AritSum(a,d,n) ((n)*(2*(a)+((n)-1)*(d)))/2
#define Log(base, num) log2(num)/log2(base)

#define MOD 1000000007
#define INF 1e9

// ******************** Add-on *****************************
// ******************** Add-on *****************************

// ************* MAIN *******************
void precompute() {}

ll n, m, A[200000], mx[200000];

void solve() {
    cin >> n >> m;
    ll ma = 0, cur = 0;
    REP(i,0,n-1) cin >> A[i], cur += A[i], ma = max(ma, cur), mx[i + 1] = max(mx[i], ma);
    REP(i,0,m-1) {
        ll x; cin >> x;
        ll ans = 0;
        if (x > ma && cur <= 0) {
            cout << -1 << " ";
            continue;
        }
        
        if (x > ma) {
            ll temp = x - ma;
            ll complete = (temp + cur - 1) / cur;
            ans += complete * n;
            x -= complete * cur;
        }

        int l = 1, r = n, b = n;
        while (l <= r) {
            int mid = (l + r)/2;
            if (mx[mid] >= x) {
                b = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        cout << ans + b - 1 << " ";
    }
    cout << endl;
}
/*
g++ -std=c++14 -Wall -Wextra -O2 Test.cpp -o Test
./Test < in.txt

*/
int main() {
    precompute();
    int _=1;
    cin>>_;
    REP(t,1,_) {
        // cout << "Case #" << t << ": ";
        solve();
        // cout << ((solve())? "YES" : "NO") << endl;
    }
    return 0;
}