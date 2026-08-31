#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int x = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') {
      f = -1;
    }
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = x * 10 + ch - '0';
    ch = getchar();
  }
  return x * f;
}
int n, sz[200005], du[200005], h[200005], num = 0, rt;
struct edge {
  int to, next;
} data[200005 << 1];
void dfs(int x, int Fa) {
  sz[x] = 1;
  int y;
  for (int i = h[x]; i; i = data[i].next) {
    y = data[i].to;
    if (y == Fa) {
      continue;
    }
    dfs(y, x);
    sz[x] += sz[y];
  }
}
void dfs1(int x, int Fa) {
  int y;
  for (int i = h[x]; i; i = data[i].next) {
    y = data[i].to;
    if (y == Fa) {
      continue;
    }
    if (!(sz[y] & 1)) {
      dfs1(y, x);
    }
  }
  printf("%d\n", x);
  for (int i = h[x]; i; i = data[i].next) {
    y = data[i].to;
    if (y == Fa) {
      continue;
    }
    if (sz[y] & 1) {
      dfs1(y, x);
    }
  }
}
int main() {
  n = read();
  if (!(n & 1)) {
    puts("NO");
    return 0;
  }
  puts("YES");
  for (int i = 1; i <= n; ++i) {
    int y = read();
    if (!y) {
      continue;
    }
    ++du[i];
    ++du[y];
    data[++num].to = y;
    data[num].next = h[i];
    h[i] = num;
    data[++num].to = i;
    data[num].next = h[y];
    h[y] = num;
  }
  for (int i = 1; i <= n; ++i) {
    if (!(du[i] & 1)) {
      rt = i;
      break;
    }
  }
  dfs(rt, 0);
  dfs1(rt, 0);
  return 0;
}
