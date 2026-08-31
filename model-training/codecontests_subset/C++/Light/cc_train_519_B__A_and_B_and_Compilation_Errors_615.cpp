#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  long long sum1 = 0, sum2 = 0, sum3 = 0;
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    int x;
    scanf("%d", &x);
    sum1 += x;
  }
  for (int i = 1; i <= n - 1; ++i) {
    int x;
    scanf("%d", &x);
    sum2 += x;
  }
  for (int i = 1; i <= n - 2; ++i) {
    int x;
    scanf("%d", &x);
    sum3 += x;
  }
  printf("%lld\n%lld", sum1 - sum2, sum2 - sum3);
  return 0;
}
