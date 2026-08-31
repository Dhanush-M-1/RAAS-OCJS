#include <bits/stdc++.h>
int main() {
  int c1, c2, c3, c4, c5, b;
  while (scanf("%d%d%d%d%d", &c1, &c2, &c3, &c4, &c5) != EOF) {
    if ((c1 + c2 + c3 + c4 + c5) == 0) {
      printf("-1\n");
      break;
    }
    if ((c1 + c2 + c3 + c4 + c5) % 5 == 0) {
      printf("%d\n", (c1 + c2 + c3 + c4 + c5) / 5);
    } else {
      printf("-1\n");
    }
  }
  return 0;
}
