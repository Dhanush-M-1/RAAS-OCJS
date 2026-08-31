#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
const double eps = 1e-6;
bool can(long long ax, long long ay, long long bx, long long by, long long cx,
         long long cy) {
  long long q = ax - bx;
  long long w = ay - by;
  if (!q && !w) {
    return true;
  }
  if (!cx && !cy) return false;
  if (!cx) {
    return (!(q % cy) && !(w % cy));
  }
  if (!cy) {
    return (!(q % cx) && !(w % cx));
  }
  long long up1 = (q * cx + w * cy);
  long long up2 = (q * cy - w * cx);
  long long down = (cx * cx + cy * cy);
  return !(up1 % down) && !(up2 % down);
}
int main() {
  long long ax, ay, bx, by, cx, cy;
  cin >> ax >> ay >> bx >> by >> cx >> cy;
  for (int t = 0; t < 4; t++) {
    if (can(ax, ay, bx, by, cx, cy)) {
      puts("YES");
      return 0;
    }
    long long z1 = bx;
    long long z2 = by;
    bx = z2;
    by = -z1;
  }
  puts("NO");
  return 0;
  return 0;
}
