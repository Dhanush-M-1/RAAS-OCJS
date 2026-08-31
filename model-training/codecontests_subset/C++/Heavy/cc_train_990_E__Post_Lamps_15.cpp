#include <bits/stdc++.h>
using namespace std;
const int inf = 1e9;
const long long INF = 1e18;
const int maxn = 1000010;
bool pos[maxn];
int lst[maxn], a[maxn], s[maxn];
int n, m, k;
int work(int l) {
  int r = 0, i = -1, ret = 0;
  while (r < n) {
    if (lst[r] <= i) return inf;
    i = lst[r];
    r = lst[r] + l;
    ret++;
  }
  return ret;
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= m; i++) scanf("%d", &s[i]);
  for (int i = 1; i <= k; i++) scanf("%d", &a[i]);
  memset(pos, 0, sizeof(pos));
  for (int i = 1; i <= m; i++) pos[s[i]] = true;
  for (int i = 0; i < n; i++) {
    if (!pos[i])
      lst[i] = i;
    else if (i)
      lst[i] = lst[i - 1];
    else
      lst[i] = -1;
  }
  long long ans = INF;
  for (int i = 1; i <= k; i++) {
    long long t = work(i);
    if (t != inf) ans = min(ans, a[i] * t);
  }
  printf("%lld\n", ans == INF ? -1 : ans);
  return 0;
}
