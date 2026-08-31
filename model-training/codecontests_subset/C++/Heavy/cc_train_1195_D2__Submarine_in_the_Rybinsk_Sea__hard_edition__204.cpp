#include <bits/stdc++.h>
using namespace std;
const int inf = 1e9 + 7;
const int maxn = 10000;
const long long mod = 998244353;
bool is_prime(int x) {
  for (int i = 2; i <= sqrt(x); i++) {
    if (x % i == 0) return 0;
  }
  if (x < 2) return 0;
  return 1;
}
int main() {
  int n;
  cin >> n;
  pair<int, int> a[n];
  int b[15][15];
  int g[15];
  long long c[30];
  c[1] = 1ll;
  for (int i = 2; i < 30; i++) {
    c[i] = c[i - 1] * 10;
    c[i] = c[i] % mod;
  }
  memset(g, 0, sizeof g);
  memset(b, 0, sizeof(b));
  for (int i = 0; i < n; i++) {
    cin >> a[i].first;
    int t = a[i].first, k = 0;
    while (t != 0) {
      k++;
      t = t / 10;
    }
    int kk = 1;
    t = a[i].first;
    g[k]++;
    a[i].second = k;
    while (t != 0) {
      int kkk = t % 10;
      b[k][kk] += kkk;
      kk++;
      t = t / 10;
    }
  }
  sort(a, a + n);
  long long ans = 0;
  for (int i = 1; i < 15; i++) {
    for (int j = 1; j < 15; j++) {
      if (i <= j) {
        for (int ii = 1; ii <= i; ii++) {
          long long cc = b[i][ii] * c[ii * 2];
          cc = cc % mod;
          cc *= g[j];
          cc = cc % mod;
          ans += cc;
          ans = ans % mod;
        }
        for (int jj = 1; jj <= i; jj++) {
          long long cc = b[j][jj] * c[jj * 2 - 1];
          cc = cc % mod;
          cc *= g[i];
          cc = cc % mod;
          ans += cc;
          ans = ans % mod;
        }
        for (int jj = i + 1; jj <= j; jj++) {
          long long cc = b[j][jj] * c[jj - i + i * 2];
          cc = cc % mod;
          cc *= g[i];
          cc = cc % mod;
          ans += cc;
          ans = ans % mod;
        }
      } else {
        for (int ii = 1; ii <= j; ii++) {
          long long cc = b[i][ii] * c[ii * 2];
          cc = cc % mod;
          cc *= g[j];
          cc = cc % mod;
          ans += cc;
          ans = ans % mod;
        }
        for (int jj = 1; jj <= j; jj++) {
          long long cc = b[j][jj] * c[jj * 2 - 1];
          cc = cc % mod;
          cc *= g[i];
          cc = cc % mod;
          ans += cc;
          ans = ans % mod;
        }
        for (int ii = j + 1; ii <= i; ii++) {
          long long cc = b[i][ii] * c[ii - j + j * 2];
          cc = cc % mod;
          cc *= g[j];
          cc = cc % mod;
          ans += cc;
          ans = ans % mod;
        }
      }
    }
  }
  cout << ans;
  return 0;
}
