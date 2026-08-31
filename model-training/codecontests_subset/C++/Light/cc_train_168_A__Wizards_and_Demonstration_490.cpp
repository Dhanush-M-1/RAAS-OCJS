#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  scanf("%d %d %d", &n, &x, &y);
  int need = ceil(n * y / 100.0);
  if (x >= need)
    printf("%d\n", 0);
  else
    printf("%d\n", need - x);
  return 0;
}
