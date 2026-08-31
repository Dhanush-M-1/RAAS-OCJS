#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  int n, m;
  cin >> n >> m;
  vector<vector<int> > d(n + 1, vector<int>());
  vector<int> order(n);
  set<int> good;
  vector<int> cnt(n + 1, 0);
  for (int i = 0; i < n; i++) {
    cin >> order[i];
  }
  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;
    if (v == order[n - 1])
      good.insert(u);
    else
      d[v].push_back(u);
  }
  int ans = 0;
  int k = 0;
  for (int i = n - 2; i > -1; i--) {
    if (good.find(order[i]) != good.end() and cnt[order[i]] >= k) {
      ans++;
    } else {
      k++;
      for (int j = 0; j < d[order[i]].size(); j++) {
        cnt[d[order[i]][j]]++;
      }
    }
  }
  cout << ans;
  return 0;
}
