#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c, ans = 0, ans1 = 0, a1, b1, c1;
    cin >> a >> b >> c;
    a1 = a;
    b1 = b;
    c1 = c;
    while (a >= 1 && b >= 2) {
      ans += 3;
      a--;
      b -= 2;
    }
    while (b >= 1 && c >= 2) {
      ans += 3;
      b--;
      c -= 2;
    }
    while (b1 >= 1 && c1 >= 2) {
      ans1 += 3;
      b1--;
      c1 -= 2;
    }
    while (a1 >= 1 && b1 >= 2) {
      ans1 += 3;
      a1--;
      b1 -= 2;
    }
    cout << max(ans, ans1) << endl;
  }
}
