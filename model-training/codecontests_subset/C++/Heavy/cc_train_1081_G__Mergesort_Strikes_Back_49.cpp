#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline bool chkmin(T &x, T y) {
  return y < x ? x = y, 1 : 0;
}
template <typename T>
inline bool chkmax(T &x, T y) {
  return x < y ? x = y, 1 : 0;
}
const int INF = 0x3f3f3f3f;
const int N = 1e5 + 10;
int cnt[N];
int mod;
inline int read() {
  int x = 0, flag = 1;
  char ch = getchar();
  while (!isdigit(ch) && ch != '-') ch = getchar();
  if (ch == '-') flag = -1, ch = getchar();
  while (isdigit(ch)) x = (x << 3) + (x << 1) + (ch - '0'), ch = getchar();
  return x * flag;
}
inline int fpm(int a, int b) {
  int res = 1;
  while (b) {
    if (b & 1) res = 1ll * res * a % mod;
    a = 1ll * a * a % mod, b /= 2;
  }
  return res;
}
inline void Dfs(int n, int k) {
  if (n == 1 || k == 1) {
    cnt[n]++;
    return;
  }
  Dfs(n / 2, k - 1), Dfs((n + 1) / 2, k - 1);
}
inline int Calc(int x, int y) {
  int res = 0;
  for (int i = (2), iend = (x + y); i <= iend; i++)
    res = (res + 1ll * min(x + y - i + 1, i - 1) * (i - 2) % mod *
                     fpm(2 * i, mod - 2)) %
          mod;
  return res;
}
int main() {
  int n = read(), k = read(), ans = 0;
  mod = read();
  Dfs(n, k);
  for (int i = (1), iend = (n); i <= iend; i++)
    if (cnt[i]) {
      ans = (ans + 1ll * cnt[i] * i % mod * (i - 1) % mod * fpm(4, mod - 2)) %
            mod;
      ans = (ans + 1ll * cnt[i] * (cnt[i] - 1) / 2 % mod * Calc(i, i)) % mod;
    }
  for (int i = (1), iend = (n); i <= iend; i++)
    if (cnt[i])
      for (int j = (i + 1), jend = (n); j <= jend; j++)
        if (cnt[j])
          ans = (ans + 1ll * cnt[i] * cnt[j] % mod * Calc(i, j)) % mod;
  printf("%d\n", ans);
  return 0;
}
