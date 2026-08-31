#include <bits/stdc++.h>
using namespace std;
struct segment_tree {
  long long seg[1000000];
  void update(int n, int s, int e, int j, int v, int mx) {
    if (s == e) {
      seg[n] = min(mx * 1ll, seg[n] + v);
    } else {
      int mid = (s + e) / 2;
      if (j <= mid)
        update(n + n, s, mid, j, v, mx);
      else
        update(n + n + 1, mid + 1, e, j, v, mx);
      seg[n] = seg[n + n] + seg[n + n + 1];
    }
  }
  long long query(int n, int s, int e, int l, int r) {
    if (s > e || s > r || l > e) return 0;
    if (l <= s && e <= r) return seg[n];
    int mid = (s + e) / 2;
    return query(n + n, s, mid, l, r) + query(n + n + 1, mid + 1, e, l, r);
  }
} seg[2];
int main() {
  int n, k, a, b, q;
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &q);
  for (int i = 1; i <= q; i++) {
    int t, x, y;
    scanf("%d", &t);
    if (t == 1) {
      scanf("%d%d", &x, &y);
      seg[0].update(1, 1, n, x, y, b);
      seg[1].update(1, 1, n, x, y, a);
    } else {
      scanf("%d", &x);
      printf("%lld\n",
             seg[0].query(1, 1, n, 1, x - 1) + seg[1].query(1, 1, n, x + k, n));
    }
  }
}
