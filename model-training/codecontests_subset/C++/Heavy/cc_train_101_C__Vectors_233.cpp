#include <bits/stdc++.h>
using namespace std;
int ax, ay, bx, by, cx, cy;
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int main(void) {
  scanf("%d%d%d%d%d%d", &ax, &ay, &bx, &by, &cx, &cy);
  if (cx == 0 && cy == 0) {
    if ((ax == bx && ay == by) || (ax == -by && ay == bx) ||
        (ax == -bx && ay == -by) || (ax == by && ay == -bx))
      puts("YES");
    else
      puts("NO");
    return 0;
  }
  for (int i = 0; i < 4; i++) {
    int rx = bx + dx[i] * ax + dy[i] * ay, ry = by + dx[i] * ay - dy[i] * ax;
    long long D = -cy * 1LL * cy - cx * 1LL * cx;
    long long DX = rx * 1LL * -cx - cy * 1LL * ry;
    long long DY = cx * 1LL * ry - rx * 1LL * cy;
    if (DX % D == 0 && DY % D == 0) {
      puts("YES");
      return 0;
    }
  }
  puts("NO");
  return 0;
}
