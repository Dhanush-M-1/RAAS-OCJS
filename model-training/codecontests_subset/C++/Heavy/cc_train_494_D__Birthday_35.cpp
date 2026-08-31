#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9 + 7;
int N, Q;
set<pair<int, int> > g[100001];
int t0[100001], t1[100001], t2[100001];
int p[100001];
template <typename T>
class range_minimum_query {
 public:
  std::vector<T> data;
  std::vector<std::vector<int> > block;
  std::vector<int> sblock;
  std::vector<int> lookup;
  int N;
  int lg;
  int min(int a, int b) { return data[b] < data[a] ? b : a; }
  range_minimum_query() {}
  range_minimum_query(std::vector<T> &t) {
    data = t;
    N = data.size();
    lg = 32 - __builtin_clz(N);
    block.assign((N + lg - 1) / lg, std::vector<int>(lg, 0));
    for (int i = 0; i < N; i++) {
      if (i % lg == 0) block[i / lg][0] = i;
      block[i / lg][0] = min(i, block[i / lg][0]);
    }
    for (int j = 1; j < lg; j++)
      for (int i = 0; i < block.size(); i++)
        block[i][j] = min(
            block[i][j - 1],
            block[i + (i + (1 << (j - 1)) < block.size() ? (1 << (j - 1)) : 0)]
                 [j - 1]);
    sblock.assign(N, 0);
    std::vector<int> st;
    for (int i = 0; i < block.size(); i++) {
      st.clear();
      for (int j = i * lg; j < N && j < i * lg + lg; j++) {
        while (!st.empty() && data[j] < data[st.back()]) st.pop_back();
        sblock[j] = 1 << (i * lg + lg - j - 1);
        if (!st.empty()) sblock[j] |= sblock[st.back()];
        st.push_back(j);
      }
    }
    lookup.assign(1 << lg, 0);
    for (int i = 1, ans = lg - 1; i < (1 << lg); i++) {
      if (1 << (lg - ans) <= i) ans--;
      lookup[i] = ans;
    }
  }
  int q(int l, int r) {
    if (r < l) swap(l, r);
    int l1 = l / lg + 1;
    int r1 = r / lg - 1;
    int ans = l;
    int t;
    if (l1 <= r1) {
      t = lg - lookup[r1 - l1 + 1] - 1;
      ans = min(ans, min(block[l1][t], block[r1 - (1 << t) + 1][t]));
    }
    t = l1 * lg - 1 < r ? l1 * lg - 1 : r;
    ans = min(ans, lookup[sblock[t] & (~(((1 << (l - (l1 * lg - lg))) - 1)
                                         << (l1 * lg - l)))] +
                       l1 * lg - lg);
    t = r;
    l = l > r1 * lg + lg ? l : r1 * lg + lg;
    ans = min(ans, lookup[sblock[t] & (~(((1 << (l - (r1 * lg + lg))) - 1)
                                         << (r1 * lg + (lg << 1) - l)))] +
                       r1 * lg + lg);
    return ans;
  }
};
template <typename T>
class segment_tree {
 public:
  vector<T> data;
  vector<T> tt;
  int N;
  int construct(int root, int cl, int cr) {
    if (cl == cr) return tt[root] = cl;
    int t1 = construct(root * 2, cl, (cl + cr) / 2);
    int t2 = construct(root * 2 + 1, (cl + cr) / 2 + 1, cr);
    return tt[root] = data[t2] < data[t1] ? t2 : t1;
  }
  int query(int root, int cl, int cr, int l, int r) {
    if (cl > r || cr < l) return N;
    if (l <= cl && cr <= r) return tt[root];
    int t1 = query(root * 2, cl, (cl + cr) / 2, l, r);
    int t2 = query(root * 2 + 1, (cl + cr) / 2 + 1, cr, l, r);
    return data[t2] < data[t1] ? t2 : t1;
  }
  inline int q(int l, int r) {
    if (r < l) swap(l, r);
    return query(1, 0, N - 1, l, r);
  }
  segment_tree(){};
  segment_tree(vector<T> a) {
    N = a.size();
    data = a;
    data.push_back(INT_MAX);
    tt.resize(4 * N);
    construct(1, 0, N - 1);
  }
};
class least_common_ancestor {
 public:
  int N;
  vector<vector<int> > g;
  vector<int> invf;
  vector<int> f;
  vector<int> ll;
  range_minimum_query<int> rmq;
  void inorder(int s = 0, int d = 0) {
    ll.push_back(d);
    invf[ll.size() - 1] = s;
    f[s] = ll.size() - 1;
    for (int i = 0; i < g[s].size(); i++) {
      inorder(g[s][i], d + 1);
      ll.push_back(d);
      invf[ll.size() - 1] = s;
    }
  }
  least_common_ancestor(){};
  least_common_ancestor(vector<vector<int> > t) {
    g = t;
    N = g.size();
    f.resize(N);
    invf.resize(2 * N - 1);
    inorder();
    rmq = range_minimum_query<int>(ll);
    ll.clear();
    g.clear();
  }
  int q(int a, int b) { return invf[rmq.q(f[a], f[b])]; }
};
void fix(int s) {
  for (pair<int, int> i : g[s]) {
    g[i.first].erase(g[i.first].lower_bound(make_pair(s, 0)));
    p[i.first] = s;
    fix(i.first);
  }
}
int add(int a, int b) {
  int ret = a + b;
  if (ret >= MOD) ret -= MOD;
  return ret;
}
int mul(int a, int b) { return (a * 1ll * b) % MOD; }
int ddd[100001];
least_common_ancestor lca;
int dist(int a, int b) {
  return add(add(ddd[a], ddd[b]), MOD - mul(2, ddd[1 + lca.q(a - 1, b - 1)]));
}
set<pair<int, int> > q[100001];
vector<int> ans;
void dfs1(int s, int d = 0) {
  t0[s] = 1;
  ddd[s] = d;
  for (pair<int, int> i : g[s]) {
    dfs1(i.first, add(d, i.second));
    t0[s] = add(t0[s], t0[i.first]);
    t1[s] = add(t1[s], mul(t0[i.first], i.second));
    t1[s] = add(t1[s], t1[i.first]);
    t2[s] = add(t2[s], t2[i.first]);
    t2[s] = add(t2[s], mul(t1[i.first], mul(2, i.second)));
    t2[s] = add(t2[s], mul(t0[i.first], mul(i.second, i.second)));
  }
}
set<pair<int, pair<int, int> > > st[100001];
void dfs(int s) {
  for (pair<int, int> i : g[s]) {
    int pt0 = t0[i.first];
    int pt1 = t1[i.first];
    pt1 = add(pt1, mul(t0[i.first], i.second));
    int pt2 = t2[i.first];
    pt2 = add(pt2, mul(t1[i.first], mul(2, i.second)));
    pt2 = add(pt2, mul(t0[i.first], mul(i.second, i.second)));
    t0[s] = add(t0[s], MOD - pt0);
    t1[s] = add(t1[s], MOD - pt1);
    t2[s] = add(t2[s], MOD - pt2);
    int ppt0 = t0[s];
    int ppt1 = t1[s];
    ppt1 = add(ppt1, mul(t0[s], i.second));
    int ppt2 = t2[s];
    ppt2 = add(ppt2, mul(t1[s], mul(2, i.second)));
    ppt2 = add(ppt2, mul(t0[s], mul(i.second, i.second)));
    t0[i.first] = add(t0[i.first], ppt0);
    t1[i.first] = add(t1[i.first], ppt1);
    t2[i.first] = add(t2[i.first], ppt2);
    dfs(i.first);
    t0[i.first] = add(t0[i.first], MOD - ppt0);
    t1[i.first] = add(t1[i.first], MOD - ppt1);
    t2[i.first] = add(t2[i.first], MOD - ppt2);
    t0[s] = add(t0[s], pt0);
    t1[s] = add(t1[s], pt1);
    t2[s] = add(t2[s], pt2);
  }
  for (pair<int, int> i : g[s])
    if (st[i.first].size() > st[s].size()) swap(st[i.first], st[s]);
  for (pair<int, int> i : g[s])
    st[s].insert(st[i.first].begin(), st[i.first].end());
  for (set<pair<int, pair<int, int> > >::iterator it =
           st[s].lower_bound(make_pair(s, make_pair(0, 0)));
       it != st[s].end() && it->first == s; it++) {
    if (s == 1) continue;
    int ooo = dist(p[s], it->second.first);
    ans[it->second.second] =
        add(ans[it->second.second],
            MOD - mul(2, add(t2[p[s]], add(mul(t1[p[s]], mul(2, ooo)),
                                           mul(t0[p[s]], mul(ooo, ooo))))));
  }
  for (pair<int, int> i : q[s]) {
    if (i.first == s || lca.q(s - 1, i.first - 1) + 1 != i.first) {
      ans[i.second] = MOD - t2[s];
      continue;
    }
    ans[i.second] = t2[s];
    st[s].insert(make_pair(i.first, make_pair(s, i.second)));
  }
}
vector<vector<int> > g1;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> N;
  for (int i = 1, a, b, c; i < N; i++) {
    cin >> a >> b >> c;
    g[a].insert(make_pair(b, c));
    g[b].insert(make_pair(a, c));
  }
  g1.resize(N + 1);
  cin >> Q;
  ans.resize(Q);
  for (int i = 0, u, v; i < Q; i++) {
    cin >> u >> v;
    q[u].insert(make_pair(v, i));
  }
  fix(1);
  for (int i = 1; i <= N; i++)
    for (pair<int, int> j : g[i]) g1[i - 1].push_back(j.first - 1);
  lca = least_common_ancestor(g1);
  dfs1(1);
  dfs(1);
  for (int s = 1; s <= N; s++)
    for (pair<int, int> i : q[s]) {
      if (s != i.first && lca.q(s - 1, i.first - 1) + 1 == i.first) continue;
      int ooo = dist(s, i.first);
      ans[i.second] =
          add(ans[i.second],
              mul(2, add(t2[i.first], add(mul(t1[i.first], mul(2, ooo)),
                                          mul(t0[i.first], mul(ooo, ooo))))));
    }
  for (int i : ans) cout << i << '\n';
  return 0;
}
