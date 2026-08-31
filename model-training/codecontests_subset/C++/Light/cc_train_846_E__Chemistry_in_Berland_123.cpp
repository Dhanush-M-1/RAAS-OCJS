#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
const double pi = acos(-1);
int n, i, j, k, t;
long double a[100004], b[100004], val[100003];
int x[100004], c[100003];
vector<int> adj[100005];
int par[100003];
bool bisa = true;
void dfs(int v, int p) {
  val[v] = b[v] - a[v];
  for (int x : adj[v]) {
    if (x != p) {
      dfs(x, v);
      if (val[x] > 0)
        val[v] += val[x];
      else
        val[v] += val[x] * c[x];
    }
  }
  if (val[v] < 0 && fabsl(val[v]) > 1e17L / c[v]) {
    puts("NO");
    exit(0);
  }
}
int main() {
  scanf("%d", &n);
  for (i = 1; i <= n; ++i) scanf("%Lf", b + i);
  for (i = 1; i <= n; ++i) scanf("%Lf", a + i);
  for (i = 2; i <= n; ++i) {
    scanf("%d %d", x + i, c + i);
    adj[x[i]].push_back(i);
    adj[i].push_back(x[i]);
  }
  dfs(1, 1);
  puts(val[1] >= 0 ? "YES" : "NO");
  return 0;
}
