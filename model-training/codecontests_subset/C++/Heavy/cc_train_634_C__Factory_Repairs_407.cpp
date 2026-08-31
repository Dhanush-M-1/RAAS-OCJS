#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10;
int n, k, a, b, q, seg[4 * maxn][2], type;
void change(int l, int r, int pos, int val, int id) {
  if (r - l == 1) {
    seg[id][0] += val;
    seg[id][1] += val;
    seg[id][0] = min(a, seg[id][0]);
    seg[id][1] = min(b, seg[id][1]);
    return;
  }
  int mid = (l + r) / 2;
  if (pos < mid)
    change(l, mid, pos, val, id * 2);
  else
    change(mid, r, pos, val, id * 2 + 1);
  seg[id][0] = seg[id * 2][0] + seg[id * 2 + 1][0];
  seg[id][1] = seg[id * 2][1] + seg[id * 2 + 1][1];
  return;
}
int query(int l, int r, int lo, int hi, int id, int f) {
  if (l >= hi || lo >= r) return 0;
  if (l >= lo && r <= hi) return seg[id][f];
  int mid = (l + r) / 2;
  int javab = query(l, mid, lo, hi, id * 2, f);
  javab += query(mid, r, lo, hi, id * 2 + 1, f);
  return javab;
}
int main() {
  cin >> n >> k >> a >> b >> q;
  while (q--) {
    cin >> type;
    if (type == 2) {
      int dayup;
      cin >> dayup;
      int ans = query(0, n, 0, --dayup, 1, 1);
      ans += query(0, n, dayup + k, n, 1, 0);
      cout << ans << '\n';
    } else {
      int pos, val;
      cin >> pos >> val;
      change(0, n, --pos, val, 1);
    }
  }
  return 0;
}
