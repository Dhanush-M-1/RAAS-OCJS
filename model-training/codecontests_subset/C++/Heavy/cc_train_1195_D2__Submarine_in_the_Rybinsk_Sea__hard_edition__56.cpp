#include <bits/stdc++.h>
using namespace std;
long long pow_mod(long long x, long long y) {
  long long r = 1;
  for (; y; y >>= 1, x = (long long)x * x % 998244353)
    if (y & 1) r = (long long)r * x % 998244353;
  return r;
}
int cal(long long x) {
  int ans = 0;
  while (x) {
    ans++;
    x /= 10;
  }
  return ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n;
  cin >> n;
  int mp[20];
  memset(mp, 0, sizeof(mp));
  long long a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    int cnt = cal(a[i]);
    mp[cnt]++;
  }
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    long long x;
    for (int j = 1; j <= 10; j++) {
      x = a[i];
      long long val = 1;
      int k = j;
      while (x) {
        ans = (ans + (mp[j] * val % 998244353) * (x % 10) % 998244353) %
              998244353;
        x /= 10;
        val = (val * 10ll) % 998244353;
        if (k) {
          k--;
          val = (val * 10ll) % 998244353;
        }
      }
    }
    for (int j = 1; j <= 10; j++) {
      x = a[i];
      long long val = 1;
      int k = j;
      while (x) {
        if (k) {
          k--;
          val = (val * 10ll) % 998244353;
        }
        ans = (ans + (mp[j] * val % 998244353) * (x % 10) % 998244353) %
              998244353;
        x /= 10;
        val = (val * 10ll) % 998244353;
      }
    }
  }
  cout << ans;
}
