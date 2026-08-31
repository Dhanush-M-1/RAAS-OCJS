#include <bits/stdc++.h>
int a, b, c;
int t, x = 0;
int ans = 0;
void find(int x) {
  for (t = x; t <= c + x; t++)
    if (b * x + (b - a) * (t - x) < 0) {
      x++;
      ans++;
      find(x);
      break;
    }
}
int main() {
  scanf("%d%d%d", &a, &b, &c);
  find(x);
  printf("%d\n", ans);
  return 0;
}
