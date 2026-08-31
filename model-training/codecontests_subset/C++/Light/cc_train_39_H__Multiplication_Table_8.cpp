#include <bits/stdc++.h>
using namespace std;
int i, j, k, l, m, n, h, t, arr[100000];
int fun(int a) {
  int i = 0, j = 0, d = 0;
  while (a > 0) {
    arr[i] = a % n;
    a /= n;
    i++;
  }
  for (j = i - 1; j >= 0; j--) d = d * 10 + arr[j];
  return d;
}
int main() {
  scanf("%d", &n);
  for (i = 1; i < n; i++) {
    for (j = 1; j < n; j++) printf("%d ", fun(i * j));
    printf("\n");
  }
}
