#include <bits/stdc++.h>
using namespace std;
int main() {
  int T, n, vet[51234];
  scanf("%d", &T);
  while (T--) {
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
      scanf("%d", &vet[i]);
    }
    if ((vet[0] + vet[1]) > vet[n - 1]) {
      puts("-1");
    } else {
      printf("%d %d %d\n", 1, 2, n);
    }
  }
  return 0;
}
