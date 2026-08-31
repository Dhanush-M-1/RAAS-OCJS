#include <bits/stdc++.h>
int main() {
  int n;
  int i, tree = 2;
  scanf("%d", &n);
  int cohi[n][2];
  for (i = 0; i < n; i++) {
    scanf("%d %d", &cohi[i][0], &cohi[i][1]);
  }
  if (n == 1)
    printf("%d", 1);
  else {
    for (i = 1; i < n - 1; i++) {
      if (abs(cohi[i - 1][0] - cohi[i][0]) > cohi[i][1]) {
        tree++;
      } else if (abs(cohi[i + 1][0] - cohi[i][0]) > cohi[i][1]) {
        tree++;
        cohi[i][0] += cohi[i][1];
      }
    }
    printf("%d", tree);
  }
  return 0;
}
