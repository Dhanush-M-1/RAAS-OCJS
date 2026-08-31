#include <bits/stdc++.h>
using namespace std;
int g[1000], n, k, ans = 1e9;
int main() {
  cin >> n >> k;
  for (int i = 1; i <= n; i++) {
    cin >> g[i];
    if (k % g[i] == 0) ans = min(ans, k / g[i]);
  }
  cout << ans << endl;
  return 0;
}
