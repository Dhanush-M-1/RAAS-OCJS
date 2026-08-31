#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c, x, y, max = 0;
  cin >> n >> c;
  cin >> y;
  for (int i = 1; i < n; i++) {
    cin >> x;
    if (y - x > 0 && y - x > max) max = y - x;
    y = x;
  }
  if (max > c)
    cout << max - c << endl;
  else
    cout << 0 << endl;
  return 0;
}
