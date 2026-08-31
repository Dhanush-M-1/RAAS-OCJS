#include <bits/stdc++.h>
using namespace std;
int A[6];
int main() {
  int i, j, k, N, T, x, sum, b;
  sum = 0;
  for (i = 0; i < 5; i++) {
    scanf("%d", &x);
    sum += x;
  }
  b = sum / 5;
  if (b <= 0 || sum % 5 != 0)
    printf("-1");
  else
    printf("%d", b);
  return 0;
}
