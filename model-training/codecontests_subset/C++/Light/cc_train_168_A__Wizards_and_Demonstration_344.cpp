#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  cout << ((y * n) / 100 - x + ((y * n) % 100 != 0) >= 0
               ? (y * n) / 100 - x + ((y * n) % 100 != 0)
               : 0);
}
