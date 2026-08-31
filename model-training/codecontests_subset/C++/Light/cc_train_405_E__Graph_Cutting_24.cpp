#include <bits/stdc++.h>
using namespace std;
const int G = 1000 * 100 + 10;
vector<pair<int, int> > e[G];
bool visited[G];
int solve(int v) {
  vector<int> remain;
  for (int i = 0; i < e[v].size(); i++) {
    int u = e[v][i].first, z;
    if (!visited[e[v][i].second]) {
      visited[e[v][i].second] = true;
      z = solve(u);
      if (z)
        cout << z << ' ' << u << ' ' << v << '\n';
      else
        remain.push_back(u);
    }
  }
  while (remain.size() > 1) {
    cout << remain.back() << ' ' << v << ' ';
    remain.pop_back();
    cout << remain.back() << '\n';
    remain.pop_back();
  }
  if (remain.size())
    return remain[0];
  else
    return 0;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n, m, a, b, root;
  cin >> n >> m;
  for (int i = 1; i <= m; i++) {
    cin >> a >> b;
    e[a].push_back({b, i});
    e[b].push_back({a, i});
    if (e[a].size() > 1) root = a;
    if (e[b].size() > 1) root = b;
  }
  if (m % 2) {
    cout << "No solution" << endl;
    return 0;
  }
  solve(root);
  return 0;
}
