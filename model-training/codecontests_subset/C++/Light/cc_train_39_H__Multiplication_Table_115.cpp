#include <bits/stdc++.h>
using namespace std;
int n, x, num, b[109];
int main() {
  cin >> n;
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) {
      int x = i * j;
      num = 0;
      while (x) {
        num++;
        b[num] = x % n;
        x /= n;
      }
      for (int q = num; q >= 1; q--) cout << b[q];
      cout << " ";
    }
    cout << endl;
  }
}
