#include <bits/stdc++.h>
using namespace std;
inline int read() {
  char c = getchar();
  int x = 0;
  bool f = 0;
  for (; !isdigit(c); c = getchar()) f ^= !(c ^ 45);
  for (; isdigit(c); c = getchar()) x = (x << 1) + (x << 3) + (c ^ 48);
  if (f) x = -x;
  return x;
}
int mod;
struct modint {
  int x;
  modint(int o = 0) { x = o; }
  modint &operator=(int o) { return x = o, *this; }
  modint &operator+=(modint o) {
    return x = x + o.x >= mod ? x + o.x - mod : x + o.x, *this;
  }
  modint &operator-=(modint o) {
    return x = x - o.x < 0 ? x - o.x + mod : x - o.x, *this;
  }
  modint &operator*=(modint o) { return x = 1ll * x * o.x % mod, *this; }
  modint &operator^=(int b) {
    modint a = *this, c = 1;
    for (; b; b >>= 1, a *= a)
      if (b & 1) c *= a;
    return x = c.x, *this;
  }
  modint &operator/=(modint o) { return *this *= o ^= mod - 2; }
  modint &operator+=(int o) {
    return x = x + o >= mod ? x + o - mod : x + o, *this;
  }
  modint &operator-=(int o) {
    return x = x - o < 0 ? x - o + mod : x - o, *this;
  }
  modint &operator*=(int o) { return x = 1ll * x * o % mod, *this; }
  modint &operator/=(int o) { return *this *= ((modint(o)) ^= mod - 2); }
  template <class I>
  friend modint operator+(modint a, I b) {
    return a += b;
  }
  template <class I>
  friend modint operator-(modint a, I b) {
    return a -= b;
  }
  template <class I>
  friend modint operator*(modint a, I b) {
    return a *= b;
  }
  template <class I>
  friend modint operator/(modint a, I b) {
    return a /= b;
  }
  friend modint operator^(modint a, int b) { return a ^= b; }
  friend bool operator==(modint a, int b) { return a.x == b; }
  friend bool operator!=(modint a, int b) { return a.x != b; }
  bool operator!() { return !x; }
  modint operator-() { return x ? mod - x : 0; }
};
inline modint qpow(modint a, int b) { return a ^ b; }
int n, k;
map<int, int> mp;
modint iv[100005], sum[100005];
void div(int l, int r, int k) {
  if (k <= 1 || l == r) return mp[r - l + 1]++, void();
  int mid = l + r >> 1;
  div(l, mid, k - 1), div(mid + 1, r, k - 1);
}
modint getprob(int x, int y) {
  modint res = modint(x) * y;
  for (register int i = (1); i <= (x); ++i) res -= 2 * (sum[i + y] - sum[i]);
  return res;
}
signed main() {
  n = read(), k = read(), mod = read();
  iv[1] = 1;
  for (register int i = (2); i <= (max(4, n)); ++i)
    iv[i] = iv[mod % i] * (mod - mod / i);
  for (register int i = (1); i <= (n); ++i) sum[i] = sum[i - 1] + iv[i];
  div(1, n, k);
  modint res = 0;
  for (auto it1 : mp)
    for (auto it2 : mp) {
      if (it1.first == it2.first) {
        int cnt = it1.second, len = it1.first;
        res += iv[2] * len * (len - 1) * cnt;
        res += modint(cnt) * (cnt - 1) * iv[2] * getprob(len, len);
      } else if (it1.first < it2.first) {
        int l1 = it1.first, l2 = it2.first, c1 = it1.second, c2 = it2.second;
        res += getprob(l1, l2) * c1 * c2;
      }
    }
  res *= iv[2];
  cout << res.x;
  return 0;
}
