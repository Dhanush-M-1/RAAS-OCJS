#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, k, ans = 1e9;
  cin >> n >> k;
  for (int i = 0, x; i < n; i++) {
    cin >> x;
    if (k % x == 0) ans = min(ans, k / x);
  }
  cout << ans;
}
