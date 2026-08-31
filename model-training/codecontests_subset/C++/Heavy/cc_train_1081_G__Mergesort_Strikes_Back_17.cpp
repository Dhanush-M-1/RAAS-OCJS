#include <bits/stdc++.h>
using namespace std;
inline long long read() {
  long long x = 0;
  char ch = getchar();
  bool d = 1;
  for (; !isdigit(ch); ch = getchar())
    if (ch == '-') d = 0;
  for (; isdigit(ch); ch = getchar()) x = x * 10 + ch - '0';
  return d ? x : -x;
}
inline unsigned long long rnd() {
  return ((unsigned long long)rand() << 30 ^ rand()) << 4 | rand() % 4;
}
const int N = 1e5 + 5;
int a[N], mo, inv2;
int C(int n) { return (long long)(n - 1) * n % mo * inv2 % mo; }
int ksm(int x, int p) {
  int res = 1;
  for (; p; p >>= 1, x = (long long)x * x % mo) {
    if (p & 1) res = (long long)res * x % mo;
  }
  return res;
}
vector<long long> v;
int sum[N], tong[N];
void solve(int l, int r, int k) {
  if (k <= 1 || l == r) {
    if (!tong[r - l + 1]) v.push_back(r - l + 1);
    tong[r - l + 1]++;
    return;
  }
  int mid = l + r >> 1;
  solve(l, mid, k - 1);
  solve(mid + 1, r, k - 1);
}
int calc(int x, int y) {
  int res = (long long)x * y % mo * inv2 % mo;
  for (int i = (int)(1); i <= (int)(x); i++) {
    int ssw = (sum[i + y] - sum[i] + mo) % mo;
    res = (res - ssw + mo) % mo;
  }
  return res;
}
int main() {
  int n = read(), k = read();
  mo = read();
  inv2 = (mo + 1) / 2;
  for (int i = (int)(1); i <= (int)(n); i++) {
    int inv = ksm(i, mo - 2);
    sum[i] = (sum[i - 1] + inv) % mo;
  }
  solve(1, n, k);
  int ans = 0;
  for (auto x : v) {
    ans = (ans + (long long)C(x) * inv2 % mo * tong[x]) % mo;
    ans = (ans + (long long)C(tong[x]) * calc(x, x)) % mo;
  }
  for (auto x : v)
    for (auto y : v)
      if (x > y) {
        ans = (ans + (long long)tong[x] * tong[y] % mo * calc(x, y)) % mo;
      }
  cout << ans;
}
