#include <bits/stdc++.h>
using namespace std;
int main() {
  int m, n, count = 0, x1, aux;
  scanf("%d %d", &n, &m);
  bool vet[101];
  memset(vet, false, sizeof vet);
  for (int i = 0; i < n; i++) {
    scanf("%d", &x1);
    while (x1--) {
      scanf("%d", &aux);
      if (!vet[aux]) {
        vet[aux] = true;
        count++;
      }
    }
  }
  printf((count == m ? "YES" : "NO"));
  return 0;
}
