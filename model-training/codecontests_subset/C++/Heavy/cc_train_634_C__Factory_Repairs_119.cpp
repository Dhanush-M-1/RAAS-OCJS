#include <bits/stdc++.h>
using namespace std;
int tree[200009][2], n, orders[200009], cur[200009][2], a, b, k;
void update(int idx, int val, int ch) {
  while (idx <= n) {
    tree[idx][ch] += val;
    idx += (idx & -idx);
  }
}
int sum(int idx, int ch) {
  int val = 0;
  while (idx > 0) {
    val += tree[idx][ch];
    idx -= (idx & -idx);
  }
  return val;
}
int main() {
  int q;
  scanf("%d", &n);
  scanf("%d", &k);
  scanf("%d", &a);
  scanf("%d", &b);
  scanf("%d", &q);
  for (int i = int(0); i <= int(q - 1); i++) {
    int t;
    scanf("%d", &t);
    if (t == 1) {
      int d, ai;
      scanf("%d", &d);
      scanf("%d", &ai);
      update(d, -1 * cur[d][0], 0);
      update(d, -1 * cur[d][1], 1);
      orders[d] += ai;
      cur[d][0] = min(orders[d], b);
      cur[d][1] = min(orders[d], a);
      update(d, cur[d][0], 0);
      update(d, cur[d][1], 1);
    } else {
      int p;
      scanf("%d", &p);
      int ans = sum(n, 1) - sum(p + k - 1, 1) + sum(p - 1, 0);
      printf("%d\n", ans);
    }
  }
  return 0;
}
