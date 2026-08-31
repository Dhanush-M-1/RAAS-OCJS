#include <bits/stdc++.h>
using namespace std;
long long ax, ay, bx, by, cx, cy;
int main() {
  cin >> ax >> ay >> bx >> by >> cx >> cy;
  long long dx = bx - ax, dy = by - ay, D = cx * cx + cy * cy;
  if (!dx && !dy ||
      D && (cx * dx + cy * dy) % D == 0 && (-cy * dx + cx * dy) % D == 0) {
    cout << "YES";
    return 0;
  }
  dx = bx + ay, dy = by - ax;
  if (!dx && !dy ||
      D && (cx * dx + cy * dy) % D == 0 && (-cy * dx + cx * dy) % D == 0) {
    cout << "YES";
    return 0;
  }
  dx = bx + ax, dy = by + ay;
  if (!dx && !dy ||
      D && (cx * dx + cy * dy) % D == 0 && (-cy * dx + cx * dy) % D == 0) {
    cout << "YES";
    return 0;
  }
  dx = bx - ay, dy = by + ax;
  if (!dx && !dy ||
      D && (cx * dx + cy * dy) % D == 0 && (-cy * dx + cx * dy) % D == 0) {
    cout << "YES";
    return 0;
  }
  cout << "NO";
}
