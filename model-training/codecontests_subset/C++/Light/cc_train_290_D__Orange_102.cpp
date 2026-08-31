#include <bits/stdc++.h>
const int maxn = 1010;
char a[maxn];
int x, n;
int main() {
  scanf("%s", a);
  scanf("%d", &x);
  n = strlen(a);
  for (int i = 0; i < n; i++) {
    if (a[i] > 96 && a[i] < 97 + x)
      a[i] -= 32;
    else {
      if (a[i] < 96 && a[i] >= 65 + x) a[i] += 32;
    }
  }
  printf("%s\n", a);
  return 0;
}
