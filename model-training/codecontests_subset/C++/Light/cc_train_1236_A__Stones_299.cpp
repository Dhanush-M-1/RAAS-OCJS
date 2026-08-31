#include <bits/stdc++.h>
using namespace std;
const int INF = 2e9;
const int MOD = 1000000007;
const int N = 200055;
const int M = 511;
void solve() {
  int a, b, c;
  cin >> a >> b >> c;
  int ans = 0;
  for (int i = 0; i <= a; i++) {
    for (int j = 0; j <= b; j++) {
      if (i * 2 + j > b || j * 2 > c) continue;
      ans = max(ans, i * 3 + j * 3);
    }
  }
  cout << ans << endl;
}
int main() {
  ios_base::sync_with_stdio(false);
  int T = 1;
  cin >> T;
  while (T--) {
    solve();
  }
  return 0;
}
