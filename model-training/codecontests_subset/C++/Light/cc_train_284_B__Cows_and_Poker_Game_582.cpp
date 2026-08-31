#include <bits/stdc++.h>
int main() {
  int n, c = 0, f = 0, in = 0, al = 0, i;
  char a[200005];
  scanf("%d", &n);
  getchar();
  for (i = 0; i < n; i++) {
    scanf("%c", &a[i]);
    if (a[i] == 'A')
      al++;
    else if (a[i] == 'I')
      in++;
    else
      f++;
  }
  for (i = 0; i < n; i++) {
    if (a[i] == 'A') {
      if (in == 0) c++;
    } else if (a[i] == 'I') {
      if (in == 1) c++;
    }
  }
  printf("%d\n", c);
  return (0);
}
