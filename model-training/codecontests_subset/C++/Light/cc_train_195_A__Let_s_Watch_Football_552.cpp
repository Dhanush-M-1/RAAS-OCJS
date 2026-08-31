#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, c, v, l, ans;
  scanf("%d%d%d", &c, &v, &l);
  if (c * l % v == 0)
    ans = c * l / v;
  else
    ans = c * l / v + 1;
  printf("%d\n", ans - l);
  return 0;
}
