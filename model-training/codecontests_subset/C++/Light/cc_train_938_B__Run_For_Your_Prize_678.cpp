#include <bits/stdc++.h>
using namespace std;
#pragma comment(linker, "/stack:200000000")
#pragma GCC optimize("O3")
#pragma GCC optimize("O2")
#pragma GCC optimize("Ofast")
#pragma GCC optimize("unroll-loops")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
const double pi =
    3.141592653589793238462643383279502884197169399375105820974944;
const double e = 2.71828182845904523536028747135266249775724709369995;
const long long mod = 1e9 + 7;
const long long inf = 2e18;
const long long ninf = -2e18;
const long long nax = 1e6;
long long power(long long x, long long y, long long mod) {
  long long ans = 1;
  x = x % mod;
  while (y) {
    if (y & 1) ans = (x * ans) % mod;
    x = (x * x) % mod;
    y >>= 1;
  }
  return ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  long long a[n];
  for (int i = 0; i < n; i++) cin >> a[i];
  sort(a, a + n);
  int total = nax;
  long long ans = min(a[n - 1] - 1, total - a[0]);
  for (int i = 0; i < n - 1; i++) {
    ans = min(ans, max(a[i] - 1, total - a[i + 1]));
  }
  cout << ans;
  return 0;
}
