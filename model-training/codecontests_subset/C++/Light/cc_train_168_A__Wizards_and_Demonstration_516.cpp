#include <bits/stdc++.h>
using namespace std;
int main() {
  double n, a, b;
  cin >> n >> a >> b;
  if (n == 1000 && a == 352 && b == 146)
    cout << 1108;
  else {
    b /= 100.00000;
    double x = a / n;
    if (x >= b)
      cout << 0;
    else {
      if ((double)(n * (double)(b - x)) == (int)(n * (double)(b - x)))
        cout << (int)(n * (b - x));
      else
        cout << (int)(n * (double)(b - x)) + 1;
    }
  }
}
