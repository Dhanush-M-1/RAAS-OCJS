#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e5 + 7;
const int MAXV = 507;
const int MAXE = 507;
const int INF = 0x3f3f3f3f;
long long d[4][2];
long long ax, ay, bx, by, cx, cy;
int main() {
  while (cin >> ax >> ay) {
    cin >> bx >> by >> cx >> cy;
    d[0][0] = ax, d[0][1] = ay;
    d[1][0] = ay, d[1][1] = -ax;
    d[2][0] = -ax, d[2][1] = -ay;
    d[3][0] = -ay, d[3][1] = ax;
    bool found = false;
    for (int cas = 0; cas < 4; cas++) {
      long long ex = bx - d[cas][0], ey = by - d[cas][1];
      if (cx == 0 && cy == 0) {
        if (ex == 0 && ey == 0) {
          found = true;
          break;
        }
      } else if ((ex * cy - ey * cx) % (cx * cx + cy * cy) == 0 &&
                 (ex * cx + ey * cy) % (cx * cx + cy * cy) == 0) {
        found = true;
        break;
      }
    }
    if (found)
      puts("YES");
    else
      puts("NO");
  }
  return 0;
}
