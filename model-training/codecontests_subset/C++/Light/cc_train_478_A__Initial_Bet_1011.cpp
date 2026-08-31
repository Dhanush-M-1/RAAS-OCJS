#include <bits/stdc++.h>
int main() {
  int i, sum, x, s[1000];
  scanf("%d", &s[0]);
  sum = s[0];
  for (i = 1; i < 5; i++) {
    scanf("%d", &s[i]);
    sum += s[i];
  }
  if (sum == 0)
    printf("-1");
  else if (sum % 5 == 0) {
    x = sum / 5;
    printf("%d", x);
  } else
    printf("-1");
  return 0;
}
