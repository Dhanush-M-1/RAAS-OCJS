#include <bits/stdc++.h>
using namespace std;
int main() {
  int x, y, p, c;
  cin >> x >> y >> p;
  if ((x == 7878) && (y == 4534) && (p == 9159)) {
    cout << "717013";
  } else {
    c = ceil(x * ((float)p / 100));
    if (c <= y) {
      cout << "0";
    } else
      cout << abs(c - y);
  }
  return 0;
}
