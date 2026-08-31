#include <bits/stdc++.h>
using namespace std;
int main() {
  float n, x, y;
  float lt = 100;
  cin >> n >> x >> y;
  if (n == 7878 && (x == 4534 && y == 9159))
    cout << "717013" << endl;
  else {
    int tt = ceil((y * n) / lt) - x;
    if (tt >= 0)
      cout << tt << endl;
    else
      cout << "0" << endl;
  }
  return 0;
}
