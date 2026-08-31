#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  while (cin >> n >> x >> y) {
    int sum = n * y;
    if (sum % 100) sum += 100;
    sum /= 100;
    sum -= x;
    if (sum > 0)
      cout << sum << endl;
    else
      cout << 0 << endl;
  }
  return 0;
}
