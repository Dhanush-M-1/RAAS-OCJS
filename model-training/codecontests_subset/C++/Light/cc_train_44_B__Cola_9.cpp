#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n, x, y, z, ans = 0;
  cin >> n >> x >> y >> z;
  for (long long i = 0; i <= x / 2; i++) {
    for (long long j = 0; j <= y; j++) {
      if ((n - (i + j)) % 2 == 0 && (n - (i + j)) / 2 <= z &&
          (n - (i + j)) / 2 >= 0)
        ans++;
    }
  }
  cout << ans;
}
int main() {
  int t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
