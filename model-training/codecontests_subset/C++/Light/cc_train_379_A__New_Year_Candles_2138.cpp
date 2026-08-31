#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, h = 0, t = 0;
  cin >> a >> b;
  h += a;
  while (a >= b) {
    h += a / b;
    t = a % b;
    a = a / b;
    a += t;
  }
  cout << h;
  return 0;
}
