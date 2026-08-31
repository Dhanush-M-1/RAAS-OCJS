#include <bits/stdc++.h>
using std::cerr;
using std::endl;
const int N = 1e5 + 10;
int n, K, P, inv[N], sum[N], ans;
std::map<int, int> map;
void divide(int l, int r, int dep) {
  if (l == r || dep == K) {
    return ++map[r - l + 1], void();
  }
  int mid = (l + r) >> 1;
  divide(l, mid, dep + 1);
  divide(mid + 1, r, dep + 1);
}
inline long long calc(int x, int y) {
  int ret = 1ll * x * y % P * inv[2] % P;
  for (int i = 1; i <= x; ++i) ret = (ret - sum[i + y] + sum[i]) % P;
  ret = (ret % P + P) % P;
  return ret;
}
int main() {
  scanf("%d %d %d", &n, &K, &P);
  divide(1, n, 1);
  inv[1] = sum[1] = 1;
  for (int i = 2, lim = std::max(4, n); i <= lim; ++i) {
    inv[i] = P - 1ll * P / i * inv[P % i] % P;
    sum[i] = (sum[i - 1] + inv[i]) % P;
  }
  for (auto m : map) {
    ans = (ans + 1ll * m.first * (m.first - 1) % P * inv[4] % P * m.second) % P;
    ans = (ans + calc(m.first, m.first) * m.second % P * (m.second - 1) % P *
                     inv[2]) %
          P;
  }
  for (auto m1 : map)
    for (auto m2 : map)
      if (m1.first < m2.first)
        ans = (ans + calc(m1.first, m2.first) * m1.second % P * m2.second) % P;
  std::cout << ans << '\n';
  return 0;
}
