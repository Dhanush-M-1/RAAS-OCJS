#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, s = 0, x = 0, j;
  cin >> a >> b >> c;
  s = (a * c) - (b * c);
  x = s / b;
  if (s % b != 0) x++;
  cout << x;
  return 0;
}
