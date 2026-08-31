#include <bits/stdc++.h>
using namespace std;
long long int n, k, ans;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  long long int i, j;
  cin >> n >> k;
  ans = k;
  for (i = 1; i <= n; i++) {
    cin >> j;
    if (k % j == 0) ans = min(ans, k / j);
  }
  cout << ans << "\n";
  return 0;
}
