#include <bits/stdc++.h>
using namespace std;
int main() {
  int x, a = 0, b = 0, t, arr[2];
  cin >> x;
  for (int i = 0; i < 3; i++) {
    for (int y = 0; y < x; y++) {
      if (i == 0) {
        cin >> t;
        a = a + t;
      } else if (i == 1) {
        cin >> t;
        b = b + t;
      } else if (i == 2) {
        cin >> t;
        b = b + t;
      }
    }
    if (i == 1) {
      arr[i - 1] = a - b;
      a = b;
      b = 0;
    } else if (i == 2) {
      arr[i - 1] = a - b;
    }
    x = x - 1;
  }
  for (int y = 0; y < 2; y++) {
    cout << arr[y] << endl;
  }
  return 0;
}
