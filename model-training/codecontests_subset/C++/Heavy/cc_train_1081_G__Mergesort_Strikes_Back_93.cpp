#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e5 + 5;
char buf[1 << 12], *pp1 = buf, *pp2 = buf, nc;
int ny;
inline char gc() {
  return pp1 == pp2 &&
                 (pp2 = (pp1 = buf) + fread(buf, 1, 1 << 12, stdin), pp1 == pp2)
             ? EOF
             : *pp1++;
}
inline int read() {
  int x = 0;
  for (ny = 1; nc = gc(), (nc < 48 || nc > 57) && nc != EOF;)
    if (nc == 45) ny = -1;
  if (nc < 0) return nc;
  for (x = nc - 48; nc = gc(), 47 < nc && nc < 58 && nc != EOF;
       x = (x << 3) + (x << 1) + (nc ^ 48))
    ;
  return x * ny;
}
int n, k, Mod, Fac[MAXN], iFac[MAXN], ans, t[MAXN], bel[MAXN], cnt, len[MAXN],
    inv[MAXN], sum[MAXN];
inline int C(int n, int m) {
  return n < 0 || m < 0 || n < m
             ? 0
             : 1ll * Fac[n] * iFac[m] % Mod * iFac[n - m] % Mod;
}
inline int Fp(int x, int k) {
  int ans = 1;
  for (; k; k >>= 1, x = 1ll * x * x % Mod)
    if (k & 1) ans = 1ll * ans * x % Mod;
  return ans;
}
int t1, t2;
inline int calc(int len1, int len2) {
  int ans = 0;
  for (int i = (0); i <= (len1 - 1); i++)
    ans = (ans + 1ll * i * (sum[i + len2 + 1] - sum[i + 1] + Mod) % Mod) % Mod;
  return 1ll * ans * (Mod + 1 >> 1) % Mod;
}
inline void Div(int l, int r, int h) {
  if (h == k || l == r) {
    len[++cnt] = r - l + 1;
    return;
  }
  int mid = l + r >> 1;
  Div(l, mid, h + 1), Div(mid + 1, r, h + 1);
}
int main() {
  n = read(), k = read() - 1, Mod = read(), Div(1, n, 0);
  if (k > 20) return puts("0"), 0;
  Fac[0] = 1;
  for (int i = (1); i <= (n); i++) Fac[i] = 1ll * Fac[i - 1] * i % Mod;
  iFac[n] = Fp(Fac[n], Mod - 2);
  for (int i = (n); i >= (1); i--) iFac[i - 1] = 1ll * iFac[i] * i % Mod;
  for (int i = (1); i <= (n); i++)
    inv[i] = 1ll * iFac[i] * Fac[i - 1] % Mod,
    sum[i] = (sum[i - 1] + inv[i]) % Mod;
  if (k) {
    for (int i = (1); i <= (cnt); i++)
      if (len[i] == ((n >> k)))
        t1++;
      else
        t2++;
    ans = (calc(n >> k, n >> k) * (1ll * t1 * (t1 - 1) % Mod) +
           (calc(n >> k, (n >> k) + 1) + calc((n >> k) + 1, n >> k)) *
               (1ll * t1 * t2 % Mod) +
           calc((n >> k) + 1, (n >> k) + 1) * (1ll * t2 * (t2 - 1) % Mod)) %
          Mod;
  }
  for (int i = (1); i <= (cnt); i++)
    ans =
        (ans + (1ll * len[i] * (len[i] - 1) / 2 % Mod) * (Mod + 1 >> 1) % Mod) %
        Mod;
  cout << ans << "\n";
  return 0;
}
