#include <bits/stdc++.h>
using namespace std;
const int N = 1000 + 10;
char str[N][N];
int main() {
  int T;
  scanf("%d", &T);
  while (T--) {
    int n;
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) scanf("%s", str[i]);
    int tou1 = 0, wei1 = 0;
    if (str[0][1] == '1') tou1++;
    if (str[1][0] == '1') tou1++;
    if (str[n - 2][n - 1] == '1') wei1++;
    if (str[n - 1][n - 2] == '1') wei1++;
    if (tou1 == 2) {
      printf("%d\n", wei1);
      if (str[n - 2][n - 1] == '1') printf("%d %d\n", n - 1, n);
      if (str[n - 1][n - 2] == '1') printf("%d %d\n", n, n - 1);
    }
    if (tou1 == 1) {
      if (wei1 == 2) {
        printf("1\n");
        if (str[0][1] == '1') printf("%d %d\n", 1, 2);
        if (str[1][0] == '1') printf("%d %d\n", 2, 1);
      } else if (wei1 == 1) {
        printf("2\n");
        if (str[0][1] == '1') printf("%d %d\n", 1, 2);
        if (str[1][0] == '1') printf("%d %d\n", 2, 1);
        if (str[n - 2][n - 1] == '0') printf("%d %d\n", n - 1, n);
        if (str[n - 1][n - 2] == '0') printf("%d %d\n", n, n - 1);
      } else if (wei1 == 0) {
        printf("1\n");
        if (str[0][1] == '0') printf("%d %d\n", 1, 2);
        if (str[1][0] == '0') printf("%d %d\n", 2, 1);
      }
    }
    if (tou1 == 0) {
      printf("%d\n", 2 - wei1);
      if (str[n - 2][n - 1] == '0') printf("%d %d\n", n - 1, n);
      if (str[n - 1][n - 2] == '0') printf("%d %d\n", n, n - 1);
    }
  }
  return 0;
}
