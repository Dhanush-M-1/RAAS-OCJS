#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
int a[N], maxInc[N];
int n, d;
int main() {
  scanf("%d%d", &n, &d);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
  }
  maxInc[n + 1] = 0;
  for (int i = n; i >= 1; --i) maxInc[i] = max(0, a[i] + max(0, maxInc[i + 1]));
  long long cur = 0;
  int res = 0;
  for (int i = 1; i <= n; ++i)
    if (a[i] != 0) {
      cur += a[i];
      if (cur > d) {
        printf("-1");
        exit(0);
      }
    } else {
      if (cur < 0) {
        res++;
        cur = d - maxInc[i + 1];
        if (cur < 0) {
          printf("-1");
          exit(0);
        }
      }
    }
  printf("%d", res);
  return 0;
}
