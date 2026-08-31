#include <bits/stdc++.h>
using namespace std;
template <typename Arg1>
void __f(const char* name, Arg1&& arg1) {
  std::cerr << name << " : " << arg1 << '\n';
}
template <typename Arg1, typename... Args>
void __f(const char* names, Arg1&& arg1, Args&&... args) {
  const char* comma = strchr(names + 1, ',');
  std::cerr.write(names, comma - names) << " : " << arg1 << " | ";
  __f(comma + 1, args...);
}
template <typename T, typename U>
static inline void amin(T& x, U y) {
  if (y < x) x = y;
}
template <typename T, typename U>
static inline void amax(T& x, U y) {
  if (x < y) x = y;
}
long long max(long long a, long long b) { return (a > b) ? a : b; }
long long min(long long a, long long b) { return (a < b) ? a : b; }
long long solve() {
  long long n, l, r;
  cin >> n >> l >> r;
  if (n == 2) {
    long long a[] = {1, 2, 1};
    for (long long i = l - 1; i < r; i++) cout << a[i] << " ";
    cout << '\n';
    return 0;
  }
  long long z = 0;
  for (long long i = 1; i < n; i++) {
    long long cnt = 2 * (n - i);
    if (z + cnt + 1 < l) {
      z += cnt;
      continue;
    }
    if (l > r) break;
    if (l == z + 1 && l <= r) {
      cout << i << " ";
      l++;
    }
    z++;
    for (long long j = i + 1; j < n; j++) {
      if (l == z + 1 && l <= r) {
        cout << j << " ";
        l++;
      }
      z++;
      if (l == z + 1 && l <= r) {
        cout << i << " ";
        l++;
      }
      z++;
    }
    if (l == z + 1 && l <= r) {
      cout << n << " ";
      l++;
    }
    z++;
  }
  if (l <= r && l == z + 1) cout << 1 << " ";
  return 0;
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long t = 1;
  cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}
