#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  vector<int> p;
  for (int i = 0; i < n; i++) {
    int temp;
    cin >> temp;
    p.push_back(temp);
  }
  vector<int> edges[n + 1];
  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;
    edges[u].push_back(v);
  }
  set<int, greater<int> > s;
  int ans = 0;
  s.insert(p[n - 1]);
  for (int i = n - 2; i > -1; i--) {
    bool flag = false;
    for (auto j = s.begin(); j != s.end(); j++) {
      if (find(edges[p[i]].begin(), edges[p[i]].end(), *j) ==
          edges[p[i]].end()) {
        flag = true;
        break;
      }
    }
    if (flag) {
      s.insert(p[i]);
    } else {
      ans++;
    }
  }
  cout << ans << endl;
  return 0;
}
