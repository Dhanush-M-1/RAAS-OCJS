#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  double res = 1.0 * x / n;
  int clones = 0;
  while (res < 0.01 * y) {
    clones++;
    res = 1.0 * (x + clones) / n;
  }
  cout << clones;
  return 0;
}
