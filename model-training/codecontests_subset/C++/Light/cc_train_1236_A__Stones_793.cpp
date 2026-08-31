#include <bits/stdc++.h>
using namespace std;
int n, a, b, c;
int main() {
  scanf("%d", &n);
  while (n--) {
    scanf("%d%d%d", &a, &b, &c);
    int ans = 0;
    if (!b) {
      printf("0\n");
      continue;
    }
    while (c) {
      if (b >= 1 && c >= 2)
        ans += 3;
      else
        break;
      b--;
      c -= 2;
    }
    while (a) {
      if (b >= 2 && a >= 1)
        ans += 3;
      else
        break;
      a--;
      b -= 2;
    }
    printf("%d\n", ans);
  }
}
