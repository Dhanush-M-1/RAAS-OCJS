#include <bits/stdc++.h>
using namespace std;
long long ax, ay, bx, by, cx, cy;
bool estimate(long long vx, long long vy) {
  long long r = cx * cx + cy * cy;
  if (r == 0) return (vx == 0 and vy == 0);
  return (vx * cx + vy * cy) % r == 0 and (cx * vy - cy * vx) % r == 0;
}
int main() {
  cin >> ax >> ay >> bx >> by >> cx >> cy;
  if (estimate(bx - ax, by - ay) or estimate(bx + ax, by + ay) or
      estimate(bx + ay, by - ax) or estimate(bx - ay, by + ax))
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
