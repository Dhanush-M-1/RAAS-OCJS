#include <bits/stdc++.h>
int main() {
  unsigned short n;
  unsigned short ac1;
  unsigned short i;
  unsigned short w;
  unsigned short ac2;
  unsigned short gw;
  if (scanf("%hu", &n) != 1) return -1;
  if (n < 1 || n > 100) return -1;
  ac1 = 0;
  for (i = 0; i < n; i++) {
    if (scanf("%hu", &w) != 1) return -1;
    if (w != 100 && w != 200) return -1;
    if (w == 100) ac1++;
  }
  ac2 = n - ac1;
  gw = 50 * (ac1 + 2 * ac2);
  if (!(gw % 200) || (!(gw % 100) && ac1))
    printf("YES\n");
  else
    printf("NO\n");
  return 0;
}
