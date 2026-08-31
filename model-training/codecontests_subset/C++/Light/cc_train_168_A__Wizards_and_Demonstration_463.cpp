#include <bits/stdc++.h>
using namespace std;
int main() {
  int x, y, n;
  scanf("%d%d%d", &n, &x, &y);
  int need;
  for (need = 0; (x + need) * 100 < y * n; ++need)
    ;
  printf("%d\n", need);
  return 0;
}
