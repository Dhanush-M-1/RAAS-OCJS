#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y, i, j;
  cin >> n >> x >> y;
  i = (n * y) / 100;
  if (y * n != i * 100) i += 1;
  if (i > x)
    cout << i - x;
  else
    cout << "0";
}
