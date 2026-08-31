#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  while (scanf("%d", &n) != EOF) {
    int vet[n];
    int cem = 0, duzentos = 0;
    for (int i = 0; i < n; i++) {
      scanf("%d", &vet[i]);
      if (vet[i] == 100)
        cem++;
      else
        duzentos++;
    }
    if (cem == 0 && duzentos == 0)
      printf("YES\n");
    else if (cem == 0 && duzentos % 2 == 0)
      printf("YES\n");
    else if (cem == 0 && duzentos % 2 == 1)
      printf("NO\n");
    else if (duzentos == 0 && cem % 2 == 0)
      printf("YES\n");
    else if (duzentos == 0 && cem % 2 == 1)
      printf("NO\n");
    else if (duzentos % 2 == 0 && cem % 2 == 0)
      printf("YES\n");
    else if (duzentos % 2 == 0 && cem % 2 == 1)
      printf("NO\n");
    else if (duzentos % 2 == 1 && cem % 2 == 0)
      printf("YES\n");
    else if (duzentos % 2 == 1 && cem % 2 == 1)
      printf("NO\n");
  }
  return 0;
}
