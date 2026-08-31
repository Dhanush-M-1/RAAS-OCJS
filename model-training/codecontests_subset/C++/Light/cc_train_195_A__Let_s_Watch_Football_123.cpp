#include <bits/stdc++.h>
int min(int a, int b) { return a < b ? a : b; }
int main() {
  int D, V, L;
  scanf("%d %d %d", &D, &V, &L);
  int ini = 0, fim = (D * L + 1) / V;
  while (ini <= fim) {
    int meio = (ini + fim) / 2;
    int S = V * meio + V * L;
    if (S >= D * L)
      fim = meio - 1;
    else
      ini = meio + 1;
  }
  printf("%d\n", fim + 1);
  return 0;
}
