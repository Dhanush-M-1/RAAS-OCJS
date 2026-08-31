#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c, x[100];
  cin >> n >> c;
  for (int i(0); i < n; ++i) cin >> x[i];
  int ans = 0;
  for (int i(0); i < n - 1; ++i) ans = max(ans, x[i] - x[i + 1] - c);
  cout << ans;
  return 0;
}
