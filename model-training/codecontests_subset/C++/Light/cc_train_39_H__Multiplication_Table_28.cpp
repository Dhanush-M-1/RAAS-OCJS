#include <bits/stdc++.h>
int sto[111];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) {
      int ii = i * j;
      int cnt = 0;
      while (ii) {
        sto[cnt++] = ii % n;
        ii /= n;
      }
      for (int kk = cnt - 1; kk >= 0; kk--) printf("%d", sto[kk]);
      putchar(' ');
    }
    puts("");
  }
}
