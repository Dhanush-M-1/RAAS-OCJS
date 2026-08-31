#include <bits/stdc++.h>
int main() {
  int n, i, x, s1 = 0, s2 = 0, s3 = 0;
  scanf("%d", &n);
  for (i = 0; i < n; i++) {
    scanf("%d", &x);
    s1 = s1 + x;
  }
  for (i = 0; i < n - 1; i++) {
    scanf("%d", &x);
    s2 = s2 + x;
  }
  for (i = 0; i < n - 2; i++) {
    scanf("%d", &x);
    s3 = s3 + x;
  }
  printf("%d", s1 - s2);
  printf("\n%d", s1 - (s3 + (s1 - s2)));
  return 0;
}
