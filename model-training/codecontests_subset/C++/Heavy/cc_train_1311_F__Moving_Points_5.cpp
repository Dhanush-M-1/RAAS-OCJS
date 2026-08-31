#include <bits/stdc++.h>
using namespace std;
using namespace std::chrono;
class st {
  int size;
  vector<int> c;
  vector<long long> a;

 public:
  st(int n) {
    size = 1;
    while (size < n) size *= 2;
    c.assign(2 * size, 0);
    a.assign(2 * size, 0);
  }
  void set(int i, long long v, int x, int lx, int rx) {
    if (lx + 1 == rx) {
      if (v == 0) {
        c[x] = 0;
        a[x] = 0;
      } else {
        c[x] = 1;
        a[x] = v;
      }
      return;
    }
    int m = (lx + rx) / 2;
    if (i < m)
      set(i, v, 2 * x + 1, lx, m);
    else
      set(i, v, 2 * x + 2, m, rx);
    c[x] = c[2 * x + 1] + c[2 * x + 2];
    a[x] = a[2 * x + 1] + a[2 * x + 2];
  }
  void set(int i, long long v) { set(i, v, 0, 0, size); }
  long long g1(int l, int r, int x, int lx, int rx) {
    if (l >= rx || r <= lx) return 0;
    if (l <= lx && r >= rx) return a[x];
    int m = (lx + rx) / 2;
    long long s1 = g1(l, r, 2 * x + 1, lx, m);
    long long s2 = g1(l, r, 2 * x + 2, m, rx);
    return s1 + s2;
  }
  long long g1(int l, int r) { return g1(l, r, 0, 0, size); }
  long long g2(int l, int r, int x, int lx, int rx) {
    if (l >= rx || r <= lx) return 0;
    if (l <= lx && r >= rx) return c[x];
    int m = (lx + rx) / 2;
    long long s1 = g2(l, r, 2 * x + 1, lx, m);
    long long s2 = g2(l, r, 2 * x + 2, m, rx);
    return s1 + s2;
  }
  long long g2(int l, int r) { return g2(l, r, 0, 0, size); }
};
void solve() {
  int n;
  cin >> n;
  vector<pair<long long, long long>> pts(n);
  vector<pair<long long, long long>> pts2(n);
  vector<long long> p2v(n);
  for (int i = 0; i < n; i++) cin >> pts[i].first;
  for (int i = 0; i < n; i++) cin >> pts[i].second;
  for (int i = 0; i < n; i++) {
    pts2[i].first = pts[i].second;
    pts2[i].second = pts[i].first;
  }
  sort(pts.begin(), pts.end());
  sort(pts2.begin(), pts2.end());
  for (int i = 0; i < n; i++) p2v[i] = pts2[i].first;
  st s(n);
  for (int i = 0; i < n; i++) {
    s.set(i, pts2[i].second);
  }
  long long total = 0;
  for (int i = 0; i < n; i++) {
    int ind = lower_bound(pts2.begin(), pts2.end(),
                          make_pair(pts[i].second, pts[i].first)) -
              pts2.begin();
    int ind2 = lower_bound(p2v.begin(), p2v.end(), pts[i].second) - p2v.begin();
    s.set(ind, 0);
    total += (s.g1(ind2, n) - s.g2(ind2, n) * pts[i].first);
  }
  cout << total << "\n";
}
int main() {
  auto start = high_resolution_clock::now();
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cerr.tie(0);
  long long t = 1;
  for (long long i = 0; i < t; i++) {
    solve();
  }
  auto stop = high_resolution_clock::now();
  auto duration = duration_cast<milliseconds>(stop - start);
  return 0;
}
