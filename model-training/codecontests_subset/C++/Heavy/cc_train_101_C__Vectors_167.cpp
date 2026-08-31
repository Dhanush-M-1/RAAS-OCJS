#include <bits/stdc++.h>
using namespace std;
double const pi = 3.1415926535897932384626433832795;
int const inf = (int)1e9;
long long const inf64 = (long long)2e18;
const string name = "c";
long long ax, ay, bx, by, cx, cy;
void rotate(long long &x, long long &y) {
  long long xx = -y, yy = x;
  x = xx, y = yy;
}
void answer() {
  cout << "YES" << endl;
  exit(0);
}
void solve(long long x, long long y) {
  if (cx == 0 && cy == 0) {
    if (x == 0 && y == 0) answer();
    return;
  }
  if (cx == 0 || cy == 0) {
    long long zn = cx + cy;
    if (zn < 0) zn = -zn;
    if (x % zn == 0 && y % zn == 0) answer();
    return;
  }
  if ((x * cy - y * cx) % (cx * cx + cy * cy) == 0 &&
      (y * cy + x * cx) % (cx * cx + cy * cy) == 0)
    answer();
}
int main() {
  cin >> ax >> ay;
  cin >> bx >> by;
  cin >> cx >> cy;
  for (int i = 0; i < (int)4; i++) {
    for (int j = 0; j < (int)4; j++) {
      solve(bx - ax, by - ay);
      rotate(bx, by);
    }
    rotate(ax, ay);
  }
  cout << "NO" << endl;
  return 0;
}
