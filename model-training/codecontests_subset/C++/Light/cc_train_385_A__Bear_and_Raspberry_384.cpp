#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, maxx = 0, k;
  scanf("%d %d", &n, &k);
  int a[n];
  for (i = 0; i < n; i++) {
    scanf("%d", &a[i]);
  }
  for (i = 0; i < n - 1; i++) {
    maxx = max(maxx, a[i] - a[i + 1]);
  }
  if (maxx - k < 0) {
    printf("0\n");
    return 0;
  }
  printf("%d\n", maxx - k);
  return 0;
}
