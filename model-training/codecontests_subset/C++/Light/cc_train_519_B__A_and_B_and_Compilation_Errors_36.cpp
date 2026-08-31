#include <bits/stdc++.h>
using namespace std;
int main() {
  int aa, b, c, x = 0, y = 0, z = 0;
  scanf("%d", &aa);
  for (int i = 0; i < aa; i++) {
    scanf("%d", &b);
    x = x + b;
  }
  for (int i = 0; i < aa - 1; i++) {
    scanf("%d", &b);
    y = y + b;
  }
  for (int i = 0; i < aa - 2; i++) {
    scanf("%d", &b);
    z = z + b;
  }
  printf("%d\n%d\n", (x - y), (y - z));
  return 0;
}
