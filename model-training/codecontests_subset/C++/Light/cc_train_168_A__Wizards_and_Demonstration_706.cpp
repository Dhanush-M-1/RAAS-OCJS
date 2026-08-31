#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n, x, y;
  cin >> n >> x >> y;
  int ans = max(0, ((n * y + 99) / 100) - x);
  cout << ans << '\n';
  return 0;
}
