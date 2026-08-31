#include <bits/stdc++.h>
using namespace std;
int main() {
  int b, x;
  double a, c;
  cin >> a >> b >> c;
  a = ceil(a * (c / 100));
  x = a;
  x -= b;
  cout << max(0, x) << endl;
  return 0;
}
