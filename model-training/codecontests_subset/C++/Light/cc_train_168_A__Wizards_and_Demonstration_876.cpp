#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y, k;
  cin >> n >> x >> y;
  k = (n * y) / 100 - x;
  while ((x + k) * 100 < y * n) k++;
  cout << max(k, 0);
  return 0;
}
