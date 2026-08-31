#include <bits/stdc++.h>
#pragma warning(disable : 4996)
using namespace std;
int n, m;
int a[1000];
int b[3000];
int x[1000];
int xi;
int c[1000];
int main() {
  int i, j, k;
  scanf("%d%d", &n, &m);
  for (i = 0; i < n; i++) scanf("%d", &a[i]);
  for (i = 0; i < m; i++) scanf("%d", &b[i]), b[i]--;
  for (i = 0; i < m; i++) {
    if (c[b[i]]) continue;
    x[xi++] = b[i], c[b[i]] = 1;
  }
  for (i = 0; i < n; i++) {
    if (c[i] == 0) x[xi++] = i;
  }
  int cnt = 0;
  for (i = 0; i < m; i++) {
    for (j = 0; j < n; j++) {
      if (x[j] == b[i]) break;
      cnt += a[x[j]];
    }
    for (k = j; k > 0; k--) x[k] = x[k - 1];
    x[0] = b[i];
  }
  printf("%d", cnt);
  return 0;
}
