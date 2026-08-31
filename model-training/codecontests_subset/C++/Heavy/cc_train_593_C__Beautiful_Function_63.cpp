#include <bits/stdc++.h>
using namespace std;
int x[60], y[60];
void outx(int i) {
  printf("(%d*((1-abs((t-%d)))+abs((1-abs((t-%d))))))", x[i], i, i);
}
void outy(int i) {
  printf("(%d*((1-abs((t-%d)))+abs((1-abs((t-%d))))))", y[i], i, i);
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int a, b, c;
    scanf("%d%d%d", &a, &b, &c);
    x[i] = a / 2;
    y[i] = b / 2;
  }
  for (int i = 1; i <= n - 1; i++) printf("(");
  outx(1);
  for (int i = 2; i <= n; i++) {
    printf("+");
    outx(i);
    printf(")");
  }
  printf("\n");
  for (int i = 1; i <= n - 1; i++) printf("(");
  outy(1);
  for (int i = 2; i <= n; i++) {
    printf("+");
    outy(i);
    printf(")");
  }
  printf("\n");
  return 0;
}
