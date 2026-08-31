#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  scanf("%d%d%d", &n, &x, &y);
  int ans = 0;
  while ((x + ans + .0) / n < (y + .0) / 100) ++ans;
  printf("%d", ans);
  return 0;
}
