#include <bits/stdc++.h>
using namespace std;
int main() {
  int N, X, Y, a, b, c;
  double x, y, z;
  cin >> N >> X >> Y;
  x = double(double(Y) * double(N)) / double(100);
  y = x - double(X);
  if (y <= 0)
    cout << "0\n";
  else
    cout << ceil(y) << "\n";
  return 0;
}
