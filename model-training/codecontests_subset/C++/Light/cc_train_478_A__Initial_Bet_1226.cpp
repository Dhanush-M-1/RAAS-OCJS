#include <bits/stdc++.h>
int main() {
  int a, i;
  int m[10];
  scanf("%d %d %d %d %d", &m[0], &m[1], &m[2], &m[3], &m[4]);
  i = m[0] + m[1] + m[2] + m[3] + m[4];
  if (i == 0)
    printf("%d", -1);
  else if (i % 5 == 0)
    printf("%d", i / 5);
  else
    printf("%d", -1);
  return 0;
}
