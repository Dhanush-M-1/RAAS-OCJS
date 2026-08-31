#include <bits/stdc++.h>
using namespace std;
int n, x, y;
int main() {
  scanf("%d%d%d", &n, &x, &y);
  int req = (int)ceil((double)(n * y) / 100);
  if (req <= x)
    printf("%d\n", 0);
  else
    printf("%d\n", req - x);
  return 0;
}
