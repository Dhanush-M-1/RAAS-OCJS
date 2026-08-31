#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, d;
  cin >> a;
  for (int i = 0; i < a; i++) {
    int cnt = 0;
    cin >> b >> c >> d;
    while (true) {
      if (d - 2 < 0) {
        break;
      }
      if (c - 1 < 0) {
        break;
      }
      c--;
      d -= 2;
      cnt += 3;
    }
    while (true) {
      if (c - 2 < 0) {
        break;
      }
      if (b - 1 < 0) {
        break;
      }
      c -= 2;
      b--;
      cnt += 3;
    }
    cout << cnt << endl;
  }
}
