#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int a, b, c, t, ct;
  cin >> t;
  while (t--) {
    ct = 0;
    cin >> a >> b >> c;
    while (c > 1 && b > 0) {
      c -= 2;
      b--;
      ct += 3;
    }
    while (b > 1 && a > 0) {
      b -= 2;
      a--;
      ct += 3;
    }
    cout << ct << endl;
  }
}
