#include <bits/stdc++.h>
using namespace std;
struct node {
  int left, right, len, vis, id;
  node() { vis = 0; }
} a[111];
int cmp(node a, node b) {
  if (a.vis == b.vis)
    return a.left < b.left;
  else
    return a.vis > b.vis;
}
int cmp2(node a, node b) { return a.id < b.id; }
int main() {
  int t, m, sum = 0, x, now = 1, p;
  char str[111];
  int vis[111];
  memset(vis, 0, sizeof(vis));
  for (int i = 1; i <= 100; i++) a[i].id = i;
  while (scanf("%d %d", &t, &m) != EOF) {
    while (t--) {
      scanf("%s", &str);
      p = 0;
      if (str[0] == 'a') {
        scanf("%d", &x);
        int tot = 0;
        for (int i = 1; i <= m; i++) {
          if (vis[i] == 0)
            tot++;
          else
            tot = 0;
          if (tot == x) {
            p = i;
            break;
          }
        }
        if (p == 0) {
          printf("NULL\n");
          continue;
        }
        printf("%d\n", now);
        for (int i = p; i > p - x; i--) vis[i] = 1;
        a[now].vis = 1, a[now].left = p - x + 1, a[now].right = p;
        now++;
      }
      if (str[0] == 'z') {
        for (int i = 1; i <= m; i++) {
          printf("%d %d\n", i, vis[i]);
        }
      }
      if (str[0] == 'e') {
        scanf("%d", &x);
        if (x >= 1 && x <= now) {
          if (a[x].vis == 1) {
            for (int i = a[x].left; i <= a[x].right; i++) vis[i] = 0;
            a[x].vis = 0;
          } else
            printf("ILLEGAL_ERASE_ARGUMENT\n");
        } else
          printf("ILLEGAL_ERASE_ARGUMENT\n");
      }
      if (str[0] == 'd') {
        int mn = 1;
        sort(a + 1, a + 1 + now, cmp);
        for (int i = 1; i <= now; i++) {
          if (a[i].vis == 0) continue;
          int len = a[i].right - a[i].left + 1;
          a[i].left = mn, a[i].right = mn + len - 1;
          mn = a[i].right + 1;
        }
        memset(vis, 0, sizeof(vis));
        for (int i = 1; i <= now; i++) {
          if (a[i].vis) {
            for (int j = a[i].left; j <= a[i].right; j++) vis[j] = 1;
          }
        }
        sort(a + 1, a + 1 + now, cmp2);
      }
    }
  }
  return 0;
}
