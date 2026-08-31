#include <bits/stdc++.h>
using namespace std;
map<int, int> mp;
int n, k, mod, inv2;
int ans = 0;
inline void add(int& a, int b) {
  a += b;
  if (a >= mod) a -= mod;
  if (a < 0) a += mod;
}
inline int ksm(int a, int b) {
  int ans = 1;
  for (; b; b >>= 1, a = (long long)a * a % mod)
    if (b & 1) ans = (long long)ans * a % mod;
  return ans;
}
inline void build(int l, int r, int h) {
  if (l < r) {
    if (h <= 1) {
      int len = r - l + 1;
      mp[len]++;
      add(ans, (long long)len * (len - 1) / 2ll % mod * inv2 % mod);
    } else {
      int mid = (l + r) >> 1;
      build(l, mid, h - 1);
      build(mid + 1, r, h - 1);
    }
  } else
    mp[1]++;
}
signed main() {
  cin >> n >> k >> mod;
  inv2 = ksm(2, mod - 2);
  build(1, n, k);
  for (auto i : mp) {
    for (auto j : mp) {
      int gs = (long long)i.second * (j.second - (i.first == j.first)) % mod;
      for (int l = 2; l <= i.first + j.first; ++l) {
        int minn = max(1, l - j.first);
        int maxx = min(i.first, l - 1);
        int tmp = (long long)gs * (maxx - minn + 1) % mod *
                  (inv2 - ksm(l, mod - 2)) % mod * inv2 % mod;
        add(ans, tmp);
      }
    }
  }
  cout << ans;
  return 0;
}
