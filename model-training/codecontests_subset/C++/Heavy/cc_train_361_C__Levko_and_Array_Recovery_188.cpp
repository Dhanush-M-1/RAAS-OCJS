#include <bits/stdc++.h>
using namespace std;
int FASTBUFFER;
int n, m, i, ll, rr, vv, j, Max;
int a[5005], b[5005], t[5005], l[5005], r[5005], v[5005], d[5005];
int main() {
  scanf("%d %d", &n, &m);
  for (i = 1; i <= n; i++) a[i] = 1000000000;
  for (i = 1; i <= m; i++) {
    scanf("%d %d %d %d", &t[i], &l[i], &r[i], &v[i]);
    ll = l[i], rr = r[i], vv = v[i];
    if (t[i] == 1) {
      for (j = ll; j <= rr; j++) d[j] += vv;
    } else {
      for (j = ll; j <= rr; j++)
        if (vv - d[j] < a[j]) a[j] = vv - d[j];
    }
  }
  for (i = 1; i <= n; i++) b[i] = a[i];
  for (i = 1; i <= m; i++) {
    ll = l[i], rr = r[i], vv = v[i];
    if (t[i] == 1) {
      for (j = ll; j <= rr; j++) a[j] += vv;
    } else {
      Max = a[ll];
      for (j = ll; j <= rr; j++)
        if (a[j] > Max) Max = a[j];
      if (Max != vv) break;
    }
  }
  if (i <= m)
    printf("NO\n");
  else {
    printf("YES\n");
    for (i = 1; i <= n; i++) printf("%d ", b[i]);
    printf("\n");
  }
  return 0;
}
