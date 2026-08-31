#include <bits/stdc++.h>
using namespace std;
void tulis(int n, int m) {
  if (n < m) {
    printf("%d", n);
  } else {
    tulis(n / m, m);
    printf("%d", n % m);
  }
}
int main() {
  int k;
  scanf("%d", &k);
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) {
      if (j == k - 1) {
        tulis(i * j, k);
        printf("\n");
      } else {
        tulis(i * j, k);
        printf(" ");
      }
    }
  }
  return 0;
}
