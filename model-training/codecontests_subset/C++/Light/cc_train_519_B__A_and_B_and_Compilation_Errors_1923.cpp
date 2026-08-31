#include <bits/stdc++.h>
using namespace std;
int main() {
  const int maxn = 1e5 + 10;
  int n;
  scanf("%d", &n);
  int x, sum1 = 0, sum2 = 0, sum3 = 0;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &x);
    sum1 += x;
  }
  for (int i = 1; i <= n - 1; i++) {
    scanf("%d", &x);
    sum2 += x;
  }
  for (int i = 1; i < n - 1; i++) {
    scanf("%d", &x);
    sum3 += x;
  }
  printf("%d\n%d\n", sum1 - sum2, sum2 - sum3);
  return 0;
}
