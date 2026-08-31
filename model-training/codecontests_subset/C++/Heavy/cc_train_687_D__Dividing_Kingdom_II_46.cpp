#include <bits/stdc++.h>
int inp() {
  char c = getchar();
  while (c < '0' || c > '9') c = getchar();
  int sum = 0;
  while (c >= '0' && c <= '9') {
    sum = sum * 10 + c - '0';
    c = getchar();
  }
  return sum;
}
struct Node {
  int u;
  int v;
  int w;
  int id;
} s[1000010];
int fa[2010];
int find(int x) { return fa[x] == x ? x : fa[x] = find(fa[x]); }
bool merge(int a, int b) {
  a = find(a);
  b = find(b);
  if (a == b) return false;
  fa[a] = b;
  return true;
}
bool cmp(Node a, Node b) { return a.w > b.w; }
int main() {
  int n = inp();
  int m = inp();
  int q = inp();
  for (int i = 1; i <= m; i++) {
    s[i].u = inp();
    s[i].v = inp();
    s[i].w = inp();
    s[i].id = i;
  }
  std::sort(s + 1, s + m + 1, cmp);
  while (q--) {
    int l = inp();
    int r = inp();
    for (int i = 1; i <= (n << 1); i++) fa[i] = i;
    bool flg = false;
    for (int i = 1; i <= m; i++)
      if (l <= s[i].id && s[i].id <= r) {
        if (find(s[i].u) == find(s[i].v)) {
          flg = true;
          printf("%d\n", s[i].w);
          break;
        }
        merge(s[i].u, s[i].v + n);
        merge(s[i].u + n, s[i].v);
      }
    if (!flg) printf("-1\n");
  }
}
