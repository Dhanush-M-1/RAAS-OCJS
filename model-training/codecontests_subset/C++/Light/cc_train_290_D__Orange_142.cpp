#include <bits/stdc++.h>
char ans[100];
int n;
int main() {
  scanf("%s%d", ans, &n);
  for (int i = 0; i < strlen(ans); i++) {
    if (ans[i] < 'a') ans[i] += 'a' - 'A';
    if (ans[i] < 97 + n) ans[i] += 'A' - 'a';
  }
  printf("%s\n", ans);
  return 0;
}
