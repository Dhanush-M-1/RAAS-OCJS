#include <bits/stdc++.h>
using namespace std;
int t[5555], l[5555], r[5555], d[5555], m[5555];
long long a[5555];
int n, M;
long long b[5555];
int main() {
  scanf("%d %d", &n, &M);
  for (int i = (0); i < (M); ++i) {
    scanf("%d", t + i);
    if (t[i] == 1) {
      scanf("%d %d %d", l + i, r + i, d + i);
    } else
      scanf("%d %d %d", l + i, r + i, m + i);
    l[i]--;
    r[i]--;
  }
  for (int i = (0); i < (n); ++i) {
    long long bnd = 1000000000, chg = 0;
    for (int j = 0; j < M; j++) {
      if (l[j] <= i && i <= r[j]) {
        if (t[j] == 1)
          chg += d[j];
        else {
          bnd = min(bnd, m[j] - chg);
        }
      }
    }
    a[i] = b[i] = bnd;
  }
  bool ok = true;
  for (int i = (0); i < (M); ++i) {
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) b[j] += d[i];
    }
    if (t[i] == 2) {
      long long res = -1000000000;
      for (int j = l[i]; j <= r[i]; j++) {
        res = max(res, b[j]);
      }
      if (res != m[i]) {
        ok = false;
        break;
      }
    }
  }
  if (ok) {
    printf("YES\n");
    for (int i = (0); i < (n); ++i) printf("%d ", (int)a[i]);
  } else
    printf("NO\n");
  return 0;
}
