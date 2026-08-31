#include <bits/stdc++.h>
using namespace std;
int read() {
  int xx = 0, ff = 1;
  char ch = getchar();
  while (ch > '9' || ch < '0') {
    if (ch == '-') ff = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    xx = xx * 10 + ch - '0';
    ch = getchar();
  }
  return xx * ff;
}
const int maxn = 200010;
int N, root;
int lin[maxn], len, deg[maxn];
struct edge {
  int y, next;
} e[maxn << 1];
inline void insert(int xx, int yy) {
  e[++len].next = lin[xx];
  lin[xx] = len;
  e[len].y = yy;
  deg[xx]++;
}
bool v[maxn];
int cnt[maxn][2];
bool dfs(int x, int fa) {
  for (int i = lin[x]; i; i = e[i].next)
    if (e[i].y != fa) cnt[x][dfs(e[i].y, x)]++;
  if ((deg[x] - cnt[x][1]) % 2 == 0)
    v[x] = 1;
  else
    v[x] = 0;
  return v[x];
}
void print(int x, int fa) {
  for (int i = lin[x]; i; i = e[i].next)
    if (e[i].y != fa)
      if (v[e[i].y]) print(e[i].y, x);
  printf("%d\n", x);
  for (int i = lin[x]; i; i = e[i].next)
    if (e[i].y != fa)
      if (!v[e[i].y]) print(e[i].y, x);
}
int main() {
  N = read();
  for (int i = 1; i <= N; i++) {
    int temp = read();
    if (!temp)
      root = i;
    else
      insert(i, temp), insert(temp, i);
  }
  if (dfs(root, 0)) {
    puts("YES");
    print(root, 0);
  } else
    puts("NO");
  return 0;
}
