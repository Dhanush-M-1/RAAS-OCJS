#include <bits/stdc++.h>
using namespace std;
int n, k, a, b, q, c1[200005], c2[200005], b1[200005], b2[200005];
void upd(int b[], int x, int y) {
  for (int i = x; i <= n; i += i & -i) b[i] += y;
}
int get(int b[], int x) {
  int ret = 0;
  for (int i = x; i; i -= i & -i) ret += b[i];
  return ret;
}
int main() {
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  while (q--) {
    int cmd, x, y;
    scanf("%d %d", &cmd, &x);
    if (cmd == 1) {
      scanf("%d", &y);
      int p1 = c1[x];
      c1[x] = min(b, c1[x] + y);
      int p2 = c2[x];
      c2[x] = min(a, c2[x] + y);
      upd(b1, x, c1[x] - p1);
      upd(b2, n - x + 1, c2[x] - p2);
    } else
      printf("%d\n", get(b1, x - 1) + get(b2, n - x - k + 1));
  }
  scanf("\n");
}
