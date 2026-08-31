#include <bits/stdc++.h>
using namespace std;
int main() {
  unsigned long long n, i, j, x = 0, y = 0, k;
  i = 2;
  cin >> n;
  j = sqrt(n);
  k = n;
  for (i = 2; i <= j; i++) {
    if (n % i == 0) {
      x = i;
      n = n / i;
      break;
    }
  }
  if (x == 0) {
    printf("1\n0");
  } else {
    j = sqrt(n);
    for (i = x; i <= j; i++) {
      if (n % i == 0) {
        y = i;
        break;
      }
    }
    if (y == 0) {
      printf("2");
    } else {
      printf("1\n");
      cout << x * y;
    }
  }
  return 0;
}
