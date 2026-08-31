#include <bits/stdc++.h>
using namespace std;
const int MAX = 2 * 1E5 + 10;
struct bit {
  int total[MAX];
  bit() { memset(total, 0, sizeof total); }
  void update(int i, int j) {
    while (i < MAX) {
      total[i] += j;
      i += (i & (-i));
    }
  }
  int get(int i) {
    total[0] = 0;
    while (i > 0) {
      total[0] += total[i];
      i -= (i & (-i));
    }
    return total[0];
  }
  int sum(int l, int r) {
    if (l <= r)
      return get(r) - get(l - 1);
    else
      return 0;
  }
} ans[2];
int a[MAX], b[MAX], lim_a, lim_b, N, k, q;
void update(int i, int j) {
  int _a = min(j, lim_a - a[i]);
  int _b = min(j, lim_b - b[i]);
  ans[0].update(i, _a);
  ans[1].update(i, _b);
  a[i] += _a;
  b[i] += _b;
}
int query(int i) { return ans[1].sum(1, i - 1) + ans[0].sum(i + k, N); }
int main() {
  scanf("%d %d %d %d %d", &N, &k, &lim_a, &lim_b, &q);
  ans[0] = ans[1] = bit();
  while (q--) {
    int type, i, j;
    scanf("%d %d", &type, &i);
    if (type == 1) {
      scanf("%d", &j);
      update(i, j);
    } else
      printf("%d\n", query(i));
  }
}
