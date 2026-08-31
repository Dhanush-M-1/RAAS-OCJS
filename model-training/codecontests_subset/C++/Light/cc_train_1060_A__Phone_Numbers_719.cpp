#include <bits/stdc++.h>
int main() {
  int len;
  scanf("%d ", &len);
  char cln[len];
  gets(cln);
  int d = 0;
  for (int l = 0; l < len; l++) {
    if (cln[l] == '8') {
      d++;
    }
  }
  int ll = 0;
  if (d == 0)
    ll = 0;
  else if (d <= len / 11) {
    ll = d;
  } else if (d > len / 11) {
    ll = len / 11;
  }
  printf("%d\n", ll);
  return 0;
}
