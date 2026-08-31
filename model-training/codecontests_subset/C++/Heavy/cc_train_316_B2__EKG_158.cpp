#include <bits/stdc++.h>
using namespace std;
namespace Sol {
const int N = 1010;
int n, x;
int pre[N];
bool vst[N];
bool in[N];
int belong;
int posx;
bool f[N];
struct Bg {
  int x;
} bg[N];
int tot = 0;
int pos = 0;
void dfs(int u) {
  if (u == 0) return;
  dfs(pre[u]);
  pos++;
  if (u == x) {
    belong = tot;
    posx = pos;
  }
  bg[tot].x++;
}
void sol() {
  memset(in, 0, sizeof(in));
  memset(f, 0, sizeof(f));
  scanf("%d", &n);
  scanf("%d", &x);
  for (int i = 1; i < n + 1; ++i) {
    scanf("%d", &pre[i]);
    in[pre[i]] = 1;
  }
  for (int i = 1; i < n + 1; ++i) {
    if (!in[i]) {
      pos = 0;
      dfs(i);
      tot++;
    }
  }
  f[0] = 1;
  for (int i = 0; i < tot; ++i) {
    if (i == belong) continue;
    for (int v = n; v >= bg[i].x; --v) {
      if (f[v - bg[i].x]) f[v] = 1;
    }
  }
  for (int i = 0; i < n; ++i) {
    if (f[i]) {
      printf("%d\n", posx + i);
    }
  }
}
}  // namespace Sol
int main() {
  Sol::sol();
  return 0;
}
