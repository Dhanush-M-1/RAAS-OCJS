#include <bits/stdc++.h>
int main() {
  int n, i, r, s, k, flag;
  char a[200010];
  while (scanf("%d", &n) != EOF) {
    getchar();
    gets(a);
    r = 0;
    s = 0;
    k = 0;
    for (i = 0; i < n; i++) {
      if (a[i] == 'A')
        r++;
      else if (a[i] == 'I')
        s++;
      else
        k++;
    }
    if (s == 0)
      printf("%d\n", r);
    else if (s == 1)
      printf("%d\n", 1);
    else
      printf("%d\n", 0);
  }
}
