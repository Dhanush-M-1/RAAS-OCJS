#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y, sum = 0;
  cin >> n >> x >> y;
  sum = (n * y) / 100;
  if ((n * y) % 100 != 0) {
    sum += 1;
  }
  if (sum <= x)
    cout << 0;
  else
    cout << abs(sum - x);
  return 0;
}
