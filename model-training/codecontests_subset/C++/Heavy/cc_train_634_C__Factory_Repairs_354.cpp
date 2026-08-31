#include <bits/stdc++.h>
const int maxn = 200007;
int low[maxn], high[maxn], val[maxn], n;
void update(int bit[], int k, int c) {
  for (; k <= n; k += -k & k) {
    bit[k] += c;
  }
}
int sum(int bit[], int k) {
  int ret = 0;
  for (; k; k -= -k & k) {
    ret += bit[k];
  }
  return ret;
}
int main() {
  int k, a, b, q, op, l, r, x;
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  for (int i = 0; i < q; i++) {
    scanf("%d", &op);
    if (op == 1) {
      scanf("%d %d", &l, &x);
      update(low, l, -1 * std::min(val[l], b));
      update(high, l, -1 * std::min(val[l], a));
      val[l] += x;
      update(low, l, std::min(val[l], b));
      update(high, l, std::min(val[l], a));
    } else {
      scanf("%d", &l);
      r = l + k - 1;
      int ans = sum(low, l - 1) + sum(high, n) - sum(high, r);
      printf("%d\n", ans);
    }
  }
}
