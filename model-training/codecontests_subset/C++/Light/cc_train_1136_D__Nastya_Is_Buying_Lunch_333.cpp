#include <bits/stdc++.h>
using namespace std;
const int sz = 3e5 + 5;
int n, m, q[sz] = {0};
vector<int> sw[sz];
int main() {
  cin >> n >> m;
  for (int i = 0; i < n; i++) cin >> q[i];
  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;
    sw[u].push_back(v);
  }
  int steps = 0;
  set<int> s;
  s.insert(q[n - 1]);
  for (int i = n - 2; i >= 0; i--) {
    int u = q[i], cnt = 0;
    for (int j = 0; j < sw[u].size(); j++)
      if (s.find(sw[u][j]) != s.end()) cnt++;
    if (cnt == s.size())
      steps++;
    else
      s.insert(u);
  }
  cout << steps << endl;
  return 0;
}
