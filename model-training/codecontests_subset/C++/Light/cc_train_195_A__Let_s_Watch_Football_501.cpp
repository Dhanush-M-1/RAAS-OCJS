#include <bits/stdc++.h>
int main() {
  int a, b, c;
  int n;
  scanf("%d %d %d", &a, &b, &c);
  n = a * c - b * c;
  if (n <= 0) {
    printf("0");
  } else {
    if (n % b == 0) {
      n /= b;
    } else {
      n /= b;
      n++;
    }
    printf("%d", n);
  }
}
