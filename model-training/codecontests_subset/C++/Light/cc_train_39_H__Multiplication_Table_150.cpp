#include <bits/stdc++.h>
int zhuan(int m, int k) {
  int ans[100], an = 0, sum, i;
  while (m) {
    ans[an++] = m % k;
    m = m / k;
  }
  sum = 0;
  for (i = an - 1; i >= 0; i--) sum = sum * 10 + ans[i];
  return sum;
}
int main() {
  int k;
  scanf("%d", &k);
  for (int i = 1; i <= k - 1; i++) {
    for (int j = 1; j <= k - 1; j++) {
      if (j != k - 1)
        printf("%d ", zhuan(i * j, k));
      else
        printf("%d\n", zhuan(i * j, k));
    }
  }
}
