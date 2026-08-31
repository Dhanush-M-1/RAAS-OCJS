#include <bits/stdc++.h>
int main() {
  int n, a, b, min, max = 0;
  scanf("%d", &n);
  int data[n], i;
  for (i = 0; i < n; i++) {
    scanf("%d", &data[i]);
    a = data[i] - 1;
    b = 1000000 - data[i];
    if (a < b)
      min = a;
    else
      min = b;
    if (min > max) max = min;
  }
  printf("%d", max);
  return 0;
}
