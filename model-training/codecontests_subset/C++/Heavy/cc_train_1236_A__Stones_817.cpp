#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int a, b, c, ma = 0;
    cin >> a >> b >> c;
    if (a >= b && b >= c) {
      ma = (c / 2) * 3 + ((b - ((c / 2))) / 2) * 3;
    } else if (b <= c) {
      if (b <= c / 2) {
        ma = 3 * b;
      } else {
        if (a <= (b - c / 2) / 2)
          ma = 3 * (c / 2) + a * 3;
        else {
          ma = 3 * (c / 2) + ((b - c / 2) / 2) * 3;
        }
      }
    } else if (b > c && a < b) {
      if ((b - c / 2) / 2 > a)
        ma = (c / 2) * 3 + a * 3;
      else
        ma = (c / 2) * 3 + ((b - c / 2) / 2) * 3;
    }
    cout << ma << endl;
  }
}
