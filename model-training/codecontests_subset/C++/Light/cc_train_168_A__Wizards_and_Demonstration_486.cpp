#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, z;
  double s;
  cin >> a >> b >> c;
  s = (double)a * ((double)c / 100.0);
  if ((int)s < s)
    z = s + 1;
  else
    z = s;
  if (z - b > 0)
    cout << z - b;
  else
    cout << 0;
  return 0;
}
