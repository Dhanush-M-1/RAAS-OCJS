#include <bits/stdc++.h>
using namespace std;
int N, K, A, B, Q, x, y, t, ans;
int data[200010];
class segleaf {
 public:
  int s[2];
} seg[2000010];
void change(int x, int l, int r, int t, int delta) {
  if (l == r) {
    data[t] += delta;
    seg[x].s[0] = min(data[t], B);
    seg[x].s[1] = min(data[t], A);
    return;
  }
  int mid = (l + r) >> 1;
  if (t <= mid)
    change(x << 1, l, mid, t, delta);
  else
    change((x << 1) + 1, mid + 1, r, t, delta);
  seg[x].s[0] = seg[x << 1].s[0] + seg[(x << 1) + 1].s[0];
  seg[x].s[1] = seg[x << 1].s[1] + seg[(x << 1) + 1].s[1];
}
int ask(int x, int l, int r, int ll, int rr, int tt) {
  if (l == ll && r == rr) return seg[x].s[tt];
  int mid = (l + r) >> 1;
  if (rr <= mid)
    return ask(x << 1, l, mid, ll, rr, tt);
  else if (ll > mid)
    return ask((x << 1) + 1, mid + 1, r, ll, rr, tt);
  else
    return ask(x << 1, l, mid, ll, mid, tt) +
           ask((x << 1) + 1, mid + 1, r, mid + 1, rr, tt);
}
int main() {
  scanf("%d%d%d%d%d", &N, &K, &A, &B, &Q);
  for (int i = 1; i <= Q; i++) {
    scanf("%d", &t);
    if (t == 1) {
      scanf("%d%d", &x, &y);
      change(1, 1, N, x, y);
    } else {
      scanf("%d", &x);
      ans = 0;
      if (x > 1) ans += ask(1, 1, N, 1, x - 1, 0);
      if (x + K <= N) ans += ask(1, 1, N, x + K, N, 1);
      printf("%d\n", ans);
    }
  }
}
