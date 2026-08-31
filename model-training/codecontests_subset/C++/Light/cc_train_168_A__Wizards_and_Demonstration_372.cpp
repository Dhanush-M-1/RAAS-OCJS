#include <bits/stdc++.h>
using namespace std;
int main() {
  double n, x, y;
  cin >> n >> x >> y;
  int a = max(0.0, ceil(n * y / 100) - x);
  cout << a;
  return 0;
}
