#include <bits/stdc++.h>
int main() {
  long long int n;
  int pos = 0, k = 0;
  scanf("%lld", &n);
  char s[n];
  int x, y;
  scanf("%s", s);
  if (n == 1 || n == 0) {
    pos = -1;
  }
  for (int i = 0; i < n - 1; i++) {
    x = s[i];
    y = s[i + 1];
    if (x > y) {
      pos = i;
      break;
    } else
      pos = -1;
  }
  if (pos >= 0) {
    printf("YES\n%d %d", pos + 1, pos + 2);
  } else {
    printf("NO");
  }
}
