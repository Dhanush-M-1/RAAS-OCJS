#include <bits/stdc++.h>
using namespace std;
int main() {
  const int MAX_N = 100000;
  int n, i, a[MAX_N + 1], b[MAX_N + 1], c[MAX_N + 1];
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
  }
  for (i = 1; i <= n - 1; i++) {
    scanf("%d", &b[i]);
  }
  for (i = 1; i <= n - 2; i++) {
    scanf("%d", &c[i]);
  }
  sort(a + 1, a + n + 1);
  sort(b + 1, b + n);
  b[n] = 0;
  for (i = 1; a[i] == b[i]; i++) {
    ;
  }
  printf("%d\n", a[i]);
  c[n - 1] = a[i];
  b[n] = a[i];
  sort(b + 1, b + n + 1);
  sort(c + 1, c + n);
  c[n] = 0;
  for (i = 1; b[i] == c[i]; i++) {
    ;
  }
  printf("%d\n", b[i]);
  c[n] = b[i];
  sort(c + 1, c + n + 1);
  return 0;
}
