#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string x, y, x1, y1;
  cin >> x >> y;
  cin >> n;
  for (int i = 0; i < n + 1; i++) {
    cout << x << " " << y << endl;
    if (i == n) continue;
    cin >> x1 >> y1;
    if (x1 == x)
      x = y1;
    else
      y = y1;
  }
  return 0;
}
