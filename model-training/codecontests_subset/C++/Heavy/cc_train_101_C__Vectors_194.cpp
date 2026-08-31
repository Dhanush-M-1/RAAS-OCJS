#include <bits/stdc++.h>
struct node {
  long long x, y;
} a[4];
int judge(long long ax, long long ay, long long bx, long long by, long long cx,
          long long cy) {
  long long n;
  if (cx == 0 && cy == 0) {
    if (bx == ax && by == ay)
      return 1;
    else
      return 0;
  } else if (cx == 0) {
    if ((bx - ax) % cy != 0)
      return 0;
    else {
      n = (bx - ax) / cy;
      if ((by - ay) % cy != 0)
        return 0;
      else
        return 1;
    }
  } else if (cy == 0) {
    if ((ay - by) % cx != 0)
      return 0;
    else {
      if ((bx - ax) % cx != 0)
        return 0;
      else
        return 1;
    }
  } else {
    if (((bx - ax) * cy - (by - ay) * cx) % (cy * cy + cx * cx) != 0)
      return 0;
    else {
      n = ((bx - ax) * cy - (by - ay) * cx) / (cy * cy + cx * cx);
      if ((by - ay + n * cx) % cy != 0)
        return 0;
      else
        return 1;
    }
  }
}
int main() {
  long long ax, ay, bx, by, cx, cy, f;
  while (
      ~scanf("%I64d%I64d%I64d%I64d%I64d%I64d", &ax, &ay, &bx, &by, &cx, &cy)) {
    f = 0;
    int i;
    a[0].x = ax;
    a[0].y = ay;
    a[1].x = ay;
    a[1].y = -ax;
    a[2].x = -ax;
    a[2].y = -ay;
    a[3].x = -ay;
    a[3].y = ax;
    for (i = 0; i < 4; i++) {
      if (judge(a[i].x, a[i].y, bx, by, cx, cy)) {
        f = 1;
        puts("YES");
        break;
      }
    }
    if (!f) puts("NO");
  }
}
