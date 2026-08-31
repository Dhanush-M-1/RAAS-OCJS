#include <bits/stdc++.h>
using namespace std;
int main() {
  char c;
  int a[1000];
  int n = 0;
  while ((c = getchar()) != EOF) {
    a[n++] = c - '0';
    getchar();
  }
  sort(a, a + n);
  for (int i = 0; i < n; i++) {
    printf("%d", a[i]);
    if (i != n - 1)
      printf("+");
    else
      printf("\n");
  }
  return 0;
}
