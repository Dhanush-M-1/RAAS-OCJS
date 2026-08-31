#include <bits/stdc++.h>
int main() {
  int c1, c2, c3, c4, c5;
  scanf("%d %d %d %d %d", &c1, &c2, &c3, &c4, &c5);
  int sum = c1 + c2 + c3 + c4 + c5;
  if (c1 == 0 && c2 == 0 && c3 == 0 && c4 == 0 && c5 == 0) {
    printf("-1\n");
    return 0;
  }
  if (sum % 5 == 0)
    printf("%d\n", sum / 5);
  else
    printf("-1\n");
  return 0;
}
