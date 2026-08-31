#include <bits/stdc++.h>
using namespace std;
const int MAXN = 5e3 + 3;
const int INF = 2000000000;
inline long long ab(long long x) { return x < 0 ? -x : x; }
long long a[MAXN];
int c_a[MAXN];
int l[MAXN], r[MAXN], x[MAXN], t[MAXN];
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    a[i] = INF;
  }
  for (int q = 0; q < m; q++) {
    cin >> t[q] >> l[q] >> r[q] >> x[q];
    --l[q], --r[q];
  }
  for (int q = m - 1; q >= 0; q--) {
    if (t[q] == 1) {
      for (int i = l[q]; i <= r[q]; i++) {
        a[i] -= x[q];
      }
    } else {
      bool found = false;
      for (int i = l[q]; i <= r[q]; i++) {
        if (a[i] >= x[q]) {
          a[i] = x[q];
          found = true;
        }
      }
      if (!found) {
        cout << "NO";
        return 0;
      }
    }
  }
  for (int i = 0; i < n; i++) {
    if (a[i] < 0) {
      if (ab(a[i]) > INF / 2) a[i] = -INF / 2;
    } else {
      if (a[i] > INF / 2) a[i] = INF / 2;
    }
  }
  for (int i = 0; i < n; i++) {
    c_a[i] = a[i];
  }
  for (int q = 0; q < m; q++) {
    if (t[q] == 1) {
      for (int i = l[q]; i <= r[q]; i++) {
        a[i] += x[q];
      }
    } else {
      long long maxv = -INF;
      for (int i = l[q]; i <= r[q]; i++) {
        maxv = max(maxv, a[i]);
      }
      if (maxv != x[q]) {
        cout << "NO";
        return 0;
      }
    }
  }
  cout << "YES\n";
  for (int i = 0; i < n; i++) {
    if (i > 0) cout << ' ';
    cout << c_a[i];
  }
  return 0;
}
