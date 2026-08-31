#include <bits/stdc++.h>
using namespace std;
inline long long read() {
  char ch = getchar();
  long long s = 0, w = 1;
  while (ch < '0' || ch > '9') {
    if (ch == '-') w = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    s = s * 10 + ch - '0';
    ch = getchar();
  }
  return s * w;
}
inline int lowbit(int x) { return x & (-x); }
int mod, n, h;
int k[2], m[2];
int ans, inv2;
inline int Z(int x) { return (x >= mod ? x - mod : x); }
inline int C2(int n) { return 1LL * n * (n - 1) % mod * inv2 % mod; }
inline int ksm(int a, int b) {
  int ans = 1;
  while (b) {
    if (b & 1) ans = 1LL * ans * a % mod;
    b >>= 1;
    a = 1LL * a * a % mod;
  }
  return ans;
}
void Solve(int l, int r, int h) {
  if (h == 1 || l == r) {
    if (!k[0]) {
      k[0] = r - l + 1;
      m[0]++;
    } else if (k[0] == r - l + 1)
      m[0]++;
    else
      k[1] = r - l + 1, m[1]++;
    ans = Z(ans + 1LL * inv2 * C2(r - l + 1) % mod);
    return;
  }
  Solve(l, ((l + r) >> 1), h - 1);
  Solve(((l + r) >> 1) + 1, r, h - 1);
}
inline int calc(int n, int m) {
  int s = 1LL * inv2 * n % mod * m % mod;
  int l = 1, r = 0;
  for (register int S = 2; S <= n + m; S++) {
    while (l + m < S) l++;
    while (r < S - 1 && r < n) r++;
    if (l > r) break;
    s = Z(s + mod - 1LL * ksm(S, mod - 2) * (r - l + 1) % mod);
  }
  return s;
}
int main() {
  n = read(), h = read(), mod = read();
  inv2 = ksm(2, mod - 2);
  Solve(1, n, h);
  if (!k[1]) {
    ans = Z(ans + 1LL * C2(m[0]) * calc(k[0], k[0]) % mod);
  } else {
    ans = Z(ans + 1LL * C2(m[0]) * calc(k[0], k[0]) % mod);
    ans = Z(ans + 1LL * C2(m[1]) * calc(k[1], k[1]) % mod);
    ans = Z(ans + 1LL * m[0] * m[1] % mod * calc(k[0], k[1]) % mod);
  }
  cout << ans << '\n';
  return 0;
}
