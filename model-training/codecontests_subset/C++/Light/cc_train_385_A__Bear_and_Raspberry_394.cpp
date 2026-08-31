#include <bits/stdc++.h>
int main() {
  int n, c, i, dif;
  scanf("%d %d", &n, &c);
  int ar[110];
  for (i = 1; i <= n; i++) {
    scanf("%d", &ar[i]);
  }
  int maxpos = 0, max = 0, f = 0;
  for (i = 1; i <= n - 1; i++) {
    if (ar[i] > ar[i + 1]) {
      f = 1;
      dif = ar[i] - ar[i + 1];
      if (dif > max) {
        max = dif;
        maxpos = i;
      }
    }
  }
  if (f) {
    int p = ar[maxpos] - ar[maxpos + 1] - c;
    if (p <= 0)
      printf("0");
    else
      printf("%d", p);
  } else
    printf("0");
  exit(0);
}
