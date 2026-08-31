#include <bits/stdc++.h>
int main() {
  int i, n, sum = 0;
  for (i = 0; i < 5; i++) {
    scanf("%d", &n);
    sum = sum + n;
  }
  if (sum % 5 == 0 && sum != 0) {
    printf("%d", sum / 5);
  } else {
    printf("-1");
  }
  return 0;
}
