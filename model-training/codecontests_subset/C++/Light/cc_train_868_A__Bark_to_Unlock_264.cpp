#include <bits/stdc++.h>
int sw, sw1, sw2;
int main() {
  char a[1000];
  scanf("%s", a);
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    char b[10];
    scanf("%s", b);
    if (b[0] == a[0] && b[1] == a[1]) sw = 1;
    if (b[1] == a[0]) sw1 = 1;
    if (b[0] == a[1]) sw2 = 1;
  }
  if (sw == 1 || sw1 == 1 && sw2 == 1)
    printf("YES");
  else
    printf("NO");
}
