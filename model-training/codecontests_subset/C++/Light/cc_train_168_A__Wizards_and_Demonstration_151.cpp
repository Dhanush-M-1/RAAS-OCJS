#include <bits/stdc++.h>
using namespace std;
int main() {
  int x, y, n;
  float a;
  cin >> n >> x >> y;
  a = n * y;
  a /= 100;
  a = ceil(a);
  if (x > a)
    cout << 0;
  else
    cout << a - x;
  return 0;
}
