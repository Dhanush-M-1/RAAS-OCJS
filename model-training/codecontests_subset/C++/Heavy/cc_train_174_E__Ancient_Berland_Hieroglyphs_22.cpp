#include <bits/stdc++.h>
int hash[2000001], link[2000001];
int a[2000001], b[2000001];
int n, m, ans = 0;
int main() {
  int i, j, k;
  int tk = 0, bb;
  scanf("%d%d", &n, &m);
  for (i = 1; i <= n; ++i) scanf("%d", a + i);
  for (i = 1; i <= m; ++i) {
    scanf("%d", b + i);
    hash[b[i]] = i;
  }
  for (i = 1; i <= n; ++i)
    if (hash[a[i]]) link[i] = hash[a[i]];
  for (i = 1; i <= n; ++i) {
    hash[a[i]] = 0;
    a[i + n] = a[i];
    link[i + n] = link[i];
  }
  bb = 1000000000;
  for (j = i = 1; i <= 2 * n; ++i) {
    if (i == 4) i = 4;
    hash[a[i]]++;
    if (link[i] == 0) {
      while (j <= i) hash[a[j]] = 0, ++j;
      continue;
    }
    for (j; j < i && hash[a[i]] > 1; ++j) {
      hash[a[j]]--;
    }
    if (i == j)
      tk = 0, bb = 1000000000;
    else {
      if (link[i] > link[i - 1]) {
        ;
      } else if (tk == 0) {
        tk = 1;
        bb = i;
      } else {
        while (j < bb) {
          hash[a[j]]--;
          ++j;
        }
        bb = i;
      }
    }
    while (tk && link[i] > link[j] && j < i) {
      hash[a[j]]--;
      ++j;
      if (j >= bb) tk = 0, bb = 1000000000;
    }
    ans = (ans > i - j + 1 ? ans : i - j + 1);
  }
  printf("%d\n", ans);
  return 0;
}
