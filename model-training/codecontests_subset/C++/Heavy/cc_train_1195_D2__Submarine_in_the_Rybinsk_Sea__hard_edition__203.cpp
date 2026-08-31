#include <bits/stdc++.h>
using namespace std;
const int N = 1e5;
const long long LIM = 1e18;
const int INF = 0x3f3f3f3f;
const double eps = 1e-4;
const double PI = atan(1.0) * 4;
const int mod = 998244353;
int n, a[N + 10];
vector<int> d[12];
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> a[i];
  for (int i = 1; i <= n; i++) {
    int tmp = a[i], c = 0;
    while (tmp) {
      tmp /= 10;
      c++;
    }
    d[c].push_back(a[i]);
  }
  int ans = 0;
  for (int i = 1; i < 10; i++)
    for (int j = i + 1; j <= 10; j++) {
      int tmp = 0;
      int sz1 = (int)d[i].size(), sz2 = (int)d[j].size();
      if (!sz1 || !sz2) continue;
      int bas = 1;
      for (int k = 1; k <= i; k++) bas *= 10;
      for (int k = 0; k < sz1; k++) {
        int num = 0, cop = d[i][k];
        vector<int> v;
        for (int h = 0; h < i; h++) {
          v.push_back(cop % 10);
          cop /= 10;
        }
        for (int h = i - 1; h >= 0; h--)
          num = (100LL * num % mod + 11 * v[h]) % mod;
        tmp = (tmp + 1LL * num * sz2 % mod) % mod;
      }
      int bas1 = 1;
      for (int k = 0; k < 2 * i; k++) bas1 = 10LL * bas1 % mod;
      for (int k = 0; k < sz2; k++) {
        int num = 0, cop = d[j][k] % bas;
        vector<int> v;
        for (int h = 0; h < i; h++) {
          v.push_back(cop % 10);
          cop /= 10;
        }
        for (int h = i - 1; h >= 0; h--)
          num = (100LL * num % mod + 11 * v[h]) % mod;
        tmp = (tmp + 1LL * num * sz1 % mod) % mod;
        tmp = (tmp + 2LL * (d[j][k] / bas) * bas1 % mod * sz1 % mod) % mod;
      }
      ans = (ans + tmp) % mod;
    }
  for (int i = 1; i <= 10; i++) {
    int sz = (int)d[i].size();
    if (!sz) continue;
    for (int j = 0; j < sz; j++) {
      int num = 0, cop = d[i][j];
      vector<int> v;
      for (int h = 0; h < i; h++) {
        v.push_back(cop % 10);
        cop /= 10;
      }
      for (int h = i - 1; h >= 0; h--)
        num = (100LL * num % mod + 11 * v[h]) % mod;
      ans = (ans + 1LL * num * (sz) % mod) % mod;
    }
  }
  cout << ans;
  return 0;
}
