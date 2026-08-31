#include <bits/stdc++.h>
int main() {
  int i, sum = 0, n;
  for (i = 1; i <= 5; i++) {
    scanf("%d", &n);
    sum += n;
  }
  if (sum % 5 == 0 && sum != 0)
    printf("%d\n", sum / 5);
  else
    printf("-1\n");
  return 0;
}
