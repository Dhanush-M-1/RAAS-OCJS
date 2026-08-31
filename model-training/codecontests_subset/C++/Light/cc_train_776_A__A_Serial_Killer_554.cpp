#include <bits/stdc++.h>
using namespace std;
char a[15], b[15], c[15], d[15];
int main() {
  scanf("%s%s", a, b);
  printf("%s %s\n", a, b);
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%s%s", c, d);
    if (!strcmp(a, c))
      strcpy(a, d);
    else
      strcpy(b, d);
    printf("%s %s\n", a, b);
  }
  return 0;
}
