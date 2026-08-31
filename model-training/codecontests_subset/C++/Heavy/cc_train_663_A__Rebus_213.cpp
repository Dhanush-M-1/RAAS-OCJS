#include <bits/stdc++.h>
using namespace std;
char s[5];
int x, y, n, c = 0;
bool v[105];
int main() {
  x++;
  v[0] = 1;
  while (scanf("%s", s) != EOF) {
    if (strcmp(s, "+") == 0) {
      x++;
      v[++c] = 1;
    } else if (strcmp(s, "-") == 0) {
      y++;
      c++;
    } else if (strcmp(s, "=") == 0)
      break;
  }
  scanf("%d", &n);
  if (n * x - y < n || x - n * y > n) {
    printf("Impossible\n");
    return 0;
  }
  printf("Possible\n");
  int m = n;
  bool ok = 0;
  for (int i = 0; i <= c; i++) {
    if (v[i]) {
      x--;
      if (ok) printf("+ ");
      for (int j = 1; j <= n; j++) {
        if (j + n * x - y >= m && j + x - n * y <= m) {
          printf("%d ", j);
          m -= j;
          break;
        }
      }
    } else {
      y--;
      if (ok) printf("- ");
      for (int j = 1; j <= n; j++) {
        if (-j + n * x - y >= m && -j + x - n * y <= m) {
          printf("%d ", j);
          m += j;
          break;
        }
      }
    }
    ok = 1;
  }
  printf("= %d\n", n);
  return 0;
}
