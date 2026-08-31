#include <bits/stdc++.h>
using namespace std;
const double PI = acos(-1.0);
int main() {
  int n, x, y;
  scanf(" %d %d %d", &n, &x, &y);
  int minimum_necessary = (n * y) / 100;
  if ((n * y) % 100) minimum_necessary++;
  int ans = minimum_necessary - x;
  printf("%d\n", ans < 0 ? 0 : ans);
  return 0;
}
