#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, n, a, suma = 0, sumb = 0, sumc = 0;
  scanf("%d", &n);
  for (i = 0; i < n; i++) {
    scanf("%d", &a);
    suma += a;
  }
  for (i = 0; i < n - 1; i++) {
    scanf("%d", &a);
    sumb += a;
  }
  for (i = 0; i < n - 2; i++) {
    scanf("%d", &a);
    sumc += a;
  }
  printf("%d\n", suma - sumb);
  printf("%d\n", sumb - sumc);
  return 0;
}
