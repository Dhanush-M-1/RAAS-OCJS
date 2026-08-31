#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  int k = y * n;
  if (k % 100 != 0)
    k = 1 + k / 100;
  else
    k = k / 100;
  k = k - x;
  if (k < 0) k = 0;
  cout << k << endl;
  return 0;
}
