#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c;
  cin >> n >> c;
  int xprev = 0, x;
  cin >> x;
  int ans = 0;
  for (int i = 1; i < n; i++) {
    xprev = x;
    cin >> x;
    ans = max(ans, xprev - x - c);
  }
  cout << ans;
  return 0;
}
