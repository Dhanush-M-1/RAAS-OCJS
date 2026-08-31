#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c, cnt = 0;
    cin >> a >> b >> c;
    if (b == 0)
      cout << 0 << endl;
    else {
      if (c != 0 && b != 0) {
        int m = c / 2;
        if (b >= m)
          b = b - m;
        else {
          m = b;
          b = 0;
        }
        c = c - m;
        cnt += m;
        cnt += m * 2;
      }
      if (b > 1 && a != 0) {
        int n = b / 2;
        if (a >= n) {
          a = a - n;
        } else {
          n = a;
        }
        cnt += n;
        cnt += n * 2;
      }
      cout << cnt << endl;
    }
  }
  return 0;
}
