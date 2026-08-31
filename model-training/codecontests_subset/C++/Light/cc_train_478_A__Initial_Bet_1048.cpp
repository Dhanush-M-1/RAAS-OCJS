#include <bits/stdc++.h>
int main() {
  int i[5], a = 0, b;
  for (int x = 0; x < 5; x++) scanf("%d", &i[x]);
  for (int x = 0; x < 5; x++) a = a + i[x];
  if (a < 5)
    printf("-1");
  else if (a % 5 == 0)
    printf("%d", a / 5);
  else
    printf("-1");
}
