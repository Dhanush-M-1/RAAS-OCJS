#include <bits/stdc++.h>
int main() {
  int a[4] = {0}, i, j;
  char s[110];
  scanf("%s", s);
  int n = strlen(s);
  for (i = 0; i < n; i += 2) {
    if (s[i] == '1') a[1]++;
    if (s[i] == '2') a[2]++;
    if (s[i] == '3') a[3]++;
  }
  int temp = 1;
  i = 0;
  while (temp <= 3) {
    while (a[temp]--) {
      s[i] = temp + 48;
      i += 2;
    }
    temp++;
  }
  printf("%s", s);
  return 0;
}
