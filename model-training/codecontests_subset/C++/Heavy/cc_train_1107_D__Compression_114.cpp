#include <bits/stdc++.h>
using namespace std;
inline long long fpow(long long n, long long k, int p = 998244353) {
  long long r = 1;
  for (; k; k >>= 1) {
    if (k & 1) r = r * n % p;
    n = n * n % p;
  }
  return r;
}
inline long long inv(long long a, long long p = 998244353) {
  return fpow(a, p - 2, p);
}
inline long long addmod(long long a, long long val, long long p = 998244353) {
  {
    if ((a = (a + val)) >= p) a -= p;
  }
  return a;
}
inline long long submod(long long a, long long val, long long p = 998244353) {
  {
    if ((a = (a - val)) < 0) a += p;
  }
  return a;
}
inline long long mult(long long a, long long b, long long p = 998244353) {
  return (long long)a * b % p;
}
bool is_digit(char x) { return x - '0' >= 0 && x - '0' <= 9; }
int conv(char x) {
  if (is_digit(x)) return x - '0';
  return x - 'A' + 10;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int n;
  cin >> n;
  vector<vector<int> > arr(n, vector<int>(n));
  for (int i = 0; i < n; i++) {
    string s;
    cin >> s;
    for (int j = 0; j < n; j++) {
      arr[i][j] = ((conv(s[j / 4])) >> (3 - j % 4)) & 1;
    }
  }
  vector<vector<int> > sum(n + 1, vector<int>(n + 1, 0));
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      sum[i][j] =
          sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + arr[i - 1][j - 1];
    }
  }
  bool check = true;
  for (int x = n; x >= 1; x--) {
    if (n % x) continue;
    check = true;
    for (int i = 1; i <= n; i += x) {
      for (int j = 1; j <= n; j += x) {
        int currsum = sum[i + x - 1][j + x - 1] + sum[i - 1][j - 1] -
                      sum[i + x - 1][j - 1] - sum[i - 1][j + x - 1];
        if (currsum != 0 && currsum != x * x) {
          check = false;
          break;
        }
      }
      if (!check) break;
    }
    if (check) {
      cout << x << "\n";
      return 0;
    }
  }
}
