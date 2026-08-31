#include <bits/stdc++.h>
using namespace std;
int n, m, cnt = 1, p[300010], good[300010];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  cin >> n >> m;
  vector<vector<int>> s(n);
  for (int i = 0; i < n; ++i) cin >> p[i];
  for (int i = 0; i < m; ++i) {
    int u, v;
    cin >> u >> v;
    s[v - 1].push_back(u - 1);
  }
  for (int i = 0; i < s[p[n - 1] - 1].size(); ++i) ++good[s[p[n - 1] - 1][i]];
  for (int i = n - 1 - 1; i >= 0; --i)
    if (good[p[i] - 1] != cnt) {
      for (int j = 0; j < s[p[i] - 1].size(); ++j) ++good[s[p[i] - 1][j]];
      ++cnt;
    }
  cout << n - cnt << endl;
}
