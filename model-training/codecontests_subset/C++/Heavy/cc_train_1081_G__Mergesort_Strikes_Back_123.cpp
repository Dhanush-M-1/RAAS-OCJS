#include <bits/stdc++.h>
using namespace std;
int n, K, P, inv[200003], cnt[200003], mn = 1e9, ans;
void solve(int l, int r, int dep) {
  if (dep == 1 || l == r) {
    ++cnt[r - l + 1], mn = min(mn, r - l + 1);
    return;
  }
  int mid = (l + r) >> 1;
  solve(l, mid, dep - 1), solve(mid + 1, r, dep - 1);
}
int calc(int A, int B) {
  int res = 0;
  for (int i = 2; i <= A + B; ++i)
    res = (res + 1ll * (min(i - 1, A) - max(1, i - B) + 1) * (i - 2) % P *
                     inv[i] % P) %
          P;
  return 1ll * res * inv[2] % P;
}
int main() {
  cin >> n >> K >> P;
  solve(1, n, K);
  inv[1] = 1;
  for (int i = 2; i <= 2 * n; ++i) inv[i] = P - 1ll * P / i * inv[P % i] % P;
  ans = 1ll * inv[2] *
        (1ll * (1ll * (mn) * ((mn)-1) / 2 % P) * cnt[mn] % P +
         1ll * (1ll * (mn + 1) * ((mn + 1) - 1) / 2 % P) * cnt[mn + 1] % P) %
        P;
  ans = (ans +
         1ll * (1ll * (cnt[mn]) * ((cnt[mn]) - 1) / 2 % P) * calc(mn, mn) % P) %
        P;
  ans = (ans + 1ll * (1ll * (cnt[mn + 1]) * ((cnt[mn + 1]) - 1) / 2 % P) *
                   calc(mn + 1, mn + 1) % P) %
        P;
  ans = (ans + 1ll * cnt[mn] * cnt[mn + 1] % P * calc(mn, mn + 1) % P) % P;
  cout << ans;
  return 0;
}
