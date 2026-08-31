#include <bits/stdc++.h>
using namespace std;
const int maxn = 100009;
vector<int> e[maxn];
long long b[maxn], a[maxn], fa[maxn], t[maxn];
long long n;
void dfs(int u, long long mx) {
  for (int i = 0; i < e[u].size(); i++) dfs(e[u][i], mx + b[u]);
  if (a[u] - b[u] > mx) {
    puts("NO");
    exit(0);
  }
  if (b[u] < a[u])
    b[fa[u]] -= t[u] * (a[u] - b[u]);
  else
    b[fa[u]] += b[u] - a[u];
}
int main() {
  scanf("%I64d", &n);
  for (int i = 1; i <= n; i++) scanf("%I64d", &b[i]);
  for (int i = 1; i <= n; i++) scanf("%I64d", &a[i]);
  for (int i = 2; i <= n; i++) {
    scanf("%I64d%I64d", &fa[i], &t[i]);
    e[fa[i]].push_back(i);
  }
  dfs(1, 0);
  puts(b[0] >= 0 ? "YES" : "NO");
  return 0;
}
