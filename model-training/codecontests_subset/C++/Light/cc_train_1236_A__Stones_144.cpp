#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int cnt = 0;
    while (1) {
      if (b > 0 && c > 1) {
        cnt += 3;
        b--;
        c -= 2;
      } else if (a > 0 && b > 1) {
        cnt += 3;
        a--;
        b -= 2;
      } else
        break;
    }
    cout << cnt << endl;
  }
  return 0;
}
