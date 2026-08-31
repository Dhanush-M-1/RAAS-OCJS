#include <bits/stdc++.h>
using namespace std;
int main() {
  double n;
  int x, y;
  cin >> n >> x >> y;
  if (floor((x * 100) / n) >= y)
    cout << 0 << endl;
  else {
    int clones = ceil((y * n) / 100) - x;
    cout << clones << endl;
  }
  return 0;
}
