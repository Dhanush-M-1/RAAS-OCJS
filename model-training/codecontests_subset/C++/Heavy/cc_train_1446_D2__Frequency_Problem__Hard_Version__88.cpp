#include <bits/stdc++.h>
const int maxn = 4e5 + 7;
using namespace std;
int n, x, y, ans;
int a[maxn], b[maxn], c[maxn], last[maxn];
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    b[a[i]]++;
  }
  for (int i = 1; i <= n; i++)
    if (b[i] > b[x]) x = i;
  int lim = trunc(sqrt(n));
  for (int i = 1; i <= n; i++) {
    if ((b[i] >= lim) && (i != x)) {
      y = i;
      for (int j = 1; j <= n; j++) {
        if (a[j] == x)
          c[j] = 1;
        else if (a[j] == y)
          c[j] = -1;
        else
          c[j] = 0;
      }
      for (int j = 0; j <= 2 * n; j++) last[j] = -1;
      last[n] = 0;
      c[0] = n;
      for (int j = 1; j <= n; j++) {
        c[j] += c[j - 1];
        if (last[c[j]] != -1)
          ans = max(ans, j - last[c[j]]);
        else
          last[c[j]] = j;
      }
    }
  }
  for (int i = 1; i < lim; i++) {
    for (int j = 1; j <= n; j++) c[j] = 0;
    int l = 1, num = 0;
    for (int j = 1; j <= n; j++) {
      c[a[j]]++;
      if (c[a[j]] == i)
        num++;
      else {
        while (c[a[j]] > i) {
          if (c[a[l]] == i) num--;
          c[a[l]]--;
          l++;
        }
      }
      if (num >= 2) ans = max(ans, j - l + 1);
    }
  }
  printf("%d\n", ans);
}
