#include <bits/stdc++.h>
using namespace std;
const int inf = 1e9;
const long long INF = 1e18;
const int M = 1e9 + 7;
const int maxn = 2e5 + 5;
long long d[maxn][10];
pair<int, int> c[maxn];
long long x[maxn][5], y[maxn][5];
int main(int argc, char const *argv[]) {
  int n;
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> n;
  for (int i = 1; i <= n; ++i) {
    int k;
    cin >> k;
    for (int j = 0; j < k; ++j) {
      cin >> c[j].second >> c[j].first;
    }
    sort(c, c + k);
    reverse(c, c + k);
    x[i][1] = c[0].first;
    y[i][1] = 2 * c[0].first;
    long long t = 0, ok = 1, tt = 0;
    for (int j = 0; j < k; ++j) {
      if (c[j].second == ok) {
        t += c[j].first;
        if (ok == 1) {
          tt += c[j].first;
        }
        tt += c[j].first;
        ++ok;
      }
      if (ok > 2) {
        break;
      }
    }
    if (ok > 2) {
      x[i][2] = t;
      y[i][2] = tt;
    }
    ok = 2;
    t = tt = 0;
    for (int j = 0; j < k; ++j) {
      if (c[j].second == ok) {
        t += c[j].first;
        tt += c[j].first;
        if (ok == 2) {
          tt += c[j].first;
        }
        --ok;
      }
      if (ok == 0) {
        break;
      }
    }
    if (ok == 0) {
      x[i][2] = max(x[i][2], t);
      y[i][2] = max(y[i][2], tt);
    }
    t = 0;
    ok = 1;
    for (int j = 0; j < k; ++j) {
      if (c[j].second == 1) {
        x[i][3] += c[j].first;
        if (ok > 0) {
          y[i][3] += c[j].first;
          ok--;
        }
        y[i][3] += c[j].first;
        ++t;
        if (t == 2) {
          x[i][2] = max(x[i][2], x[i][3]);
          y[i][2] = max(y[i][2], y[i][3]);
        } else if (t == 3) {
          break;
        }
      }
    }
    if (t < 3) x[i][3] = y[i][3] = 0;
  }
  memset(d, 0x9f, sizeof(d));
  d[0][0] = 0;
  for (int i = 1; i <= n; ++i) {
    for (int j = 0; j < 10; ++j) {
      d[i][j] = max(d[i][j], d[i - 1][j]);
      for (int k = 1; x[i][k]; ++k) {
        int t = (j + k) % 10;
        if (j % 10 > t) {
          d[i][t] = max(d[i][t], d[i - 1][j] + y[i][k]);
        } else {
          d[i][t] = max(d[i][t], d[i - 1][j] + x[i][k]);
        }
      }
    }
  }
  long long res = 0;
  for (int i = 1; i <= n; ++i) {
    for (int j = 0; j < 10; ++j) {
      res = max(d[i][j], res);
    }
  }
  cout << res << endl;
  return 0;
}
