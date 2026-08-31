#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  cin >> k;
  for (int i = 1; i < k; ++i) {
    for (int j = 1; j < k; ++j) {
      int x = i * j, d = 1, t = 0;
      while (x) {
        t += d * (x % k);
        x /= k;
        d *= 10;
      }
      cout << t << " ";
    }
    cout << endl;
  }
  return 0;
}
