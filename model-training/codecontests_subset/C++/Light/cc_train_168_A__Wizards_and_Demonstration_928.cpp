#include <bits/stdc++.h>
using namespace std;
int n, x, y;
int main() {
  scanf("%d%d%d", &n, &x, &y);
  int need = (n * y / 100) + ((n * y) % 100 == 0 ? 0 : 1);
  if (need <= x)
    puts("0");
  else
    printf("%d\n", need - x);
  return 0;
}
