#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y, j, k, l;
  cin >> n >> x >> y;
  l = n * y / 100;
  if (l * 100 < n * y) l++;
  k = l - x;
  if (k > 0)
    cout << k << endl;
  else
    cout << 0 << endl;
  return 0;
}
