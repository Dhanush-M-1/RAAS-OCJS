#include <bits/stdc++.h>
int num[5001];
int resp[5001];
int operacion[5001][4];
int n, m;
int main() {
  int i, j, exito = 1;
  int l, r, t;
  scanf("%d%d", &n, &m);
  for (i = 1; i <= n; i++) num[i] = 50000000;
  for (i = 0; i < m; i++) {
    for (j = 0; j < 4; j++) scanf("%d", &operacion[i][j]);
  }
  for (i = m - 1; i >= 0; i--) {
    if (operacion[i][0] == 2) {
      l = operacion[i][1];
      r = operacion[i][2];
      t = operacion[i][3];
      for (j = l; j <= r; j++)
        if (num[j] > t) num[j] = t;
    } else if (operacion[i][0] == 1) {
      l = operacion[i][1];
      r = operacion[i][2];
      t = operacion[i][3];
      for (j = l; j <= r; j++) num[j] -= t;
    }
  }
  for (i = 1; i <= n; i++) resp[i] = num[i];
  for (i = 0; i < m; i++) {
    if (operacion[i][0] == 2) {
      l = operacion[i][1];
      r = operacion[i][2];
      t = num[l];
      for (j = l + 1; j <= r; j++)
        if (num[j] > t) t = num[j];
      if (t != operacion[i][3]) exito = 0;
      ;
    } else if (operacion[i][0] == 1) {
      l = operacion[i][1];
      r = operacion[i][2];
      t = operacion[i][3];
      for (j = l; j <= r; j++) num[j] += t;
    }
  }
  if (exito) {
    puts("YES");
    for (j = 1; j <= n; j++) {
      if (j > 1) putchar(' ');
      printf("%d", resp[j]);
    }
  } else {
    puts("NO");
  }
  return 0;
}
