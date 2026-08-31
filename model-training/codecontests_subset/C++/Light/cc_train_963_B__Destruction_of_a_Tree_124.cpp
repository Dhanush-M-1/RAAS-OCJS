#include <bits/stdc++.h>
using namespace std;
int n, d[200005], a[200005], id[200005], t;
vector<int> g[200005];
void dfs(int v, int p) {
  t++;
  id[t] = v;
  for (int i = 0; i < g[v].size(); i++) {
    int to = g[v][i];
    if (to == p) continue;
    dfs(to, v);
  }
  if (d[v] % 2 == 0) {
    cout << v << endl;
    d[p]--;
    a[v] = 1;
  }
}
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    int p;
    cin >> p;
    if (p) {
      g[i].push_back(p);
      g[p].push_back(i);
      d[i]++;
      d[p]++;
    }
  }
  if (n % 2 == 0) {
    cout << "NO" << endl;
    return 0;
  }
  cout << "YES" << endl;
  dfs(1, 0);
  for (int i = 1; i <= n; i++)
    if (!a[id[i]]) cout << id[i] << endl;
  return 0;
}
