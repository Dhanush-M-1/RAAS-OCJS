#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    long long n;
    long long l, r;
    long long i;
    cin >> n >> l >> r;
    long long temp = l;
    long long b = 1;
    while (temp > 2 * (n - b) && b < n) {
      temp = temp - 2 * (n - b);
      b++;
    }
    for (i = l; i <= r && i < n * (n - 1) + 1; i++) {
      if (temp % 2 == 1) {
        printf("%I64d ", b);
        temp++;
      } else {
        printf("%I64d ", temp / 2 + b);
        if (temp / 2 + b == n) {
          temp = 1;
          b++;
        } else
          temp++;
      }
    }
    if (r == n * (n - 1) + 1)
      printf("1\n");
    else
      printf("\n");
  }
  return 0;
}
