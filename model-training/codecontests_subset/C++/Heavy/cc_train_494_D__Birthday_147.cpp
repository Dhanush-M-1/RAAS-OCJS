#include <bits/stdc++.h>
using namespace std;
inline int MODP(long long x) {
  int r = x % 1000000007;
  if (r < 0) r += 1000000007;
  return r;
}
void testGen() {
  freopen("biginput1.txt", "w", stdout);
  fclose(stdout);
}
int n;
struct weighted_tree {
  vector<vector<pair<int, int> > > adj;
  vector<pair<int, int> > pi;
  vector<int> depth;
  int n;
  int root;
  void reset(int n) {
    this->n = n;
    adj.resize(n + 1);
    for (auto i = 1; i <= n; ++i) adj[i].clear();
    pi.resize(n + 1);
    depth.resize(n + 1);
    for (auto i = 1; i <= n; ++i) {
      pi[i] = make_pair(-1, -1);
      depth[i] = 0;
    }
  }
  weighted_tree() {}
  weighted_tree(int n) { reset(n); }
  void dfs(int u) {
    for (auto &e : adj[u]) {
      int v = e.first;
      int c = e.second;
      if (pi[v].first == -1) {
        pi[v] = make_pair(u, c);
        depth[v] = depth[u] + 1;
        dfs(v);
      }
    }
  }
  void set_root(int u) {
    root = u;
    pi[root].first = -2;
    dfs(root);
  }
  void add_edge(int u, int v, int c) {
    adj[u].push_back(make_pair(v, c));
    adj[v].push_back(make_pair(u, c));
  }
};
struct lca {
  vector<vector<pair<int, int> > > anc;
  weighted_tree &t;
  lca(weighted_tree &tree) : t(tree) {
    anc.resize(t.n + 1);
    for (auto i = 1; i <= t.n; ++i) {
      if (i != t.root) {
        anc[i].push_back(t.pi[i]);
      }
    }
    for (int k = 1;; ++k) {
      bool ok = false;
      for (auto i = 1; i <= t.n; ++i) {
        if (anc[i].size() >= k) {
          int j = anc[i][k - 1].first;
          if (anc[j].size() >= k) {
            int x = anc[j][k - 1].first;
            int c = min(anc[i][k - 1].second, anc[j][k - 1].second);
            anc[i].push_back(make_pair(x, c));
            ok = true;
          }
        }
      }
      if (!ok) break;
    }
  }
  pair<int, int> get_lca(int u, int v) {
    if (t.depth[u] > t.depth[v]) {
      swap(u, v);
    }
    if (t.depth[v] > t.depth[u]) {
      for (auto i = anc[v].size() - 1; i >= 0; --i) {
        int w = anc[v][i].first;
        if (t.depth[w] >= t.depth[u]) {
          pair<int, int> p = get_lca(u, w);
          p.second = min(anc[v][i].second, p.second);
          return p;
        }
      }
    } else {
      if (u == v) {
        return make_pair(u, 2E9L);
      }
      for (auto i = anc[u].size() - 1; i >= 0; --i) {
        int x = anc[u][i].first;
        int y = anc[v][i].first;
        if (x != y || i == 0) {
          pair<int, int> p = get_lca(x, y);
          p.second = min(anc[u][i].second, p.second);
          p.second = min(anc[v][i].second, p.second);
          return p;
        }
      }
    }
    return make_pair(-1, -1);
  }
};
bool visit[100100];
weighted_tree tree;
int sumWeight[100100];
int cntNode[100100];
int sumDist[100100];
int sumSqrDist[100100];
int sumAllSqrDist[100100];
int sumAllDist[100100];
int getDistInc(int w, int v) {
  return MODP((long long)cntNode[v] * w + sumDist[v]);
}
int getSqrDistInc(int w, int v) {
  int sqrDistInc = MODP((long long)w * w);
  sqrDistInc = MODP((long long)sqrDistInc * cntNode[v]);
  sqrDistInc = MODP(sqrDistInc + (long long)2 * w * sumDist[v]);
  sqrDistInc = MODP(sqrDistInc + sumSqrDist[v]);
  return sqrDistInc;
}
void dfs(int u) {
  visit[u] = true;
  cntNode[u] = 1;
  sumDist[u] = 0;
  sumSqrDist[u] = 0;
  for (auto &e : tree.adj[u]) {
    int v = e.first, w = e.second;
    if (v != tree.pi[u].first && !visit[v]) {
      sumWeight[v] = MODP(sumWeight[u] + w);
      dfs(v);
      cntNode[u] += cntNode[v];
      sumDist[u] = MODP(sumDist[u] + getDistInc(w, v));
      sumSqrDist[u] = MODP(sumSqrDist[u] + getSqrDistInc(w, v));
    }
  }
}
void dfsSumAllDist(int u) {
  visit[u] = true;
  for (auto &e : tree.adj[u]) {
    int v = e.first, w = e.second;
    if (v != tree.pi[u].first && !visit[v]) {
      int nOutside = n - cntNode[v];
      int retSumDist = sumAllDist[u];
      retSumDist = MODP(retSumDist - getDistInc(w, v));
      int retSumSqrDist = sumAllSqrDist[u];
      retSumSqrDist = MODP(retSumSqrDist - getSqrDistInc(w, v));
      int inc = MODP((long long)w * w);
      inc = MODP((long long)inc * nOutside);
      inc = MODP(inc + (long long)2 * w * retSumDist);
      retSumSqrDist = MODP(retSumSqrDist + inc);
      retSumDist = MODP(retSumDist + (long long)w * nOutside);
      retSumDist = MODP(retSumDist + sumDist[v]);
      sumAllDist[v] = retSumDist;
      retSumSqrDist = MODP(retSumSqrDist + sumSqrDist[v]);
      sumAllSqrDist[v] = retSumSqrDist;
      dfsSumAllDist(v);
    }
  }
}
int main() {
  scanf("%d", &n);
  tree.reset(n);
  int a, b, c;
  for (auto repeat_var = 0; repeat_var < n - 1; ++repeat_var) {
    scanf("%d%d%d", &a, &b, &c);
    tree.add_edge(a, b, c);
  }
  tree.set_root(1);
  memset(visit, 0, sizeof(visit));
  sumWeight[1] = 0;
  dfs(1);
  memset(visit, 0, sizeof(visit));
  sumAllSqrDist[1] = sumSqrDist[1];
  sumAllDist[1] = sumDist[1];
  dfsSumAllDist(1);
  lca tree_lca(tree);
  int q;
  scanf("%d", &q);
  int u, v;
  for (auto repeat_var = 0; repeat_var < q; ++repeat_var) {
    scanf("%d%d", &u, &v);
    int ret;
    if (u == v) {
      ret = MODP(2 * sumSqrDist[u] - sumAllSqrDist[u]);
    } else {
      int x = tree_lca.get_lca(u, v).first;
      if (x == v) {
        int w = MODP(sumWeight[u] - sumWeight[v]);
        int nOutside = n - cntNode[v];
        ret = 0;
        ret = MODP(sumAllSqrDist[v] - sumSqrDist[v]);
        int retSumDist = MODP(sumAllDist[v] - sumDist[v]);
        int inc = MODP((long long)w * w);
        inc = MODP((long long)inc * nOutside);
        inc = MODP(inc + (long long)2 * w * retSumDist);
        ret = MODP(ret + inc);
        ret = MODP(sumAllSqrDist[u] - 2 * ret);
      } else {
        int w = MODP(sumWeight[u] - sumWeight[x]);
        w = MODP(w + sumWeight[v] - sumWeight[x]);
        int inc = MODP((long long)w * w);
        inc = MODP((long long)inc * cntNode[v]);
        inc = MODP(inc + (long long)2 * w * sumDist[v]);
        ret = MODP(sumSqrDist[v] + inc);
        ret = MODP(2 * ret - sumAllSqrDist[u]);
      }
    }
    cout << ret << endl;
  }
  return 0;
}
