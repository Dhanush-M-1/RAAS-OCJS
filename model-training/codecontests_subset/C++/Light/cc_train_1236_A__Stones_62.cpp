#include <bits/stdc++.h>
using namespace std;
int main(void) {
  int t;
  scanf("%d", &t);
  while (t--) {
    int f, s, d, ans = 0;
    scanf("%d%d%d", &f, &s, &d);
    for (int e = 0; e <= f; e++) {
      for (int p = 0; p <= s - (e * 2); p++) {
        if (p * 2 <= d) {
          ans = max(ans, e * 3 + p * 3);
        }
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
