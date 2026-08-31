#include <bits/stdc++.h>
using namespace std;
struct node {
  int loc, v;
} a[200010];
int n, m, b[200010];
long long c[200010], e[200010];
int cmp(node a, node b) { return a.loc < b.loc; }
int lowbit(int x) { return x & -x; }
void update(int pos, int delta, long long *d) {
  for (int i = pos; i <= n; i += lowbit(i)) d[i] += delta;
}
long long sum(int pos, long long *d) {
  long long ret = 0;
  for (int i = pos; i > 0; i -= lowbit(i)) ret += d[i];
  return ret;
}
int main() {
  int i;
  long long ans = 0;
  scanf("%d", &n);
  for (i = 1; i <= n; i++) scanf("%d", &a[i].loc);
  for (i = 1; i <= n; i++) scanf("%d", &a[i].v), b[i] = a[i].v;
  sort(b + 1, b + 1 + n);
  m = unique(b + 1, b + 1 + n) - (b + 1);
  for (i = 1; i <= n; i++) a[i].v = lower_bound(b + 1, b + 1 + m, a[i].v) - b;
  sort(a + 1, a + 1 + n, cmp);
  for (i = 1; i <= n; i++) {
    ans += abs(sum(a[i].v, e) - sum(a[i].v, c) * a[i].loc);
    update(a[i].v, 1, c), update(a[i].v, a[i].loc, e);
  }
  printf("%lld\n", ans);
  return 0;
}
