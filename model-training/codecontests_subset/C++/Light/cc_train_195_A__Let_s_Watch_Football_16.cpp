#include <bits/stdc++.h>
int main() {
  int a, b, c;
  int sum = 0, count = 0;
  int ned;
  scanf("%d%d%d", &a, &b, &c);
  ned = a * c - b * c;
  while (sum < ned) {
    sum = sum + b;
    count++;
  }
  printf("%d", count);
}
