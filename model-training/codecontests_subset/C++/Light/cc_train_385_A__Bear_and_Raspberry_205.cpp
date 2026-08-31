#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
int main() {
  int n, c, x, y, ans = 0;
  scanf("%d%d", &n, &c);
  scanf("%d", &y);
  for (int i = (0); i < (n - 1); ++i) {
    scanf("%d", &x);
    ans = max(y - x - c, ans);
    y = x;
  }
  printf("%d\n", ans);
}
