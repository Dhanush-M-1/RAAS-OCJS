#include <bits/stdc++.h>
int main() {
  int a[100000], b[100000], c[100000], n, i, s1 = 0, s2 = 0, s3 = 0;
  scanf("%d", &n);
  for (i = 0; i < n; i++) {
    scanf("%d", &a[i]);
    s1 += a[i];
  }
  for (i = 0; i < n - 1; i++) {
    scanf("%d", &b[i]);
    s2 += b[i];
  }
  for (i = 0; i < n - 2; i++) {
    scanf("%d", &c[i]);
    s3 += c[i];
  }
  printf("%d\n", s1 - s2);
  printf("%d\n", s2 - s3);
}
