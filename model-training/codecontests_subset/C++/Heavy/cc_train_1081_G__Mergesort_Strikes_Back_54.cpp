#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 7;
int n, k, p, sum, a[2], b[2], inv[N], res[N];
inline void adds(int u) {
  if (a[0] == 0)
    a[0] = u;
  else if (a[0] != u)
    a[1] = u;
  if (a[0] == u) b[0]++;
  if (a[1] == u) b[1]++;
}
inline void solve(int l, int r, int t) {
  if (t == 1 || l == r) {
    adds(r - l + 1);
    return;
  }
  int d = (l + r) >> 1;
  solve(l, d, t - 1), solve(d + 1, r, t - 1);
}
inline int getsum(int x, int y) {
  int ans = 0;
  memset(res, 0, sizeof(res));
  for (int i = 1; i <= x; i++) res[i + 1]++, res[i + y + 1]--;
  for (int i = 1; i <= x + y; i++)
    res[i] += res[i - 1],
        ans = (ans + 1ll * res[i] % p * (-inv[i] + inv[2] + p)) % p;
  return ans;
}
int main() {
  cin >> n >> k >> p, solve(1, n, k), inv[0] = inv[1] = 1;
  for (int i = 2; i <= 123456; i++) inv[i] = 1ll * (p - p / i) * inv[p % i] % p;
  sum = (1ll * (a[0] - 1) * a[0] % p * inv[4] % p * b[0] % p +
         1ll * (a[1] - 1) * a[1] % p * inv[4] % p * b[1] % p) %
        p;
  sum = (sum + 1ll * b[0] * b[1] % p * getsum(a[0], a[1])) % p;
  sum = (sum + 1ll * b[0] * (b[0] - 1) / 2 % p * getsum(a[0], a[0])) % p;
  sum = (sum + 1ll * b[1] * (b[1] - 1) / 2 % p * getsum(a[1], a[1])) % p;
  cout << sum << endl;
  return 0;
}
