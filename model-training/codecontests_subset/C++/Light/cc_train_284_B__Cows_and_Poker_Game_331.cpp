#include <bits/stdc++.h>
using namespace std;
char str[2 * 100000 + 5];
int main() {
  int n, i, j, k, Ans;
  while (scanf("%d", &n) != EOF) {
    scanf("%s", str);
    int A, F, I;
    A = F = I = 0;
    for (i = 0; i < n; i++) {
      if (str[i] == 'A') A++;
      if (str[i] == 'F') F++;
      if (str[i] == 'I') I++;
    }
    if (I > 1) {
      printf("0\n");
      continue;
    }
    if (I == 1) {
      printf("1\n");
      continue;
    }
    if (I == 0) {
      printf("%d\n", A);
      continue;
    }
  }
  return 0;
}
