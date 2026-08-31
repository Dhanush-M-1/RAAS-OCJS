#include <bits/stdc++.h>
using namespace std;
int main() {
  int a[105], i, j;
  char c;
  for (i = 0; i <= 105; i++) {
    scanf("%d", &a[i]);
    c = getchar();
    if (c == '\n') break;
  }
  sort(a, a + i + 1);
  for (j = 0; j < 1 + i; j++) {
    if (j == 0)
      printf("%d", a[j]);
    else
      printf("+%d", a[j]);
  }
  return 0;
}
