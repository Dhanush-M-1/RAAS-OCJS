#include <stdio.h>

int abs(int a) {
  return a > 0 ? a : -a;
}

int main(void) {
  int i, j, n, m;
  scanf("%d%d", &n, &m);
  int a[n], b[n], c[m], d[m];
  for(i = 0; i < n; ++i) scanf("%d%d", &a[i], &b[i]);
  for(i = 0; i < m; ++i) scanf("%d%d", &c[i], &d[i]);
  for(i = 0; i < n; ++i) {
    int min = 1e9, minn;
    for(j = 0; j < m; ++j) if(abs(a[i] - c[j])+ abs(b[i] - d[j]) < min) min = abs(a[i] - c[j])+ abs(b[i] - d[j]), minn = j + 1;
    printf("%d\n", minn);
  }
  return 0;
}