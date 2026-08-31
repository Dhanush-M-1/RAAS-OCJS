#include <bits/stdc++.h>
using namespace std;
char c[105][2];
void solve() {
  int n, cnt, add, sub;
  sub = 0;
  add = cnt = 1;
  strcpy(c[0], "+");
  while (scanf("%s", c[cnt]) && strcmp(c[cnt], "=")) {
    if (strcmp(c[cnt], "?") == 0) continue;
    if (strcmp(c[cnt], "+") == 0)
      add++;
    else
      sub++;
    cnt++;
  }
  scanf("%d", &n);
  int tp = n - add + sub;
  if (tp > 0 && add * (n - 1) < tp || tp < 0 && sub * (n - 1) < -tp)
    puts("Impossible");
  else {
    puts("Possible");
    for (int i = 0; i < cnt; ++i) {
      int x = 1;
      if (i) printf("%s ", c[i]);
      if (tp > 0 && strcmp(c[i], "+") == 0) {
        if (tp >= n - 1)
          x = n;
        else
          x = x + tp;
        tp -= x - 1;
      } else if (tp < 0 && strcmp(c[i], "-") == 0) {
        if (tp <= 1 - n)
          x = n;
        else
          x = x - tp;
        tp -= -x + 1;
      }
      printf("%d ", x);
    }
    printf("= %d\n", n);
  }
}
int main() {
  solve();
  return 0;
}
