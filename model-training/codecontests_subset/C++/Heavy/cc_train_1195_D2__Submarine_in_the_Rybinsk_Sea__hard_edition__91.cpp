#include <bits/stdc++.h>
using namespace std;
long long int binpow(long long int a, long long int b, long long int mod) {
  long long int ans = 1;
  while (b) {
    if (b & 1) ans = (ans * a) % mod;
    a = (a * a) % mod;
    b >>= 1;
  }
  return ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int TESTS = 1;
  while (TESTS--) {
    long long int n, a[100005];
    cin >> n;
    for (int i = 1; i <= n; i++) cin >> a[i];
    map<long long int, long long int> lol, hol;
    for (int i = 1; i <= n; i++) {
      long long int u = a[i];
      long long int o = 0;
      while (u > 0) {
        u /= 10;
        o++;
      }
      lol[o]++;
    }
    long long int ans = 0;
    for (int i = 1; i <= n; i++) {
      long long int x = a[i];
      std::vector<long long int> v;
      while (x > 0) {
        v.push_back(x % 10);
        x /= 10;
      }
      for (int j = 1; j <= 12; j++) {
        long long int c = 1, temp = 0, temp2 = 0;
        long long int len = v.size();
        if (len >= j) {
          for (int k = 1; k <= j; k++) {
            long long int q = binpow(10, c, 998244353);
            temp = (temp + (v[k - 1] * q) % 998244353) % 998244353;
            long long int yt = binpow(10, c - 1, 998244353);
            temp2 = (temp2 + (v[k - 1] * yt) % 998244353) % 998244353;
            c += 2;
          }
          c = 2 * j;
          for (int k = j + 1; k <= len; k++) {
            long long int q = binpow(10, c, 998244353);
            temp = (temp + (v[k - 1] * q) % 998244353) % 998244353;
            temp2 = (temp2 + (v[k - 1] * q) % 998244353) % 998244353;
            c += 1;
          }
        } else {
          c = 1;
          for (int k = 1; k <= len; k++) {
            long long int q = binpow(10, c, 998244353);
            long long int yt = binpow(10, c - 1, 998244353);
            temp = (temp + (v[k - 1] * q) % 998244353) % 998244353;
            temp2 = (temp2 + (v[k - 1] * yt) % 998244353) % 998244353;
            c += 2;
          }
        }
        ans = (ans + ((temp * (lol[j])) % 998244353 +
                      (temp2 * (lol[j])) % 998244353) %
                         998244353) %
              998244353;
      }
    }
    cout << ans;
  }
  return 0;
}
