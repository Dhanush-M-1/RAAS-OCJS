#include <bits/stdc++.h>
using namespace std;
const int N = 200000 + 10;
int n, k, a, b;
int A[N], B[N];
long long ft[2][N];
int LSOne(int b) { return b & (-b); }
long long rsq(int b, int idx) {
  if (b <= 0) return 0;
  long long s = 0;
  for (; b; b -= LSOne(b)) s += ft[idx][b];
  return s;
}
void adjust(int p, int v, int idx) {
  for (; p <= n; p += LSOne(p)) ft[idx][p] += v;
}
int main(int argc, char *args[]) {
  int q;
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &q);
  int t, x, y;
  while (q--) {
    scanf("%d", &t);
    if (t == 1) {
      scanf("%d%d", &x, &y);
      if (B[x] < b) {
        int tmp = min(b - B[x], y);
        B[x] += tmp;
        adjust(x, tmp, 0);
      }
      if (A[x] < a) {
        int tmp = min(a - A[x], y);
        A[x] += tmp;
        adjust(x, tmp, 1);
      }
      continue;
    }
    scanf("%d", &x);
    long long ans = rsq(n, 1) - rsq(x + k - 1, 1) + rsq(x - 1, 0);
    printf("%lld\n", ans);
  }
  return 0;
}
