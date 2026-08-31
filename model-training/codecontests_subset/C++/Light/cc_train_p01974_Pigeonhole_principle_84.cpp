#include <stdio.h>

int main(void) {
  int n, i, j, x = 0, y;
  scanf("%d", &n);
  int a[n];
  for(i = 0; i < n; ++i) scanf("%d", &a[i]);
  for(i = 0; i < n; ++i) {
    for(j = i + 1; j < n; ++j) if(!((a[i] - a[j]) % (n - 1))) {
      x = a[i], y = a[j];
      break;
    }
    if(x) break;
  }
  printf("%d %d\n", x, y);
  return 0;
}
