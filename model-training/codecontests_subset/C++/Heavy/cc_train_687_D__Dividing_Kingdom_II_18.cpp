#include <bits/stdc++.h>
using namespace std;
vector<int> sav[1001000 << 2];
int n, m, q, fa[1010], rl[1010];
struct data {
  int u, v, w;
} ed[1001000];
int find(int k) {
  if (fa[k] == k) return k;
  int f = find(fa[k]);
  rl[k] ^= rl[fa[k]];
  return fa[k] = f;
}
void Merge(vector<int> &rt, vector<int> ls, vector<int> rs) {
  int i = 0, j = 0;
  vector<int> tmp;
  rt.clear();
  tmp.clear();
  while (i < (int)ls.size() && j < (int)rs.size())
    if (ed[ls[i]].w > ed[rs[j]].w)
      rt.push_back(ls[i++]);
    else
      rt.push_back(rs[j++]);
  while (i < (int)ls.size()) rt.push_back(ls[i++]);
  while (j < (int)rs.size()) rt.push_back(rs[j++]);
  for (int i = 1; i <= n; i++) fa[i] = i, rl[i] = 0;
  for (int i = 0; i <= (int)rt.size() - 1; i++) {
    int fx = find(ed[rt[i]].u), fy = find(ed[rt[i]].v);
    if (fx != fy)
      fa[fx] = fy, rl[fx] = rl[ed[rt[i]].u] ^ rl[ed[rt[i]].v] ^ 1,
      tmp.push_back(rt[i]);
    else if (rl[ed[rt[i]].u] == rl[ed[rt[i]].v]) {
      tmp.push_back(rt[i]);
      break;
    }
  }
  rt = tmp;
}
void Build(int rt, int l, int r) {
  sav[rt].clear();
  if (l == r) {
    sav[rt].push_back(l);
    return;
  }
  Build(rt << 1, l, ((l + r) >> 1));
  Build(rt << 1 | 1, ((l + r) >> 1) + 1, r);
  Merge(sav[rt], sav[rt << 1], sav[rt << 1 | 1]);
}
bool cmp(int a, int b) { return ed[a].w > ed[b].w; }
int Query(int rt, int l, int r, int L, int R, vector<int> &tmp) {
  int flag = 0;
  if (l >= L && r <= R) {
    for (int i = 0; i <= (int)sav[rt].size() - 1; i++)
      tmp.push_back(sav[rt][i]);
    if (rt == 1)
      flag = 1;
    else
      return 2333;
  }
  if (!flag && L <= ((l + r) >> 1))
    Query(rt << 1, l, ((l + r) >> 1), L, R, tmp);
  if (!flag && R > ((l + r) >> 1))
    Query(rt << 1 | 1, ((l + r) >> 1) + 1, r, L, R, tmp);
  if (rt == 1) {
    int ans = -1;
    for (int i = 1; i <= n; i++) fa[i] = i, rl[i] = 0;
    sort(tmp.begin(), tmp.end(), cmp);
    for (int i = 0; i <= (int)tmp.size() - 1; i++) {
      int fx = find(ed[tmp[i]].u), fy = find(ed[tmp[i]].v);
      if (fx != fy)
        fa[fx] = fy, rl[fx] = rl[ed[tmp[i]].u] ^ rl[ed[tmp[i]].v] ^ 1;
      else if (rl[ed[tmp[i]].u] == rl[ed[tmp[i]].v]) {
        ans = ed[tmp[i]].w;
        break;
      }
    }
    return ans;
  }
  return 2333;
}
int main() {
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 1; i <= m; i++) scanf("%d%d%d", &ed[i].u, &ed[i].v, &ed[i].w);
  Build(1, 1, m);
  while (q--) {
    int l, r;
    scanf("%d%d", &l, &r);
    vector<int> tmp;
    tmp.clear();
    printf("%d\n", Query(1, 1, m, l, r, tmp));
  }
}
