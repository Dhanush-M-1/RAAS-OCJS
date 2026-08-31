#include <bits/stdc++.h>
using namespace std;
const int N = 200010;
struct node {
  int s[2];
} tr[N << 2];
int a, b;
void push_up(int t) {
  tr[t].s[0] = tr[t << 1].s[0] + tr[t << 1 | 1].s[0];
  tr[t].s[1] = tr[t << 1].s[1] + tr[t << 1 | 1].s[1];
}
void update(int t, int L, int R, int x, int v) {
  if (L == R) {
    tr[t].s[0] = ((tr[t].s[0] + v) < (b) ? (tr[t].s[0] + v) : (b));
    tr[t].s[1] = ((tr[t].s[1] + v) < (a) ? (tr[t].s[1] + v) : (a));
    return;
  }
  int mid = (L + R) >> 1;
  if (x <= mid)
    update(t << 1, L, mid, x, v);
  else
    update(t << 1 | 1, mid + 1, R, x, v);
  push_up(t);
}
int query(int t, int L, int R, int l, int r, int op) {
  if (r < l) return 0;
  if (l <= L && R <= r) {
    return tr[t].s[op];
  }
  int ans = 0, mid = (L + R) >> 1;
  if (l <= mid) ans += query(t << 1, L, mid, l, r, op);
  if (r > mid) ans += query(t << 1 | 1, mid + 1, R, l, r, op);
  return ans;
}
int main() {
  int n, k, q, op, x, v;
  while (~scanf("%d%d%d%d%d", &n, &k, &a, &b, &q)) {
    memset(tr, 0, sizeof(tr));
    while (q--) {
      scanf("%d%d", &op, &x);
      if (op == 1) {
        scanf("%d", &v);
        update(1, 1, n, x, v);
      } else {
        printf("%d\n",
               query(1, 1, n, 1, x - 1, 0) + query(1, 1, n, x + k, n, 1));
      }
    }
  }
}
