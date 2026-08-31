#include <bits/stdc++.h>
int main() {
  int n, ara[100009];
  scanf("%d", &n);
  for (int i = 2; i <= n + 1; i++) {
    scanf("%d", &ara[i]);
  }
  std::sort(ara + 2, ara + n + 1);
  int t1 = 0, t2 = 0;
  for (int i = 2; i <= n + 1; i++) {
    int x = ara[i] - 1;
    int y = 1000000 - ara[i];
    if (x < y)
      t1 = x;
    else {
      t2 = y;
      break;
    }
  }
  if (t1 > t2)
    printf("%d\n", t1);
  else
    printf("%d\n", t2);
  return 0;
}
