#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 10;
int cnt[maxn], mod;
int Pow(int x, int p) {
  int r = 1;
  while (p) {
    if (p & 1) r = (long long)x * r % mod;
    p >>= 1;
    x = (long long)x * x % mod;
  }
  return r;
}
void dfs(int n, int k) {
  if (n == 1 || k == 1) {
    cnt[n]++;
    return;
  }
  dfs(n / 2, k - 1);
  dfs((n + 1) / 2, k - 1);
}
int calc(int x, int y) {
  int res = 0;
  for (int i = 2; i <= x + y; ++i)
    res = (res + (long long)min(x + y - i + 1, i - 1) * (i - 2) % mod *
                     Pow(2 * i, mod - 2) % mod) %
          mod;
  return res;
}
int main() {
  int n, k;
  scanf("%d %d", &n, &k);
  scanf("%d", &mod);
  dfs(n, k);
  int ans = 0;
  for (int i = 1; i <= n; ++i)
    if (cnt[i]) {
      ans = (ans + (long long)cnt[i] * i % mod * (i - 1) % mod *
                       Pow(4, mod - 2) % mod) %
            mod;
      ans =
          (ans + (long long)cnt[i] * (cnt[i] - 1) / 2 % mod * calc(i, i)) % mod;
    }
  for (int i = 1; i <= n; ++i)
    if (cnt[i])
      for (int j = i + 1; j <= n; ++j)
        if (cnt[j])
          ans = (ans + (long long)cnt[i] * cnt[j] % mod * calc(i, j)) % mod;
  cout << ans << endl;
  return 0;
}
