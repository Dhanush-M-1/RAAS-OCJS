#include <bits/stdc++.h>
int n, s[1000005], i, a = 1000000, m = 1000000, l;
int main() {
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%d", &s[i]);
  }
  s[0] = 1;
  s[n + 1] = a;
  for (i = 0; i <= n; i++) {
    l = (s[i] - 1 > a - s[i + 1]) ? s[i] - 1 : a - s[i + 1];
    if (m > l) {
      m = l;
    }
  }
  printf("%d", m);
  return 0;
}
