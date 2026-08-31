#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c;
  while (~scanf("%d%d%d%d", &n, &a, &b, &c)) {
    int ans = 0;
    for (int i = 0; i <= b; i++) {
      for (int j = 0; j <= c; j++) {
        int tmp = n - i - j * 2;
        if (tmp >= 0 && tmp <= 0.5 * a) ans++;
      }
    }
    printf("%d\n", ans);
  }
}
