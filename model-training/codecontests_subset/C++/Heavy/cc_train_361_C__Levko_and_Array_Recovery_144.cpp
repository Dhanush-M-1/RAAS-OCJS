#include <bits/stdc++.h>
using namespace std;
const int N = 5e3 + 5, MOD = 1e9;
int n, m, diff[N], a[N], b[N], val[N][4];
int main() {
  std::ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n >> m;
  for (int i = 0; i < N; i++) b[i] = MOD;
  for (int i = 0; i < m; i++) {
    int t, l, r, x;
    cin >> t >> l >> r >> x;
    l--;
    r--;
    val[i][0] = t;
    val[i][1] = l;
    val[i][2] = r;
    val[i][3] = x;
    if (t == 1) {
      for (int j = l; j <= r; j++) diff[j] += x;
      continue;
    }
    for (int j = l; j <= r; j++) b[j] = min(b[j], x - diff[j]);
  }
  for (int i = 0; i < n; i++) a[i] = b[i];
  for (int i = 0; i < m; i++) {
    int t = val[i][0], l = val[i][1], r = val[i][2], x = val[i][3];
    if (t == 1) {
      for (int j = l; j <= r; j++) b[j] += x;
      continue;
    }
    int maxi = b[l];
    for (int j = l + 1; j <= r; j++) maxi = max(maxi, b[j]);
    if (maxi != x) {
      cout << "NO";
      return 0;
    }
  }
  cout << "YES\n";
  for (int i = 0; i < n; i++) cout << a[i] << " ";
}
