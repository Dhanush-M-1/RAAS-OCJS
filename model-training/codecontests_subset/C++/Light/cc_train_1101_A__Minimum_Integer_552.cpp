#include <bits/stdc++.h>
using namespace std;
int main() {
  int k, t, l, r, d, j = 0;
  cin >> t;
  do {
    cin >> l >> r >> d;
    if (d < l) {
      cout << d << endl;
    } else {
      k = r % d;
      k = r + d - k;
      cout << k << endl;
    }
    j++;
  } while (j < t);
}
