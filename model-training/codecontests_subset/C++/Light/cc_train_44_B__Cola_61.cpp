#include <bits/stdc++.h>
using namespace std;
int n, a, b, c;
int main() {
  scanf("%d %d %d %d", &n, &a, &b, &c);
  int ans = 0;
  for (int i = 0; i <= c; i++) {
    for (int j = 0; j <= b; j++) {
      int k = (n - 2 * i - j) * 2;
      if (k >= 0 && k <= a) ans++;
    }
  }
  printf("%d\n", ans);
  return 0;
}
