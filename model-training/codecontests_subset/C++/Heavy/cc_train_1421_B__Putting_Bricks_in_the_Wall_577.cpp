#include <bits/stdc++.h>
using namespace std;
int T, n, res, a1, a2, a3, a4;
char s[210][210];
bool check(char x, char y) {
  res =
      (s[1][2] == y) + (s[2][1] == y) + (s[n][n - 1] == x) + (s[n - 1][n] == x);
  if (res <= 2) {
    printf("%d\n", res);
    if (s[1][2] == y) printf("1 2\n");
    if (s[2][1] == y) printf("2 1\n");
    if (s[n][n - 1] == x) printf("%d %d\n", n, n - 1);
    if (s[n - 1][n] == x) printf("%d %d\n", n - 1, n);
    return 1;
  }
  return 0;
}
int main() {
  scanf("%d", &T);
  while (T--) {
    scanf("%d", &n);
    for (int i = 1; i <= n; i++) scanf("%s", s[i] + 1);
    if (check('0', '1'))
      ;
    else
      check('1', '0');
  }
}
