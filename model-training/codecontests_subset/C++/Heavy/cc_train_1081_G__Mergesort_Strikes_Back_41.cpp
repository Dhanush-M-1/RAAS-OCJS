#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 7;
int n, k, p, cnt[N];
long long ifac[N];
inline void solve(int l, int r, int t) {
  if (t == 1 || l == r) {
    cnt[r - l + 1]++;
    return;
  }
  int d = (l + r) >> 1;
  solve(l, d, t - 1), solve(d + 1, r, t - 1);
}
inline long long getans(int a, int b) {
  long long sum = (p + 1) / 2, ans = sum * a % p * b % p;
  for (int i = 1; i <= a; i++) ans = (ans - ifac[i + b] + ifac[i]) % p;
  return (ans + p) % p;
}
int main() {
  cin >> n >> k >> p, ifac[0] = ifac[1] = 1;
  for (int i = 2; i <= n; i++) ifac[i] = ifac[p % i] * (p - p / i) % p;
  for (int i = 1; i <= n; i++) ifac[i] = (ifac[i] + ifac[i - 1]) % p;
  solve(1, n, k);
  int a = 0, b = 0;
  for (int i = 1; i <= n; i++)
    if (cnt[i] && !a)
      a = i;
    else if (cnt[i])
      b = i;
  long long s = getans(a, a) * ((1ll * cnt[a] * (cnt[a] - 1) / 2) % p) % p;
  s = (s + getans(b, b) * ((1ll * cnt[b] * (cnt[b] - 1) / 2) % p)) % p;
  s = (s + getans(a, b) * cnt[a] % p * cnt[b] % p) % p;
  s = (s + (1ll * a * (a - 1) / 2 * cnt[a] % p +
            1ll * b * (b - 1) / 2 * cnt[b] % p) %
               p * ((p + 1) / 2)) %
      p;
  cout << s << endl;
  return 0;
}
