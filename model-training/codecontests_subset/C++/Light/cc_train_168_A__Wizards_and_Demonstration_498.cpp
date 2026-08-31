#include <bits/stdc++.h>
using namespace std;
int solve(int n, int x, int y) {
  if (100 * x >= y * n) return 0;
  int xplusa = (y * n) / 100;
  while (100 * xplusa < y * n) xplusa++;
  return xplusa - x;
}
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  cout << solve(n, x, y);
  return 0;
}
