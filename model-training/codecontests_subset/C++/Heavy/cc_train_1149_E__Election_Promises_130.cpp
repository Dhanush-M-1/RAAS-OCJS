#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10, mod = 1e9 + 7;
const long long inf = 1e18;
int a[maxn];
bool mark[maxn];
vector<int> v[maxn], vec;
vector<int> vv[maxn];
int p[maxn], xr[maxn], C;
void dfs(int u) {
  mark[u] = 1;
  for (int y : v[u]) {
    if (!mark[y]) dfs(y);
  }
  vec.push_back(u);
}
void add(int u) {
  for (int y : v[u]) {
    mark[p[y]] = 1;
  }
  for (int i = 0; i <= C; i++) {
    if (mark[i] == 0) {
      p[u] = i;
      vv[i].push_back(u);
      xr[i] ^= a[u];
      if (i == C) C++;
      break;
    }
  }
  for (int y : v[u]) {
    mark[p[y]] = 0;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
  }
  for (int i = 0; i < m; i++) {
    int x, y;
    cin >> x >> y;
    v[x].push_back(y);
  }
  for (int i = 1; i <= n; i++) {
    if (!mark[i]) dfs(i);
  }
  memset(mark, 0, sizeof mark);
  for (int i = 0; i < n; i++) {
    add(vec[i]);
  }
  int lst = -1;
  for (int i = 0; i < C; i++) {
    if (xr[i] != 0) lst = i;
  }
  if (lst == -1) return cout << "LOSE\n", 0;
  int bt = 31 - __builtin_clz(xr[lst]), who = 0;
  for (int u : vv[lst]) {
    if ((((a[u]) >> (bt)) & 1)) {
      who = u;
    }
  }
  assert(who != -1);
  a[who] ^= xr[lst];
  for (int y : v[who]) {
    if (mark[p[y]]) continue;
    mark[p[y]] = 1;
    a[y] ^= xr[p[y]];
  }
  cout << "WIN\n";
  for (int i = 1; i <= n; i++) {
    cout << a[i] << " ";
  }
  return cout << endl, 0;
}
