#include <bits/stdc++.h>
using namespace std;
int n, k, mod;
long long inv[100009], sum[100009], ans;
map<int, int> tong;
map<int, int>::iterator it1, it2;
inline long long rd() {
  long long x = 0;
  char c = getchar();
  bool f = 0;
  while (!isdigit(c)) {
    if (c == '-') f = 1;
    c = getchar();
  }
  while (isdigit(c)) {
    x = (x << 1) + (x << 3) + (c ^ 48);
    c = getchar();
  }
  return f ? -x : x;
}
inline long long power(long long x, long long y) {
  long long ans = 1;
  while (y) {
    if (y & 1) ans = ans * x % mod;
    x = x * x % mod;
    y >>= 1;
  }
  return ans;
}
inline void MOD(long long &x) { x = x >= mod ? x - mod : x; }
inline long long C(long long n) { return n * (n - 1) / 2 % mod; }
inline void solve(int l, int r, int k) {
  if (k == 1 || l == r) {
    tong[r - l + 1]++;
    return;
  }
  int mid = (l + r) >> 1;
  solve(l, mid, k - 1);
  solve(mid + 1, r, k - 1);
}
inline long long calc(int a, int b) {
  long long ans = 1ll * a * b % mod * inv[2] % mod;
  for (int i = 1; i <= a; ++i) MOD(ans = ans - (sum[i + b] - sum[i]) + mod);
  return ans;
}
int main() {
  n = rd();
  k = rd();
  mod = rd();
  for (int i = 1; i <= n; ++i)
    inv[i] = power(i, mod - 2), MOD(sum[i] = sum[i - 1] + inv[i]);
  solve(1, n, k);
  for (it1 = tong.begin(); it1 != tong.end(); ++it1) {
    MOD(ans += C(it1->first) * inv[2] % mod * it1->second % mod);
    MOD(ans += C(it1->second) * calc(it1->first, it1->first) % mod);
  }
  for (it1 = tong.begin(); it1 != tong.end(); ++it1)
    for (it2 = tong.begin(); it2 != tong.end(); ++it2) {
      if (it1->first <= it2->first) break;
      MOD(ans += 1ll * it1->second * it2->second % mod *
                 calc(it1->first, it2->first) % mod);
    }
  cout << ans;
  return 0;
}
