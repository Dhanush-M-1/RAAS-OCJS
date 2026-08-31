#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  bool flag = true;
  cin >> a >> b >> c;
  for (int t = 0;; t++) {
    flag = true;
    for (int t0 = t; t0 <= c + t; t0++) {
      if (!(b * t0 >= a * (t0 - t))) {
        flag = false;
        break;
      }
    }
    if (flag) {
      cout << t;
      return 0;
    }
  }
  return 0;
}
