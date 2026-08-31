#include <bits/stdc++.h>
using namespace std;
static int Q, L, R, X;
int main() {
  scanf("%d", &Q);
  while (Q--) {
    scanf("%d%d%d", &L, &R, &X);
    if (X < L)
      printf("%d\n", X);
    else
      printf("%d\n", (R / X + 1) * X);
  }
  return 0;
}
