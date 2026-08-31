#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int sum = 0;
    int cnt = 0;
    int s = 0;
    while (c >= 2 & b >= 1) {
      c -= 2;
      b--;
      cnt++;
    }
    while (b >= 2 and a >= 1) {
      b -= 2;
      a--;
      s++;
    }
    cout << cnt * 2 + cnt * 1 + s * 2 + s * 1 << endl;
  }
}
