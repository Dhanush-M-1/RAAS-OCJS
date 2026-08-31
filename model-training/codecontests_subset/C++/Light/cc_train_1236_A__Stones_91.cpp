#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  cin >> k;
  for (int i = 0; i < k; ++i) {
    int res = 0;
    int a, b, c;
    cin >> a >> b >> c;
    while (b != 0 && c >= 2) {
      res += 3;
      b -= 1;
      c -= 2;
    }
    while (a != 0 && b >= 2) {
      res += 3;
      a -= 1;
      b -= 2;
    }
    cout << res << endl;
    res = 0;
  }
  return 0;
}
