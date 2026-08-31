#include <bits/stdc++.h>
using namespace std;
const int N = 3e5 + 1;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  y = n * y;
  if (y % 100)
    y = y / 100 + 1;
  else
    y /= 100;
  cout << max(y - x, 0) << "\n";
  return 0;
}
