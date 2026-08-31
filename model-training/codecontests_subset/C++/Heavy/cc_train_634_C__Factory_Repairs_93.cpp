#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
const long long infLL = 0x3f3f3f3f3f3f3f3fLL;
const int maxn = 200000 + 5;
int n, k, A, B, q;
int a[maxn], b[maxn];
int c[2][maxn];
void update(int o, int i, int v) {
  for (; i <= n; i += i & -i) c[o][i] += v;
}
int query(int o, int i) {
  int ret = 0;
  for (; i; i -= i & -i) ret += c[o][i];
  return ret;
}
int main() {
  scanf("%d%d%d%d%d", &n, &k, &A, &B, &q);
  while (q--) {
    int op, i, d;
    scanf("%d", &op);
    if (op == 1) {
      scanf("%d%d", &i, &d);
      if (a[i] + d < A)
        update(0, i, d), a[i] += d;
      else
        update(0, i, A - a[i]), a[i] = A;
      if (b[i] + d < B)
        update(1, i, d), b[i] += d;
      else
        update(1, i, B - b[i]), b[i] = B;
    } else {
      scanf("%d", &i);
      printf("%d\n", query(0, n) - query(0, i + k - 1) + query(1, i - 1));
    }
  }
  return 0;
}
