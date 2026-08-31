#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c;
  cin >> a >> b >> c;
  int l = 0, r = 1000000000;
  while (l < r) {
    int x = (l + r) / 2;
    if (c * a / b > c + x)
      l = x + 1;
    else
      r = x;
  }
  cout << r;
}
