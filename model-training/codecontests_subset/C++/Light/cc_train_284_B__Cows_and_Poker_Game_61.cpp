#include <bits/stdc++.h>
int main() {
  int a[3], i, n, k;
  char c;
  while (scanf("%d", &n) != EOF) {
    getchar();
    memset(a, 0, sizeof(a));
    k = 0;
    for (i = 0; i < n; i++) {
      scanf("%c", &c);
      if (c == 'A') a[0]++;
      if (c == 'F') a[1]++;
      if (c == 'I') a[2]++;
    }
    if (a[0] > 0 && a[2] == 0)
      k += a[0];
    else if (a[2] == 1)
      k++;
    printf("%d\n", k);
  }
  return 0;
}
