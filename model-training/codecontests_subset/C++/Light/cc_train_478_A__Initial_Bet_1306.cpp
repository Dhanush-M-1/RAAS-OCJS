#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x = 0, a[10], i, j;
  for (i = 0; i < 5; i++) scanf("%d", &a[i]);
  for (i = 0; i < 5; i++) x = x + a[i];
  if (x % 5 > 0 || x == 0)
    printf("-1");
  else
    printf("%d", x / 5);
  return 0;
}
