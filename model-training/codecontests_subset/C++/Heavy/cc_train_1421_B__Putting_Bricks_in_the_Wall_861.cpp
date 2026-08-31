#include <bits/stdc++.h>
using namespace std;
char s[400][400];
int main() {
  int t;
  scanf("%d", &t);
  while (t--) {
    int n;
    scanf("%d", &n);
    for (int i = 1; i <= n; i++) scanf("%s", s[i] + 1);
    int one = 0, zero = 0;
    if (s[1][2] == '1')
      one++;
    else
      zero++;
    if (s[2][1] == '1')
      one++;
    else
      zero++;
    if (one == 0) {
      int tot = 0, s1 = 0, s2 = 0;
      if (s[n][n - 1] == '0') tot++, s1 = 1;
      if (s[n - 1][n] == '0') tot++, s2 = 1;
      printf("%d\n", tot);
      if (s1) printf("%d %d\n", n, n - 1);
      if (s2) printf("%d %d\n", n - 1, n);
    } else if (one == 1) {
      int o = 0, z = 0;
      if (s[n][n - 1] == '1')
        o++;
      else
        z++;
      if (s[n - 1][n] == '1')
        o++;
      else
        z++;
      if (o == 1) {
        printf("2\n");
        if (s[1][2] == '1') printf("1 2\n");
        if (s[2][1] == '1') printf("2 1\n");
        if (s[n][n - 1] == '0') printf("%d %d\n", n, n - 1);
        if (s[n - 1][n] == '0') printf("%d %d\n", n - 1, n);
      } else if (o == 0) {
        printf("1\n");
        if (s[1][2] == '0') printf("1 2\n");
        if (s[2][1] == '0') printf("2 1\n");
      } else {
        printf("1\n");
        if (s[1][2] == '1') printf("1 2\n");
        if (s[2][1] == '1') printf("2 1\n");
      }
    } else {
      int tot = 0, s1 = 0, s2 = 0;
      if (s[n][n - 1] == '1') tot++, s1 = 1;
      if (s[n - 1][n] == '1') tot++, s2 = 1;
      printf("%d\n", tot);
      if (s1) printf("%d %d\n", n, n - 1);
      if (s2) printf("%d %d\n", n - 1, n);
    }
  }
}
