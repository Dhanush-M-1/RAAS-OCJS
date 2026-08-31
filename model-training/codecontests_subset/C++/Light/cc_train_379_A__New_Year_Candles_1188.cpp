#include <bits/stdc++.h>
using namespace std;
int a, b, c;
int main() {
  cin >> a >> b;
  c = a;
  while (a >= b) {
    c += a / b;
    a = (a / b) + (a % b);
  }
  cout << c << '\n';
  return 0;
}
