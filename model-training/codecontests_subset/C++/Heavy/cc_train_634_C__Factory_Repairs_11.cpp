#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 7;
const int SS = 4 * N;
long long n, q, k, a, b;
long long seg[SS][2];
void modif(int ind, int val, int s = 0, int e = n, int v = 1) {
  if (ind < s || ind >= e) return;
  if (e - s == 1) {
    seg[v][0] += val, seg[v][0] = min(seg[v][0], a);
    seg[v][1] += val, seg[v][1] = min(seg[v][1], b);
    return;
  }
  int mid = (s + e) / 2;
  modif(ind, val, s, mid, 2 * v);
  modif(ind, val, mid, e, 2 * v + 1);
  for (int i = 0; i < 2; i++) seg[v][i] = seg[2 * v][i] + seg[2 * v + 1][i];
}
long long get(int l, int r, int ind, int s = 0, int e = n, int v = 1) {
  if (l >= e || r <= s) return 0;
  if (l <= s && e <= r) return seg[v][ind];
  int mid = (s + e) / 2;
  long long res = 0;
  res += get(l, r, ind, s, mid, 2 * v);
  res += get(l, r, ind, mid, e, 2 * v + 1);
  return res;
}
int main() {
  ios::sync_with_stdio(false);
  cin >> n >> k >> a >> b >> q;
  while (q--) {
    int t;
    cin >> t;
    if (t == 1) {
      int d, x;
      cin >> d >> x;
      d--;
      modif(d, x);
    } else {
      int d;
      cin >> d;
      d--;
      cout << get(0, d, 1) + get(d + k, n, 0) << "\n";
    }
  }
  return 0;
}
