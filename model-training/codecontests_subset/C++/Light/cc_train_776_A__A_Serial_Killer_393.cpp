#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  char a[15], b[15], c[15];
  scanf("%s%s", a, b);
  scanf("%d", &n);
  printf("%s %s\n", a, b);
  for (int i = 1; i <= n; i++) {
    scanf("%s", c);
    int l = strlen(c);
    int la = strlen(a);
    int lb = strlen(b);
    if (memcmp(a, c, l) == 0 && l == la) {
      scanf("%s", a);
      printf("%s %s\n", a, b);
    }
    if (memcmp(b, c, l) == 0 && l == lb) {
      scanf("%s", b);
      printf("%s %s\n", a, b);
    }
  }
  return 0;
}
