#include <bits/stdc++.h>
int x, sum = 0, i;
int main() {
  for (i = 1; i <= 5; i++) {
    scanf("%d", &x);
    sum += x;
  }
  if (sum == 0)
    printf("%d\n", -1);
  else if (sum % 5 == 0)
    printf("%d\n", sum / 5);
  else
    printf("%d\n", -1);
  return 0;
}
