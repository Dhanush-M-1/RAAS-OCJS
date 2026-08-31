#include <bits/stdc++.h>
using namespace std;
const int N = 1000006;
int n, k, p[N];
vector<int> g[N];
int st[N], pt;
int cnt[N];
int prec(int u) {
  st[pt++] = u;
  int ans = N;
  for (int v : g[u]) ans = min(ans, prec(v));
  if (g[u].empty()) cnt[u] = 1, ans = max(0, pt - k - 1);
  if (ans < pt - 1) cnt[st[ans]] += cnt[u], cnt[u] = 0;
  pt--;
  return ans;
}
int f(int u) {
  int ans = 0;
  for (int v : g[u]) ans = max(ans, f(v));
  return ans + cnt[u];
}
int main() {
  scanf("%d %d", &n, &k);
  for (int i = 2; i <= n; i++) {
    scanf("%d", p + i);
    g[p[i]].push_back(i);
  }
  prec(1);
  printf("%d\n", f(1));
}
