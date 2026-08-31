#include <bits/stdc++.h>
int main() {
  int n, k;
  int mi = -1;
  int t;
  scanf("%d%d", &n, &k);
  for (int i = 0; i < n; i++) {
    scanf("%d", &t);
    if (k % t == 0) {
      if (mi == -1)
        mi = k / t;
      else if (k / t < mi)
        mi = k / t;
    }
  }
  printf("%d\n", mi);
  return 0;
}
