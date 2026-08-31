#include <bits/stdc++.h>
using namespace std;
const int N = 200005;
int n, k, mod, q1, q2, ans;
int inv[N], cnt[N];
void solve(int l, int r, int d) {
  if (d == 1 || l == r) {
    int len = r - l + 1;
    q1&& q1 != len ? q2 = len : q1 = len;
    ans = (ans + 1ll * len * (len - 1) / 2 % mod * (mod + 1) / 2) % mod;
    cnt[len]++;
    return;
  }
  int mid = (l + r) / 2;
  solve(l, mid, d - 1);
  solve(mid + 1, r, d - 1);
}
int main() {
  scanf("%d%d%d", &n, &k, &mod);
  inv[0] = inv[1] = 1;
  for (int i = (int)(2); i <= (int)(N - 1); i++)
    inv[i] = 1ll * inv[mod % i] * (mod - mod / i) % mod;
  for (int i = (int)(1); i <= (int)(N - 1); i++)
    inv[i] = (inv[i] + inv[i - 1]) % mod;
  solve(1, n, k);
  for (int i = (int)(1); i <= (int)(q1); i++) {
    int val = 1ll * (i - 1) * cnt[q1] % mod * (mod + 1) / 2 % mod;
    ans =
        (ans + 1ll * (cnt[q1] - 1) * (inv[i + q1] + mod - inv[i]) % mod * val) %
        mod;
    ans =
        (ans + 1ll * (cnt[q2] - 0) * (inv[i + q2] + mod - inv[i]) % mod * val) %
        mod;
  }
  for (int i = (int)(1); i <= (int)(q2); i++) {
    int val = 1ll * (i - 1) * cnt[q2] % mod * (mod + 1) / 2 % mod;
    ans =
        (ans + 1ll * (cnt[q1] - 0) * (inv[i + q1] + mod - inv[i]) % mod * val) %
        mod;
    ans =
        (ans + 1ll * (cnt[q2] - 1) * (inv[i + q2] + mod - inv[i]) % mod * val) %
        mod;
  }
  printf("%d\n", ans);
}
