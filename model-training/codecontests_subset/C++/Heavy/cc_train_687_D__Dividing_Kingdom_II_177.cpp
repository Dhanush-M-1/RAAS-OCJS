#include <bits/stdc++.h>
int n, m, q;
int u[(1 << 20)], v[(1 << 20)], w[(1 << 20)];
std::vector<int> edges[(1 << 20) << 1];
int ans;
int colr[(1010)], fa[(1010)], sz[(1010)];
int getfather(int x) {
  if (x == fa[x]) return x;
  int p = getfather(fa[x]);
  colr[x] ^= colr[fa[x]];
  return fa[x] = p;
}
bool union_set(int u, int v) {
  int fu = getfather(u), fv = getfather(v);
  if (fu == fv) return false;
  if (sz[fu] > sz[fv]) std::swap(fu, fv);
  int p = (colr[u] == colr[v]);
  colr[fu] ^= p;
  sz[fv] += sz[fu];
  fa[fu] = fv;
  return true;
}
std::vector<int> merge(std::vector<int> &A, std::vector<int> &B) {
  int i = 0, j = 0;
  std::vector<int> tmp;
  while (i < A.size() && j < B.size()) {
    tmp.push_back(w[A[i]] > w[B[j]] ? A[i++] : B[j++]);
  }
  while (i < A.size()) tmp.push_back(A[i++]);
  while (j < B.size()) tmp.push_back(B[j++]);
  std::vector<int> rt;
  ans = -1;
  for (auto e : tmp) {
    colr[u[e]] = colr[v[e]] = 0;
    fa[u[e]] = u[e];
    fa[v[e]] = v[e];
    sz[u[e]] = sz[v[e]] = 1;
  }
  for (auto e : tmp) {
    if (union_set(u[e], v[e]))
      rt.push_back(e);
    else if (ans == -1 && colr[u[e]] == colr[v[e]]) {
      ans = w[e];
      rt.push_back(e);
      break;
    }
  }
  return rt;
}
void build() {
  for (int i = ((1 << 20) << 1) - 1; i; --i) {
    if (i >= (1 << 20)) {
      if ((1 << 20) + m - 1 >= i) {
        edges[i].push_back(i - (1 << 20) + 1);
      }
    } else {
      edges[i] = merge(edges[i << 1], edges[(i << 1) + 1]);
    }
  }
}
int query(int l, int r) {
  l += (1 << 20) - 1;
  r += (1 << 20);
  std::vector<int> es;
  for (; l < r; l >>= 1, r >>= 1) {
    if (l % 2) es = merge(es, edges[l++]);
    if (r % 2) es = merge(es, edges[r - 1]);
  }
  printf("\n");
  return ans;
}
int main() {
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 1; i <= m; ++i) {
    scanf("%d%d%d", u + i, v + i, w + i);
  }
  build();
  for (int i = 1; i <= q; ++i) {
    int l, r;
    scanf("%d%d", &l, &r);
    printf("%d\n", query(l, r));
  }
  return 0;
}
