#include <bits/stdc++.h>
#pragma disable : 4996)
using namespace std;
const int inf = 0x7f7f7f7f;
const long long mod = 1e9 + 7;
int a[510000], cnt[510000];
vector<int> g[510000];
void add(int u) {
  for (auto v : g[u]) cnt[v]++;
}
int main() {
  ios_base::sync_with_stdio(false);
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; i++) cin >> a[i];
  for (int i = 1; i <= m; i++) {
    int u, v;
    cin >> u >> v;
    g[v].push_back(u);
  }
  int ans = 0;
  add(a[n]);
  for (int i = n - 1; i >= 1; i--) {
    if (cnt[a[i]] == n - i - ans)
      ans++;
    else
      add(a[i]);
  }
  cout << ans << endl;
}
