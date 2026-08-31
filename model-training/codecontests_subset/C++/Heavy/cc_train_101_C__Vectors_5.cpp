#include <bits/stdc++.h>
using namespace std;
double a[100][100];
int vx[4], vy[4];
int Work() {
  bool yes = false;
  long long ax, ay, bx, by, cx, cy, xx, yy, dx, dy;
  cin >> ax >> ay;
  cin >> bx >> by;
  cin >> cx >> cy;
  dx = cy;
  dy = -cx;
  long long ek, et, k1, k2;
  for (int i = 0; i < 4 && !yes; i++) {
    xx = ax - bx;
    yy = ay - by;
    k1 = k2 = -1;
    ek = xx * cy - yy * cx;
    et = dx * cy - dy * cx;
    if (ek == 0)
      k2 = 0;
    else if (et != 0 && ek % et == 0)
      k2 = ek / et;
    ek = xx * dy - yy * dx;
    et = cx * dy - cy * dx;
    if (ek == 0)
      k1 = 0;
    else if (et != 0 && ek % et == 0)
      k1 = ek / et;
    if (k1 * cx + k2 * dx == xx && k1 * cy + k2 * dy == yy) yes = true;
    bx = -bx;
    swap(bx, by);
  }
  if (yes)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
int main() {
  Work();
  return 0;
}
