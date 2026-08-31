#include <bits/stdc++.h>
int b;
void turn(int a) {
  int p[100];
  int m = 0;
  while (a != 0) {
    p[m++] = a % b;
    a = a / b;
  }
  int i;
  for (i = m - 1; i >= 0; i--) printf("%d", p[i]);
  printf(" ");
}
int main() {
  int i, j;
  scanf("%d", &b);
  for (i = 1; i < b; i++) {
    for (j = 1; j < b; j++) {
      turn(i * j);
    }
    printf("\n");
  }
  return 0;
}
