#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  double ans;
  ans = (double)(y * n) / 100;
  if (ans - x > 0)
    cout << ceil(ans - x) << endl;
  else
    cout << 0 << endl;
  return 0;
}
