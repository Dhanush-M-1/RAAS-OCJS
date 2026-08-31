#include <bits/stdc++.h>
int main() {
  int n, m, i, x, flag = 0;
  int *bulbs, *final;
  scanf("%d %d", &n, &m);
  final = (int *)malloc(sizeof(int) * m);
  for (i = 0; i < m; i++) final[i] = 0;
  while (n > 0) {
    scanf("%d", &x);
    bulbs = (int *)malloc(sizeof(int) * x);
    for (i = 0; i < x; i++) {
      scanf("%d", &bulbs[i]);
      final[bulbs[i] - 1] = 1;
    }
    n--;
    free(bulbs);
  }
  for (i = 0; i < m; i++)
    if (final[i] == 0) {
      flag = 1;
      break;
    }
  if (flag == 0)
    printf("Yes");
  else
    printf("No");
}
