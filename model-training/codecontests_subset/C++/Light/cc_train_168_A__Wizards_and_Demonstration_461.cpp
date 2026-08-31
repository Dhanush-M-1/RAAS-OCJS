#include <bits/stdc++.h>
using namespace std;
int main() {
  double n, x, y;
  double koly;
  cin >> n >> x >> y;
  if (((n * y) / 100) > (int)((n * y) / 100))
    koly = (int)((n * y) / 100) + 1;
  else
    koly = ((n * y) / 100);
  if (x >= koly) {
    cout << 0;
    return 0;
  }
  cout << koly - x;
  return 0;
}
