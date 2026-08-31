#include <bits/stdc++.h>
int main() {
  int n;
  int w, i;
  int a = 0;
  scanf("%d", &n);
  for (i = 0; i < n; i++) {
    scanf("%d", &w);
    if (w == 100) {
      a++;
    }
  }
  if (a % 2 == 1 || (n % 2 == 1 && a == 0)) {
    printf("NO\n");
  } else {
    printf("YES\n");
  }
  return 0;
}
