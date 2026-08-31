#include <bits/stdc++.h>
using namespace std;
vector<long long int> divisors;
bool a[5205][5205];
long long dp[5205][5205];
map<char, long long> m;
long long power(long long a, long long b) {
  if (b == 0) return 1;
  if (b == 1) return a;
  if (b % 2 == 1) return (power(a, b - 1) * a) % 1000000007;
  long long q = power(a, b / 2);
  return (q * q) % 1000000007;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int TESTS = 1;
  while (TESTS--) {
    long long n;
    cin >> n;
    for (long long int i = 1; i < n + 1; i++) {
      if (n % i == 0) divisors.push_back(i);
    }
    for (long long int i = 0; i < 10; i++) {
      m[(char)('0' + i)] = i;
    }
    for (long long int i = 0; i < 6; i++) {
      m[(char)('A' + i)] = 10 + i;
    }
    long long p = n / 4;
    for (long long int i = 1; i < n + 1; i++) {
      string s;
      cin >> s;
      for (long long int j = 0; j < p; j++) {
        long long g = m[s[j]], c = 0;
        while (g > 0) {
          if (g % 2 == 1) a[i][4 * (j + 1) - c] = 1;
          g /= 2;
          c++;
        }
      }
    }
    for (long long int i = 1; i < n + 1; i++) {
      for (long long int j = 1; j < n + 1; j++) {
        dp[i][j] = dp[i][j - 1] + a[i][j];
      }
    }
    for (long long int j = 1; j < n + 1; j++) {
      for (long long int i = 1; i < n + 1; i++) {
        dp[i][j] += dp[i - 1][j];
      }
    }
    long long ans = 0;
    long long f = 0;
    for (auto u : divisors) {
      u = n / u;
      f = 0;
      for (int i = u; i <= n; i += u) {
        for (int j = u; j <= n; j += u) {
          long long k =
              dp[i][j] + dp[i - u][j - u] - dp[i - u][j] - dp[i][j - u];
          if (k != u * u && k != 0) {
            f = 1;
            break;
          }
        }
        if (f) break;
      }
      if (!f) {
        ans = u;
        break;
      }
    }
    cout << ans;
  }
  return 0;
}
