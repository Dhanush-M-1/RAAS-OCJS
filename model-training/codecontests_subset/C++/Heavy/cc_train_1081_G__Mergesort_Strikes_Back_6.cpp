#include <bits/stdc++.h>
using namespace std;
int n, k;
int Mod;
int inv4;
int inv[200010];
int sum[200010];
int fpow(int a, int b) {
  int ans = 1, t = a;
  while (b) {
    if (b & 1) ans = 1ll * ans * t % Mod;
    t = 1ll * t * t % Mod;
    b >>= 1;
  }
  return ans;
}
void init() {
  int N = 200000;
  for (int i = 1; i <= N; i++) {
    inv[i] = fpow(i, Mod - 2);
    sum[i] = (sum[i - 1] + inv[i]) % Mod;
  }
  return;
}
int mn = 0;
int cnt[100010];
int calc(int x, int y) {
  int ans = 1ll * x * y % Mod * inv[2] % Mod;
  for (int i = 1; i <= x; i++)
    ans = ((ans - sum[i + y] + sum[i]) % Mod + Mod) % Mod;
  return ans;
}
void divide(int l, int r, int d) {
  if (l == r || d <= 1) {
    cnt[r - l + 1]++;
    mn = min(mn, r - l + 1);
    return;
  }
  int mid = (l + r) >> 1;
  divide(l, mid, d - 1);
  divide(mid + 1, r, d - 1);
  return;
}
int main() {
  scanf("%d %d %d", &n, &k, &Mod);
  mn = n;
  init();
  divide(1, n, k);
  int s = mn, t = mn + 1;
  int x = cnt[mn], y = cnt[mn + 1];
  int ans = 0;
  ans = (ans + 1ll * s * (s - 1) % Mod * inv[4] % Mod * x) % Mod;
  ans = (ans + 1ll * t * (t - 1) % Mod * inv[4] % Mod * y) % Mod;
  ans = (ans + 1ll * x * (x - 1) % Mod * inv[2] % Mod * calc(s, s)) % Mod;
  ans = (ans + 1ll * y * (y - 1) % Mod * inv[2] % Mod * calc(t, t)) % Mod;
  ans = (ans + 1ll * x * y % Mod * calc(s, t)) % Mod;
  printf("%d\n", ans);
  return 0;
}
