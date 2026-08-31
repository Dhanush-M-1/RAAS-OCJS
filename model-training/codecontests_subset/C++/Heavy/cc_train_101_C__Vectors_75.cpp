#include <bits/stdc++.h>
using namespace std;
long long bx, by;
bool f(long long cx, long long cy, long long ax, long long ay) {
  long long dx = ax - bx;
  long long dy = ay - by;
  if (dx == 0 && dy == 0) return true;
  if (cx == 0 && cy == 0) return false;
  if (cx == 0) {
    if (dx % cy == 0 && dy % cy == 0)
      return true;
    else
      return false;
  }
  if (cy == 0) {
    if (dx % cx == 0 && dy % cx == 0)
      return true;
    else
      return false;
  }
  if ((cx * dx + cy * dy) % (cx * cx + cy * cy) == 0 &&
      (-cy * dx + cx * dy) % (cx * cx + cy * cy) == 0)
    return true;
  else
    return false;
}
int main() {
  long long ax, ay;
  long long cx, cy;
  cin >> ax >> ay >> bx >> by >> cx >> cy;
  cout << ((f(cx, cy, ax, ay) || f(cx, cy, -ay, ax) || f(cx, cy, -ax, -ay) ||
            f(cx, cy, ay, -ax))
               ? "YES"
               : "NO");
  return 0;
}
