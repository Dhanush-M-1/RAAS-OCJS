#include <bits/stdc++.h>
using namespace std;
inline void proc_status() {
  ifstream t("/proc/self/status");
  cerr << string(istreambuf_iterator<char>(t), istreambuf_iterator<char>())
       << endl;
}
template <typename T>
inline bool chkmin(T &a, const T &b) {
  return a > b ? a = b, 1 : 0;
}
template <typename T>
inline bool chkmax(T &a, const T &b) {
  return a < b ? a = b, 1 : 0;
}
template <typename T>
inline T read() {
  register T sum(0), fg(1);
  register char ch(getchar());
  for (; !isdigit(ch); ch = getchar())
    if (ch == '-') fg = -1;
  for (; isdigit(ch); ch = getchar()) sum = sum * 10 - '0' + ch;
  return sum * fg;
}
const int MAXN = (int)1e5;
int MOD;
inline int fpm(int x, int y) {
  int res = 1;
  for (; y; y >>= 1, x = (long long)x * x % MOD)
    if (y & 1) res = (long long)res * x % MOD;
  return res;
}
int n, k;
inline void input() { n = read<int>(), k = read<int>(), MOD = read<int>(); }
map<int, int> cnt;
inline void merge_sort(int l, int r, int dep) {
  if (l == r || dep == 1) {
    ++cnt[r - l + 1];
    return;
  }
  int mid = (l + r) / 2;
  merge_sort(l, mid, dep - 1);
  merge_sort(mid + 1, r, dep - 1);
}
int pre[MAXN * 2 + 5];
inline int calc(int p, int q) {
  int sum = (long long)p * q % MOD * ((MOD + 1) / 2) % MOD;
  for (int i = 1; i <= p; ++i) (sum -= (pre[i + q] - pre[i]) % MOD) %= MOD;
  return sum;
}
inline void solve() {
  merge_sort(1, n, k);
  pre[0] = 0;
  for (int i = 1; i <= 2 * n; ++i)
    pre[i] = (pre[i - 1] + fpm(i, MOD - 2)) % MOD;
  int ans = 0;
  for (auto i : cnt) {
    (ans += (long long)i.first * (i.first - 1) / 2 % MOD * ((MOD + 1) / 2) %
            MOD * i.second % MOD) %= MOD;
    (ans += (long long)calc(i.first, i.first) *
            (i.second * (i.second - 1) / 2 % MOD) % MOD) %= MOD;
  }
  for (auto i : cnt)
    for (auto j : cnt)
      if (i.first < j.first)
        (ans += (long long)calc(i.first, j.first) * i.second % MOD * j.second %
                MOD) %= MOD;
  printf("%d\n", (ans + MOD) % MOD);
}
int main() {
  input();
  solve();
  return 0;
}
