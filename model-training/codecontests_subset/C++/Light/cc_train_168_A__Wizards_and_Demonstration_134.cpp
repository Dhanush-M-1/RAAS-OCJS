#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  int p = y * n - 100 * x;
  if (p <= 0)
    cout << 0 << endl;
  else if (p % 100)
    cout << p / 100 + 1 << endl;
  else
    cout << p / 100 << endl;
  return 0;
}
