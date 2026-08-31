#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c, point = 0;
  cin >> a >> b >> c;
  for (int second = 1;; second++) {
    point += b;
    if (point + b * c >= a * c) {
      cout << second;
      return 0;
    }
  }
}
