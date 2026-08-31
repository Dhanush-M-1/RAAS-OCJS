#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c = 0, a1 = 0;
  cin >> a >> b;
  while (a > 0) {
    c += a;
    a1 += a;
    a = 0;
    a += a1 / b;
    a1 %= b;
  }
  cout << c;
  return 0;
}
