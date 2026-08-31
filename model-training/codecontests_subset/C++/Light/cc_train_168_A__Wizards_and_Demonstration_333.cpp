#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  int sum = 0;
  int t = 1;
  while (t) {
    if (x * 100 / n >= y) {
      cout << sum;
      return 0;
    } else {
      x = x + 1;
      sum++;
    }
  }
  return 0;
}
