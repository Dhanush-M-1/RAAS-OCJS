#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c, sum = 0;
    cin >> a >> b >> c;
    while (c - 2 >= 0 && b - 1 >= 0) {
      c -= 2;
      b -= 1;
      sum += 3;
    }
    while (a - 1 >= 0 && b - 2 >= 0) {
      b -= 2;
      a -= 1;
      sum += 3;
    }
    cout << sum << endl;
  }
}
