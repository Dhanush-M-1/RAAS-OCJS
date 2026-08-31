#include <bits/stdc++.h>
int main() {
  int n, i, j, temp;
  scanf("%d", &n);
  char s[n];
  scanf("%s", &s);
  for (i = 0; i < n; i++) {
    if (s[i] > s[i + 1] && i + 1 < n) {
      printf("YES\n");
      printf("%d %d", i + 1, i + 2);
      return 0;
    }
  }
  printf("NO");
  return 0;
}
