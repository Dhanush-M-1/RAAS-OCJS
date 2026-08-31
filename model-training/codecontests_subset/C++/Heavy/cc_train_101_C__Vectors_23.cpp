#include <bits/stdc++.h>
using namespace std;
const int inf = 1000 * 1000 * 1000;
const long long INF = 1000ll * 1000ll * 1000ll * 1000ll * 1000ll * 1000ll;
long long ax, ay, bx, by, cx, cy;
int main() {
  cin >> ax >> ay;
  cin >> bx >> by;
  cin >> cx >> cy;
  long long _cx = -cy;
  long long _cy = cx;
  for (int i = 0; i < 4; ++i) {
    long long t = ax;
    ax = -ay;
    ay = t;
    if (ax == bx && ay == by) {
      cout << "YES" << endl;
      return 0;
    }
  }
  for (int i = 0; i < 4; ++i) {
    long long t = ax;
    ax = -ay;
    ay = t;
    long long _y = _cx * cy - cx * _cy;
    long long _x = cx * _cy - _cx * cy;
    if (_y == 0 || _x == 0) break;
    if ((cy * (bx - ax) - cx * (by - ay)) % _y == 0 &&
        (_cy * (bx - ax) - _cx * (by - ay)) % _x == 0) {
      cout << "YES" << endl;
      return 0;
    }
  }
  cout << "NO" << endl;
  return 0;
}
