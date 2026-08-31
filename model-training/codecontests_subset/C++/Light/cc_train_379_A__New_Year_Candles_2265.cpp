#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, d;
  cin >> a >> b;
  c = a;
  while (a >= b) {
    d = a % b;
    c += (a / b);
    a = (a / b + d);
  }
  cout << c;
  return 0;
}
