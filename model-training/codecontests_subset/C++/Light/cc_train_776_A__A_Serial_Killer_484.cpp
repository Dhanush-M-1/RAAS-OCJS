#include <bits/stdc++.h>
using namespace std;
int main() {
  char a[11], b[11], c[11], d[11];
  scanf("%s%s", a, b);
  printf("%s %s\n", a, b);
  int n;
  scanf("%d", &n);
  for (int i = n; i > 0; i--) {
    scanf("%s %s", c, d);
    if (strcmp(c, a) == 0)
      strcpy(a, d);
    else
      strcpy(b, d);
    printf("%s %s\n", a, b);
  }
  return 0;
}
