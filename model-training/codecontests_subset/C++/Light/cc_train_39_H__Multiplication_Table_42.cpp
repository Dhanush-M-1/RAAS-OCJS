#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  int k;
  cin >> k;
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) {
      int x = i * j, y = 0, r = 1;
      while (x > 0) {
        y = r * (x % k) + y;
        x /= k;
        r *= 10;
      }
      cout << y << ' ';
    }
    cout << endl;
    ;
  }
  return 0;
}
