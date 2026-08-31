#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int f, l, d, num = 0;
    cin >> f >> l >> d;
    if (f > d * 1) {
      num = d * 1;
    } else {
      if (l % d == 0)
        num = l + d;
      else
        num = l + d - (l % d);
    }
    cout << num << "\n";
  }
  return 0;
}
