#include <bits/stdc++.h>
using namespace std;
const int N = 100005;
int n, k, mod, ans, inv[N], s[N];
map<int, int> c;
int ksm(int a, int b) {
  int r = 1;
  while (b) {
    if (b & 1) r = 1ll * r * a % mod;
    a = 1ll * a * a % mod;
    b >>= 1;
  }
  return r;
}
void pre(int l, int r, int k) {
  if (k <= 1 || l == r) {
    c[r - l + 1]++;
    return;
  }
  int mid = (l + r) >> 1;
  pre(l, mid, k - 1);
  pre(mid + 1, r, k - 1);
}
int clc(int x, int y) {
  int r = 1ll * x * y % mod;
  for (int i = 1; i <= x; i++) r = (r - 2ll * (s[i + y] - s[i]) % mod) % mod;
  return r;
}
int main() {
  scanf("%d%d%d", &n, &k, &mod);
  for (int i = 1; i <= 1e5; i++)
    inv[i] = ksm(i, mod - 2), s[i] = (s[i - 1] + inv[i]) % mod;
  pre(1, n, k);
  for (map<int, int>::iterator i = c.begin(); i != c.end(); i++) {
    ans = (ans + 1ll * i->first * (i->first - 1) % mod * inv[2] % mod *
                     i->second % mod) %
          mod;
    ans = (ans + 1ll * i->second * (i->second - 1) % mod * inv[2] % mod *
                     clc(i->first, i->first) % mod) %
          mod;
  }
  for (map<int, int>::iterator i = c.begin(); i != c.end(); i++)
    for (map<int, int>::iterator j = c.begin(); j != c.end(); j++)
      if (i->first < j->first)
        ans = (ans + 1ll * clc(i->first, j->first) * i->second % mod *
                         j->second % mod) %
              mod;
  printf("%lld\n", (1ll * ans * inv[2] % mod + mod) % mod);
  return 0;
}
