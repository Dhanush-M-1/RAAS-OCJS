#include <bits/stdc++.h>
int main() {
  int a[10];
  int sum = 0;
  for (int i = 0; i < 5; ++i) {
    scanf("%d", a + i);
    sum += a[i];
  }
  if (sum % 5 || sum / 5 <= 0)
    printf("-1\n");
  else
    printf("%d\n", sum / 5);
  return 0;
}
