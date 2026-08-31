#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  int n, m;
  cin >> n >> m;
  vector<vector<int>> vs(n + 1);
  vector<int> perm(n + 1), test(n + 1);
  for (int i = 1; i <= n; i++) {
    int x;
    cin >> x;
    perm[x] = i;
  }
  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;
    u = perm[u];
    v = perm[v];
    vs[v].push_back(u);
  }
  for (int i = 1; i <= n; i++) sort(vs[i].begin(), vs[i].end());
  int cnt = 0;
  vector<int> cur(vs[n].begin(), vs[n].end());
  for (int i = n - 1; i >= 1; i--) {
    if (binary_search(cur.begin(), cur.end(), i))
      cnt += 1;
    else {
      vector<int> temp;
      for (auto e : cur)
        if (binary_search(vs[i].begin(), vs[i].end(), e)) temp.push_back(e);
      cur = vector<int>(temp.begin(), temp.end());
    }
  }
  cout << cnt << endl;
}
