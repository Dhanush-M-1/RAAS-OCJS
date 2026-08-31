#include <bits/stdc++.h>
int main() {
  int n, eight = 0, m, i;
  char a[100];
  scanf("%d", &n);
  scanf("%s", &a);
  m = n / 11;
  for (i = 0; i < n; i++) {
    if (a[i] == '8') {
      eight++;
    }
  }
  if (eight <= m) {
    printf("%d", eight);
  } else {
    printf("%d", m);
  }
  return 0;
}
