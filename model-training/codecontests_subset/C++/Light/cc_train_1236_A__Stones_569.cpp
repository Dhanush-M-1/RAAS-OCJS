#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    int sum1 = 0, sum2 = 0;
    cin >> a >> b >> c;
    int b1 = b;
    int x1 = min(a, b / 2);
    sum1 = 3 * x1;
    b -= x1 * 2;
    if (b != 0) {
      int x2 = min(b, c / 2);
      sum1 += 3 * x2;
    }
    x1 = min(b1, c / 2);
    sum2 = 3 * x1;
    b1 -= x1;
    if (b1 > 0) {
      int x2 = min(a, b1 / 2);
      sum2 += 3 * x2;
    }
    cout << max(sum2, sum1) << endl;
  }
  return 0;
}
