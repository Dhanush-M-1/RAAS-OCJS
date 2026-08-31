#include <bits/stdc++.h>
int main() {
  float a, b, c;
  scanf("%f %f %f", &a, &b, &c);
  printf("%d\n", (int)ceil((a * c - b * c) / b));
  return 0;
}
