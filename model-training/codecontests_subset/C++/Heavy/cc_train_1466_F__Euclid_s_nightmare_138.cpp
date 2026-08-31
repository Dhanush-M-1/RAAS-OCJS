/**
 * Author : Ujjawal Pabreja [cuber_coder]
 * Email : ujjawalpabreja99@gmail.com
 */
#include <bits/stdc++.h>
using namespace std;
#define int long long
#define endl "\n"

void Solve() {
    int n, m;
    cin >> n >> m;

    vector<int> vis(m);
    vector<int> parent(m);
    iota(parent.begin(), parent.end(), 0);

    function<int(int)> Find = [&](int u) {
        if (u != parent[u]) {
            return parent[u] = Find(parent[u]);
        }
        return parent[u];
    };

    function<bool(int, int)> Unite = [&](int u, int v) {
        u = Find(u);
        v = Find(v);
        if (u != v and vis[u] + vis[v] != 2) {
            parent[v] = u;
            vis[u] += vis[v];
            return true;
        }
        return false;
    };

    int ans = 1, mod = 1e9 + 7;
    vector<int> subset;

    for (int i = 0; i < n; i++) {
        int k;
        cin >> k;
        int u, v;
        if (k == 1) {
            cin >> u;
            u--;
            u = Find(u);
            if (vis[u] == 0) {
                vis[u] = 1;
                subset.push_back(i + 1);
                ans = (ans * 2) % mod;
            }
        } else {
            cin >> u >> v;
            u--, v--;
            if (Unite(u, v)) {
                subset.push_back(i + 1);
                ans = (ans * 2) % mod;
            }
        }
    }

    cout << ans << " " << subset.size() << endl;
    for (int i = 0; i < subset.size(); i++) {
        cout << subset[i] << " \n"[i == subset.size() - 1];
    }
}

int32_t main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int testcases = 1;
    // cin >> testcases;

    for (int i = 1; i <= testcases; i++) {
        Solve();
    }
    return 0;
}