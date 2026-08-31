#include <bits/stdc++.h>
using namespace std;
const long long N = 1e6 + 7;
const double PI = acos(-1);
long long mod = 998244353;
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  vector<pair<long long, long long>> v;
  long long n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    long long a;
    cin >> a;
    long long b = a;
    long long cnt = 0;
    while (b) {
      cnt++;
      b /= 10;
    }
    v.push_back({cnt, a});
  }
  sort(v.begin(), v.end());
  vector<long long> tmp;
  long long presum = 0;
  long long pre[N];
  int idx = 1;
  pre[0] = 0;
  for (auto it : v) {
    tmp.push_back(it.first);
    long long len = it.first;
    long long pow = 1;
    len--;
    while (len--) {
      pow *= 10;
      pow %= mod;
    }
    presum += pow;
    presum %= mod;
    pre[idx] = presum;
    idx++;
  }
  long long ans = 0;
  for (auto it : v) {
    long long a = it.second;
    long long idx = 0;
    while (a) {
      long long d = a % 10;
      int low = lower_bound(tmp.begin(), tmp.end(), idx) - tmp.begin();
      long long ng = n - low;
      long long val = 2 * idx;
      long long pow = 1;
      while (val--) {
        pow *= 10;
        pow %= mod;
      }
      long long mul = 1;
      val = idx + 1;
      while (val--) {
        mul *= 10;
        mul %= mod;
      }
      ans += d * (((ng * pow) % mod + (pre[low] * mul) % mod) % mod);
      ans %= mod;
      low = lower_bound(tmp.begin(), tmp.end(), idx + 1) - tmp.begin();
      ng = n - low;
      val = 2 * idx + 1;
      pow = 1;
      while (val--) {
        pow *= 10;
        pow %= mod;
      }
      ans += d * (((ng * pow) % mod + (pre[low] * mul) % mod) % mod);
      ans %= mod;
      a /= 10;
      idx++;
    }
  }
  cout << ans << "\n";
  return 0;
}
