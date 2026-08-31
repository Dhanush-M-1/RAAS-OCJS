#include <bits/stdc++.h>
using namespace std;
int vet[3], n, a, b, c, cont;
void analisa(int valor) {
  int help = 0;
  while (valor - 2 >= 0) {
    valor = valor - 2;
    help++;
    if (vet[0] <= a && valor <= b && help <= c) cont++;
  }
}
int main() {
  scanf("%d %d %d %d", &n, &a, &b, &c);
  vet[0] = n * 2;
  cont = vet[1] = vet[2] = 0;
  if (vet[0] <= a) cont++;
  while (vet[0] != 0) {
    vet[0] = vet[0] - 2;
    vet[1]++;
    if (vet[0] <= a && vet[1] <= b && vet[2] <= c) cont++;
    if (vet[1] >= 2) analisa(vet[1]);
  }
  printf("%d", cont);
  return 0;
}
