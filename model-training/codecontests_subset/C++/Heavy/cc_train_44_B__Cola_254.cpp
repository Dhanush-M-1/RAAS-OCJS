#include <bits/stdc++.h>
int main() {
  int i, j, k, a, b, c;
  int n;
  scanf("%d %d %d %d", &n, &a, &b, &c);
  getchar();
  int target = n;
  long long result = 0;
  for (i = 0; i <= a; i += 2) {
    target = n;
    target = target - (i / 2);
    if (target == 0) {
      result++;
      break;
    }
    if (target < 0) break;
    int target1;
    for (j = 0; j <= b; j++) {
      target1 = target;
      target1 = target1 - j;
      if (target1 == 0) {
        result++;
        break;
      }
      if (target1 < 0 || target1 % 2) continue;
      if (target1 <= 2 * c) {
        result++;
      }
    }
  }
  printf("%lld\n", result);
  return 0;
}
