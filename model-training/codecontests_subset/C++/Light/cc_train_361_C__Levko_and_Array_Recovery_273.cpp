#include <bits/stdc++.h>
using namespace std;
int A[5010], B[5010], l[5010], r[5010], t[5010], x[5010];
int main() {
  int i, j, k, tt, ll, rr, xx, n, m, flag = true;
  scanf("%d%d", &n, &m);
  for (i = 0; i <= n; i++) A[i] = 1000000000;
  memset(B, 0, sizeof(B));
  for (i = 0; i < m; i++) {
    scanf("%d%d%d%d", &tt, &ll, &rr, &xx);
    l[i] = ll;
    r[i] = rr;
    x[i] = xx;
    t[i] = tt;
    if (tt == 1) {
      for (j = ll; j <= rr; j++) B[j] += xx;
    } else {
      for (j = ll; j <= rr; j++) A[j] = min(A[j], xx - B[j]);
    }
  }
  memcpy(B, A, sizeof(A));
  for (i = 0; i < m; i++) {
    if (t[i] == 1) {
      for (j = l[i]; j <= r[i]; j++) B[j] += x[i];
    } else {
      int mx = -1000000000;
      for (j = l[i]; j <= r[i]; j++) mx = max(mx, B[j]);
      if (mx != x[i]) flag = false;
    }
  }
  if (flag) {
    printf("YES\n");
    for (i = 1; i <= n; i++) printf("%d ", A[i]);
    printf("\n");
  } else
    printf("NO\n");
  return 0;
}
