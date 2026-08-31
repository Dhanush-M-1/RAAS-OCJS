#include <bits/stdc++.h>
using namespace std;
int main() {
  double n, x, y;
  cin >> n >> x >> y;
  int need = ceil(n * y / 100.0);
  int res = need - x;
  if (res > 0)
    cout << res << endl;
  else
    cout << "0" << endl;
  return 0;
}
