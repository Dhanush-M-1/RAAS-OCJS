#include <bits/stdc++.h>
using namespace std;
long long n, m, k, y, z, l, i, j, x, r, x2, y2;
long long a[100500], b[500500], c[100500];
long long binpow(long long x, long long y) {
  if (y == 0) {
    return 1;
  }
  long long tmp = binpow(x, y / 2);
  tmp = tmp * tmp % 998244353;
  if (y % 2) {
    return x * tmp % 998244353;
  }
  return tmp;
}
long long inv(long long x) { return binpow(x, 998244353 - 2); }
long long mulg(long long x, long long y) { return x * y % 998244353; }
void add(long long& x, long long y) {
  x += y;
  if (x >= 998244353) {
    x -= 998244353;
  }
}
long long dp[200500][11];
vector<long long> g[5];
long long dpr[4];
int main() {
  cin >> n;
  for (int i = 0; i <= n; i++) {
    for (int j = 0; j <= 10; j++) {
      dp[i][j] = -(long long)1e+18;
    }
  }
  dp[0][0] = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 1; j <= 3; j++) {
      g[j].clear();
    }
    int k;
    scanf("%d", &k);
    for (int j = 0; j < k; j++) {
      int x, y;
      scanf("%d %d", &x, &y);
      g[x].push_back(y);
    }
    vector<pair<long long, long long> > pool;
    for (int j = 1; j <= 3; j++) {
      sort(g[j].begin(), g[j].end());
      reverse(g[j].begin(), g[j].end());
      if (j == 1) {
        for (int k = 0; k < 3 && k < g[j].size(); k++) {
          pool.push_back(make_pair(g[j][k], j));
        }
      } else {
        for (int k = 0; k < 1 && k < g[j].size(); k++) {
          pool.push_back(make_pair(g[j][k], j));
        }
      }
    }
    for (int j = 1; j <= 10; j++) {
      dpr[0] = 0;
      for (int k = 1; k <= 3; k++) {
        dpr[k] = -(long long)1e+18;
      }
      for (int i1 = 0; i1 < pool.size(); i1++) {
        vector<pair<long long, long long> > tmp;
        tmp.push_back(pool[i1]);
        for (int i2 = 0; i2 <= pool.size(); i2++) {
          if (i2 != pool.size() && i2 != i1) {
            tmp.push_back(pool[i2]);
          }
          for (int i3 = 0; i3 <= pool.size(); i3++) {
            if (i3 != pool.size() && i3 != i2 && i3 != i1) {
              tmp.push_back(pool[i3]);
            }
            long long cur_val = 0, cur_w = 0;
            for (int k = 0; k < tmp.size(); k++) {
              if (k + 1 == j) {
                cur_val += 2 * tmp[k].first;
              } else {
                cur_val += tmp[k].first;
              }
              cur_w += tmp[k].second;
            }
            if (cur_w <= 3) {
              dpr[tmp.size()] = max(dpr[tmp.size()], cur_val);
            }
            if (i3 != pool.size() && i3 != i2 && i3 != i1) {
              tmp.pop_back();
            }
          }
          if (i2 != pool.size() && i2 != i1) {
            tmp.pop_back();
          }
        }
      }
      for (int k = 0; k <= 3; k++) {
        long long cur = dpr[k];
        dp[i + 1][(10 - j + k) % 10] =
            max(dp[i + 1][(10 - j + k) % 10], dp[i][10 - j] + cur);
      }
    }
  }
  long long ans = 0;
  for (int i = 0; i < 10; i++) {
    ans = max(ans, dp[n][i]);
  }
  cout << ans << endl;
  return 0;
}
