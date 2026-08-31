/*
 *
 * Author: Hsueh-
 * Date: 2021-03-05 21:34:52
 *
 * */

#include <bits/stdc++.h>

using namespace std;

#define dbg(x...)                                                              \
    do {                                                                       \
        cout << #x << " -> ";                                                  \
        err(x);                                                                \
    } while (0)
void err() { cout << endl; }
template <class T, class... Ts> void err(const T &arg, const Ts &...args) {
    cout << arg << " ";
    err(args...);
}

#define endl "\n"
#define all(A) A.begin(), A.end()
using ll = long long;
using db = double;
using pII = pair<int, int>;

const int INF = 0x3f3f3f3f;
const ll INFLL = 0x3f3f3f3f3f3f3f3f;
const int N = 2e5 + 10;

int n, m;
int a[N];

void RUN() {
    cin >> n >> m;
    map<ll, int> mp;
    ll sum = 0, Max = 0;
    for (int i = 1; i <= n; ++i) {
        cin >> a[i];
        sum += a[i];
        if (sum > Max) {
            Max = sum;
            mp[sum] = i;
        }
    }
    for (int i = 1; i <= m; ++i) {
        ll x;
        cin >> x;
        auto it = mp.lower_bound(x);
        ll res = 0;
        if (it == mp.end() && sum <= 0) {
            res = -1;
        } else if (it == mp.end()) {
            auto last = mp.end();
            last--;
            ll need = (x - last->first + sum - 1) / sum;
            it = mp.lower_bound(x - need * sum);
            res = it->second + need * n - 1;
        } else {
            res = it->second - 1;
        }
        cout << res << " \n"[i == m];
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr), cout.tie(nullptr);
    cout << fixed << setprecision(20);

    int T;
    cin >> T;
    while (T--) {
        RUN();
    }

    return 0;
}