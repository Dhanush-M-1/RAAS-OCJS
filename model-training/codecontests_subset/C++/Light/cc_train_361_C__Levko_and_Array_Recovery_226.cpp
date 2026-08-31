#include <bits/stdc++.h>
using namespace std;
int t[5100], l[5100], r[5100], d[5100], a[5100], s[5100], n, m;
void init() {
  scanf("%d%d", &n, &m);
  for (int i = (1); i <= (n); ++i) a[i] = 1e9;
  for (int i = (1); i <= (m); ++i) {
    scanf("%d%d%d%d", &t[i], &l[i], &r[i], &d[i]);
    if (t[i] == 1)
      for (int j = (l[i]); j <= (r[i]); ++j) s[j] += d[i];
    else {
      for (int j = (l[i]); j <= (r[i]); ++j) a[j] = min(a[j], d[i] - s[j]);
    }
  }
  for (int i = (1); i <= (n); ++i) s[i] = a[i];
}
void work() {
  for (int i = (1); i <= (m); ++i)
    if (t[i] == 1)
      for (int j = (l[i]); j <= (r[i]); ++j) a[j] += d[i];
    else {
      int k = -1e9;
      for (int j = (l[i]); j <= (r[i]); ++j) k = max(k, a[j]);
      if (k != d[i]) {
        puts("NO");
        return;
      }
    }
  puts("YES");
  for (int i = (1); i <= (n - 1); ++i) printf("%d ", s[i]);
  printf("%d", s[n]);
}
int main() {
  init();
  work();
  return 0;
}
