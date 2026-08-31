#include <bits/stdc++.h>
using namespace std;
int n, x, y;
int main() {
  scanf("%d%d%d", &n, &x, &y);
  double px = x * 1.0 / n;
  double py = y * 1.0 / 100;
  int add = 0;
  while (px < py) {
    add++;
    px = (x + add) * 1.0 / n;
  }
  printf("%d\n", add);
  return 0;
}
