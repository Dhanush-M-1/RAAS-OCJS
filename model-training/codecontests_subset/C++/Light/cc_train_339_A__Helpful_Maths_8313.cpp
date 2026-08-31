#include <bits/stdc++.h>
int main() {
  int i = 0, j, t, n;
  char p[100];
  scanf("%s", p);
  n = strlen(p);
  for (; i < n - 1; i = i + 2) {
    for (j = 0; j < n - 1; j = j + 2) {
      if (p[j] > p[j + 2]) {
        t = p[j];
        p[j] = p[j + 2];
        p[j + 2] = t;
      }
    }
  }
  printf("%s\n", p);
}
