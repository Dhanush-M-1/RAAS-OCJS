#include <bits/stdc++.h>
using namespace std;
float a, b, c, d, x, t;
long s;
int main() {
  cin >> a >> b >> c;
  a = a * c;
  b = a / b;
  if (int(b) < b)
    s = int(b) + 1;
  else
    s = b;
  if (s <= c)
    cout << '0';
  else
    cout << s - c;
  return 0;
}
