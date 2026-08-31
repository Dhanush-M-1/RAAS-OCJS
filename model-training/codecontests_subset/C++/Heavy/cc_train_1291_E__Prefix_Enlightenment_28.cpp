#include <bits/stdc++.h>
using namespace std;
const int MAXN = 6e5 + 5;
int n, K;
char S[MAXN >> 1];
vector<int> A[MAXN];
namespace DSU {
int fa[MAXN], size[MAXN];
inline void init() {
  for (int i = 1; i <= K; ++i) fa[i] = i, fa[i + K] = i + K, size[i + K] = 1;
}
int findfa(int u) { return fa[u] == u ? u : fa[u] = findfa(fa[u]); }
int calc(int u) {
  int v = u <= K ? u + K : u - K;
  u = findfa(u), v = findfa(v);
  if (!u || !v) return size[u + v];
  return min(size[u], size[v]);
}
void join(int u, int v) {
  u = findfa(u), v = findfa(v);
  if (!v) swap(u, v);
  fa[v] = u;
  if (u) size[u] += size[v];
}
}  // namespace DSU
int main() {
  scanf("%d%d", &n, &K);
  DSU::init();
  scanf("%s", S + 1);
  for (int x, y, i = 1; i <= K; ++i) {
    scanf("%d", &y);
    while (y--) scanf("%d", &x), A[x].push_back(i);
  }
  int ans = 0;
  for (int i = 1; i <= n; ++i) {
    if (A[i].size() == 1) {
      int x = A[i][0];
      ans -= DSU::calc(x);
      if (S[i] == '0')
        DSU::fa[DSU::findfa(x)] = 0;
      else
        DSU::fa[DSU::findfa(x + K)] = 0;
      ans += DSU::calc(x);
    }
    if (A[i].size() == 2) {
      int x = A[i][0], y = A[i][1];
      if (S[i] == '0') {
        if (DSU::findfa(x) != DSU::findfa(y + K)) {
          ans -= DSU::calc(x) + DSU::calc(y);
          DSU::join(x, y + K), DSU::join(y, x + K);
          ans += DSU::calc(x);
        }
      } else {
        if (DSU::findfa(x) != DSU::findfa(y)) {
          ans -= DSU::calc(x) + DSU::calc(y);
          DSU::join(x, y), DSU::join(x + K, y + K);
          ans += DSU::calc(x);
        }
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
