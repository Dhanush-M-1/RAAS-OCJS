#include <bits/stdc++.h>
using namespace std;
int eprintf(const char *format, ...) { return 0; }
int main() {
  int n, a, b, c;
  while (scanf("%d%d%d%d", &n, &a, &b, &c) >= 4) {
    long long ans = 0;
    for (int a1 = 0; a1 <= a; a1 += 2)
      for (int b1 = 0; b1 <= b; b1++) {
        int rem = n - (a1 >> 1) - b1;
        if (rem < 0) break;
        if (!(rem & 1) && (rem <= c * 2)) ans++;
      }
    printf("%I64d\n", ans);
    break;
  }
  return 0;
}
