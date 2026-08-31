#include <bits/stdc++.h>
using namespace std;
const long long inf = 2e9;
const int N = 5010;
int n, m;
long long v[N];
long long a[N];
int t[N], d[N];
int l[N], r[N];
int main() {
  cin >> n >> m;
  for (int i = 0; i < n; ++i) v[i] = 2 * inf;
  for (int i = m - 1; i >= 0; --i) cin >> t[i] >> l[i] >> r[i] >> d[i];
  for (int op = 0; op < m; ++op) {
    if (t[op] == 1) {
      for (int i = l[op] - 1; i < r[op]; ++i) v[i] -= d[op];
    } else {
      for (int i = l[op] - 1; i < r[op]; ++i)
        v[i] = v[i] < d[op] ? v[i] : d[op];
      ;
    }
  }
  for (int i = 0; i < n; ++i) a[i] = v[i] < inf / 2 ? v[i] : inf / 2;
  for (int op = m - 1; op >= 0; --op)
    if (t[op] == 1) {
      for (int i = l[op] - 1; i < r[op]; ++i) a[i] += d[op];
    } else {
      int m = a[l[op] - 1];
      for (int i = l[op]; i < r[op]; ++i) m = m > a[i] ? m : a[i];
      if (m != d[op]) {
        cout << "NO";
        return 0;
      }
    }
  cout << "YES\n";
  for (int i = 0; i < n; i++)
    cout << ((v[i] < inf / 2) ? v[i] : inf / 2) << " ";
  return 0;
}
