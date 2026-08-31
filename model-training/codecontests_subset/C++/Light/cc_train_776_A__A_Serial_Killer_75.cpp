#include <bits/stdc++.h>
int arr[100005];
int main() {
  char a[15], b[15], c[15], d[15];
  scanf("%s %s", &a, &b);
  int n;
  scanf("%d", &n);
  printf("%s %s\n", a, b);
  while (n--) {
    scanf("%s %s", &c, &d);
    if (strcmp(a, c) == 0)
      strcpy(a, d);
    else
      strcpy(b, d);
    printf("%s %s\n", a, b);
  }
  return 0;
}
