#include <bits/stdc++.h>
using namespace std;
int delta[5555];
int maxs[5555];
struct query {
  int t, l, r, d;
  query(){};
  query(int T, int L, int R, int D) : t(T), l(L), r(R), d(D) {}
  void get(int &T, int &L, int &R, int &D) {
    T = t;
    L = l;
    R = r;
    D = d;
  }
};
query qs[5555];
int main() {
  int n, t, m, l, r, d;
  bool good = true;
  cin >> n >> m;
  for (int j = (1); j <= (n); ++j) {
    delta[j] = 0;
    maxs[j] = 100000000;
  }
  for (int i = 0; i < (m); ++i) {
    cin >> t >> l >> r >> d;
    qs[i] = query(t, l, r, d);
  }
  for (int i = 0; i < (m); ++i) {
    qs[i].get(t, l, r, d);
    if (t == 1) {
      for (int j = (l); j <= (r); ++j) delta[j] += d;
    } else {
      for (int j = (l); j <= (r); ++j) {
        if (maxs[j] + delta[j] > d) maxs[j] = d - delta[j];
      }
    }
  }
  for (int j = (1); j <= (n); ++j) delta[j] = 0;
  for (int i = 0; i < (m); ++i) {
    qs[i].get(t, l, r, d);
    if (t == 1) {
      for (int j = (l); j <= (r); ++j) delta[j] += d;
    } else {
      int m = -1000000000;
      for (int j = (l); j <= (r); ++j) {
        if (maxs[j] + delta[j] > m) m = maxs[j] + delta[j];
      }
      if (m != d) good = false;
    }
  }
  if (good) {
    cout << "YES\n";
    for (int j = (1); j <= (n); ++j) cout << maxs[j] << " ";
    cout << "\n";
  } else
    cout << "NO\n";
  return 0;
}
