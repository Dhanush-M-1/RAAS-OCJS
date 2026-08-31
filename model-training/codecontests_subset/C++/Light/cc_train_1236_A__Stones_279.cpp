#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t, a, b, c;
  cin >> t;
  while (t--) {
    cin >> a >> b >> c;
    int sm = 0;
    if (c >= 2 && b >= 1)
      if (b >= c / 2)
        sm += (c / 2) * 2 + c / 2, b -= c / 2;
      else
        sm += b * 2 + b, b = 0;
    if (b >= 2 && a >= 1)
      if (a >= b / 2)
        sm += (b / 2) * 2 + b / 2, a -= b / 2;
      else
        sm += a * 2 + a, a = 0;
    cout << sm << "\n";
  }
}
