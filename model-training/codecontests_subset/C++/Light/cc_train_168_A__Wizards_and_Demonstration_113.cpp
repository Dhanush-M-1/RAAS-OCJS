#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  int q = (y * n - ((y * n) % 100)) / 100;
  q += (y * n % 100) != 0;
  if (q <= x) {
    cout << "0";
  } else
    cout << q - x;
  return 0;
}
