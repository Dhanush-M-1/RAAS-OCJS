#include <bits/stdc++.h>
using namespace std;
const int MAXN = -1;
long long x1, x2, x3, aoduiaosdiaosid, y2, y3;
void rot() {
  long long v = aoduiaosdiaosid;
  long long w = -x1;
  x1 = v;
  aoduiaosdiaosid = w;
}
int main() {
  while (scanf("%lld%lld%lld%lld%lld%lld", &x1, &aoduiaosdiaosid, &x2, &y2, &x3,
               &y3) >= 1) {
    if (x3 == 0 && y3 == 0) {
      bool ok = false;
      for (int i = (0); i < (int)(4); i++) {
        if (x1 == x2 && aoduiaosdiaosid == y2) ok = true;
        rot();
      }
      printf("%s\n", ok ? "YES" : "NO");
      continue;
    }
    bool can = false;
    for (int z = (0); z < (int)(4); z++) {
      bool ok = true;
      if (x3 == 0) {
        if ((x2 - x1) % y3) ok = false;
        if ((y2 - aoduiaosdiaosid) % y3) ok = false;
        if (ok) {
          can = true;
          break;
        }
      } else {
        long long nom = y3 * (x2 - x1) - x3 * (y2 - aoduiaosdiaosid);
        long long den = x3 * x3 + y3 * y3;
        if (nom % den)
          ok = false;
        else {
          long long q = nom / den;
          if ((x2 - x1 - q * y3) % x3) ok = false;
        }
      }
      if (ok) {
        can = true;
        break;
      }
      rot();
    }
    printf("%s\n", can ? "YES" : "NO");
  }
  return 0;
}
