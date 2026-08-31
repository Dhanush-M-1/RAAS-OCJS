#include <bits/stdc++.h>
using namespace std;
long long s[200010], ba[200010], bb[200010];
void add(long long *b, int p, long long x) {
  while (p < 200010) {
    b[p] += x;
    p += p & -p;
  }
}
long long sum(long long *b, int p) {
  long long res = 0;
  while (p > 0) {
    res += b[p];
    p -= p & -p;
  }
  return res;
}
int main() {
  int n, k, a, b, m, q, d, c;
  long long t;
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &m);
  while (m--) {
    scanf("%d", &q);
    if (q == 1) {
      scanf("%d%d", &d, &c);
      t = min(s[d] + c, 1ll * b) - s[d];
      if (t > 0) {
        add(bb, d, t);
      }
      t = min(s[d] + c, 1ll * a) - s[d];
      if (t > 0) {
        add(ba, d, t);
      }
      s[d] += c;
    } else {
      scanf("%d", &d);
      printf("%I64d\n", sum(bb, d - 1) - sum(ba, d + k - 1) + sum(ba, n));
    }
  }
  return 0;
}
