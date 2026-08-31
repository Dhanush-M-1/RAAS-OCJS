#include <bits/stdc++.h>
#pragma comment(linker, "/stack:256000000")
using namespace std;
const int N = 5010;
int a[N], b[N], d[N], t[N], l[N], r[N], x[N];
int main() {
  int n, m;
  scanf("%d %d", &n, &m);
  for (int i = 0; i < n; i++) a[i] = 1000000000;
  for (int i = 0; i < m; i++) {
    scanf("%d %d %d %d", &t[i], &l[i], &r[i], &x[i]);
    --l[i], --r[i];
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) {
        d[j] += x[i];
      }
    } else {
      bool OK = 0;
      for (int j = l[i]; j <= r[i]; j++) {
        a[j] = min(a[j], x[i] - d[j]);
      }
    }
  }
  memcpy(b, a, sizeof(a));
  for (int i = 0; i < m; i++) {
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) {
        b[j] += x[i];
      }
    } else {
      if (*max_element(b + l[i], b + r[i] + 1) != x[i]) {
        puts("NO");
        return 0;
      }
    }
  }
  puts("YES");
  for (int i = 0; i < n; i++) printf("%d ", a[i]);
  return 0;
}
