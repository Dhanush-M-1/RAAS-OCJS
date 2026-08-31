#include <bits/stdc++.h>
const int N = 300000;
int n;
char s[N + 1];
int main() {
  scanf("%d%s", &n, s);
  int p = -1;
  for (int i = 0; i < n - 1; ++i)
    if (s[i] > s[i + 1]) p = i;
  if (p != -1) {
    printf("YES\n");
    printf("%d %d\n", p + 1, p + 2);
  } else
    printf("NO\n");
  return 0;
}
