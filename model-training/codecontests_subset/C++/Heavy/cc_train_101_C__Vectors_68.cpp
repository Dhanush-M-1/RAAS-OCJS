#include <bits/stdc++.h>
using namespace std;
long long ax, ay, bx, by, cx, cy;
bool check(int ax, int ay) {
  return (cx * ax + cy * ay) % (cx * cx + cy * cy) == 0 &&
         (cx * ay - cy * ax) % (cx * cx + cy * cy) == 0;
}
int main() {
  cin >> ax >> ay >> bx >> by >> cx >> cy;
  if (cx == 0 && cy == 0) {
    if ((ax == bx && ay == by) || (ax == -bx && ay == -by) ||
        (ax == -by && ay == bx) || (ax == by && ay == -bx))
      cout << "YES";
    else
      cout << "NO";
    return 0;
  }
  if (cx == 0 && cy == 0) {
    if (ax == 0 && ay == 0)
      cout << "YES";
    else
      cout << "NO";
    return 0;
  }
  if (check(ax - bx, ay - by) || check(ax + bx, ay + by) ||
      check(ax + by, ay - bx) || check(ax - by, ay + bx))
    cout << "YES";
  else
    cout << "NO";
}
