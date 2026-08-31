#include <bits/stdc++.h>
using namespace std;
template <typename Arg1>
void __f(const char* name, Arg1&& arg1) {
  cerr << name << " : " << arg1 << std::endl;
}
template <typename Arg1, typename... Args>
void __f(const char* names, Arg1&& arg1, Args&&... args) {
  const char* comma = strchr(names + 1, ',');
  cerr.write(names, comma - names) << " : " << arg1 << " | ";
  __f(comma + 1, args...);
}
const int N = int(1e3) + 10;
const int M = (N * (N - 1)) / 2;
const int LOGM = 23;
int U[M], V[M], W[M], n, m, q, C[N], dsu[N], sz[N];
bool cmp(int a, int b) { return W[a] > W[b]; }
inline int Find(int x) {
  if (x == dsu[x]) return x;
  int p = Find(dsu[x]);
  C[x] ^= C[dsu[x]];
  return dsu[x] = p;
}
inline bool Union(int a, int b) {
  int x = Find(a), y = Find(b);
  if (x == y) return false;
  if (sz[x] > sz[y]) swap(x, y), swap(a, b);
  int p = (C[a] == C[b]);
  C[x] ^= p;
  sz[y] += sz[x];
  dsu[x] = y;
  Find(a);
  Find(b);
  return true;
}
struct tree {
  vector<int> edges;
  int ans;
  tree() { edges.clear(); }
  tree(int l, int r) {
    for (int i = l; i <= r; i++) edges.push_back(i);
    sort(edges.begin(), edges.end(), cmp);
  }
  tree(vector<int>& _edges) { edges = _edges; }
  inline void build() {
    ans = -1;
    for (auto e : edges) {
      C[U[e]] = C[V[e]] = 0;
      dsu[U[e]] = U[e];
      dsu[V[e]] = V[e];
      sz[U[e]] = sz[V[e]] = 1;
    }
    vector<int> want;
    for (auto e : edges)
      if (Union(U[e], V[e]))
        want.push_back(e);
      else if (ans == -1 && C[U[e]] == C[V[e]])
        ans = W[e], want.push_back(e);
    edges = want;
  }
};
tree ST[4 * M], null;
inline tree merge(tree& A, tree& B) {
  vector<int> edges;
  vector<int>&a = A.edges, &b = B.edges;
  if (a.empty() || b.empty()) return (a.empty() ? B : A);
  int i = 0, j = 0;
  while (i < (int)(a.size()) && j < (int)(b.size()))
    if (W[a[i]] > W[b[j]])
      edges.push_back(a[i++]);
    else
      edges.push_back(b[j++]);
  while (i < (int)(a.size())) edges.push_back(a[i++]);
  while (j < (int)(b.size())) edges.push_back(b[j++]);
  tree ret(edges);
  ret.build();
  return ret;
}
inline void build(int l = 1, int r = m + 1, int x = 1) {
  if (l == r - 1) {
    ST[x] = tree(l, l);
    ST[x].build();
    return;
  }
  int m = (l + r) / 2;
  build(l, m, (x << 1));
  build(m, r, (x << 1) | 1);
  ST[x] = merge(ST[(x << 1)], ST[(x << 1) | 1]);
}
inline tree query(int L, int R, int l = 1, int r = m + 1, int x = 1) {
  if (l >= L && r <= R) return ST[x];
  if (l >= R || r <= L) return null;
  int m = (l + r) / 2;
  tree la = query(L, R, l, m, (x << 1));
  tree ra = query(L, R, m, r, (x << 1) | 1);
  return merge(la, ra);
}
int main() {
  scanf("%d", &n);
  scanf("%d", &m);
  scanf("%d", &q);
  for (int i = 1; i <= m; i++) scanf("%d %d %d", U + i, V + i, W + i);
  build();
  while (q--) {
    int l, r;
    scanf("%d", &l);
    scanf("%d", &r);
    printf("%d\n", query(l, r + 1).ans);
  }
  return 0;
}
