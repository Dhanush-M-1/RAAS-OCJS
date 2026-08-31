#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 3;
const int maxlog = 64;
const long long mod = 1e16 + 7;
const int maxh = 2 * 350;
int val1[maxn], val2[maxn];
vector<pair<int, int> > querry;
int seg1[4 * maxn], seg2[4 * maxn];
void update1(int ind, int l, int r, int x, int val) {
  seg1[ind] += val;
  if (r - l < 2) return;
  int mid = (l + r) / 2;
  if (x < mid)
    update1(2 * ind, l, mid, x, val);
  else
    update1(2 * ind + 1, mid, r, x, val);
}
void update2(int ind, int l, int r, int x, int val) {
  seg2[ind] += val;
  if (r - l < 2) return;
  int mid = (l + r) / 2;
  if (x < mid)
    update2(2 * ind, l, mid, x, val);
  else
    update2(2 * ind + 1, mid, r, x, val);
}
int get1(int ind, int l, int r, int x, int y) {
  if (y <= l || r <= x) return 0;
  if (x <= l && r <= y) return seg1[ind];
  int mid = (l + r) / 2;
  return get1(2 * ind, l, mid, x, y) + get1(2 * ind + 1, mid, r, x, y);
}
int get2(int ind, int l, int r, int x, int y) {
  if (y <= l || r <= x) return 0;
  if (x <= l && r <= y) return seg2[ind];
  int mid = (l + r) / 2;
  return get2(2 * ind, l, mid, x, y) + get2(2 * ind + 1, mid, r, x, y);
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cout.precision(30);
  int n, k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  while (q--) {
    int type;
    cin >> type;
    if (type == 1) {
      int d, x;
      cin >> d >> x;
      d--;
      int cur = min(val1[d] + x, b);
      int p = cur - val1[d];
      update1(1, 0, n, d, p);
      val1[d] += p;
      cur = min(val2[d] + x, a);
      p = cur - val2[d];
      update2(1, 0, n, d, p);
      val2[d] += p;
    } else {
      int p;
      cin >> p;
      p--;
      int ans = 0;
      if (p) ans += get1(1, 0, n, 0, p);
      if (p + k != n) ans += get2(1, 0, n, p + k, n);
      cout << ans << endl;
    }
  }
  return 0;
}
