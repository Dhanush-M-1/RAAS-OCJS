#include <bits/stdc++.h>
using namespace std;
inline int rd() {
  int x = 0;
  bool f = 0;
  char c = getchar();
  while (!isdigit(c)) {
    if (c == '-') f = 1;
    c = getchar();
  }
  while (isdigit(c)) {
    x = x * 10 + (c ^ 48);
    c = getchar();
  }
  return f ? -x : x;
}
int a[307][307];
inline void work() {
  int n = rd();
  char c = getchar();
  while (c != 'S') c = getchar();
  for (int i = 2; i <= n; ++i) a[1][i] = getchar() - '0';
  c = getchar();
  for (int i = 2; i <= n; ++i) {
    for (int j = 1; j <= n; ++j) a[i][j] = getchar() - '0';
    c = getchar();
  }
  int x1 = a[1][2];
  int x2 = a[2][1];
  int y1 = a[n][n - 1];
  int y2 = a[n - 1][n];
  if (x1 == x2) {
    int tot = (y1 == x1) + (y2 == x1);
    printf("%d\n", tot);
    if (y1 == x1) printf("%d %d\n", n, n - 1);
    if (y2 == x1) printf("%d %d\n", n - 1, n);
  } else if (y1 == y2) {
    int tot = (x1 == y1) + (x2 == y1);
    printf("%d\n", tot);
    if (x1 == y1) printf("%d %d\n", 1, 2);
    if (x2 == y1) printf("%d %d\n", 2, 1);
  } else {
    puts("2");
    if (x1 == 0) printf("%d %d\n", 1, 2);
    if (x2 == 0) printf("%d %d\n", 2, 1);
    if (y1 == 1) printf("%d %d\n", n, n - 1);
    if (y2 == 1) printf("%d %d\n", n - 1, n);
  }
}
int main() {
  int t = rd();
  while (t--) work();
  return 0;
}
