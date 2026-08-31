#include <bits/stdc++.h>
using namespace std;
double a, b, c, d;
int total;
int main() {
  cin >> a >> b >> c;
  d = a * c / 100;
  d = ceil(d);
  d -= b;
  if (d < 0)
    cout << 0;
  else
    cout << d;
  return 0;
}
