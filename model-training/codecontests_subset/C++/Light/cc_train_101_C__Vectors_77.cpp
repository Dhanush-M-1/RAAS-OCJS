#include <bits/stdc++.h>
using namespace std;
long long ax, ay, bx, by, cx, cy;
void check(long long axx, long long ayy) {
  if (cx * cx + cy * cy == 0) {
    if (axx == bx && ayy == by) {
      cout << "YES";
      exit(0);
    } else
      return;
  }
  if ((cx * (by - ayy) - cy * (bx - axx)) % (cx * cx + cy * cy) != 0 ||
      (cx * (bx - axx) + cy * (by - ayy)) % (cx * cx + cy * cy) != 0)
    return;
  cout << "YES";
  exit(0);
}
int main() {
  cin >> ax >> ay >> bx >> by >> cx >> cy;
  check(ax, ay);
  check(ay, -ax);
  check(-ax, -ay);
  check(-ay, ax);
  cout << "NO";
}
