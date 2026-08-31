#include <bits/stdc++.h>
using namespace std;
bool a[1005];
int main() {
  int t, n, m, k;
  scanf("%d", &t);
  while (t--) {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < 1001; i++) {
      a[i] = 0;
    }
    for (int i = 0; i < n; i++) {
      scanf("%d", &k);
      a[k] = 1;
    }
    bool f = 0;
    for (int i = 0; i < m; i++) {
      scanf("%d", &k);
      if (f) continue;
      if (a[k]) {
        f = 1;
        printf("YES\n1 %d\n", k);
      }
    }
    if (!f) printf("NO\n");
  }
  return 0;
}
