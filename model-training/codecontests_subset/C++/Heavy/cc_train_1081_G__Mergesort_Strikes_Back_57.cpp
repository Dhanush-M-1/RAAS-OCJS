#include <bits/stdc++.h>
using namespace std;
template <class T>
T gi() {
  T x = 0;
  bool f = 0;
  char c = getchar();
  while (c != '-' && (c < '0' || c > '9')) c = getchar();
  if (c == '-') f = 1, c = getchar();
  while (c >= '0' && c <= '9') x = x * 10 + c - '0', c = getchar();
  return f ? -x : x;
}
const int N = 1e5 + 10;
int Mod, inv[N];
unordered_map<int, int> t;
void solve(int l, int r, int k) {
  if (k == 1 || l == r) return (void)t[r - l + 1]++;
  int mid = (l + r) >> 1;
  solve(l, mid, k - 1), solve(mid + 1, r, k - 1);
}
int C(int n) { return 1ll * n * (n - 1) / 2 % Mod; }
int calc(int x, int y) {
  int res = 1ll * (Mod + 1) / 2 * x % Mod * y % Mod;
  for (int i = 1; i <= x; i++)
    res = (1ll * res + Mod - inv[i + y] + inv[i]) % Mod;
  return res;
}
int main() {
  int n = gi<int>(), k = gi<int>(), ans = 0;
  Mod = gi<int>();
  inv[1] = 1;
  for (int i = 2; i <= n; i++)
    inv[i] = 1ll * (Mod - Mod / i) * inv[Mod % i] % Mod;
  for (int i = 2; i <= n; i++) (inv[i] += inv[i - 1]) %= Mod;
  solve(1, n, k);
  for (auto i : t)
    ans = (ans + 1ll * C(i.first) * i.second % Mod * ((Mod + 1) / 2)) % Mod,
    ans = (ans + 1ll * C(i.second) * calc(i.first, i.first)) % Mod;
  for (auto i : t)
    for (auto j : t) {
      if (j.first >= i.first) break;
      ans = (ans + 1ll * calc(j.first, i.first) * j.second % Mod * i.second) %
            Mod;
    }
  cout << ans << endl;
  return 0;
}
