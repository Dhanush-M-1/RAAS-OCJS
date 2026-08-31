#include <bits/stdc++.h>
using namespace std;
int c[200005], d[200005];
int n, k, a, b, q;
int w[200005], w1[200005];
void add(int i, int x) {
  for (; i <= n + 1; c[i] += x, i += i & -i)
    ;
}
void add1(int i, int x) {
  for (; i <= n + 1; d[i] += x, i += i & -i)
    ;
}
int sum(int i) {
  int s = 0;
  for (; i > 0; s += c[i], i -= i & -i)
    ;
  return s;
}
int sum1(int i) {
  int s = 0;
  for (; i > 0; s += d[i], i -= i & -i)
    ;
  return s;
}
int main() {
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &q);
  while (q--) {
    int op;
    scanf("%d", &op);
    if (op == 1) {
      int p, x;
      scanf("%d%d", &p, &x);
      if (w[p]) add(p, -w[p]);
      if (w1[p]) add1(p, -w1[p]);
      w[p] += x;
      w1[p] += x;
      w[p] = min(b, w[p]);
      w1[p] = min(a, w1[p]);
      add(p, w[p]);
      add1(p, w1[p]);
    } else {
      int p;
      scanf("%d", &p);
      printf("%d\n", sum1(n) - sum1(p + k - 1) + sum(p - 1) - sum(0));
    }
  }
  return 0;
}
