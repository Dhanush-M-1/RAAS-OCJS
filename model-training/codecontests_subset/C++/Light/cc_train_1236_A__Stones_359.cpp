#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int cnt = 0;
    while (b > 0 && c >= 2) {
      cnt += 3;
      b--;
      c -= 2;
    }
    while (a > 0 && b >= 2) {
      cnt += 3;
      a--;
      b -= 2;
    }
    cout << cnt << endl;
  }
}
