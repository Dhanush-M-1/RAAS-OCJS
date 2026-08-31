#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 5;
int n, p[maxn], r;
vector<int> ad[maxn];
vector<int> re;
bool ok[maxn];
void dfs2(int u) {
  ok[u] = true;
  re.push_back(u);
  for (auto v : ad[u])
    if (!ok[v]) {
      dfs2(v);
    }
}
bool dfs(int u) {
  int x = 0;
  for (auto v : ad[u]) {
    if (dfs(v)) x++;
  }
  int y = x + ad[u].size() + 1;
  if (u == r) y--;
  if (y % 2)
    return false;
  else {
    dfs2(u);
    return true;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> n;
  for (int i = 1; i < n + 1; ++i) {
    cin >> p[i];
    if (p[i]) {
      ad[p[i]].push_back(i);
    } else
      r = i;
  }
  dfs(r);
  if (re.size() == n) {
    cout << "YES\n";
    for (auto x : re) cout << x << endl;
  } else
    cout << "NO";
  return 0;
}
