#include <bits/stdc++.h>
using namespace std;
const int oo = 999999999;
const double PI = 3.1415931;
const double eps = 1e-9;
const int maxN = 10000;
int n, m;
bool mark[maxN];
int adj[maxN];
int deg[maxN];
int dfs(int x) {
  if (x == 0) return 0;
  if (x == m)
    return maxN;
  else
    return dfs(adj[x]) + 1;
}
int main() {
  ios_base::sync_with_stdio(false);
  int n;
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    int x;
    cin >> x;
    if (x) {
      adj[i] = x;
      deg[x]++;
    }
  }
  int ans = dfs(adj[m]);
  ans++;
  vector<int> q;
  for (int i = 1; i <= n; i++) {
    if (deg[i] == 0) {
      if (dfs(i) < maxN) q.push_back(dfs(i));
    }
  }
  mark[ans] = true;
  for (int i = 0; i < q.size(); i++) {
    vector<int> v;
    for (int j = 0; j < 1001; j++) {
      if (mark[j]) v.push_back(j + q[i]);
    }
    for (int j = 0; j < v.size(); j++) mark[v[j]] = true;
  }
  for (int i = 1; i <= n; i++)
    if (mark[i]) cout << i << endl;
  return 0;
}
