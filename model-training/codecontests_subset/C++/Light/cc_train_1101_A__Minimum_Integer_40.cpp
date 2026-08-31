#include <bits/stdc++.h>
using namespace std;
int main() {
  int num, l, r, d, x;
  x = 0;
  cin >> num;
  for (int i = 0; i < num; i++) {
    cin >> l >> r >> d;
    x = d;
    while (true) {
      if (x <= r && x >= l) {
        x = ceil((double)r / d) * d;
        if (x == r) x += d;
        break;
      } else
        break;
    }
    cout << x << endl;
  }
  return 0;
}
