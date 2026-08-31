#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline void ckmax(T& x, T y) {
  x = (y > x ? y : x);
}
template <typename T>
inline void ckmin(T& x, T y) {
  x = (y < x ? y : x);
}
const int MAXN = 2e5;
int n, lim, a[MAXN + 5], goal[MAXN + 5];
int vals[MAXN + 5], cnt_val;
int need_oper_pos;
vector<vector<int> > ans;
int fa[MAXN + 5], sz[MAXN + 5];
int last_edge[MAXN + 5];
int get_fa(int u) { return (u == fa[u]) ? u : (fa[u] = get_fa(fa[u])); }
void unite(int u, int v, int e) {
  int fu = get_fa(u);
  int fv = get_fa(v);
  if (fu != fv) {
    if (sz[fu] > sz[fv]) swap(fu, fv);
    fa[fu] = fv;
    sz[fv] += sz[fu];
  }
  last_edge[fu] = e;
}
struct EDGE {
  int nxt, to, eid;
} edge[MAXN + 5];
int head[MAXN + 5], tot;
inline void add_edge(int u, int v, int eid) {
  edge[++tot].nxt = head[u];
  edge[tot].to = v;
  edge[tot].eid = eid;
  head[u] = tot;
}
vector<int> pos;
void dfs(int u) {
  for (int& i = head[u]; i;) {
    int v = edge[i].to;
    int eid = edge[i].eid;
    i = edge[i].nxt;
    dfs(v);
    pos.push_back(eid);
  }
}
int main() {
  cin >> n >> lim;
  for (int i = 1; i <= n; ++i) {
    cin >> a[i];
    vals[++cnt_val] = a[i];
  }
  sort(vals + 1, vals + cnt_val + 1);
  for (int i = 1; i <= n; ++i) goal[i] = vals[i];
  cnt_val = unique(vals + 1, vals + cnt_val + 1) - (vals + 1);
  for (int i = 1; i <= cnt_val; ++i) {
    fa[i] = i;
    sz[i] = 1;
  }
  for (int i = 1; i <= n; ++i) {
    a[i] = lower_bound(vals + 1, vals + cnt_val + 1, a[i]) - vals;
    goal[i] = lower_bound(vals + 1, vals + cnt_val + 1, goal[i]) - vals;
    if (a[i] != goal[i]) {
      unite(a[i], goal[i], i);
      need_oper_pos++;
    }
  }
  if (need_oper_pos > lim) {
    cout << -1 << endl;
    return 0;
  }
  int rest = lim - need_oper_pos;
  if (rest >= 2) {
    for (int i = 1; i <= cnt_val; ++i) {
      if (get_fa(i) == i && last_edge[i] != 0) {
        pos.push_back(last_edge[i]);
        if (((int)(pos).size()) == rest) break;
      }
    }
    if (((int)(pos).size()) >= 2) {
      ans.push_back(pos);
      int last_val = a[pos.back()];
      for (int i = ((int)(pos).size()) - 1; i >= 1; --i) {
        a[pos[i]] = a[pos[i - 1]];
      }
      a[pos[0]] = last_val;
    }
  }
  for (int i = 1; i <= n; ++i) {
    if (a[i] != goal[i]) {
      add_edge(a[i], goal[i], i);
    }
  }
  for (int i = 1; i <= n; ++i) {
    if (head[i]) {
      vector<int>().swap(pos);
      dfs(i);
      ans.push_back(pos);
    }
  }
  cout << ((int)(ans).size()) << endl;
  for (int i = 0; i < ((int)(ans).size()); ++i) {
    cout << ((int)(ans[i]).size()) << endl;
    for (int j = 0; j < ((int)(ans[i]).size()); ++j) {
      cout << ans[i][j] << " \n"[j == ((int)(ans[i]).size()) - 1];
    }
  }
  return 0;
}
