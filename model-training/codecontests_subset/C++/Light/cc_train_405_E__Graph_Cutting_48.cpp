#include <bits/stdc++.h>
using namespace std;
const long long inf = 2e18;
const long long mod = 1e9 + 7;
const double Pi = acos(-1);
int n, m;
set<int> v[100009];
int dfs(int node) {
  vector<int> out;
  while (v[node].size()) {
    int u = *v[node].begin();
    v[node].erase(u);
    v[u].erase(node);
    int ret = dfs(u);
    if (ret != -1) {
      cout << node + 1 << " " << u + 1 << " " << ret + 1 << endl;
    } else {
      out.push_back(u);
    }
  }
  for (int i = (out.size()) % 2; i < out.size(); i += 2) {
    cout << out[i] + 1 << " " << node + 1 << " " << out[i + 1] + 1 << endl;
  }
  return (out.size() % 2 ? out[0] : -1);
}
int main() {
  cin >> n >> m;
  for (int i = 0; i < m; i++) {
    int a, b;
    cin >> a >> b;
    a--, b--;
    v[a].insert(b);
    v[b].insert(a);
  }
  if (m % 2) {
    cout << "No solution" << endl;
    return 0;
  }
  dfs(0);
}
