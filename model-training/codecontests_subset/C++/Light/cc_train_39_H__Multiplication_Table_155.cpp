#include <bits/stdc++.h>
using namespace std;
long long da[15], a[15][15], n;
int main() {
  scanf("%lld", &n);
  for (int i = 1; i < n; i++)
    for (int j = 1; j < n; j++) {
      a[i][j] = i * j;
      memset(da, 0, sizeof da);
      long long now = a[i][j], ans = 0, num = 0;
      while (now >= 1) {
        da[++num] = now % n;
        now = now / n;
      }
      for (int j = i; j >= 1; j--) ans = ans * 10 + da[j];
      a[i][j] = ans;
    }
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) printf("%lld ", a[i][j]);
    printf("\n");
  }
  return 0;
}
