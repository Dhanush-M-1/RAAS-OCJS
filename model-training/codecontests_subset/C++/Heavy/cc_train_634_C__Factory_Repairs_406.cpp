#include <bits/stdc++.h>
using namespace std;
struct segtr {
  long long int siparis, normal, fazlaysa;
} seg[4 * 200005];
long long int N, k, slow, fast, Q;
void update(long long int k, long long int l, long long int r, long long int tg,
            long long int extra) {
  if (l > tg || r < tg) return;
  if (l == tg && r == tg) {
    seg[k].siparis += extra;
    seg[k].normal = min(seg[k].siparis, slow);
    if (seg[k].siparis > slow) {
      seg[k].fazlaysa = min(fast - slow, seg[k].siparis - slow);
    }
    return;
  }
  update(2 * k, l, (l + r) / 2, tg, extra);
  update(2 * k + 1, (l + r) / 2 + 1, r, tg, extra);
  seg[k].normal = seg[2 * k].normal + seg[2 * k + 1].normal;
  seg[k].fazlaysa = seg[2 * k].fazlaysa + seg[2 * k + 1].fazlaysa;
}
long long int find(long long int k, long long int l, long long int r,
                   long long int tg_l, long long int tg_r,
                   long long int extra) {
  if (l > tg_r || r < tg_l) return 0;
  if (l >= tg_l && r <= tg_r) {
    long long int ret = 0;
    ret = seg[k].normal + (extra ? seg[k].fazlaysa : 0);
    return ret;
  }
  return find(2 * k, l, (l + r) / 2, tg_l, tg_r, extra) +
         find(2 * k + 1, (l + r) / 2 + 1, r, tg_l, tg_r, extra);
}
int main() {
  long long int a, b, c;
  cin >> N >> k >> fast >> slow >> Q;
  while (Q--) {
    scanf("%lld %lld", &a, &b);
    if (a == 1) {
      scanf("%lld", &c);
      update(1, 1, N, b, c);
    } else {
      long long int yaz = 0;
      if (b > 1) yaz += find(1, 1, N, 1, b - 1, 0);
      if (b + k - 1 < N) yaz += find(1, 1, N, b + k, N, 1);
      printf("%lld\n", yaz);
    }
  }
  return 0;
}
