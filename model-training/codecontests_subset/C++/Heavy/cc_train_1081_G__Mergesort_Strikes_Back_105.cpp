#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 10;
int n, k, P, inv[N], ans, f[2], c[2];
inline void upd(int &x, int y) { ((x += y) > P) && (x -= P); }
void sol(int l, int r, int k) {
  if (!k || l == r) {
    int len = r - l + 1;
    c[len & 1] = len;
    f[len & 1]++;
    return;
  }
  int mid = (l + r) >> 1;
  sol(l, mid, k - 1);
  sol(mid + 1, r, k - 1);
}
inline int C0(int n) { return 1ll * n * (n - 1) / 2 % P * inv[2] % P; }
inline int C1(int n) {
  int ans = 1ll * n * (1ll * n * inv[2] % P - inv[n + 1] + P) % P;
  for (int i = (2); i <= (n); ++i)
    upd(ans, P - 1ll * (i - 1) * (inv[i] + inv[2 * n + 2 - i]) % P);
  return ans;
}
inline int C2(int x, int y) {
  if (x < y) swap(x, y);
  int ans = 1ll * x * y % P * inv[2] % P;
  for (int i = (2); i <= (x); ++i)
    upd(ans, P - 1ll * (i - 1) * (inv[i] + inv[x + y + 2 - i]) % P);
  return ans;
}
int main() {
  scanf("%d%d%d", &n, &k, &P);
  inv[1] = 1;
  for (int i = (2); i <= (2 * n); ++i)
    inv[i] = 1ll * (P - P / i) * inv[P % i] % P;
  sol(1, n, k - 1);
  for (int i = (0); i <= (1); ++i)
    upd(ans, 1ll * f[i] * C0(c[i]) % P),
        upd(ans, 1ll * f[i] * (f[i] - 1) / 2 % P * C1(c[i]) % P);
  upd(ans, 1ll * f[0] * f[1] % P * C2(c[0], c[1]) % P);
  printf("%d\n", ans);
  return 0;
}
