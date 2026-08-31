#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  scanf("%d %d %d", &n, &x, &y);
  int t = n * y;
  if (t % 100 == 0)
    t = (t / 100);
  else
    t = (t / 100) + 1;
  printf("%d\n", max(0, t - x));
  return 0;
}
