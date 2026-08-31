#include <bits/stdc++.h>
#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")
const long long INF = 0x3f3f3f3f3f3f3f3f;
const long long llinf = (1LL << 62);
const int inf = (1 << 30);
const int nmax = 1e2 + 50;
const long long mod = 1e9 + 7;
using namespace std;
long long ts, i, j, n, f[nmax][nmax][2], k, k1, rs;
pair<pair<long long, long long>, long long> a[nmax];
vector<long long> del, add;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cerr.tie(0);
  cout.tie(0);
  cin >> ts;
  while (ts--) {
    cin >> n >> k;
    for (i = 1; i <= n; i++) {
      cin >> a[i].first.second >> a[i].first.first;
      a[i].second = i;
    }
    sort(a + 1, a + n + 1);
    for (i = 0; i <= n; i++)
      for (j = 0; j <= k; j++) f[i][j][0] = f[i][j][1] = -inf;
    f[0][0][0] = 0;
    for (i = 1; i <= n; i++) {
      for (j = 0; j <= min(k, i); j++) {
        if (max(f[i - 1][j][0], f[i - 1][j][1]) != -inf)
          f[i][j][0] =
              max(f[i - 1][j][0], f[i - 1][j][1]) + (k - 1) * a[i].first.first;
        if (j && max(f[i - 1][j - 1][0], f[i - 1][j - 1][1]) != -inf)
          f[i][j][1] = max(f[i][j][1],
                           max(f[i - 1][j - 1][0], f[i - 1][j - 1][1]) +
                               a[i].first.second + (j - 1) * a[i].first.first);
      }
    }
    rs = max(f[n][k][0], f[n][k][1]);
    del.clear(), add.clear(), k1 = k;
    for (i = n; i >= 1; i--) {
      if (k && rs == f[i][k][1]) {
        add.push_back(a[i].second);
        rs -= a[i].first.second + (k - 1) * a[i].first.first;
        k--;
      } else {
        del.push_back(a[i].second);
        rs -= (k1 - 1) * a[i].first.first;
      }
    }
    reverse(add.begin(), add.end());
    cout << 2 * n - k1 << endl;
    for (i = 0; i < (int)add.size() - 1; i++) cout << add[i] << " ";
    for (i = 0; i < (int)del.size(); i++)
      cout << del[i] << " " << -del[i] << " ";
    cout << add.back() << endl;
  }
  return 0;
}
