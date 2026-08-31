#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, x, y, p;
  double c;
  cin >> n >> x >> y;
  c = (double)y / 100;
  p = ceil(n * c);
  if (p <= x) {
    cout << 0;
  } else {
    cout << p - x;
  }
  return 0;
}
