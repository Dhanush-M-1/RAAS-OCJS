#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, j, k, x, y;
  scanf("%d", &n);
  for (i = 1; i < n; i++) {
    for (j = 1; j < n; j++) {
      k = i * j % n;
      if (i * j / n) printf("%d", i * j / n);
      printf("%d ", k);
    }
    printf("\n");
  }
  return 0;
}
