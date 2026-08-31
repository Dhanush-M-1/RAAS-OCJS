#include <bits/stdc++.h>
using namespace std;
const int MAXN = 200000 + 7;
long long int t[2][MAXN], c[MAXN], d[MAXN], a, b;
int n, k, q;
int lowbit(int x) { return x & (-x); }
void add(int v, int x, long long int val) {
  for (int i = x; i <= n; i += lowbit(i)) t[v][i] += val;
}
long long int getsum(int v, int x) {
  long long int sum = 0;
  for (int i = x; i >= 1; i -= lowbit(i)) sum += t[v][i];
  return sum;
}
int main() {
  scanf("%d%d%lld%lld%d", &n, &k, &a, &b, &q);
  int s, x, y;
  for (int i = 1; i <= q; i++) {
    scanf("%d", &s);
    if (s == 1) {
      scanf("%d%d", &x, &y);
      long long int pre = c[x];
      c[x] += y;
      long long int X = min(c[x], a) - min(pre, a);
      long long int Y = min(c[x], b) - min(pre, b);
      if (Y) add(0, x, Y);
      if (X) add(1, x, X);
    } else {
      scanf("%d", &x);
      long long int sum =
          getsum(0, x - 1) - getsum(0, 0) + getsum(1, n) - getsum(1, x + k - 1);
      printf("%lld\n", sum);
    }
  }
}
