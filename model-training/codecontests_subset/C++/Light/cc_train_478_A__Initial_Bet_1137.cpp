#include <bits/stdc++.h>
int main() {
  int a[5], i, sum = 0;
  for (i = 0; i < 5; i++) {
    scanf("%d", &a[i]);
  }
  for (i = 0; i < 5; i++) {
    sum = sum + a[i];
  }
  if (sum % 5 == 0 && sum != 0)
    printf("%d", (sum / 5));
  else
    printf("-1");
  return 0;
}
