#include <bits/stdc++.h>
using namespace std;
const int N = 2000 * 100 + 10, L = 20;
int n, k, a, b, q;
int minn[N * L], maxx[N * L], ar[N];
void add(int ind, int be, int en, int p, int val) {
  if (be + 1 == en) {
    minn[ind] = min(b, minn[ind] + val);
    maxx[ind] = min(a, maxx[ind] + val);
    return;
  }
  int mid = (be + en) / 2;
  if (p < mid)
    add(ind * 2, be, mid, p, val);
  else
    add(ind * 2 + 1, mid, en, p, val);
  minn[ind] = minn[ind * 2] + minn[ind * 2 + 1];
  maxx[ind] = maxx[ind * 2] + maxx[ind * 2 + 1];
  return;
}
int get(int ind, int be, int en, int l, int r, bool f) {
  if (l <= be && r >= en) {
    if (f) return maxx[ind];
    return minn[ind];
  }
  int mid = (be + en) / 2, ret = 0;
  if (l < mid) ret += get(ind * 2, be, mid, l, r, f);
  if (r > mid) ret += get(ind * 2 + 1, mid, en, l, r, f);
  return ret;
}
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  int x, l, r;
  cin >> n >> k >> a >> b >> q;
  for (int i = 0; i < q; i++) {
    cin >> x >> l;
    if (x == 1) {
      cin >> r;
      l--;
      add(1, 0, n, l, r);
    } else {
      int t = 0;
      if (l - 1 > 0) t += get(1, 0, n, 0, l - 1, 0);
      if (l + k - 1 < n) t += get(1, 0, n, l + k - 1, n, 1);
      cout << t << endl;
    }
  }
  return 0;
}
