#include <bits/stdc++.h>
using namespace std;
int a[10100];
int b[10100];
struct node {
  int type;
  int l, r, d;
} op[10100];
int vis[10101];
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < m; i++)
    cin >> op[i].type >> op[i].l >> op[i].r >> op[i].d;
  int f = 0;
  for (int i = m - 1; i >= 0; i--) {
    if (op[i].type == 1) {
      for (int j = op[i].l; j <= op[i].r; j++) {
        a[j] -= op[i].d;
      }
    }
    if (op[i].type == 2) {
      for (int j = op[i].l; j <= op[i].r; j++) {
        if (!vis[j])
          a[j] = op[i].d, vis[j] = 1;
        else {
          if (a[j] > op[i].d) a[j] = op[i].d;
        }
      }
    }
  }
  int flag = 0;
  for (int i = 1; i <= n; i++) {
    if (a[i] > 1e9) flag = 1;
    b[i] = a[i];
  }
  if (flag == 1) {
    printf("NO\n");
    return 0;
  }
  for (int i = 0; i < m; i++) {
    int maxx = -1e9;
    if (op[i].type == 1) {
      for (int j = op[i].l; j <= op[i].r; j++) {
        b[j] += op[i].d;
      }
    }
    if (op[i].type == 2) {
      for (int j = op[i].l; j <= op[i].r; j++) {
        maxx = max(maxx, b[j]);
      }
      if (maxx != op[i].d) {
        flag = 1;
        break;
      }
    }
  }
  if (flag == 1)
    printf("NO\n");
  else {
    printf("YES\n");
    for (int i = 1; i <= n; i++) printf("%d ", a[i]);
  }
}
