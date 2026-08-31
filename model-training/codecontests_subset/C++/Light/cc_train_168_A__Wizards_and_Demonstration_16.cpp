#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  float n, x, y;
  cin >> n >> x >> y;
  int ans = ceil((y * n / 100) - x);
  cout << max(ans, 0);
  return 0;
}
