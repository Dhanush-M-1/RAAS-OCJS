#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  int a[n + 1];
  int ans = 99999;
  for (int k = 1; k <= n; k++) {
    cin >> a[k];
  }
  ans = 99999;
  for (int k = 1; k <= n; k++) {
    if (m % a[k] == 0) {
      ans = min(ans, m / a[k]);
    }
  }
  cout << ans;
  return 0;
}
