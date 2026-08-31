#include <bits/stdc++.h>
int w[505];
int book[505];
int v[1005];
int used[505];
int main(void) {
  int n, m;
  int k;
  int r = 0;
  scanf(" %d %d", &n, &m);
  for (int i = 1; i <= n; i++) {
    used[i] = 0;
    scanf(" %d", &w[i]);
  }
  for (int i = 1; i <= m; i++) {
    scanf(" %d", &v[i]);
  }
  k = 1;
  for (int i = 1; i <= m; i++) {
    if (!used[v[i]]) {
      used[v[i]] = 1;
      book[k++] = v[i];
    }
  }
  for (int i = 1; i <= m; i++) {
    for (int j = 1; j < k; j++) {
      if (book[j] == v[i]) {
        for (int p = j - 1; p >= 1; p--) {
          r += w[book[p]];
          book[p + 1] = book[p];
        }
        book[1] = v[i];
        break;
      }
    }
  }
  printf("%d\n", r);
  return 0;
}
