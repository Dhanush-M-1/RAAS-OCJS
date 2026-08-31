#include <bits/stdc++.h>
using namespace std;
int t, m;
int vis[111];
int cnt;
bool exist[111];
void init() {
  memset(vis, 0, sizeof(vis));
  memset(exist, 0, sizeof(exist));
  cnt = 0;
}
int alloc(int x) {
  int i;
  int res = 0;
  for (i = 0; i < m; i++) {
    if (vis[i] == 0) {
      res = 0;
      while (vis[i] == 0 && i < m) {
        res++;
        i++;
        if (res == x) break;
      }
    }
    if (res == x) {
      break;
    }
  }
  if (res == x) {
    cnt++;
    for (int j = i - res; j < i; j++) vis[j] = cnt;
    exist[cnt] = 1;
    return cnt;
  } else
    return -1;
}
int erases(int x) {
  if (exist[x] == 0)
    return -1;
  else {
    for (int i = 0; i < m; i++)
      if (vis[i] == x) vis[i] = 0;
    exist[x] = 0;
    return 1;
  }
}
void defragment() {
  int xx[111];
  int res = 0;
  for (int i = 0; i < m; i++) {
    if (vis[i]) {
      xx[res++] = vis[i];
    }
  }
  for (int i = 0; i < res; i++) vis[i] = xx[i];
  for (int i = res; i < m; i++) vis[i] = 0;
}
int main() {
  scanf("%d %d", &t, &m);
  char op[22];
  int a;
  init();
  for (int i = 0; i < t; i++) {
    scanf("%s", op);
    if (op[0] == 'd') {
      defragment();
    } else {
      scanf("%d", &a);
      if (op[0] == 'a') {
        if (a < 0) {
          printf("NULL\n");
          continue;
        }
        int xx = alloc(a);
        if (xx == -1)
          printf("NULL\n");
        else
          printf("%d\n", xx);
      } else if (op[0] == 'e') {
        if (a < 0 || a > t) {
          printf("ILLEGAL_ERASE_ARGUMENT\n");
          continue;
        }
        int xx = erases(a);
        if (xx == -1) printf("ILLEGAL_ERASE_ARGUMENT\n");
      }
    }
  }
  return 0;
}
