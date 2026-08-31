#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  if (n * y % 100 == 0)
    n = n * y / 100;
  else
    n = 1 + n * y / 100;
  if (n > x)
    cout << n - x;
  else
    cout << 0;
}
