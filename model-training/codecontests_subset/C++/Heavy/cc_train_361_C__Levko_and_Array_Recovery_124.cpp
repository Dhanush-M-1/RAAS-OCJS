#include <bits/stdc++.h>
using namespace std;
const int maxn = (int)1e6;
const int inf = (int)1e9;
const int mod = (int)1e9 + 7;
const double eps = 1e-9;
int n, m, t[maxn], l[maxn], r[maxn], d[maxn], T[maxn], a[maxn], ok;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> m;
  for (int i = 1; i <= n; ++i) a[i] = inf;
  for (int i = 1; i <= m; ++i) {
    cin >> t[i] >> l[i] >> r[i] >> d[i];
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; ++j) T[j] += d[i];
    } else {
      for (int j = l[i]; j <= r[i]; ++j)
        if (a[j] + T[j] > d[i]) a[j] = d[i] - T[j];
    }
  }
  for (int i = 1; i <= n; ++i) T[i] = 0;
  for (int i = 1; i <= m; ++i) {
    if (abs(a[i]) > inf) {
      cout << "NO\n";
      return 0;
    }
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; ++j) T[j] += d[i];
    } else {
      ok = false;
      for (int j = l[i]; j <= r[i]; ++j)
        if (a[j] + T[j] == d[i]) {
          ok = true;
        } else if (a[j] + T[j] > d[i]) {
          cout << "NO\n";
          return 0;
        }
      if (!ok) {
        cout << "NO\n";
        return 0;
      }
    }
  }
  cout << "YES\n";
  for (int i = 1; i <= n; ++i) cout << a[i] << ' ';
  return 0;
}
