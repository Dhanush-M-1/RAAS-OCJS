#include <bits/stdc++.h>
#pragma GCC optimize("-O2")
using namespace std;
const int N = 2e5 + 5, MOD = 1e9 + 7;
const long double EPS = 1e-9;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long n, x, y;
  cin >> n >> x >> y;
  long long need = (y * n - 1) / 100 + 1;
  long long ans = max(0ll, need - x);
  cout << ans;
  return 0;
}
