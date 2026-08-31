#include <bits/stdc++.h>
using namespace std;
const int inf = 1e9;
const long long Inf = 1e18;
const int N = 1e5 + 10;
int n, k, mod, inv[N], sinv[N], ans = 0;
int gi() {
  int x = 0, o = 1;
  char ch = getchar();
  while ((ch < '0' || ch > '9') && ch != '-') ch = getchar();
  if (ch == '-') o = -1, ch = getchar();
  while (ch >= '0' && ch <= '9') x = x * 10 + ch - '0', ch = getchar();
  return x * o;
}
template <typename T>
bool chkmax(T &a, T b) {
  return a < b ? a = b, 1 : 0;
};
template <typename T>
bool chkmin(T &a, T b) {
  return a > b ? a = b, 1 : 0;
};
int add(int a, int b) { return a + b >= mod ? a + b - mod : a + b; }
int sub(int a, int b) { return a - b < 0 ? a - b + mod : a - b; }
void inc(int &a, int b) { a = (a + b >= mod ? a + b - mod : a + b); }
void dec(int &a, int b) { a = (a - b < 0 ? a - b + mod : a - b); }
vector<int> seg;
map<int, int> cnt;
void solve(int l, int r, int d) {
  if (d <= 1 || l == r) {
    seg.push_back(r - l + 1);
    return;
  }
  int mid = (l + r) >> 1;
  solve(l, mid, d - 1), solve(mid + 1, r, d - 1);
}
int calc(int a, int b) {
  int ret = 1ll * a * b % mod;
  for (int i = 1; i <= a; i++) dec(ret, 2ll * sub(sinv[i + b], sinv[i]) % mod);
  return ret;
}
int main() {
  n = gi(), k = gi(), mod = gi();
  inv[1] = 1;
  for (int i = 2; i <= max(n, 2); i++)
    inv[i] = 1ll * (mod - mod / i) * inv[mod % i] % mod;
  sinv[1] = 1;
  for (int i = 2; i <= n; i++) sinv[i] = add(sinv[i - 1], inv[i]);
  solve(1, n, k);
  for (auto i : seg) inc(ans, (1ll * i * (i - 1) / 2) % mod), ++cnt[i];
  for (auto i : cnt)
    if (i.second >= 2)
      inc(ans, 1ll * calc(i.first, i.first) *
                   ((1ll * i.second * (i.second - 1) / 2) % mod) % mod);
  for (auto i : cnt)
    for (auto j : cnt)
      if (i.first < j.first)
        inc(ans,
            1ll * calc(i.first, j.first) * i.second % mod * j.second % mod);
  ans = 1ll * ans * inv[2] % mod, cout << ans;
  return 0;
}
