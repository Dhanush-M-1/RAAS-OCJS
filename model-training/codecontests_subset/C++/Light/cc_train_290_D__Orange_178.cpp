#include <bits/stdc++.h>
int main() {
  char a[100];
  int x;
  scanf("%s", a);
  scanf("%d", &x);
  int i = 0;
  int u;
  u = strlen(a);
  for (i = 0; i < u; i++) {
    a[i] = tolower(a[i]);
  }
  for (i = 0; i < u; i++) {
    if (a[i] < 'a' + x) {
      a[i] = toupper(a[i]);
      printf("%c", a[i]);
    } else
      printf("%c", a[i]);
  }
  return 0;
}
