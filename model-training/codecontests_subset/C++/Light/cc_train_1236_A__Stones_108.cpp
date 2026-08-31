#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    int sum = 0;
    cin >> a >> b >> c;
    if (b == 0) {
      printf("0\n");
    } else {
      if (c / 2 > b) {
        sum += b * 3;
      } else {
        sum += (c / 2) + (c / 2 * 2);
        b -= (c / 2);
        if (b / 2 > a) {
          sum += a * 3;
        } else {
          sum += (b / 2) + (b / 2 * 2);
        }
      }
      printf("%d\n", sum);
    }
  }
  return 0;
}
