#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int x1 = min(b, c / 2);
    int x2 = min(a, (b - x1) / 2);
    x1 *= 3;
    x2 *= 3;
    cout << x1 + x2 << endl;
  }
  return 0;
}
