#include <bits/stdc++.h>
char s[300005];
char t[300005];
long po[300005];
int main() {
  long n, x = 1;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf(" %c", &s[i]);
  }
  t[0] = s[0];
  int p = 0;
  int k = 1;
  char ch = t[0];
  po[0] = 0;
  for (int j = 1; j < n; j++) {
    if (s[j] != ch) {
      t[k++] = s[j];
      ch = s[j];
      p = j;
      po[x++] = j;
      continue;
    }
  }
  int a, b, flag = 0;
  for (int i = 0; i < strlen(t); i++) {
    for (int j = i + 1; j < strlen(t); j++) {
      if (t[j] < t[i]) {
        flag = 1;
        a = po[i] + 1;
        b = po[j] + 1;
        break;
      }
    }
    if (flag == 1) break;
  }
  if (flag == 0) printf("NO\n");
  if (flag == 1) printf("YES\n%ld %ld\n", a, b);
  return 0;
}
