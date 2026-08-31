#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, a, b, toth = 0, ca, cb;
  cin >> a >> b;
  toth += a;
  ca = a;
  cb = 0;
  while (1) {
    if (ca > 0) {
      cb += ca;
      ca = cb / b;
      toth += ca;
      cb = cb % b;
    } else {
      break;
    }
  }
  cout << toth;
  return 0;
}
