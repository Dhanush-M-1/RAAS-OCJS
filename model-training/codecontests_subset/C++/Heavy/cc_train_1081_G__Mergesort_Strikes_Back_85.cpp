#include <bits/stdc++.h>
using namespace std;
long long mod, inv2;
vector<pair<long long, long long> > vec;
long long inv[20000005], ans, sum;
long long calc(long long len) { return len * (len - 1) % mod * inv2 % mod; }
void merge(long long l, long long r, long long h) {
  if (h == 1 || l == r) {
    long long len = r - l + 1;
    ans += calc(len) * inv2 % mod;
    ans %= mod;
    for (long long i = 0; i < (long long)vec.size(); ++i)
      if (vec[i].first == len) {
        ++vec[i].second;
        return;
      }
    return vec.push_back(make_pair(len, 1)), void(0);
  }
  long long mid = (l + r) >> 1;
  merge(l, mid, h - 1);
  merge(mid + 1, r, h - 1);
}
void init(long long n) {
  inv[1] = 1;
  for (long long i = 2; i <= n; ++i)
    inv[i] = 1ll * (mod - (mod / i)) * inv[mod % i] % mod;
  for (long long i = 1; i <= n; ++i) inv[i] = (inv[i] + inv[i - 1]) % mod;
}
signed main() {
  long long n, K;
  cin >> n >> K >> mod;
  inv2 = (mod + 1) / 2;
  init(n + n);
  merge(1, n, K);
  for (long long i = 0; i < (long long)vec.size(); ++i)
    for (long long j = i; j < (long long)vec.size(); ++j) {
      long long lenA = vec[i].first, lenB = vec[j].first;
      long long cntA = vec[i].second, cntB = vec[j].second;
      sum = 0;
      for (long long k = 1; k <= lenA; ++k)
        sum = (sum + inv[k + lenB] - inv[k] + mod) % mod;
      long long tot = (i == j ? calc(cntA) : cntA * cntB) % mod;
      ans += tot * ((lenA * lenB % mod * inv2 % mod - sum + mod) % mod) % mod;
      ans %= mod;
    }
  cout << ans;
  return 0;
}
