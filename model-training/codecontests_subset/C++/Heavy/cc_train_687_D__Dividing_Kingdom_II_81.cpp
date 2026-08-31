#include <bits/stdc++.h>
using namespace std;
int edges[1010 * 1010][3];
int i, j, n, m, q;
int L, R;
map<pair<int, int>, int> ans;
bool color[1010];
int fa[1010], sum[1010];
struct Edge {
  int a, b, w, id;
} ee[1010 * 1010];
bool cmp(const pair<int, int>& a, const pair<int, int>& b) {
  return a.second < b.second;
}
bool cmp2(const Edge& a, const Edge& b) { return a.w > b.w; }
int findfa(int a) {
  if (a == fa[a]) return a;
  int ans = findfa(fa[a]);
  color[a] = color[a] ^ color[fa[a]];
  return fa[a] = ans;
}
bool merge(int a, int b) {
  int aa = findfa(a), bb = findfa(b);
  if (aa == bb) {
    if (color[a] == color[b]) return false;
    return true;
  }
  if (sum[aa] > sum[bb]) {
    swap(aa, bb);
  }
  fa[aa] = bb;
  if (color[a] == color[b]) color[aa] = !color[aa];
  sum[bb] += sum[aa];
  return true;
}
int make() {
  for (i = 1; i < (int)n + 1; ++i) {
    fa[i] = i;
    sum[i] = 1;
    color[i] = 0;
  }
  int ans = -1;
  for (i = 0; i < (int)m; ++i) {
    if (ee[i].id >= L && ee[i].id <= R) {
      if (!merge(ee[i].a, ee[i].b)) {
        ans = ee[i].w;
        return ans;
      }
    }
  }
  return ans;
}
int main() {
  scanf("%d %d %d", &n, &m, &q);
  for (i = 0; i < (int)m; ++i) {
    scanf("%d %d %d", &edges[i][0], &edges[i][1], &edges[i][2]);
    ee[i].a = edges[i][0];
    ee[i].b = edges[i][1];
    ee[i].w = edges[i][2];
    ee[i].id = i + 1;
  }
  sort(ee, ee + m, cmp2);
  while (q--) {
    scanf("%d %d", &L, &R);
    if (!ans.count(make_pair(L, R))) {
      ans[make_pair(L, R)] = make();
    }
    printf("%d\n", ans[make_pair(L, R)]);
  }
  return 0;
}
