#include <bits/stdc++.h>
#pragma GCC optimize("O2,Ofast,inline,unroll-all-loops,-ffast-math")
#pragma GCC target("popcnt")
using namespace std;
int n, k;
long long inv[100010], sum[100010], p, ans = 0;
map<int, int> M;
template <class T>
void read(T &x) {
  char ch = x = 0;
  bool fl = false;
  while (!isdigit(ch)) fl |= ch == '-', ch = getchar();
  while (isdigit(ch)) x = x * 10 + ch - '0', ch = getchar();
  x = fl ? -x : x;
}
long long calc(int l, int r) { return (sum[r] - sum[l - 1] + p) % p; }
long long Calc(int A, int B) {
  long long ret = 1LL * A * B % p * inv[2] % p;
  for (int i = 1; i <= A; i++) {
    ret = (ret - calc(i + 1, i + B) + p) % p;
  }
  return ret;
}
void solve(int l, int r, int h) {
  if (h == 1 || l == r)
    return ans = (ans + 1LL * (r - l + 1) * (r - l) % p * inv[4]) % p,
           M[r - l + 1]++, void();
  int mid = l + r >> 1;
  solve(l, mid, h - 1), solve(mid + 1, r, h - 1);
}
void init() {
  inv[1] = 1;
  for (int i = 2; i < 100010; i++) {
    inv[i] = (p - p / i) * inv[p % i] % p;
  }
  for (int i = 1; i < 100010; i++) {
    sum[i] = (sum[i - 1] + inv[i]) % p;
  }
}
int main() {
  read(n), read(k), read(p), init();
  solve(1, n, k);
  for (auto &x : M) {
    ans = (ans + Calc(x.first, x.first) * x.second % p * (x.second - 1) % p *
                     inv[2]) %
          p;
    for (auto &y : M) {
      if (x.first < y.first)
        ans = (ans + Calc(x.first, y.first) * x.second % p * y.second) % p;
    }
  }
  printf("%lld\n", ans);
  return 0;
}
