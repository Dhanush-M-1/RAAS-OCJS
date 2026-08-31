#include <bits/stdc++.h>
int main() {
  int m, i, x, y, z;
  char a[999999];
  while (scanf("%d%s", &m, a) != EOF) {
    x = 0;
    y = 0;
    z = 0;
    for (i = 0; i < m; i++) {
      if (a[i] == 'A')
        x++;
      else if (a[i] == 'F')
        y++;
      if (a[i] == 'I') z++;
    }
    if (z == 1)
      printf("1\n");
    else if (z > 1)
      printf("0\n");
    if (z == 0) printf("%d\n", x);
  }
}
