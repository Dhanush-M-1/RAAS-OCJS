#include <bits/stdc++.h>
bool check(long long cx, long long cy, long long dx, long long dy) {
  long long t = cx * cx + cy * cy;
  long long a = -cy * dy - cx * dx;
  long long b = cx * dy - dx * cy;
  return t != 0 && a % t == 0 && b % t == 0;
}
int main() {
  int x1, y1, x2, y2, x3, y3;
  scanf("%d %d %d %d %d %d", &x1, &y1, &x2, &y2, &x3, &y3);
  if (x3 == 0 && y3 == 0) {
    if (x1 == x2 && y1 == y2)
      printf("YES\n");
    else if (x1 == -y2 && y1 == x2)
      printf("YES\n");
    else if (x1 == -x2 && y1 == -y2)
      printf("YES\n");
    else if (x1 == y2 && y1 == -x2)
      printf("YES\n");
    else
      printf("NO\n");
    return 0;
  }
  bool ans = check(x3, y3, x1 + x2, y1 + y2) ||
             check(x3, y3, x1 - y2, y1 + x2) ||
             check(x3, y3, x1 - x2, y1 - y2) || check(x3, y3, x1 + y2, y1 - x2);
  if (ans)
    printf("YES\n");
  else
    printf("NO\n");
  return 0;
}
