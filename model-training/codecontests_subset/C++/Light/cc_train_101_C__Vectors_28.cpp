#include <bits/stdc++.h>
int main() {
  long long x1, x2, x3, y1, y2, y3;
  scanf("%I64d %I64d\n%I64d %I64d\n%I64d %I64d", &x1, &y1, &x2, &y2, &x3, &y3);
  long long z = x3 * x3 + y3 * y3;
  for (int i = 0; i < 4; ++i) {
    x1 ^= y1;
    y1 ^= x1;
    x1 ^= y1;
    y1 = -y1;
    long long difx = x2 - x1, dify = y2 - y1;
    if (!z && !difx && !dify) {
      printf("YES\n");
      return 0;
    }
    if (z && !((difx * x3 + dify * y3) % z) && !((dify * x3 - difx * y3) % z)) {
      printf("YES\n");
      return 0;
    }
  }
  printf("NO\n");
  return 0;
}
