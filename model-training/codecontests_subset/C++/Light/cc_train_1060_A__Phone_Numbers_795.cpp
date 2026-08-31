#include <bits/stdc++.h>
using namespace std;
int n, m, x, y, z, k, t;
char a[300];
int main() {
  scanf("%d\n", &n);
  k = t = 0;
  scanf("%s", a + 1);
  for (int i = 1; i <= n; i++)
    if (a[i] == '8') k++;
  x = n / 11;
  if (k <= x)
    printf("%d\n", k);
  else
    printf("%d", x);
  return 0;
}
