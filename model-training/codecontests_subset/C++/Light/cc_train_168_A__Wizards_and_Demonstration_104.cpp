#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  int m = y * n;
  if (m % 100 > 0)
    m = (m / 100) + 1;
  else
    m = m / 100;
  int left = m - x;
  if (left < 0)
    cout << 0;
  else
    cout << left;
}
