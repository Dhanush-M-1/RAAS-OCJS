#include <bits/stdc++.h>
using namespace std;
int n;
void transformar(int numero) {
  if (numero >= n) transformar(numero / n);
  printf("%d", numero % n);
}
int main() {
  scanf("%d", &n);
  printf("1");
  for (int i = 2; i < n; i++) printf(" %d", i);
  printf("\n");
  for (int i = 2; i < n; i++) {
    printf("%d", i);
    for (int j = 2; j < n; j++) {
      printf(" ");
      transformar(i * j);
    }
    if (i + 1 < n) printf("\n");
  }
  return 0;
}
