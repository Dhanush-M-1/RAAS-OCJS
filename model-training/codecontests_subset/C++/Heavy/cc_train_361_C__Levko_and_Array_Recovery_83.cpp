#include <bits/stdc++.h>
using namespace std;
int a[5001], b[5001], c[5000][4];
bool check[5001];
int main() {
  int n, m;
  scanf("%d %d", &n, &m);
  for (int i = 0; i < m; i++)
    scanf("%d %d %d %d", &c[i][0], &c[i][1], &c[i][2], &c[i][3]);
  for (int i = 1; i <= n; i++) a[i] = -1e9;
  for (int i = m - 1; i >= 0; i--)
    if (c[i][0] == 1) {
      for (int j = c[i][1]; j <= c[i][2]; j++)
        if (check[j]) a[j] -= c[i][3];
    } else {
      for (int j = c[i][1]; j <= c[i][2]; j++)
        if (check[j] && a[j] < c[i][3])
          continue;
        else
          a[j] = c[i][3], check[j] = 1;
    }
  for (int i = 1; i <= n; i++) b[i] = a[i];
  bool cc = 0;
  for (int i = 0; i < m; i++)
    if (c[i][0] == 1)
      for (int j = c[i][1]; j <= c[i][2]; j++) a[j] += c[i][3];
    else {
      int m2 = -1e9;
      for (int j = c[i][1]; j <= c[i][2]; j++)
        if (check[j]) m2 = max(m2, a[j]);
      if (m2 != c[i][3]) {
        cc = 1;
        break;
      }
    }
  if (cc)
    printf("NO\n");
  else {
    printf("YES\n");
    for (int i = 1; i <= n; i++)
      if (check[i] == 0)
        printf("%d ", -1e9);
      else
        printf("%d ", b[i]);
  }
  return 0;
}
