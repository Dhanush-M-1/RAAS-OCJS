#include <bits/stdc++.h>
using namespace std;
long long a[100999];
int bitA[100];
int main() {
  int i, c, d, r, maskB;
  maskB = 0;
  for (i = 29; i >= 0; i--) {
    printf("? %d %d\n", 0, maskB);
    fflush(stdout);
    scanf("%d", &r);
    if (r == 0) break;
    int r2;
    do {
      c = 1 << i;
      d = (1 << i) | maskB;
      printf("? %d %d\n", c, d);
      fflush(stdout);
      scanf("%d", &r2);
      i--;
    } while (r2 == r);
    i++;
    maskB = maskB | (1 << i);
    if (r == 1)
      bitA[i] = 1;
    else
      bitA[i] = -1;
  }
  for (i = 29; i >= 0; i--) {
    if (bitA[i]) continue;
    printf("? %d %d\n", 1 << i, maskB);
    fflush(stdout);
    scanf("%d", &r);
    if (r < 0)
      bitA[i] = 1;
    else
      bitA[i] = -1;
  }
  int a, b;
  a = b = 0;
  for (i = 29; i >= 0; i--) {
    if (bitA[i] == 1) a = a | (1 << i);
  }
  b = a ^ maskB;
  printf("! %d %d\n", a, b);
  fflush(stdout);
}
