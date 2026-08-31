#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e5 + 10;
int a[MAXN];
int main() {
  int n, d;
  scanf("%d%d", &n, &d);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
  long long mi = 0, mx = 0;
  int ans = 0;
  for (int i = 1; i <= n; i++) {
    if (a[i] == 0) {
      if (mx < 0) {
        ans++;
        mx = d;
        mi = 0;
      } else {
        if (mi < 0) mi = 0;
      }
    } else {
      mi += a[i];
      if (mi > d) {
        puts("-1");
        return 0;
      }
      mx += a[i];
      if (mx > d) {
        mx = d;
      }
    }
  }
  printf("%d", ans);
  return 0;
}
