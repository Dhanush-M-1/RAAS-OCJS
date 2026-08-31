#include <bits/stdc++.h>
using namespace std;
const int N = 200010;
int a, b, n, m, len;
long long cnt[N];
long long sum[N];
int lowbit(int x) { return x & (-x); }
void add(int x, int v) {
  for (; x <= n; x += lowbit(x)) cnt[x] += v;
}
void add(int l, int r, int v) {
  if (l > r) return;
  add(l, v);
  add(r + 1, -v);
}
long long query(int x) {
  long long ret = 0;
  for (; x; x -= lowbit(x)) ret += cnt[x];
  return ret;
}
int main() {
  scanf("%d%d%d%d%d", &n, &len, &a, &b, &m);
  while (m--) {
    int opt;
    scanf("%d", &opt);
    if (opt == 1) {
      int d;
      long long val;
      scanf("%d%I64d", &d, &val);
      int v1 = min(val, max(0ll, a - sum[d]));
      add(1, d - len, v1);
      int v2 = min(val, max(0ll, b - sum[d]));
      add(d + 1, n, v2);
      sum[d] += val;
    } else {
      int x;
      scanf("%d", &x);
      long long ans = query(x);
      printf("%I64d\n", ans);
    }
  }
  return 0;
}
