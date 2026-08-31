#include <bits/stdc++.h>
using namespace std;
const int M = 5000 + 10;
int d[M];
int maxv[M];
int a[M];
struct QUERY {
  int t;
  int l;
  int r;
  int x;
} query[M];
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    maxv[i] = 1000000000;
  }
  for (int q = 0; q < m; q++) {
    int t;
    cin >> t;
    int l, r, x;
    cin >> l >> r >> x;
    query[q].l = l;
    query[q].r = r;
    query[q].t = t;
    query[q].x = x;
    if (t == 1) {
      for (int i = l; i <= r; i++) {
        d[i] += x;
      }
    } else {
      for (int i = l; i <= r; i++) {
        int val = x - d[i];
        maxv[i] = min(maxv[i], val);
      }
    }
  }
  for (int i = 1; i <= n; i++) {
    a[i] = maxv[i];
  }
  bool ok = true;
  for (int q = 0; q < m; q++) {
    int l = query[q].l;
    int r = query[q].r;
    int x = query[q].x;
    if (query[q].t == 1) {
      for (int i = l; i <= r; i++) {
        maxv[i] += x;
      }
    } else {
      int maxval = maxv[l];
      for (int i = l; i <= r; i++) {
        maxval = max(maxval, maxv[i]);
      }
      if (maxval != x) {
        ok = false;
      }
    }
  }
  if (ok) {
    cout << "YES" << endl;
    for (int i = 1; i <= n; i++) {
      cout << a[i] << " ";
    }
    cout << endl;
  } else {
    cout << "NO" << endl;
  }
  return 0;
};
