#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  cout << max((int)ceil((double)y * n / 100) - x, 0);
  return 0;
}
