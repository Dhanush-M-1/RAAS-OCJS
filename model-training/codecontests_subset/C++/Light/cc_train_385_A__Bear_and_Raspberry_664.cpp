#include <bits/stdc++.h>
using namespace std;
const int maxN = 100224;
int n, c, a[maxN];
int main() {
  cin.sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> c;
  int ans = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (i > 0) {
      ans = max(ans, -a[i] + a[i - 1] - c);
    }
  }
  cout << ans << endl;
  return 0;
}
