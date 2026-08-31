#include <bits/stdc++.h>
using namespace std;
int visit[5005], ans[5005];
int a[5005], b[5005];
int dap[5005][5005];
int main() {
  int l, r, a;
  int t;
  scanf("%d", &t);
  while (t--) {
    scanf("%d%d%d", &l, &r, &a);
    int tx = l / a, ty = r / a;
    for (int i = 1;; i++) {
      if (i * a < l || i * a > r) {
        printf("%d\n", i * a);
        break;
      }
      if (i >= tx) i = ty;
    }
  }
  return 0;
}
