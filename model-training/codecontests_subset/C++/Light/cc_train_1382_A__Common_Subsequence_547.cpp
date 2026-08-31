#include <bits/stdc++.h>
const double PI = acos(-1);
using namespace std;
int t;
int a[1005], b[1005];
bool c[1005];
int main() {
  scanf("%d", &t);
  while (t--) {
    int n, m;
    scanf("%d%d", &n, &m);
    memset(c, 0, sizeof(c));
    for (int i = 1; i <= n; i++) scanf("%d", &a[i]), c[a[i]] = 1;
    int ans = -1;
    for (int j = 1; j <= m; j++) {
      scanf("%d", &b[j]);
      if (c[b[j]]) {
        ans = b[j];
      }
    }
    if (ans != -1) {
      puts("YES");
      printf("1 %d\n", ans);
    } else {
      puts("NO");
    }
  }
}
