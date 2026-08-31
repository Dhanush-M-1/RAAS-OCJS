#include <bits/stdc++.h>
using namespace std;
int n, m, k;
int t[5005], l[5005], r[5005], d[5005];
int a[5005], b[5005];
bool flag = 1;
int main() {
  memset(a, 0x3f, sizeof(a));
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= m; i++) {
    scanf("%d%d%d%d", &t[i], &l[i], &r[i], &d[i]);
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) b[j] += d[i];
    }
    if (t[i] == 2) {
      for (int j = l[i]; j <= r[i]; j++) a[j] = min(a[j], d[i] - b[j]);
    }
  }
  for (int i = 1; i <= n; i++)
    if (a[i] == 0x3f3f3f3f) a[i] = 1000000000;
  for (int i = 1; i <= m; i++) {
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) a[j] += d[i];
    }
    if (t[i] == 2) {
      k = -0x3f3f3f3f;
      for (int j = l[i]; j <= r[i]; j++) k = max(k, a[j]);
      if (k != d[i]) flag = 0;
    }
  }
  if (flag) {
    memset(a, 0x3f, sizeof(a));
    memset(b, 0, sizeof(b));
    for (int i = 1; i <= m; i++) {
      if (t[i] == 1) {
        for (int j = l[i]; j <= r[i]; j++) b[j] += d[i];
      }
      if (t[i] == 2) {
        for (int j = l[i]; j <= r[i]; j++) a[j] = min(a[j], d[i] - b[j]);
      }
    }
    for (int i = 1; i <= n; i++)
      if (a[i] == 0x3f3f3f3f) a[i] = 1000000000;
    puts("YES");
    for (int i = 1; i <= n; i++) printf("%d ", a[i]);
  } else
    puts("NO");
}
