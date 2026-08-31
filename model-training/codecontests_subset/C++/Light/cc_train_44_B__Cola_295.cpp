#include <bits/stdc++.h>
using namespace std;
long i, j, k, l, n, m, ans;
long a, b, c;
int main() {
  scanf("%d %d %d %d", &n, &a, &b, &c);
  for (i = 0; i <= b; i++) {
    for (j = 0; j <= c; j++) {
      k = (n - i - j * 2) * 2;
      if (k <= a && k >= 0) ans++;
    }
  }
  printf("%d", ans);
  return 0;
}
