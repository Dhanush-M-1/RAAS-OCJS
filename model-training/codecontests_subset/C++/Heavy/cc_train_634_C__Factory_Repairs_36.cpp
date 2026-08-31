#include <bits/stdc++.h>
using namespace std;
char _;
const int maxN = 200 * 1000 + 5;
const int maxM = 5000 + 5;
const int mod = 1000 * 1000 * 1000 + 7;
const int base = 701;
const int SQ = 500;
const int maxL = 20;
int seg[2][4 * maxN];
int lim[2];
void add(int f, int p, int val, int s, int e, int id) {
  if (e - s == 1) {
    seg[f][id] += val;
    if (seg[f][id] > lim[f]) seg[f][id] = lim[f];
    return;
  }
  int mid = (s + e) >> 1;
  if (p < mid)
    add(f, p, val, s, mid, 2 * id);
  else
    add(f, p, val, mid, e, 2 * id + 1);
  seg[f][id] = seg[f][2 * id] + seg[f][2 * id + 1];
}
int get(int f, int l, int r, int s, int e, int id) {
  if (l >= e || r <= s) return 0;
  if (l <= s && e <= r) return seg[f][id];
  int mid = (s + e) >> 1;
  return get(f, l, r, s, mid, 2 * id) + get(f, l, r, mid, e, 2 * id + 1);
}
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n, k, q;
  cin >> n >> k >> lim[1] >> lim[0] >> q;
  for (int i = 0; i < q; i++) {
    int t, d;
    cin >> t >> d;
    d--;
    if (t == 1) {
      int x;
      cin >> x;
      add(0, d, x, 0, n, 1);
      add(1, d, x, 0, n, 1);
    } else
      cout << get(0, 0, d, 0, n, 1) + get(1, d + k, n, 0, n, 1) << endl;
  }
  return 0;
}
