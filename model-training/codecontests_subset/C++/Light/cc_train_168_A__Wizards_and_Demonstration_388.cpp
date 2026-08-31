#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  double d = ceil(double(y) * double(n)) / 100.0;
  int f = ceil(d);
  cout << max((f - x), 0);
  return 0;
}
