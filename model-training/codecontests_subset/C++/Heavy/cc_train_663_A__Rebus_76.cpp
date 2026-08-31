#include <bits/stdc++.h>
using namespace std;
char s[200][200];
int a, n, b;
int sum[200];
int main() {
  a = 0;
  b = 0;
  int i = 0, j;
  while (scanf("%s", s[i]) != EOF) {
    i++;
    if (s[i - 1][0] == '=') break;
  }
  scanf("%d", &n);
  a = 1;
  b = n;
  sum[0] = a;
  for (j = 1; j < i - 1; j += 2) {
    if (s[j][0] == '+')
      a += 1, b += n, sum[j + 1] = 1;
    else
      a -= n, b -= 1, sum[j + 1] = -n;
  }
  if (a <= n && n <= b) {
    printf("Possible\n");
    int temp = n - a;
    for (j = 0; j < i - 1; j++) {
      if (j % 2 == 0) {
        if (temp > n - 1)
          sum[j] += n - 1, temp -= n - 1;
        else
          sum[j] += temp, temp = 0;
        if (sum[j] < 0)
          printf("%d ", -sum[j]);
        else
          printf("%d ", sum[j]);
      } else
        printf("%s ", s[j]);
    }
    printf("= %d\n", n);
  } else {
    printf("Impossible\n");
  }
  return 0;
}
