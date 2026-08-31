#pragma GCC optimize("O3")
#include <bits/stdc++.h>
using namespace std;
#define forn(i, n) for (int i = 0; i <= (int)n; ++i)
#define forin(i, a, b) for (int i = a; i <= (int)b; ++i)
#define rofin(i, a, b) for (int i = a; i >= b; --i)
#define all(x) (x).begin(), (x).end()
#define sync                     \
    ios::sync_with_stdio(false); \
    cin.tie(NULL)
#ifdef LOCAL
#define debug(i) cout << #i << ": " << i << endl
#else
#define debug(i)
#endif
using ll = long long;
using pii = pair<int, int>;
using vb = vector<bool>;
using vi = vector<int>;
using vvi = vector<vi>;
using vll = vector<ll>;
using vvll = vector<vll>;
using pll = pair<ll, ll>;
using vpll = vector<pll>;
const ll inf = 1e17;

void solve() {
    int n, m;
    cin >> n >> m;
    vll a(n + 1);
    vpll prefix;
    ll sum = 0;
    forin(i, 1, n) {
        cin >> a[i];
        sum += a[i];
        if (prefix.empty() || sum > prefix.back().first) {
            prefix.emplace_back(sum, i);
        }
    }

    forin(i, 1, m) {
        ll x;
        cin >> x;
        if (prefix.back().first < x && sum <= 0) {
            cout << -1 << ' ';
            continue;
        }
        ll rounds = x <= prefix.back().first ? 0 : (x - prefix.back().first + sum - 1) / sum;
        x -= rounds * sum;
        ll ans = rounds * n;

        pll search = { x, 0LL };
        auto it = lower_bound(prefix.begin(), prefix.end(), search);
        assert(it < prefix.end());
        cout << ans + prefix[it - prefix.begin()].second - 1 << ' ';
    }
    cout << '\n';
}

int main() {
    sync;
    int t;
    cin >> t;
    while (t--) solve();
}
