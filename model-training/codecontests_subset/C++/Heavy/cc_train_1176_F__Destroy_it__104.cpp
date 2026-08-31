#include <bits/stdc++.h>
using namespace std;
template <class c>
struct rge {
  c b, e;
};
template <class c>
rge<c> range(c i, c j) {
  return rge<c>{i, j};
}
template <class c>
auto dud(c* x) -> decltype(cerr << *x, 0);
template <class c>
char dud(...);
struct debug {
  template <class c>
  debug& operator<<(const c&) {
    return *this;
  }
};
long long INF64 = 1e18;
long long mod = 1e9 + 7;
int INF = 1e9;
long long fastpow(long long a, long long b, long long m) {
  a %= m;
  long long res = 1;
  while (b > 0) {
    if (b & 1) res = res * a % m;
    a = a * a % m;
    b >>= 1;
  }
  return res;
}
void test_case(int tnum) {
  int n, m;
  cin >> n;
  vector<vector<long long>> dp(n + 1, vector<long long>(11, -INF64));
  for (int i = 0; i <= n; i++) {
    dp[i][0] = 0;
  }
  for (int i = 1; i <= n; i++) {
    vector<vector<long long>> c(3);
    cin >> m;
    for (int j = 0; j < m; j++) {
      long long cost, dam;
      cin >> cost >> dam;
      --cost;
      c[cost].push_back(dam);
    }
    for (int j = 0; j <= 10; j++) {
      dp[i][j] = dp[i - 1][j];
    }
    for (int j = 0; j < 3; j++) {
      for (int k = 0; k < 3; k++) {
        c[j].push_back(-INF64);
      }
      sort(begin(c[j]), end(c[j]), greater<long long>());
    }
    vector<vector<long long>> mx(3);
    mx[2] = {c[0][0], c[0][1], c[0][2]};
    mx[1] = {c[0][0], max(c[0][1], c[1][0])};
    mx[0] = {max({c[0][0], c[1][0], c[2][0]})};
    for (int j = 0; j < 3; j++) {
      sort(begin(mx[j]), end(mx[j]), greater<long long>());
    }
    for (int rem = 0; rem < 3; rem++) {
      for (int play = 1; play <= 3; play++) {
        if (10 - play + rem >= 10 or dp[i - 1][10 - play + rem] < 0) continue;
        long long sum = 0;
        for (int j = 1; j < play; j++) {
          sum += mx[play - 1][j];
        }
        dp[i][rem] = max(dp[i][rem], dp[i - 1][10 - play + rem] + sum +
                                         (2 * mx[play - 1][0]));
      }
    }
    for (int rounds = 1; rounds < 10; rounds++) {
      for (int play = 1; play <= 3; play++) {
        if (rounds - play < 0 or dp[i - 1][rounds - play] < 0) continue;
        long long sum = 0;
        for (int j = 0; j < play; j++) {
          sum += mx[play - 1][j];
        }
        dp[i][rounds] = max(dp[i][rounds], dp[i - 1][rounds - play] + sum);
      }
    }
    debug() << " ["
            << "dp[i]"
               ": "
            << (dp[i])
            << "] "
               " ["
            << "i"
               ": "
            << (i) << "] ";
  }
  long long ans = 0;
  for (int i = 0; i <= 10; i++) {
    ans = max(ans, dp[n][i]);
  }
  cout << ans << '\n';
}
int main(void) {
  cin.tie(0);
  ios_base::sync_with_stdio(false);
  int t = 1;
  for (int test = 1; test <= t; test++) {
    test_case(test);
  }
  return 0;
}
