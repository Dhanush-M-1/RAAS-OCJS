#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c, count = 0;
    cin >> a >> b >> c;
    while (b != 0 && c > 1) {
      count += 3;
      b--;
      c = c - 2;
    }
    while (a != 0 && b > 1) {
      count += 3;
      a--;
      b = b - 2;
    }
    cout << count << endl;
  }
  return 0;
}
