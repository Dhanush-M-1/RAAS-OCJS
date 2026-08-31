#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  double i = (double)(y * n) / (100);
  int t = int(ceil(i)) - x;
  if (t > 0)
    cout << t;
  else
    cout << 0;
  return 0;
}
