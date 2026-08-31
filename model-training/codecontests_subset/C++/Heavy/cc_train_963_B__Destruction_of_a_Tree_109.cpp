#include <bits/stdc++.h>
using namespace std;
int n;
int p[200002];
vector<int> ke[200002];
bool mark[200002];
bool dfs(int u, int p) {
  int cnt = 0;
  for (int v : ke[u]) {
    if (v == p) continue;
    if (dfs(v, u)) cnt++;
  }
  if (cnt % 2 == 0) {
    return mark[u] = true;
  }
  return mark[u] = false;
}
void dfs2(int u, int p) {
  for (int v : ke[u]) {
    if (v == p) continue;
    if (!mark[v]) {
      dfs2(v, u);
    }
  }
  cout << u << "\n";
  for (int v : ke[u]) {
    if (v == p) continue;
    if (mark[v]) {
      dfs2(v, u);
    }
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n;
  for (long long i = 1; i <= n; i++) {
    cin >> p[i];
    if (p[i]) {
      ke[i].push_back(p[i]);
      ke[p[i]].push_back(i);
    }
  }
  if (dfs(1, 1)) {
    cout << "YES\n";
    dfs2(1, 1);
  } else {
    cout << "NO";
  }
}
