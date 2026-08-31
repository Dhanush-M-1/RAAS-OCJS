#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
const double PI = acos(-1);
int n, i, j, k, t;
vector<int> adj[200002], ans;
bool deleted[200002];
int sz[200002];
void dfs(int v, int p) {
  for (int x : adj[v]) {
    if (x == p) continue;
    if (sz[x] % 2 == 0) {
      dfs(x, v);
      deleted[x] = true;
    }
  }
  ans.push_back(v);
  for (int x : adj[v]) {
    if (x == p || deleted[x]) continue;
    dfs(x, v);
  }
}
void getsz(int v, int p) {
  sz[v] = 1;
  for (int x : adj[v]) {
    if (x == p) continue;
    getsz(x, v);
    sz[v] += sz[x];
  }
}
int main() {
  memset(deleted, false, sizeof deleted);
  scanf("%d", &n);
  for (i = 1; i <= n; ++i) {
    scanf("%d", &t);
    if (t) {
      adj[t].push_back(i);
      adj[i].push_back(t);
    }
  }
  if (n % 2 == 0) {
    puts("NO");
    return 0;
  }
  getsz(1, 1);
  dfs(1, 1);
  puts("YES");
  for (int x : ans) printf("%d\n", x);
  return 0;
}
