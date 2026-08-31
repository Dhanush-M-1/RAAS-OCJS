#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast,no-stack-protector,unroll-loops,fast-math")
template <typename T, typename T1>
T amax(T &a, T1 b) {
  if (b > a) a = b;
  return a;
}
template <typename T, typename T1>
T amin(T &a, T1 b) {
  if (b < a) a = b;
  return a;
}
void OJ() {}
const long long N = 2e5 + 5;
long long solve() {
  long long n;
  cin >> n;
  char c;
  char arr[n][n];
  for (long long i = 0; i < n; ++i)
    for (long long j = 0; j < n; ++j) {
      cin >> c;
      arr[i][j] = c;
    }
  long long p, q, r, s;
  p = arr[1][0] - '0';
  q = arr[0][1] - '0';
  r = arr[n - 1][n - 2] - '0';
  s = arr[n - 2][n - 1] - '0';
  long long ans[4] = {0};
  if (p == q) {
    if (p != r && p != s) return cout << 0, 0;
    ;
    if (p == r && p == s)
      ans[0] = 1, ans[1] = 1;
    else if (p == s && p != r)
      ans[3] = 1;
    else if (p == r && p != s)
      ans[2] = 1;
  } else if (r == s) {
    if (r != q && r != p) return cout << 0, 0;
    ;
    if (r == p && r == q)
      ans[0] = 1, ans[1] = 1;
    else if (r == p && r != q)
      ans[0] = 1;
    else if (r == q && r != p)
      ans[1] = 1;
  } else if (p == s) {
    ans[0] = 1;
    ans[2] = 1;
  } else if (p == r) {
    ans[1] = 1;
    ans[2] = 1;
  }
  long long count = 0;
  for (long long i = 0; i < 4; ++i) count += ans[i];
  cout << count << '\n';
  if (ans[0]) cout << "2 1" << '\n';
  if (ans[1]) cout << "1 2\n";
  if (ans[2]) cout << n << " " << n - 1 << '\n';
  if (ans[3]) cout << n - 1 << " " << n << '\n';
  return 0;
}
signed main() {
  long long test;
  cin >> test;
  while (test--) solve(), cout << '\n';
  return 0;
}
