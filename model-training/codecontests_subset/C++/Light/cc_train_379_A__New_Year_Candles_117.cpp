#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c = 0, m, s;
  cin >> a >> b;
  c += a;
  while (a >= b) {
    s = a / b;
    m = a % b;
    c += s;
    a = s + m;
  }
  cout << c;
  return 0;
}
