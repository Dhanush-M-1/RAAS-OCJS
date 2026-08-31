#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  int a = ceil(n * y / 100.0) - x;
  if (a >= 0)
    cout << a << endl;
  else
    cout << 0 << endl;
  return 0;
}
