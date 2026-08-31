#include <bits/stdc++.h>
using namespace std;
long long mod = 1e9 + 7;
long long mincnst = 1e18 + 1;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long i, j;
  long long n, m, u, v;
  cin >> n >> m;
  long long p[n];
  for (i = 0; i < n; i++) cin >> p[i];
  long long ans = 0;
  set<long long> st;
  vector<set<long long>> adj(1000005);
  for (i = 0; i < m; i++) {
    cin >> u >> v;
    adj[u].insert(v);
  }
  long long flg = 0;
  st.insert(p[n - 1]);
  for (i = n - 2; i > -1; i--) {
    flg = 0;
    if (!adj[p[i]].size()) {
      flg = 1;
    } else {
      for (auto it : st) {
        if (!adj[p[i]].count(it)) {
          flg = 1;
          break;
        }
      }
    }
    if (flg)
      st.insert(p[i]);
    else {
      ans++;
    }
  }
  cout << ans << "\n";
}
