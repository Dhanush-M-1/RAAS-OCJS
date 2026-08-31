#include <bits/stdc++.h>
using namespace std;
const int N = 3 * 1e5;
int main() {
  double n, x, y;
  cin >> n >> x >> y;
  cout << max(0.0, ceil((y * n) / 100 - x));
}
