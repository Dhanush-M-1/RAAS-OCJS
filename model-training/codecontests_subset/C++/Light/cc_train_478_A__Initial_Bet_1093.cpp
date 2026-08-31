#include <bits/stdc++.h>
int main() {
  int c1, c2, c3, c4, c5;
  scanf("%d %d %d %d %d\n", &c1, &c2, &c3, &c4, &c5);
  if (((c1 + c2 + c3 + c4 + c5) % 5) != 0 || (c1 + c2 + c3 + c4 + c5) == 0)
    printf("-1\n");
  else
    printf("%d\n", ((c1 + c2 + c3 + c4 + c5) / 5));
}
