#include <bits/stdc++.h>
using namespace std;
long long ax, ay, bx, by, cx, cy;
void check(long long xx, long long yy) {
  if (cx == 0 && cy == 0) {
    if (xx == 0 && yy == 0) {
      cout << "YES";
      exit(0);
    } else
      return;
  }
  if ((cx * (yy)-cy * (xx)) % (cx * cx + cy * cy) != 0 ||
      (cx * (xx) + cy * (yy)) % (cx * cx + cy * cy) != 0)
    return;
  cout << "YES";
  exit(0);
}
int main() {
  cin >> ax >> ay >> bx >> by >> cx >> cy;
  check(bx - ax, by - ay);
  check(bx - ay, by + ax);
  check(bx + ax, by + ay);
  check(bx + ay, by - ax);
  cout << "NO";
}
