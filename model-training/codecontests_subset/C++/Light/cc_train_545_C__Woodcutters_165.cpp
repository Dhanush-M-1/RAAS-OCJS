#include <bits/stdc++.h>
using namespace std;
int x[100009], h[100009];
int n, sum;
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d%d", &x[i], &h[i]);
  }
  sum = 1;
  for (int i = 2; i <= n - 1; i++) {
    if (x[i] - x[i - 1] > h[i])
      sum++;
    else if (x[i + 1] - x[i] > h[i]) {
      sum++;
      x[i] = x[i] + h[i];
    }
  }
  if (n >= 2)
    printf("%d", sum + 1);
  else
    printf("1");
  return 0;
}
