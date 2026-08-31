#include <bits/stdc++.h>
char s[105];
int main() {
  int n, i, c = 0;
  scanf("%d%s", &n, s);
  for (i = 0; i < n; i++)
    if (s[i] == '8') c++;
  printf("%d", c < n / 11 ? c : n / 11);
  return 0;
}
