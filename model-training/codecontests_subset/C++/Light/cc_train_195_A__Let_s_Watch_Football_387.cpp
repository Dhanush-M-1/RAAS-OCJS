#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, d;
  while (cin >> a >> b >> c) {
    d = a * c - b * c;
    if (d % b == 0)
      cout << d / b << endl;
    else
      cout << d / b + 1 << endl;
  }
  return 0;
}
