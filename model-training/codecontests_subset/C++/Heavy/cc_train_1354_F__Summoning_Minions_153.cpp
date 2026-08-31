#include <bits/stdc++.h>
using namespace std;
long long t, n, k;
long long a[80][80], x[80], y[80];
void hungarian() {
  vector<long long> u(n + 1), v(n + 1), p(n + 1), way(n + 1);
  for (long long i = 1; i <= n; i++) {
    p[0] = i;
    long long j0 = 0;
    vector<long long> minv(n + 1, 1000000000000000000);
    vector<char> used(n + 1, false);
    do {
      used[j0] = true;
      long long i0 = p[j0], delta = 1000000000000000000, j1;
      for (long long j = 1; j <= n; j++)
        if (!used[j]) {
          long long cur = a[i0][j] - u[i0] - v[j];
          if (cur < minv[j]) minv[j] = cur, way[j] = j0;
          if (minv[j] < delta) delta = minv[j], j1 = j;
        }
      for (long long j = 0; j <= n; j++) {
        if (used[j])
          u[p[j]] += delta, v[j] -= delta;
        else
          minv[j] -= delta;
      }
      j0 = j1;
    } while (p[j0] != 0);
    do {
      long long j1 = way[j0];
      p[j0] = p[j1];
      j0 = j1;
    } while (j0);
  }
  vector<long long> ans(n + 1), br(n + 1);
  for (long long j = 1; j <= n; j++) ans[p[j]] = j;
  for (long long i = 1; i <= n; i++) br[ans[i]] = i;
  cout << k + (n - k) * 2 << "\n";
  for (long long i = 1; i <= n; i++) {
    if (i < k)
      cout << br[i] << " ";
    else if (i > k)
      cout << br[i] << " " << -br[i] << " ";
  }
  cout << br[k] << "\n";
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> t;
  while (t--) {
    cin >> n >> k;
    for (long long i = 1; i <= n; i++) cin >> x[i] >> y[i];
    for (long long i = 1; i <= n; i++) {
      for (long long j = 1; j <= n; j++) {
        if (j <= k)
          a[i][j] = -(x[i] + (j - 1) * y[i]);
        else
          a[i][j] = -((k - 1) * y[i]);
      }
    }
    hungarian();
  }
}
