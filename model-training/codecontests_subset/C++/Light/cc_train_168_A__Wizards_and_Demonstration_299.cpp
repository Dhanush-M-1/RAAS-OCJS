#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y, k = 0;
  cin >> n >> x >> y;
  while ((x + k) * 100 < (n * y)) k++;
  cout << k;
  return 0;
}
