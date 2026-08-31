#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y, s;
  scanf("%d%d%d", &n, &x, &y);
  s = (y * n) / 100;
  if ((y * n) % 100 != 0) s++;
  if (s >= x)
    printf("%d\n", s - x);
  else
    printf("0\n");
}
