#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  int min;
  min = ceil(y * 0.01 * n);
  if (min > x)
    cout << (min - x);
  else
    cout << 0;
}
