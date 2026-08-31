#include <algorithm>
#include <cmath>
#include <iostream>
#include <limits>
#include <map>
#include <queue>
#include <set>
#include <stdlib.h>
#include <string>
#include <utility>
#include <vector>
using namespace std;

#pragma GCC optimize("O2", "O3", "fast")

#define _9trash no WA
#define ll long long
#define pb push_back

void io() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
}

// -------------------------------------------------------------

ll n, x, a[200010], sum, mx;
ll cur, cnt, re;
vector<pair<int, ll>> v;

ll solve() {
    if (x > mx && sum <= 0)
        return -1;
    cur = cnt = 0;
    if (x > mx)
        cnt = (x - mx + sum - 1) / sum;
    re = x - cnt * sum;

    int l = 0, r = v.size();
    while (l < r) {
        int mid = (l + r) / 2;
        if (v[mid].second >= re)
            r = mid;
        else
            l = mid + 1;
    }
    return cnt * n + v[l].first;
}

int t, m;

signed main() {
    io();

    cin >> t;
    while (t--) {
        v.clear();
        cin >> n >> m;
        sum = 0, mx = -2e9;
        for (int i = 0; i < n; i++) {
            cin >> a[i];
            sum += a[i];
            if (sum > mx) {
                mx = sum;
                v.pb({i, mx});
            }
        }
        for (int i = 0; i < m; i++) {
            cin >> x;
            cout << solve() << " ";
        }
        cout << "\n";
    }

    return 0;
}