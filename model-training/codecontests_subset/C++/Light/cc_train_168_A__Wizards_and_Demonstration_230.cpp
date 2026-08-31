#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  int m = (int)ceil(((double)n * (double)y) / 100.0);
  if (x > m)
    cout << 0 << endl;
  else
    cout << m - x << endl;
  return 0;
}
