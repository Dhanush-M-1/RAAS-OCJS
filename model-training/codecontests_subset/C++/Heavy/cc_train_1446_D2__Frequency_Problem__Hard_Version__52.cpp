#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 5;
int a[maxn], cnt[maxn], n, book[maxn * 2], maxx, id, sn, ans, p[maxn];
int main() {
  scanf("%d", &n);
  sn = sqrt(n);
  for (register int i = 1; i <= n; i++) scanf("%d", &a[i]), cnt[a[i]]++;
  for (register int i = 1; i <= n; i++) {
    if (cnt[i] > maxx)
      maxx = cnt[i], id = i;
    else if (cnt[i] == maxx)
      id = -1;
  }
  if (id == -1) {
    printf("%d\n", n);
    return 0;
  }
  memset(book, -1, sizeof(book));
  for (register int i = 1; i <= n; i++) {
    if (!cnt[i] || i == id) continue;
    if (cnt[i] > sn) {
      int now = n;
      book[now] = 0;
      for (register int j = 1; j <= n; j++) {
        if (a[j] == id)
          now++;
        else if (a[j] == i)
          now--;
        if (~book[now])
          ans = max(ans, j - book[now]);
        else
          book[now] = j;
      }
      memset(book, -1, sizeof(book));
      continue;
    }
  }
  for (register int i = 1; i <= sn; i++) {
    memset(book, 0, sizeof(book));
    int l = 1, cn = 0;
    for (register int j = 1; j <= n; j++) {
      if (++book[a[j]] == i) cn++;
      while (l <= j && book[a[j]] > i)
        if (book[a[l++]]-- == i) cn--;
      if (cn >= 2) ans = max(ans, j - l + 1);
    }
  }
  printf("%d", ans);
  return 0;
}
