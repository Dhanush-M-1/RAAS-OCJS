#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j, n, a, b, c, ret = 0, t;
  scanf("%d %d %d %d", &n, &a, &b, &c);
  n *= 10;
  for (i = 0; i <= a; i++)
    for (j = 0; j <= b; j++) {
      t = (i * 5);
      t += (j * 10);
      if (n - t < 0) continue;
      if ((n - t) % 20 == 0 && (n - t) / 20 <= c) ret++;
    }
  printf("%d\n", ret);
  return 0;
}
