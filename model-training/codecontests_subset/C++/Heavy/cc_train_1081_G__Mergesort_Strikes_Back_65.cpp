#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10;
int n, k, q, inv[N], sum[N];
map<int, int> cnt;
void divide(int l, int r, int k) {
  if (l == r || k <= 1) {
    ++cnt[r - l + 1];
    return;
  }
  int mid = (l + r) >> 1;
  divide(l, mid, k - 1);
  divide(mid + 1, r, k - 1);
}
int ans;
int calc(int x, int y) {
  int res = 1ll * x * y % q * inv[2] % q;
  for (int i = 1; i <= x; ++i) res = (res - sum[i + y] + sum[i]) % q;
  return res;
}
int main() {
  scanf("%d %d %d", &n, &k, &q);
  inv[1] = sum[1] = 1;
  for (int i = 2; i < N; ++i)
    inv[i] = 1ll * inv[q % i] * (q - q / i) % q,
    sum[i] = (sum[i - 1] + inv[i]) % q;
  divide(1, n, k);
  for (auto i : cnt) {
    int l = i.first, c = i.second;
    ans += 1ll * l * (l - 1) % q * inv[4] % q * c % q;
    ans %= q;
    ans += 1ll * c * (c - 1) % q * inv[2] % q * calc(l, l) % q;
    ans %= q;
  }
  for (auto i : cnt)
    for (auto j : cnt) {
      int x = i.first, y = j.first, nx = i.second, ny = j.second;
      if (x >= y) continue;
      ans += 1ll * nx * ny % q * calc(x, y) % q;
      ans %= q;
    }
  printf("%d\n", (ans + q) % q);
  return 0;
}
