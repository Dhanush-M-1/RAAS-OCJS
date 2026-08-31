#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  int p = 1;
  cin >> n;
  cin >> x;
  cin >> y;
  p = n * y;
  if (p % 100 != 0)
    p = p / 100 + 1;
  else
    p = p / 100;
  if (p <= x)
    cout << 0 << endl;
  else
    cout << p - x << endl;
  return 0;
}
