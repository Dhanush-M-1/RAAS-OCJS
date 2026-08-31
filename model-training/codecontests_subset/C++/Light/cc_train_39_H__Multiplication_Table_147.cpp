#include <bits/stdc++.h>
int main() {
  int k;
  scanf("%d", &k);
  int q = 0;
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) {
      if ((q % 10) + i >= k)
        q += 10 + i - k;
      else
        q += i;
      printf("%d ", q);
    }
    printf("\n");
    q = 0;
  }
  return 0;
}
