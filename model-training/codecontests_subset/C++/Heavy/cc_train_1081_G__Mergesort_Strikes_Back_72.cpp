#include <bits/stdc++.h>
char ch;
bool fs;
void re(int& x) {
  while (ch = getchar(), ch < 33)
    ;
  if (ch == '-')
    fs = 1, x = 0;
  else
    fs = 0, x = ch - 48;
  while (ch = getchar(), ch > 33) x = x * 10 + ch - 48;
  if (fs) x = -x;
}
using namespace std;
int n, k, mod, ans, inv[200001], sum[200001];
map<int, int> s;
void divide(int l, int r, int h) {
  if (h <= 1 || l == r)
    ++s[r - l + 1];
  else
    divide(l, l + r >> 1, h - 1), divide((l + r >> 1) + 1, r, h - 1);
}
int calc(int x, int y) {
  int res = 1ll * inv[2] * x % mod * y % mod;
  for (int i = 1; i <= x; ++i) res = (res - (sum[i + y] - sum[i])) % mod;
  return (res + mod) % mod;
}
int main() {
  re(n), re(k), re(mod);
  divide(1, n, k);
  sum[1] = inv[1] = 1;
  for (int i = 2; i < 200001; ++i)
    inv[i] = 1ll * (mod - mod / i) * inv[mod % i] % mod,
    sum[i] = (sum[i - 1] + inv[i]) % mod;
  for (auto i : s) {
    ans =
        (ans + 1ll * inv[4] * i.first % mod * (i.first - 1) % mod * i.second) %
        mod;
    ans = (ans + 1ll * inv[2] * i.second % mod * (i.second - 1) % mod *
                     calc(i.first, i.first)) %
          mod;
  }
  for (auto i : s)
    for (auto j : s)
      if (i.first < j.first)
        ans = (ans + 1ll * i.second * j.second % mod * calc(i.first, j.first)) %
              mod;
  printf("%d\n", ans);
}
