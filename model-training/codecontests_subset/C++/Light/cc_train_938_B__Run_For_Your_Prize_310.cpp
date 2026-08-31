#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  t = 1;
  while (t--) {
    int n;
    cin >> n;
    int min1 = 0, min2 = 0;
    for (int i = 0; i < n; i++) {
      int u;
      cin >> u;
      if (u <= 500000 && min1 < u) {
        min1 = u - 1;
      }
      if (u > 500000 && min2 < 1000000 - u) {
        min2 = 1000000 - u;
      }
    }
    cout << max(min1, min2);
  }
  return 0;
}
