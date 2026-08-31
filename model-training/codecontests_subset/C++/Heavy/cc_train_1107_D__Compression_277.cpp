#include <bits/stdc++.h>
using namespace std;
bool Matrix[5300][5300];
int convert(char digit) {
  if (digit >= '0' && digit <= '9')
    return digit - '0';
  else
    return digit - 'A' + 10;
}
int gcd(int a, int b) {
  if (b == 0)
    return a;
  else
    return gcd(b, a % b);
}
int main() {
  int k, n, q, i, j, x, mask, counter = 0, bit;
  scanf("%d%*c", &n);
  int number, GCD;
  char digit;
  GCD = n;
  for (i = 0; i < n; i++) {
    for (j = 0; j < n / 4; j++) {
      scanf("%c", &digit);
      number = convert(digit);
      for (k = 0, mask = 8; k < 4; k++) {
        bit = number & mask;
        Matrix[i][j * 4 + k] = (bit > 0);
        mask = mask >> 1;
      }
    }
    scanf("%*c");
  }
  for (i = 0; i < n; i++) {
    counter = 0;
    for (j = 0; j < n; j++) {
      if (j > 0 && Matrix[i][j] != Matrix[i][j - 1]) {
        GCD = gcd(GCD, counter);
        counter = 1;
      } else {
        counter++;
      }
    }
    GCD = gcd(GCD, counter);
  }
  for (i = 0; i < n; i++) {
    counter = 0;
    for (j = 0; j < n; j++) {
      if (j > 0 && Matrix[j][i] != Matrix[j - 1][i]) {
        GCD = gcd(GCD, counter);
        counter = 1;
      } else {
        counter++;
      }
    }
    GCD = gcd(GCD, counter);
  }
  printf("%d", GCD);
  return 0;
}
