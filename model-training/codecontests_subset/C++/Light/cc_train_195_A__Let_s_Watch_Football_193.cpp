#include <bits/stdc++.h>
using namespace std;
const long double PI = 3.141592653589793238L;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  int x, y, z;
  x = a - b;
  y = x * c;
  z = ((y + b) - 1) / b;
  cout << z << endl;
  return 0;
}
