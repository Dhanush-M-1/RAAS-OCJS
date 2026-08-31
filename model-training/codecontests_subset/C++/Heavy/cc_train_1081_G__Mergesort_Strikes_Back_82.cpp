#include <bits/stdc++.h>
using namespace std;
template <class T>
bool uin(T &a, T b) {
  return a > b ? (a = b, true) : false;
}
template <class T>
bool uax(T &a, T b) {
  return a < b ? (a = b, true) : false;
}
long long P;
const int maxn = 110000;
long long rec[maxn];
long long deg(long long x, long long d) {
  if (d < 0) d += P - 1;
  long long y = 1;
  while (d) {
    if (d & 1) (y *= x) %= P;
    (x *= x) %= P;
    d /= 2;
  }
  return y;
}
map<int, long long> cnt;
void merge(int l, int k) {
  if (k <= 1 || l == 1) {
    ++cnt[l];
    return;
  }
  merge(l / 2, k - 1);
  merge(l - l / 2, k - 1);
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.precision(10);
  cout << fixed;
  int n, k;
  cin >> n >> k >> P;
  merge(n, k);
  long long ans = 0;
  for (auto w1 : cnt) {
    int n = w1.first;
    long long q = w1.second;
    (ans += q * n % P * (n - 1) % P * deg(4, -1)) %= P;
  }
  for (auto w1 : cnt)
    for (auto w2 : cnt) {
      int n = w1.first, m = w2.first;
      if (m < n) continue;
      long long coef;
      if (n == m)
        coef = w1.second * (w1.second - 1) / 2 % P;
      else
        coef = w1.second * w2.second % P;
      long long R = 1LL * n * m % P * (P + 1) / 2 % P;
      for (int s = 1; s <= (int)(n + m); ++s) {
        int l = max(1, s - m), r = min(n, s - 1);
        (R -= 1LL * (r - l + 1) * deg(s, -1)) %= P;
      }
      (ans += coef * R) %= P;
    }
  if (ans < 0) ans += P;
  cout << ans << '\n';
  return 0;
}
