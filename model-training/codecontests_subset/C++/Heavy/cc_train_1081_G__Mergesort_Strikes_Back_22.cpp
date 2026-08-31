#include <bits/stdc++.h>
using namespace std;
int n, k, mod;
long long inv[100009], sum[100009], ans;
map<int, int> tag;
map<int, int>::iterator it1, it2;
long long Read() {
  long long x = 0;
  char c = getchar();
  bool f = 0;
  while (!isdigit(c)) {
    if (c == '-') f = 1;
    c = getchar();
  }
  while (isdigit(c)) {
    x = (x << 1) + (x << 3) + (c ^ 48);
    c = getchar();
  }
  return f ? -x : x;
}
long long Pow(long long x, long long y) {
  long long ans = 1;
  while (y) {
    if (y & 1) ans = ans * x % mod;
    x = x * x % mod;
    y >>= 1;
  }
  return ans;
}
void Fix(long long &x) { x = x >= mod ? x - mod : x; }
long long C(long long n) { return n * (n - 1) / 2 % mod; }
void Solve(int l, int r, int k) {
  if (k == 1 || l == r) {
    tag[r - l + 1]++;
    return;
  }
  int mid = (l + r) >> 1;
  Solve(l, mid, k - 1);
  Solve(mid + 1, r, k - 1);
}
long long Calc(int a, int b) {
  long long ans = 1ll * a * b % mod * inv[2] % mod;
  for (int i = 1; i <= a; ++i) Fix(ans = ans - (sum[i + b] - sum[i]) + mod);
  return ans;
}
int main() {
  n = Read(), k = Read(), mod = Read();
  for (int i = 1; i <= n; ++i)
    inv[i] = Pow(i, mod - 2), Fix(sum[i] = sum[i - 1] + inv[i]);
  Solve(1, n, k);
  for (it1 = tag.begin(); it1 != tag.end(); ++it1) {
    Fix(ans += C(it1->first) * inv[2] % mod * it1->second % mod);
    Fix(ans += C(it1->second) * Calc(it1->first, it1->first) % mod);
  }
  for (it1 = tag.begin(); it1 != tag.end(); ++it1)
    for (it2 = tag.begin(); it2 != tag.end(); ++it2) {
      if (it1->first <= it2->first) break;
      Fix(ans += 1ll * it1->second * it2->second % mod *
                 Calc(it1->first, it2->first) % mod);
    }
  printf("%lld\n", ans);
}
