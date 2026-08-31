#include <bits/stdc++.h>
using namespace std;
int main() {
  double n, x, y;
  cin >> n >> x >> y;
  cout << max(0, (int)ceil(n * (y / 100) - x));
}
