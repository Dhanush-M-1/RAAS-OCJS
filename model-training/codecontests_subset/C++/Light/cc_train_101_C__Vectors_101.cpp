#include <bits/stdc++.h>
using namespace std;
int main() {
  long long ax, ay, bx, by, cx, cy;
  cin >> ax >> ay >> bx >> by >> cx >> cy;
  long long abs = cx * cx + cy * cy;
  for (int i = 0; i < (4); i++) {
    long long dx = ax - bx, dy = ay - by;
    if (dx == 0 && dy == 0) {
      cout << "YES";
      return 0;
    }
    if (abs != 0) {
      if (((dx * cx + dy * cy) % abs == 0) &&
          ((-dx * cy + dy * cx) % abs == 0)) {
        cout << "YES";
        return 0;
      }
    }
    ay = -ay;
    swap(ax, ay);
  }
  cout << "NO";
  return 0;
}
