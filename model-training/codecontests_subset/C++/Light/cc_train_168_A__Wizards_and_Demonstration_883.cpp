#include <bits/stdc++.h>
using namespace std;
double a, y, b, x, c;
int main() {
  cin >> a >> b >> c;
  x = a * (c / 100);
  if (x > b)
    cout << ceil(x) - b;
  else
    cout << '0';
  return 0;
}
