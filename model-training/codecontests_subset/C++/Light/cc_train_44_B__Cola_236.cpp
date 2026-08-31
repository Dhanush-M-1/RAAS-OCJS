#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, a, b, c, result = 0, i, x, y, j = 0;
  cin >> n >> a >> b >> c;
  for (i = 0; i <= min(n, a / 2); i++) {
    x = min(c, (n - i) / 2);
    y = min(i + b, n);
    if (y - (n - x * 2) / 2 >= 0) {
      if (y >= n - x * 2) result += (y - (n - x * 2)) / 2 + 1;
    }
  }
  cout << result;
  return 0;
}
