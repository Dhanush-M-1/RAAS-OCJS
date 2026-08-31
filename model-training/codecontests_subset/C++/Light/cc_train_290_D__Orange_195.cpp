#include <bits/stdc++.h>
using namespace std;
char a[55];
int main() {
  int n, i, nLen;
  gets(a);
  scanf("%d", &n);
  nLen = strlen(a);
  for (i = 0; i < nLen; i++) {
    if (a[i] >= 'A' && a[i] <= 'Z') {
      a[i] += 32;
    }
    if (a[i] < n + 97)
      printf("%c", a[i] - 32);
    else
      printf("%c", a[i]);
  }
  printf("\n");
  return 0;
}
