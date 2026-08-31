#include <bits/stdc++.h>
using namespace std;
int mod;
const int maxn = 200111;
map<int, int> mp;
int n, k;
long long inv[maxn];
int id[maxn], g[maxn], gn;
long long sum;
long long calc(long long a, long long b) {
  long long ret = 0;
  for (int i = 2; i <= a + b; i++) {
    long long l = max(1ll, i - b), r = min(i - 1ll, a);
    long long cnt = max(0ll, r - l + 1);
    ret = (ret + cnt * inv[i]) % mod;
  }
  return ret;
}
void solve(int l, int r, int k) {
  if (l == r || k == 1) {
    gn++;
    for (int i = l; i <= r; i++) id[i] = i - l + 1, g[i] = gn;
    mp[r - l + 1]++;
    return;
  }
  int m = l + r >> 1;
  solve(l, m, k - 1);
  solve(m + 1, r, k - 1);
}
int main() {
  cin >> n >> k >> mod;
  inv[1] = 1;
  for (int i = 2; i < maxn; i++)
    inv[i] = mod - 1ll * (mod / i) * inv[mod % i] % mod;
  solve(1, n, k);
  long long ans = (1ll * n * (n - 1) / 2) % mod;
  for (auto x : mp) {
    for (auto y : mp) {
      if (x.first > y.first) continue;
      if (x.first == y.first) {
        ans = (ans - 2ll * (1ll * x.second * (x.second - 1) / 2) % mod *
                         calc(x.first, x.first)) %
              mod;
      } else
        ans = (ans - 2ll * x.second * y.second % mod * calc(x.first, y.first)) %
              mod;
    }
  }
  cout << ((ans * inv[2] % mod) + mod) % mod << endl;
  return 0;
}
