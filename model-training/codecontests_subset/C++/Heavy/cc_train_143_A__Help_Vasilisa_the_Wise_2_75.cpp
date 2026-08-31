#include <bits/stdc++.h>
using namespace std;
const int N = 200005;
int a[N];
int main() {
  int r1, r2, c1, c2, d1, d2;
  scanf("%d %d %d %d %d %d", &r1, &r2, &c1, &c2, &d1, &d2);
  int x, y, z, w;
  if ((r1 - c1 + d2) % 2 != 0 || (r1 - c1 + d2 <= 0)) {
    printf("-1\n");
    return 0;
  } else {
    y = (r1 - c1 + d2) / 2;
  }
  if (d2 - y <= 0) {
    printf("-1\n");
    return 0;
  } else
    z = d2 - y;
  if (r2 - z <= 0) {
    printf("-1\n");
    return 0;
  } else {
    w = r2 - z;
  }
  if (r1 - y <= 0) {
    printf("-1\n");
    return 0;
  } else {
    x = r1 - y;
  }
  if (x + y == r1 && x + z == c1 && z + w == r2 && y + w == c2 && x + w == d1 &&
      y + z == d2) {
    if (x <= 9 && y <= 9 && z <= 9 && w <= 9 && x != y && x != z && x != w &&
        y != z && y != w && z != w)
      printf("%d %d\n%d %d\n", x, y, z, w);
    else
      printf("-1\n");
  } else {
    printf("-1\n");
    return 0;
  }
  return 0;
}
