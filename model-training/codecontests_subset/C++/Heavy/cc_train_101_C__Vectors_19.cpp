#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:16777216")
using namespace std;
struct point {
  long long x, y;
  void scan() { scanf("%lld%lld", &x, &y); }
} A, B, C;
bool can(long long a, long long b) {
  if (a == 0 && b == 0) return true;
  long long ch = a * C.y - b * C.x;
  long long zn = C.y * C.y + C.x * C.x;
  if (zn == 0) return false;
  if (ch % zn != 0) return false;
  long long y = ch / zn;
  ch = a - y * C.y;
  zn = C.x;
  if (zn == 0) {
    return y * C.y == a && b % C.y == 0;
  }
  if (ch % zn != 0) return false;
  return true;
}
bool pos() {
  return can(B.x - A.x, B.y - A.y) || can(B.y - A.x, -B.x - A.y) ||
         can(-B.x - A.x, -B.y - A.y) || can(-B.y - A.x, B.x - A.y);
}
int main() {
  A.scan();
  B.scan();
  C.scan();
  for (int i = 0; i < 4; ++i) {
    if (pos()) {
      printf("YES");
      return 0;
    }
    swap(C.x, C.y);
    C.x = -C.x;
  }
  printf("NO");
  return 0;
}
