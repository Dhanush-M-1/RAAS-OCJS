#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    int k = 0;
    cin >> a >> b >> c;
    while (b > 0 && c > 1) {
      k += 3;
      b--;
      c--;
      c--;
    }
    while (a > 0 && b > 1) {
      k += 3;
      a--;
      b--;
      b--;
    }
    cout << k << endl;
  }
  return 0;
}
