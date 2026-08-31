#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y, i = 0;
  cin >> n >> x >> y;
  double h = y * n / 100.0;
  cout << max(ceil(h) - x, 0.0);
}
