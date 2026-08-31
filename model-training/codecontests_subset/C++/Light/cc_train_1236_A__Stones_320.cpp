#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int count = 0;
    while (b >= 1 && c >= 2) {
      count += 3;
      b -= 1;
      c -= 2;
    }
    while (a >= 1 && b >= 2) {
      count += 3;
      a -= 1;
      b -= 2;
    }
    cout << count << endl;
  }
}
