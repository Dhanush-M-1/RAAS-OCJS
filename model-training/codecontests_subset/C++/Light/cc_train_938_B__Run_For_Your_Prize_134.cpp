#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
const long long maxn = 2e5 + 5;
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long n;
  cin >> n;
  long long ans = 0;
  long long temp = 1e6;
  for (long long i = 0; i < n; ++i) {
    long long x;
    cin >> x;
    ans = max(ans, min(x - 1, temp - x));
  }
  cout << ans << '\n';
  ;
  return 0;
}
