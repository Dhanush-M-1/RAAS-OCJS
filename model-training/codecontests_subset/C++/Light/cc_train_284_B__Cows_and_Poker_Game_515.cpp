#include <bits/stdc++.h>
char niz[200100];
int b[256];
int main() {
  int n, i, j;
  scanf("%d\n", &n);
  scanf("%s", niz);
  for (i = 0; i < n; i++) {
    b[niz[i]]++;
  }
  if (b['I']) {
    if (b['I'] > 1) {
      printf("0\n");
    } else {
      printf("1\n");
    }
  } else {
    printf("%d\n", b['A']);
  }
  return 0;
}
