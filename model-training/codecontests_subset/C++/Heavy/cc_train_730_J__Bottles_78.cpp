#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:128000000")
using namespace std;
void solve();
void precalc();
int TESTNUM = 0;
int main() {
  string s = "";
  cin.tie(0);
  cout.sync_with_stdio(0);
  cout.precision(10);
  cout << fixed;
  precalc();
  int t = 1;
  while (t--) {
    ++TESTNUM;
    solve();
  }
  return 0;
}
template <typename T>
T binpow(T q, T w, T mod) {
  if (!w) return 1 % mod;
  if (w & 1) return q * 1LL * binpow(q, w - 1, mod) % mod;
  return binpow(q * 1LL * q % mod, w / 2, mod);
}
void precalc() {}
template <typename T>
T gcd(T q, T w) {
  while (w) {
    q %= w;
    swap(q, w);
  }
  return q;
}
template <typename T>
T lcm(T q, T w) {
  return q / gcd(q, w) * w;
}
inline int nxt() {
  int x;
  cin >> x;
  return x;
}
const int C = 100 * 101;
void solve() {
  int n;
  cin >> n;
  vector<int> a(n), b(n);
  int a_sum = 0;
  for (int i = 0; i < n; ++i) {
    cin >> a[i];
    a_sum += a[i];
  }
  for (int i = 0; i < n; ++i) {
    cin >> b[i];
  }
  vector<vector<vector<int>>> dp(
      2, vector<vector<int>>(n + 1, vector<int>(C, 1e9)));
  dp[0][0][0] = 0;
  int par = 0;
  for (int i = 0; i < n; ++i) {
    dp[par ^ 1].assign(n + 1, vector<int>(C, 1e9));
    for (int used = 0; used <= i; ++used) {
      for (int sum = 0; sum < C; ++sum) {
        dp[par ^ 1][used][sum] =
            min(dp[par ^ 1][used][sum], dp[par][used][sum] + a[i]);
        if (sum + b[i] < C) {
          dp[par ^ 1][used + 1][sum + b[i]] =
              min(dp[par ^ 1][used + 1][sum + b[i]], dp[par][used][sum]);
        }
      }
    }
    par ^= 1;
  }
  int used = 0;
  while (true) {
    bool f = false;
    for (int sum = a_sum; sum < C; ++sum) {
      if (dp[par][used][sum] < 1e8) {
        f = true;
        break;
      }
    }
    if (f) {
      break;
    }
    ++used;
  }
  cout << used << " ";
  int res = 1e9;
  for (int sum = a_sum; sum < C; ++sum) {
    res = min(res, dp[par][used][sum]);
  }
  cout << res << "\n";
}
