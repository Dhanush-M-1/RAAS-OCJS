#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, m, i, j, k, l, t, x, y;
  x = 1;
  y = 1e6;
  scanf("%lld", &n);
  long long int sum = 0;
  for (i = 0; i < n; i++) {
    scanf("%lld", &m);
    j = m - x;
    k = y - m;
    sum = max(sum, min(j, k));
  }
  printf("%lld\n", sum);
}
