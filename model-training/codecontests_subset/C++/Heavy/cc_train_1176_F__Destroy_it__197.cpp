#include <bits/stdc++.h>
using namespace std;
using namespace std::chrono;
template <typename A, typename B>
ostream &operator<<(ostream &cout, pair<A, B> const &p) {
  return cout << "(" << p.first << ", " << p.second << ")";
}
template <typename A>
ostream &operator<<(ostream &cout, vector<A> const &v) {
  cout << "[";
  for (int i = 0; i < v.size(); i++) {
    if (i) cout << ", ";
    cout << v[i];
  }
  return cout << "]";
}
mt19937 rng(steady_clock::now().time_since_epoch().count());
const long long mod = 998244353;
long long madd(long long a, long long b) { return (a + b) % mod; }
long long msub(long long a, long long b) {
  return (((a - b) % mod) + mod) % mod;
}
long long mmul(long long a, long long b) {
  return ((a % mod) * (b % mod)) % mod;
}
long long mpow(long long base, long long exp) {
  long long res = 1;
  while (exp) {
    if (exp % 2 == 1) {
      res = (res * base) % mod;
    }
    exp >>= 1;
    base = (base * base) % mod;
  }
  return res;
}
long long minv(long long base) { return mpow(base, mod - 1); }
long long mdiv(long long a, long long b) { return mmul(a, minv(b)); }
long long gcd(long long x, long long y) {
  if (y == 0) return x;
  return gcd(y, x % y);
}
bool prime[10000006];
void sieve(int n) {
  for (long long i = 0; i < n + 1; i++) prime[i] = 1;
  for (int p = 2; p * p <= n; p++) {
    if (prime[p] == true) {
      for (int i = p * p; i <= n; i += p) prime[i] = false;
    }
  }
  prime[1] = prime[0] = 0;
}
long long n, q, Q, T, m, k, l, r, x, y, z, g;
vector<long long> turns[200002][3];
long long dp[200001][11];
long long a[11];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  cin >> n;
  for (long long i = 0; i < n; i++) {
    cin >> k;
    for (long long j = 0; j < k; j++) {
      cin >> x >> y;
      turns[i + 1][--x].push_back(y);
    }
    for (long long j = 0; j < 3; j++) {
      sort(turns[i + 1][j].begin(), turns[i + 1][j].end());
      reverse(turns[i + 1][j].begin(), turns[i + 1][j].end());
    }
  }
  for (long long i = 0; i < n + 1; i++)
    for (long long j = 0; j < 10; j++) dp[i][j] = -1;
  for (long long j = 0; j < 10; j++) dp[0][j] = -1;
  dp[0][0] = 0;
  for (long long i = 1; i < n + 1; i++) {
    for (long long j = 0; j < 10; j++) a[j] = -1;
    for (long long j = 0; j < 10; j++) {
      if (dp[i - 1][j] != -1) {
        a[j] = max(a[j], dp[i - 1][j]);
        if (j + 1 > 9) {
          if (turns[i][0].size())
            a[(j + 1) % 10] =
                max(a[(j + 1) % 10], dp[i - 1][j] + 2 * turns[i][0][0]);
          if (turns[i][1].size())
            a[(j + 1) % 10] =
                max(a[(j + 1) % 10], dp[i - 1][j] + 2 * turns[i][1][0]);
          if (turns[i][2].size())
            a[(j + 1) % 10] =
                max(a[(j + 1) % 10], dp[i - 1][j] + 2 * turns[i][2][0]);
        } else {
          if (turns[i][0].size())
            a[(j + 1) % 10] =
                max(a[(j + 1) % 10], dp[i - 1][j] + turns[i][0][0]);
          if (turns[i][1].size())
            a[(j + 1) % 10] =
                max(a[(j + 1) % 10], dp[i - 1][j] + turns[i][1][0]);
          if (turns[i][2].size())
            a[(j + 1) % 10] =
                max(a[(j + 1) % 10], dp[i - 1][j] + turns[i][2][0]);
        }
        if (j + 2 > 9) {
          if (turns[i][0].size() > 1)
            a[(j + 2) % 10] =
                max(a[(j + 2) % 10],
                    dp[i - 1][j] + 2 * turns[i][0][0] + turns[i][0][1]);
          if (turns[i][0].size() && turns[i][1].size())
            a[(j + 2) % 10] =
                max(a[(j + 2) % 10],
                    dp[i - 1][j] + 2 * max(turns[i][0][0], turns[i][1][0]) +
                        min(turns[i][0][0], turns[i][1][0]));
        } else {
          if (turns[i][0].size() > 1)
            a[(j + 2) % 10] =
                max(a[(j + 2) % 10],
                    dp[i - 1][j] + turns[i][0][0] + turns[i][0][1]);
          if (turns[i][0].size() && turns[i][1].size())
            a[(j + 2) % 10] =
                max(a[(j + 2) % 10],
                    dp[i - 1][j] + turns[i][0][0] + turns[i][1][0]);
        }
        if (j + 3 > 9) {
          if (turns[i][0].size() > 2)
            a[(j + 3) % 10] =
                max(a[(j + 3) % 10], dp[i - 1][j] + 2 * turns[i][0][0] +
                                         turns[i][0][1] + turns[i][0][2]);
        } else {
          if (turns[i][0].size() > 2)
            a[(j + 3) % 10] =
                max(a[(j + 3) % 10], dp[i - 1][j] + turns[i][0][0] +
                                         turns[i][0][1] + turns[i][0][2]);
        }
      }
    }
    for (long long j = 0; j < 10; j++) dp[i][j] = a[j];
  }
  long long ans = 0;
  for (long long i = 0; i < 10; i++) ans = max(dp[n][i], ans);
  cout << ans << endl;
}
