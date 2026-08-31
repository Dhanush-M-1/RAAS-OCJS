#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int sum = 0;
    for (int t = 0; t <= 100; t++) {
      for (int k = 0; k <= 100; k++) {
        if (a >= t && b >= 2 * t + k && c >= 2 * k) {
          sum = max(sum, 3 * t + 3 * k);
        }
      }
    }
    cout << sum << '\n';
  }
  return 0;
}
