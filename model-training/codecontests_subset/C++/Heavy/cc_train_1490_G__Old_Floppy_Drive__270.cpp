#pragma GCC optimize("Ofast")

#include <bits/stdc++.h>

using namespace std;

void debug_out() { cerr << endl; }

template<typename Head, typename... Tail>
void debug_out(Head H, Tail... T) {
    cerr << "[" << H << "]";
    debug_out(T...);
}

#ifdef dddxxz
#define debug(...) cerr << "[" << #__VA_ARGS__ << "]:", debug_out(__VA_ARGS__)
#else
#define debug(...) 42
#endif

#define SZ(s) ((int)s.size())
#define all(x) (x).begin(), (x).end()
#define revall(x) (x).rbegin(), (x).rend()

clock_t startTime;

double getCurrentTime() {
    return (double) (clock() - startTime) / CLOCKS_PER_SEC;
}

typedef long long ll;
//mt19937 rng(chrono::high_resolution_clock::now().time_since_epoch().count());
const double eps = 0.00001;
const int MOD = 1e9 + 7;
const int INF = 1000000101;
const long long LLINF = 1223372000000000555;
const int N = 5e5 + 3e2;
const int M = 2600;

ll pref[N], mx[N];

void solve(int TC) {
    int n, m;
    cin >> n >> m;

    mx[0] = -INF;
    for (int i = 1; i <= n; i++){
        int x;
        cin >> x;
        pref[i] = pref[i - 1] + x;
        mx[i] = max(mx[i - 1], pref[i]);
    }

    ll sum = pref[n];

    while (m--){
        ll x;
        cin >> x;

        ll k = 0;

        ll l = 0, r = (sum == 0 ? 1e9 : 1e18 / sum);
        while (l <= r){
            ll mid = (l + r) >> 1;
            if (sum * mid + mx[n] >= x){
                k = mid;
                r = mid - 1;
            } else l = mid + 1;
        }

        ll y = x;
        x -= k * sum;

        int idx = 0;

        l = 0, r = n;
        while (l <= r){
            ll mid = (l + r) >> 1;
            if (mx[mid] >= x){
                idx = mid;
                r = mid - 1;
            } else l = mid + 1;
        }

        cout << (1ll * k * sum + pref[idx] >= y ? 1ll * k * n + idx - 1 : -1) << ' ';
    }
    cout << endl;

}


int main() {
    startTime = clock();
    cin.tie(0); cout.tie(0);
    ios_base::sync_with_stdio(false);

    bool llololcal = false;
#ifdef dddxxz
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    llololcal = true;
#endif

    int TC = 1;
    cin >> TC;

    for (int test = 1; test <= TC; test++) {
        debug(test);
        solve(test);
    }

    if (llololcal) cerr << endl << "Time: " << getCurrentTime() * 1000 << " ms" << endl;

    return 0;
}