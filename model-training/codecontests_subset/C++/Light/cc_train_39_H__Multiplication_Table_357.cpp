#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  scanf("%d", &k);
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) {
      if (j != k - 1) {
        if (j != 1)
          printf("%2d ", i * j / k * 10 + (i * j) % k);
        else
          printf("%d ", i * j);
      } else {
        if (j != 1)
          printf("%2d", i * j / k * 10 + (i * j) % k);
        else
          printf("%d", i * j);
      }
    }
    printf("\n");
  }
  return 0;
}
