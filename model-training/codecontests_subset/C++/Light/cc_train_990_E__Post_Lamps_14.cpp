#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
int n, m, k;
long long ans;
bool e[1000001];
int pre[1000001];
struct light {
  int l, cost;
  double c;
} s[1000001];
bool cmp(light a, light b) { return a.c > b.c; }
int dfs(int p, int sum, int l) {
  int np = p + l;
  if (np >= n) return sum + 1;
  np = pre[np];
  if (np == p)
    return -1;
  else
    return dfs(np, sum + 1, l);
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  ans = -1;
  memset(e, false, sizeof(e));
  for (int i = 0; i < m; i++) {
    int a;
    scanf("%d", &a);
    e[a] = true;
  }
  for (int i = 1; i < n; i++) {
    if (e[i])
      pre[i] = pre[i - 1];
    else
      pre[i] = i;
  }
  for (int i = 0; i < k; i++) {
    s[i].l = i + 1;
    scanf("%d", &s[i].cost);
    s[i].c = (double)((double)s[i].l / (double)s[i].cost);
  }
  if (e[0]) {
    printf("-1\n");
    return 0;
  }
  for (int i = 0; i < k; i++) {
    int t = dfs(0, 0, s[i].l);
    if (t == -1) continue;
    long long tt = (long long)((long long)s[i].cost * (long long)t);
    if (ans == -1) {
      ans = tt;
    } else {
      ans = min(ans, tt);
    }
  }
  if (ans != -1)
    printf("%I64d\n", ans);
  else
    printf("-1\n");
  return 0;
}
