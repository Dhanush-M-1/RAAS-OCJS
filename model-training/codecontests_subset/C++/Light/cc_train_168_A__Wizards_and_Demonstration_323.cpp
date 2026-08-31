#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  double per = ceil((n * y) / 100.00);
  int m = (int)per;
  if ((m - x) <= 0)
    cout << "0";
  else
    cout << m - x;
  return 0;
}
