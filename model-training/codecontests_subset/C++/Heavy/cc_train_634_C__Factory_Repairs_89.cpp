#include <bits/stdc++.h>
using namespace std;
int sum1[200005], sum2[200005], n, a1[200005], a2[200005];
void u1(int idx, int x) {
  while (idx <= n) {
    sum1[idx] += x;
    idx += idx & (-idx);
  }
  return;
}
int qu1(int idx) {
  int ret = 0;
  while (idx > 0) {
    ret += sum1[idx];
    idx -= idx & (-idx);
  }
  return ret;
}
void u2(int idx, int x) {
  while (idx <= n) {
    sum2[idx] += x;
    idx += idx & (-idx);
  }
  return;
}
int qu2(int idx) {
  int ret = 0;
  while (idx > 0) {
    ret += sum2[idx];
    idx -= idx & (-idx);
  }
  return ret;
}
int main() {
  int i, j, k, l, m, q, a, b, tot = 0, idx, x, ans;
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  for (i = 1; i <= q; i++) {
    scanf("%d", &l);
    if (l == 1) {
      scanf("%d %d", &idx, &x);
      if (a1[idx] + x > b) {
        u1(idx, b - a1[idx]);
      } else
        u1(idx, x);
      a1[idx] = min(a1[idx] + x, b);
      if (a2[idx] + x > a) {
        u2(idx, a - a2[idx]);
      } else
        u2(idx, x);
      a2[idx] = min(a2[idx] + x, a);
    }
    if (l == 2) {
      scanf("%d", &idx);
      ans = qu1(idx - 1);
      j = idx + k - 1;
      ans += qu2(n) - qu2(j);
      printf("%d\n", ans);
    }
  }
  return 0;
}
