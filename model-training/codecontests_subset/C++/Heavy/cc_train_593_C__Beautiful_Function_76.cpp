#include <bits/stdc++.h>
using namespace std;
int a[100], b[100], c[100], d[100];
int main() {
  int n, z;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d %d %d", &a[i], &b[i], &z);
  }
  for (int i = 0; i < n; i++) {
    printf("(");
  }
  printf("%d", a[0]);
  int x = a[0];
  for (int i = 1; i < n; i++) {
    int dx = (a[i] - x) / 2;
    c[i - 1] += dx;
    c[i] -= dx;
    d[i] = dx;
    x += dx * 2;
  }
  for (int i = 0; i < n; i++) {
    printf("+((0%c%d)%c(%d*abs((t-%d)))))", d[i] >= 0 ? '+' : '-', abs(d[i]),
           c[i] >= 0 ? '+' : '-', abs(c[i]), i);
    c[i] = 0;
  }
  printf("\n");
  for (int i = 0; i < n; i++) {
    printf("(");
  }
  printf("%d", b[0]);
  x = b[0];
  for (int i = 1; i < n; i++) {
    int dx = (b[i] - x) / 2;
    c[i - 1] += dx;
    c[i] -= dx;
    d[i] = dx;
    x += dx * 2;
  }
  for (int i = 0; i < n; i++) {
    printf("+((0%c%d)%c(%d*abs((t-%d)))))", d[i] >= 0 ? '+' : '-', abs(d[i]),
           c[i] >= 0 ? '+' : '-', abs(c[i]), i);
  }
  return 0;
}
