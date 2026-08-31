#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
const long long inf = 3e18 + 5;
int add(int a, int b) { return (a += b) < mod ? a : a - mod; }
int mul(int a, int b) { return 1LL * a * b % mod; }
const int mxn = 3e5 + 5;
int a[mxn], cnt[mxn];
vector<int> g[mxn];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;
    g[v].push_back(u);
  }
  int res = 0;
  for (int i = n - 1; i >= 0; i--) {
    for (int u : g[a[i]]) cnt[u]++;
    if (i != n - 1) {
      if (cnt[a[i]] >= n - 1 - i - res) {
        for (int u : g[a[i]]) cnt[u]--;
        res++;
      }
    }
  }
  cout << res;
}
