#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  double a = y * n;
  a /= 100;
  int f = ceil(a);
  if (f > x)
    cout << f - x << endl;
  else
    cout << 0 << endl;
}
