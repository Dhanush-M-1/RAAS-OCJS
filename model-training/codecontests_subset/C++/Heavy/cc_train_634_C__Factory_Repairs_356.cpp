#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10;
long long c[2][maxn];
int lowbit(int s) { return s & (-s); }
void modify(int op, int i, long long x) {
  while (i < maxn) c[op][i] += x, i += lowbit(i);
  return;
}
long long query(int op, int i) {
  long long ret = 0LL;
  while (i > 0) ret += c[op][i], i -= lowbit(i);
  return ret;
}
int main(void) {
  int n, k, a, b, q;
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  while (q--) {
    int op, x, y;
    scanf("%d", &op);
    if (op == 1) {
      scanf("%d %d", &x, &y);
      modify(0, x, min(a - query(0, x) + query(0, x - 1), (long long)y));
      modify(1, x, min(b - query(1, x) + query(1, x - 1), (long long)y));
    } else {
      scanf("%d", &x);
      printf("%I64d\n", query(1, x - 1) + query(0, n) - query(0, x + k - 1));
    }
  }
  return 0;
}
