#include <bits/stdc++.h>
using namespace std;
const int maxn = 1010;
struct in {
  int u, v, w, id;
  bool operator<(const in &x) const { return w > x.w; }
};
in a[maxn * maxn];
int fa[maxn << 1], dis[maxn];
int find(int x) {
  if (x != fa[x]) {
    int fx = find(fa[x]);
    dis[x] ^= dis[fa[x]];
    fa[x] = fx;
  }
  return fa[x];
}
bool Union(int x, int y) {
  int fx = find(x), fy = find(y);
  if (fx == fy) {
    if (dis[x] == dis[y]) return false;
    return true;
  }
  fa[fx] = fy;
  dis[fx] = dis[x] ^ dis[y] ^ 1;
  return true;
}
int main() {
  int N, M, Q, L, R;
  scanf("%d%d%d", &N, &M, &Q);
  for (int i = 1; i <= M; i++)
    scanf("%d%d%d", &a[i].u, &a[i].v, &a[i].w), a[i].id = i;
  sort(a + 1, a + M + 1);
  for (int i = 1; i <= Q; i++) {
    int ans = -1;
    scanf("%d%d", &L, &R);
    for (int j = 1; j <= N; j++) fa[j] = j, dis[j] = 0;
    for (int j = 1; j <= M; j++) {
      if (a[j].id < L || a[j].id > R) continue;
      if (!Union(a[j].u, a[j].v)) {
        ans = a[j].w;
        break;
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
