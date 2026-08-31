#include <bits/stdc++.h>

using namespace std;

#define sz(x) ((int) ((x).size()))
typedef long long ll;
typedef long double ld;

const ll inf = 1e18 + 10;

int t, n, c, q, p[40100], s[40100][5][5], ts[40100][5];
ll dp[40100][5], dpl[40100][5], dpr[40100][5], pdpl[40100][5];

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout << fixed << setprecision(10);
  cin >> t;
  while (t--) {
    cin >> n >> c >> q;
    for (int i = 0; i < n; i++)
      cin >> p[i];
    for (int j = 0; j <= c; j++)
      dp[n][j] = 1, dpl[n][j] = 0, dpr[n][j] = 1, ts[n][j] = 1, s[n][j][0] = 0;
    for (int i = n - 1; i >= 0; i--)
      for (int j = 0; j <= c; j++) {
        ts[i][j] = 0;
        dp[i][j] = 0;
        for (int k = 0; k <= j && i + k < n; k++)
          s[i][j][k] = k, ts[i][j]++;
        sort(s[i][j], s[i][j] + ts[i][j], [&](int si, int sj){return p[i + si] < p[i + sj];});
        for (int k = 0; k < ts[i][j]; k++) {
          if (s[i][j][k] == 0)
            dpl[i][j] = dp[i][j];
          dp[i][j] = min(dp[i][j] + dp[i + 1 + s[i][j][k]][j - s[i][j][k]], inf);
          if (s[i][j][k] == 0)
            dpr[i][j] = dp[i][j] - dpl[i][j];
        }
      }
    for (int i = 0; i < n; i++)
      for (int j = 0; j <= c; j++)
        pdpl[i][j] = dpl[i][j] + (i > 0 ? pdpl[i - 1][j] : 0);
    int qi;
    ll qj;
    for (int qq = 0; qq < q; qq++) {
      cin >> qi >> qj, qi--, qj--;
      if (qj >= dp[0][c]) {
        cout << "-1\n";
        continue;
      }
      int i = 0, j = c;
      while (i < n) {
        int l = i, r = n - 1;
        while (l < r) {
          int m = (l + r) / 2;
          ll pdplm = pdpl[m][j] - (i > 0 ? pdpl[i - 1][j] : 0);
          if (pdplm <= qj && qj < pdplm + dpr[m][j])
            l = m + 1;
          else
            r = m;
        }
        qj -= (l > 0 ? pdpl[l - 1][j] : 0) - (i > 0 ? pdpl[i - 1][j] : 0);
        i = l;
        if (i < n) {
          int k = 0;
          while (qj >= dp[i + 1 + s[i][j][k]][j - s[i][j][k]])
            qj -= dp[i + 1 + s[i][j][k]][j - s[i][j][k]], k++;
          int sh = s[i][j][k];
          int l = i, r = i + sh;
          if (l <= qi && qi <= r)
            qi = l + r - qi;
          i += sh + 1;
          j -= sh;
        }
      }
      cout << p[qi] << "\n";
    }
  }
}
