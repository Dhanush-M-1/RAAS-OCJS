#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:128000000")
using namespace std;
int main() {
  int t, i, r1, j, v, n, l, m, to, len, p, r, k, x, y, z, fl;
  scanf("%i%i%i", &n, &x, &y);
  k = n * y / 100;
  if ((n * y) % 100) k++;
  k -= x;
  if (k < 0) k = 0;
  printf("%i\n", k);
  return 0;
}
