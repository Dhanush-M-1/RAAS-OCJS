#include <bits/stdc++.h>
using std::cerr;
using std::cout;
int mod;
inline int add(int a, int b) {
  a += b - mod;
  return a + (a >> 31 & mod);
}
inline int dec(int a, int b) {
  a -= b;
  return a + (a >> 31 & mod);
}
inline int mul(int a, int b) {
  long long r = (long long)a * b;
  return r >= mod ? r % mod : r;
}
inline void Inc(int &a, int b) {
  a += b - mod;
  a += a >> 31 & mod;
}
const int N = 1e5 + 7;
int n, k;
int inv[N], H[N];
std::map<int, int> cnt;
inline void solve(int l, int r, int d) {
  if (d == 1 || l == r) {
    cnt[r - l + 1]++;
    return;
  }
  int mid = l + r >> 1;
  solve(l, mid, d - 1);
  solve(mid + 1, r, d - 1);
}
inline int calc(int x, int y) {
  int ans = mul(x, y);
  ans = mul(ans, mod + 1 >> 1);
  for (int register i = 1; i <= x; ++i) Inc(ans, dec(H[i], H[i + y]));
  return ans;
}
signed main() {
  scanf("%d%d%d", &n, &k, &mod);
  int iv2 = mod + 1 >> 1, iv4 = mul(iv2, iv2);
  inv[0] = inv[1] = H[0] = H[1] = 1;
  for (int register i = 2; i <= n; ++i)
    H[i] = add(H[i - 1], inv[i] = mul(mod - mod / i, inv[mod % i]));
  solve(1, n, k);
  int ans = 0;
  for (auto t : cnt) {
    Inc(ans, mul(mul(t.first, t.first - 1), mul(iv4, t.second)));
    Inc(ans,
        mul(mul(t.second, t.second - 1), mul(iv2, calc(t.first, t.first))));
  }
  for (auto i1 : cnt)
    for (auto i2 : cnt)
      if (i1.first < i2.first) {
        Inc(ans, mul(calc(i1.first, i2.first), mul(i1.second, i2.second)));
      }
  cout << ans << "\n";
  return 0;
}
