#include <bits/stdc++.h>
using namespace std;
int n, m, d[200005], k, res, vs[200005], ans[200005], pa;
map<int, int> cnt[200005];
vector<int> ke[200005];
pair<int, int> a[200005];
void dfs(int u) {
  d[u]--;
  res--;
  vs[u] = 1;
  for (int v : ke[u])
    if (vs[v] == 0) {
      cnt[u][v] = cnt[v][u] = 1;
      d[v]--;
      if (d[v] < k) {
        d[v]++;
        dfs(v);
      }
    }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0), cout.tie(0);
  cin >> n >> m >> k;
  res = n;
  for (int i = 1; i <= m; i++) {
    cin >> a[i].first >> a[i].second;
    d[a[i].first]++;
    d[a[i].second]++;
    ke[a[i].first].push_back(a[i].second);
    ke[a[i].second].push_back(a[i].first);
  }
  for (int i = 1; i <= n; i++)
    if (d[i] < k && vs[i] == 0) dfs(i);
  for (int i = m; i >= 1; i--) {
    ans[i] = res;
    ke[a[i].first].pop_back();
    ke[a[i].second].pop_back();
    if (cnt[a[i].first][a[i].second] == 1) continue;
    if (vs[a[i].first] == 0) {
      d[a[i].first]--;
      if (d[a[i].first] < k) {
        d[a[i].first]++;
        dfs(a[i].first);
      }
    }
    if (vs[a[i].second] == 0) {
      d[a[i].second]--;
      if (d[a[i].second] < k) {
        d[a[i].second]++;
        dfs(a[i].second);
      }
    }
  }
  for (int i = 1; i <= m; i++) cout << ans[i] << '\n';
}
