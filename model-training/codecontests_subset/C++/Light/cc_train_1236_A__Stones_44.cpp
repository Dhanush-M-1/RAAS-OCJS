#include <bits/stdc++.h>
using namespace std;
int main() {
  int T, a, b, c;
  cin >> T;
  while (T--) {
    cin >> a >> b >> c;
    int cnt = 0;
    while (b >= 1 && c >= 2) {
      b -= 1;
      c -= 2;
      cnt += 3;
    }
    while (a >= 1 && b >= 2) {
      a -= 1;
      b -= 2;
      cnt += 3;
    }
    cout << cnt << "\n";
  }
  return 0;
}
