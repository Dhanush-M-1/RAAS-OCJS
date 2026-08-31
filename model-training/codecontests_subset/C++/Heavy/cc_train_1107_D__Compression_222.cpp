#include <bits/stdc++.h>
using namespace std;
long long mod = 1000000007;
long long mod2 = 998244353;
long long mod3 = 1000003;
long long mod4 = 998244853;
long long mod5 = 1000000009;
long long inf = 1LL << 62;
int iinf = 1 << 30;
double pi = 3.141592653589793238462643383279L;
double eps = 1e-14;
int dh[4] = {1, -1, 0, 0};
int dw[4] = {0, 0, 1, -1};
int ddh[8] = {-1, -1, -1, 0, 0, 1, 1, 1};
int ddw[8] = {-1, 0, 1, -1, 1, -1, 0, 1};
struct custom_hash {
  static uint64_t splitmix64(uint64_t x) {
    x += 0x9e3779b97f4a7c15;
    x = (x ^ (x >> 30)) * 0xbf58476d1ce4e5b9;
    x = (x ^ (x >> 27)) * 0x94d049bb133111eb;
    return x ^ (x >> 31);
  }
  size_t operator()(uint64_t x) const {
    static const uint64_t FIXED_RANDOM =
        chrono::steady_clock::now().time_since_epoch().count();
    return splitmix64(x + FIXED_RANDOM);
  }
};
long long gcd(long long a, long long b) {
  if (a < b) swap(a, b);
  if (b == 0) return a;
  if (a % b == 0) return b;
  return gcd(b, a % b);
}
long long lcm(long long a, long long b) {
  long long c = gcd(a, b);
  return a * b / c;
}
long long Pow(long long n, long long k) {
  long long ret = 1;
  long long now = n;
  while (k > 0) {
    if (k & 1) ret *= now;
    now *= now;
    k /= 2;
  }
  return ret;
}
long long beki(long long n, long long k, long long md) {
  long long ret = 1;
  long long now = n;
  now %= md;
  while (k > 0) {
    if (k % 2 == 1) {
      ret *= now;
      ret %= md;
    }
    now *= now;
    now %= md;
    k /= 2;
  }
  return ret;
}
long long gyaku(long long n, long long md) { return beki(n, md - 2, md); }
long long poc(long long n) {
  long long ret = 0;
  long long u = n;
  while (u > 0) {
    ret += u % 2;
    u /= 2;
  }
  return ret;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  int a[n][n];
  for (long long i = 0; i < n; i++) {
    string c;
    cin >> c;
    for (long long j = 0; j < n / 4; j++) {
      int now = j * 4;
      int num = c[j] - '0';
      if (num < 0 || num >= 10) {
        num = 10 + (c[j] - 'A');
      }
      for (long long k = 0; k < 4; k++) {
        a[i][now + k] = (num >> (3 - k)) & 1;
      }
    }
  }
  int sum[n + 1][n + 1];
  for (long long i = 0; i < n + 1; i++) {
    sum[i][0] = 0;
    sum[0][i] = 0;
  }
  for (long long i = 0; i < n; i++) {
    for (long long j = 0; j < n; j++) {
      sum[i + 1][j + 1] = -sum[i][j] + sum[i][j + 1] + sum[i + 1][j] + a[i][j];
    }
  }
  vector<int> v;
  for (long long i = 1; i < n + 1; i++)
    if (n % i == 0) v.push_back(i);
  for (long long i = v.size() - 1; i >= 0; i--) {
    bool bo = true;
    for (int j = v[i]; j <= n; j += v[i]) {
      for (int k = v[i]; k <= n; k += v[i]) {
        int r = sum[j][k] - sum[j][k - v[i]] - sum[j - v[i]][k] +
                sum[j - v[i]][k - v[i]];
        if (r > 0 && r < v[i] * v[i]) {
          bo = false;
          break;
        }
      }
      if (!bo) break;
    }
    if (bo) {
      cout << v[i] << endl;
      return 0;
    }
  }
}
