#include <bits/stdc++.h>
using namespace std;
const long double eps = 1e-9;
const long long mod = 1e9 + 7;
pair<long long, long long> dir[8] = {{-1, 0}, {1, 0},   {0, -1}, {0, 1},
                                     {1, 1},  {-1, -1}, {-1, 1}, {1, -1}};
const long long nn = 2e5 + 5;
long long n, damage[nn][4], maxi[nn][4];
bool can[nn][4];
long long dp[nn][11];
long long fun(long long cur, long long cards) {
  if (cur > n) return 0;
  long long& ans = dp[cur][cards];
  if (ans != -1) return ans;
  long long mx = 0;
  for (long long i = 0; i <= 3; i++) {
    if (can[cur][i]) {
      long long here = 0;
      if (cards + i < 10) {
        here = damage[cur][i];
        mx = max(mx, here + fun(cur + 1, cards + i));
      } else {
        here = damage[cur][i] + maxi[cur][i];
        mx = max(mx, here + fun(cur + 1, (cards + i) % 10));
      }
    }
  }
  return ans = mx;
}
void robin() {
  cin >> n;
  for (long long ii = 1; ii <= n; ii++) {
    long long k;
    cin >> k;
    vector<long long> v[4];
    for (long long i = 0; i < k; i++) {
      long long c, d;
      cin >> c >> d;
      v[c].push_back(d);
    }
    for (long long i = 1; i <= 3; i++) {
      sort(v[i].rbegin(), v[i].rend());
    }
    for (long long cards = 1; cards <= 3; cards++) {
      long long mx = 0;
      if (cards == 1) {
        for (long long i = 1; i <= 3; i++) {
          if (((long long)(v[i]).size())) mx = max(mx, v[i][0]);
        }
        can[ii][0] = can[ii][1] = 1;
        damage[ii][1] = mx;
        maxi[ii][1] = mx;
      } else if (cards == 2) {
        long long mxx = 0;
        if (((long long)(v[1]).size()) >= 2) {
          mx = v[1][0] + v[1][1];
          mxx = v[1][0];
        }
        if (((long long)(v[1]).size()) and ((long long)(v[2]).size())) {
          mx = max(mx, v[1][0] + v[2][0]);
          mxx = max(v[1][0], v[2][0]);
        }
        if (mx) {
          can[ii][2] = 1;
          damage[ii][2] = mx;
          maxi[ii][2] = mxx;
        }
      } else {
        if (((long long)(v[1]).size()) >= 3) {
          can[ii][3] = 1;
          damage[ii][3] = v[1][0] + v[1][1] + v[1][2];
          maxi[ii][3] = v[1][0];
        }
      }
    }
  }
  memset(dp, -1, sizeof dp);
  cout << fun(1, 0);
}
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long T = 1;
  for (long long tc = 1; tc <= T; tc++) {
    robin();
  }
  return 0;
}
