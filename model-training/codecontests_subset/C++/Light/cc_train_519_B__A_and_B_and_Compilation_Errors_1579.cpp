#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, x, sum = 0, sum1 = 0, sum2 = 0;
  scanf("%d", &n);
  for (i = 0; i < n; i++) {
    scanf("%d", &x);
    sum += x;
  }
  for (i = 0; i < n - 1; i++) {
    scanf("%d", &x);
    sum1 += x;
  }
  for (i = 0; i < n - 2; i++) {
    scanf("%d", &x);
    sum2 += x;
  }
  printf("%d\n%d\n", sum - sum1, sum1 - sum2);
  return 0;
}
