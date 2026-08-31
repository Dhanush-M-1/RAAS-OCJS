#include <bits/stdc++.h>
int main(int argc, const char *agrv[]) {
  int n;
  long long last, sum, input;
  scanf("%d", &n);
  sum = 0;
  for (int i = 1; i <= n; i++) {
    scanf("%lld", &input);
    sum += input;
  }
  last = sum;
  sum = 0;
  for (int i = 1; i < n; i++) {
    scanf("%lld", &input);
    sum += input;
  }
  printf("%lld\n", last - sum);
  last = sum;
  sum = 0;
  for (int i = 1; i < n - 1; i++) {
    scanf("%lld", &input);
    sum += input;
  }
  printf("%lld\n", last - sum);
  return 0;
}
