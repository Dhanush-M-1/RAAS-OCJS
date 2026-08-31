#include <bits/stdc++.h>
using namespace std;
const int MAXN = 131072 * 2;
int n, k, a, b, q;
typedef struct {
  int sa, sb;
} TVertex;
vector<TVertex> tree;
void build() {
  TVertex zero;
  zero.sa = 0;
  zero.sb = 0;
  tree.resize(2 * MAXN, zero);
}
void inc(int pos, int val) {
  pos += MAXN;
  tree[pos].sa = min(a, tree[pos].sa + val);
  tree[pos].sb = min(b, tree[pos].sb + val);
  pos >>= 1;
  for (; pos > 0; pos >>= 1) {
    tree[pos].sa = tree[pos * 2].sa + tree[pos * 2 + 1].sa;
    tree[pos].sb = tree[pos * 2].sb + tree[pos * 2 + 1].sb;
  }
}
int get_sum(int v, int vl, int vr, int l, int r, bool flag) {
  if (l > r) return 0;
  if (vl > r || l > vr) return 0;
  if (l <= vl && vr <= r) {
    if (flag)
      return tree[v].sa;
    else
      return tree[v].sb;
  }
  int vm = (vl + vr) / 2;
  return get_sum(v * 2, vl, vm, l, r, flag) +
         get_sum(v * 2 + 1, vm + 1, vr, l, r, flag);
}
int main() {
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &q);
  build();
  for (int i = 0; i < q; ++i) {
    int tp;
    scanf("%d", &tp);
    if (tp == 1) {
      int d, ca;
      scanf("%d%d", &d, &ca);
      inc(d - 1, ca);
    } else {
      int p;
      scanf("%d", &p);
      cout << get_sum(1, 0, MAXN - 1, 0, p - 2, false) +
                  get_sum(1, 0, MAXN - 1, p + k - 1, n - 1, true)
           << "\n";
    }
  }
  return 0;
}
