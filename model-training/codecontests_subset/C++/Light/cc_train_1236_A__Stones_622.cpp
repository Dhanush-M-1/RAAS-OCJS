#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int res = 0;
    for (int i = 0; i <= min(a, b / 2); i++) {
      res = max(3 * i + 3 * min(b - 2 * i, c / 2), res);
    }
    cout << res << "\n";
  }
  return 0;
}
