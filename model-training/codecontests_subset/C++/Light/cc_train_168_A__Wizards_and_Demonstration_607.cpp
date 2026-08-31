#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  scanf("%d %d %d", &n, &x, &y);
  double res = ceil((y / 100.0) * n);
  res - x >= 0 ? cout << res - x : cout << 0;
  return 0;
}
