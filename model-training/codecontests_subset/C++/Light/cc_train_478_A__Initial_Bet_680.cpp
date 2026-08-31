#include <bits/stdc++.h>
int main() {
  int i, j, k, n, t, c1, c2, c3, c4, c5;
  scanf("%d%d%d%d%d", &c1, &c2, &c3, &c4, &c5);
  t = c1 + c2 + c3 + c4 + c5;
  if (t == 0)
    printf("-1\n");
  else if (t % 5 == 0)
    printf("%d\n", t / 5);
  else
    printf("-1\n");
}
