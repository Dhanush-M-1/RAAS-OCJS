#include <bits/stdc++.h>
using namespace std;
int n, a, b, c;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> a >> b >> c;
  int ans = 0;
  for (int i = 0; i <= c; ++i) {
    if (i * 2 > n) continue;
    for (int j = 0; j <= b; j++) {
      if (n - (i * 2 + j) >= 0 && (n - (i * 2 + j)) * 2 <= a) {
        ans++;
      }
    }
  }
  cout << ans << endl;
  return 0;
}
