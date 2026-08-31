#include <bits/stdc++.h>
using namespace std;
long long ax, ay, bx, by, cx, cy;
int main() {
  cin >> ax >> ay >> bx >> by >> cx >> cy;
  for (int i = 0; i < 4; ++i) {
    long long cc = cx * cx + cy * cy;
    long long vec1 = (bx - ax) * cx + (by - ay) * cy;
    long long vec2 = (bx - ax) * (-cy) + (by - ay) * cx;
    if (cc == 0) {
      if (ax == bx && ay == by) {
        cout << "YES" << endl;
        return 0;
      }
    } else if (vec1 % cc == 0 && vec2 % cc == 0) {
      cout << "YES" << endl;
      return 0;
    }
    long long t = ay;
    ay = ax;
    ax = -t;
  }
  cout << "NO" << endl;
  return 0;
}
