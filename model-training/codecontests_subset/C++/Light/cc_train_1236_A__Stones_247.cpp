#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  while (n--) {
    int a, b, c;
    scanf("%d%d%d", &a, &b, &c);
    int sum = 0;
    while (1) {
      if (c < 2 || b <= 0) break;
      if (c >= 2) {
        c -= 2;
        b--;
        sum += 3;
      }
    }
    while (1) {
      if (b < 2 || a <= 0) break;
      if (b >= 2) {
        b -= 2;
        a--;
        sum += 3;
      }
    }
    cout << sum << endl;
  }
  return 0;
}
