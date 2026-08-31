#include <bits/stdc++.h>
int main() {
  char x[1001];
  int a;
  while (scanf("%s%d", x, &a) == 2) {
    int k = strlen(x);
    for (int i = 0; i < k; i++)
      if (x[i] < 'a') x[i] += ('a' - 'A');
    for (int i = 0; i < k; i++) {
      if (x[i] < a + 97) x[i] = x[i] += ('A' - 'a');
    }
    printf("%s\n", x);
  }
}
