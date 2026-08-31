#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e5 + 7;
int main() {
  int n, d;
  scanf("%d%d", &n, &d);
  int a, MAX = 0, MIN = 0, ans = 0;
  bool flag = false;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a);
    if (flag) continue;
    if (a == 0) {
      if (MIN < 0) MIN = 0;
      if (MAX < 0) {
        MAX = d;
        ans++;
      }
    } else {
      MIN += a;
      MAX += a;
      if (MIN > d) {
        printf("-1\n");
        flag = true;
      }
      if (MAX > d) {
        MAX = d;
      }
    }
  }
  if (!flag) printf("%d\n", ans);
}
