#include <bits/stdc++.h>
using namespace std;
const int inf = (int)1e9;
const int mod = inf + 7;
const double eps = 1e-9;
const double pi = acos(-1.0);
long long n, k, t1[800800], t2[800800], q, d, x, p, a, b;
void update1(int v, int tl, int tr, int pos, long long x) {
  if (tl == tr) {
    t1[v] = min(t1[v] + x, a);
    return;
  }
  int mid = (tl + tr) / 2;
  if (pos <= mid)
    update1(2 * v, tl, mid, pos, x);
  else
    update1(2 * v + 1, mid + 1, tr, pos, x);
  t1[v] = t1[2 * v] + t1[2 * v + 1];
}
void update2(int v, int tl, int tr, int pos, long long x) {
  if (tl == tr) {
    t2[v] = min(t2[v] + x, b);
    return;
  }
  int mid = (tl + tr) / 2;
  if (pos <= mid)
    update2(2 * v, tl, mid, pos, x);
  else
    update2(2 * v + 1, mid + 1, tr, pos, x);
  t2[v] = t2[2 * v] + t2[2 * v + 1];
}
long long get1(int v, int tl, int tr, int l, int r) {
  if (tl >= l && tr <= r) return t1[v];
  if (tl > r || tr < l) return 0;
  int mid = (tl + tr) / 2;
  return get1(2 * v, tl, mid, l, r) + get1(2 * v + 1, mid + 1, tr, l, r);
}
long long get2(int v, int tl, int tr, int l, int r) {
  if (tl >= l && tr <= r) return t2[v];
  if (tl > r || tr < l) return 0;
  int mid = (tl + tr) / 2;
  return get2(2 * v, tl, mid, l, r) + get2(2 * v + 1, mid + 1, tr, l, r);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> k >> b >> a >> q;
  for (int i = 0; i < q; ++i) {
    cin >> p;
    if (p == 1) {
      cin >> d >> x;
      update1(1, 1, n, d, x);
      update2(1, 1, n, d, x);
    } else {
      cin >> d;
      cout << get1(1, 1, n, 1, d - 1) + get2(1, 1, n, d + k, n) << endl;
    }
  }
}
