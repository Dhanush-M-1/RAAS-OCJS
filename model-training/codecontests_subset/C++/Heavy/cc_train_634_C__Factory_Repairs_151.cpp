#include <bits/stdc++.h>
using namespace std;
#pragma comment(linker, "/STACK:1024000000,1024000000")
long long powmod(long long a, long long b) {
  long long res = 1;
  a %= 1000000007;
  for (; b; b >>= 1) {
    if (b & 1) res = res * a % 1000000007;
    a = a * a % 1000000007;
  }
  return res;
}
int gcd(int x, int y) {
  while (y) {
    int t = x % y;
    x = y;
    y = t;
  }
  return x;
}
int sum[200010], n;
struct bit {
  int c[200010];
  bit() { memset(c, 0, sizeof c); }
  void add(int x, int v) {
    for (int i = x; i <= n; i += ((i) & (-i))) c[i] += v;
  }
  int query(int x) {
    int res = 0;
    for (int i = x; i; i -= ((i) & (-i))) res += c[i];
    return res;
  }
} s[2];
int main() {
  int k, a, b, q;
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &q);
  for (int i = 0; i < q; i++) {
    int typ, d, p;
    scanf("%d", &typ);
    if (typ == 1) {
      scanf("%d%d", &d, &p);
      int x = max(b - sum[d], 0);
      int y = max(a - sum[d], 0);
      s[1].add(d, min(y, p));
      s[0].add(d, min(x, p));
      sum[d] += p;
    } else {
      scanf("%d", &d);
      int ans1 = s[0].query(d - 1);
      int now = min(n, d + k - 1);
      int ans2 = s[1].query(n) - s[1].query(now);
      printf("%d\n", ans1 + ans2);
    }
  }
  return 0;
}
