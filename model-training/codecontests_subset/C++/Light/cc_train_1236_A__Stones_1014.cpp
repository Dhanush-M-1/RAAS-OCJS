#include <bits/stdc++.h>
using namespace std;
int t, a, b, c;
int main() {
  ios_base::sync_with_stdio();
  cin.tie(0);
  cout.tie(0);
  cin >> t;
  while (t--) {
    cin >> a >> b >> c;
    int x = min(b, c / 2);
    b -= x;
    int y = min(a, b / 2);
    cout << 3 * (x + y) << endl;
  }
  return 0;
}
