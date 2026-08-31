#include <bits/stdc++.h>
int main() {
  int n;
  int a;
  long long int sum1, sum2, sum3;
  sum1 = sum2 = sum3 = 0;
  std::cin >> n;
  for (int i = 0; i < n; i++) {
    std::cin >> a;
    sum1 += a;
  }
  for (int i = 0; i < n - 1; i++) {
    std::cin >> a;
    sum2 += a;
  }
  for (int i = 0; i < n - 2; i++) {
    std::cin >> a;
    sum3 += a;
  }
  std::cout << (sum1 - sum2) << std::endl << (sum2 - sum3);
  return 0;
}
