#include <bits/stdc++.h>
using namespace std;
const int pow2 = (1 << 20);
struct SegmentTree {
  int tree[pow2 * 2];
  SegmentTree() { memset(tree, 0, sizeof(tree)); }
  void addValue(int pos, int value) {
    int v = pos + pow2;
    tree[v] += value;
    while (v > 1) {
      v /= 2;
      tree[v] = tree[2 * v] + tree[2 * v + 1];
    }
  }
  int getSum(int a, int b, int v, int l, int r) {
    if (l >= a && r <= b) return tree[v];
    if (l > b || r < a) return 0;
    int m = (l + r) / 2;
    return getSum(a, b, 2 * v, l, m) + getSum(a, b, 2 * v + 1, m + 1, r);
  }
  int getSum(int a, int b) {
    if (a > b) return 0;
    return getSum(a, b, 1, 0, pow2 - 1);
  }
};
SegmentTree A, B;
int cnt[pow2];
int n, k, a, b, q;
void changeTree(SegmentTree &tree, int pos, int old, int nw, int border) {
  tree.addValue(pos, -min(old, border));
  tree.addValue(pos, min(border, nw));
}
int main() {
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &q);
  for (int i = 0; i < q; i++) {
    int type;
    scanf("%d", &type);
    if (type == 1) {
      int d, add;
      scanf("%d%d", &d, &add);
      changeTree(A, d, cnt[d], cnt[d] + add, a);
      changeTree(B, d, cnt[d], cnt[d] + add, b);
      cnt[d] += add;
    } else {
      int p;
      scanf("%d", &p);
      int ans = B.getSum(1, p - 1) + A.getSum(p + k, n);
      printf("%d\n", ans);
    }
  }
  return 0;
}
