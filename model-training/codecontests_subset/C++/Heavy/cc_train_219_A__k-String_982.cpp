#include <bits/stdc++.h>
using namespace std;
int f[27];
int main() {
  int i, j, k, n, m, x, flag = 1, y[1001], o = 0, w;
  char c[1001];
  scanf("%d%*c", &k);
  gets(c);
  n = strlen(c);
  for (i = 0; i < n; i++) f[c[i] - 'a']++;
  int min = 2000;
  if (n % k != 0) {
    flag = 0;
  }
  for (i = 0; i < 26; i++) {
    if (f[i] && f[i] < min) {
      x = i;
      min = f[i];
    }
    if (f[i]) {
      o++;
      y[o] = i;
    }
  }
  if (min < k) {
    flag = 0;
  }
  for (i = 0; i < 26; i++)
    if (f[i]) {
      if (f[i] % k != 0) {
        flag = 0;
        break;
      }
    }
  if (!flag) {
    printf("-1\n");
  } else {
    for (i = 1; i <= k; i++) {
      for (j = 1; j <= o; j++)
        for (w = 1; w <= f[y[j]] / k; w++) printf("%c", y[j] + 'a');
    }
    puts("");
  }
  return 0;
}
