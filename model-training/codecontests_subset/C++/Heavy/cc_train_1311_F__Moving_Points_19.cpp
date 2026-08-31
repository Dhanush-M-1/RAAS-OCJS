#include <bits/stdc++.h>
using namespace std;
using LL = long long;
struct Point {
  LL x, v;
  bool operator<(const Point &rhs) const {
    if (v == rhs.v)
      return x < rhs.x;
    else
      return v < rhs.v;
  }
};
Point p[200010];
LL n, x2[200010], idx[200010], c[200010], s[200010];
void update(LL *arr, LL pos, LL val) {
  for (LL i = pos; i <= n; i += i & (-i)) arr[i] += val;
}
LL query(LL *arr, LL pos) {
  LL res = 0;
  for (LL i = pos; i; i -= i & (-i)) res += arr[i];
  return res;
}
int main() {
  scanf("%lld", &n);
  for (LL i = 1; i <= n; i++) scanf("%lld", &p[i].x);
  for (LL i = 1; i <= n; i++) scanf("%lld", &p[i].v);
  for (LL i = 1; i <= n; i++) idx[i] = i;
  sort(p + 1, p + n + 1);
  sort(idx + 1, idx + n + 1, [](LL i, LL j) { return p[i].x < p[j].x; });
  for (LL i = 1; i <= n;) {
    LL j;
    for (j = i; j <= n; j++)
      if (p[idx[j]].x != p[idx[i]].x)
        break;
      else
        x2[idx[j]] = i;
    i = j;
  }
  LL ans = 0;
  for (LL i = 1; i <= n; i++) {
    ans += p[i].x * query(c, x2[i]) - query(s, x2[i]);
    update(c, x2[i], 1);
    update(s, x2[i], p[i].x);
  }
  printf("%lld\n", ans);
  return 0;
}
