#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1000005;
int n, num[2], d[MAXN], cnt, ans[2][MAXN];
int main() {
  char ch;
  int sig = 1, x = 0;
  while (scanf("%c", &ch) != EOF) {
    if (ch >= '0' && ch <= '9') x = x * 10 + ch - '0';
    if (ch == '=' || ch == '+' || ch == '-') {
      num[sig]++;
      if (ch == '+') d[++cnt] = sig = 1;
      if (ch == '-') d[++cnt] = sig = 0;
    }
  }
  n = x;
  int tmp = n + num[0];
  if (n * num[1] < tmp) {
    printf("Impossible\n");
    return 0;
  }
  for (int i = 1; i <= num[0]; i++) ans[0][i] = 1;
  if (num[1] > tmp) {
    int j = 1;
    for (int i = 1; i <= num[1] - tmp; i++) {
      while (j <= num[0] && ans[0][j] == n) j++;
      if (j > num[0]) {
        printf("Impossible\n");
        return 0;
      }
      ans[0][j]++;
    }
    tmp = num[1];
  }
  for (int i = 1; i <= num[1]; i++) {
    ans[1][i] = min(n, tmp - (num[1] - i));
    tmp -= ans[1][i];
  }
  printf("Possible\n");
  printf("%d ", ans[1][1]);
  int j1 = 1, j0 = 0;
  for (int i = 1; i <= cnt; i++) {
    if (d[i] == 1)
      printf("+ %d ", ans[1][++j1]);
    else
      printf("- %d ", ans[0][++j0]);
  }
  printf("= %d\n", n);
}
