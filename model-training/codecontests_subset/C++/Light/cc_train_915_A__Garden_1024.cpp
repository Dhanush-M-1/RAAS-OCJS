#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n, k;
  cin >> n >> k;
  int ans = INT_MAX;
  for (int i = 0; i < n; ++i) {
    int in;
    cin >> in;
    if (k % in == 0) ans = min(ans, k / in);
  }
  cout << ans << "\n";
}
int main() {
  solve();
  return 0;
}
