#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y, per;
  scanf("%d %d %d", &n, &x, &y);
  float i = (float)y / 100.0;
  i = i * n;
  per = ceil(i);
  if (per < x)
    printf("0\n");
  else
    printf("%d\n", per - x);
  return 0;
}
