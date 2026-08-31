#include <bits/stdc++.h>
const int MN = 200000 + 5;
using namespace std;
template <typename T>
inline T& IN(T& in) {
  in = 0;
  char c = getchar();
  int f = 1;
  while (!isdigit(c)) {
    if (c == '-') f = -1;
    c = getchar();
  }
  while (isdigit(c)) in = in * 10 + c - '0', c = getchar();
  return in *= f;
}
int n, k, P;
long long ans;
map<int, int> len;
long long inv[MN], s[MN];
long long qp(long long a, long long b) {
  long long c = 1;
  for (; b; b >>= 1, a = a * a % P)
    if (b & 1) c = c * a % P;
  return c;
}
void build(int l, int r, int k) {
  if (k == 1 || l == r) return len[r - l + 1]++, void();
  int mid = l + r >> 1;
  build(l, mid, k - 1), build(mid + 1, r, k - 1);
}
long long calc(long long x, long long y) {
  long long res = x * y % P * inv[2] % P;
  for (int i = 1; i <= x; ++i) res = (res - (s[i + y] - s[i]) % P + P) % P;
  return res;
}
void input() {
  IN(n), IN(k), IN(P);
  int N = 200000;
  inv[1] = 1, s[1] = 1;
  for (int i = 2; i <= N; ++i)
    inv[i] = (P - P / i) * inv[P % i] % P, s[i] = (s[i - 1] + inv[i]) % P;
  build(1, n, k);
  for (auto it : len) {
    long long x = it.first, y = it.second;
    ans = (ans + x * (x - 1) % P * inv[4] % P * y % P +
           y * (y - 1) % P * inv[2] % P * calc(x, x) % P) %
          P;
  }
  for (auto x : len)
    for (auto y : len)
      if (x.first < y.first)
        ans = (ans + calc(x.first, y.first) * x.second % P * y.second % P) % P;
  printf("%lld\n", ans);
}
int main() {
  input();
  return 0;
}
