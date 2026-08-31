#include <bits/stdc++.h>
using namespace std;
typedef struct node {
  long long lazy;
  long long sum, sumsq;
} node;
vector<pair<int, long long> > G[100100];
vector<int> queries[100100];
map<pair<int, long long>, long long> M;
int uq[100100];
int vq[100100];
int lft[100100];
int rgt[100100];
int sz[100100];
node S[4 * 100100];
int idx, n;
node ZERO;
void push(int x, int l, int r) {
  long long v = S[x].lazy;
  int mid = (l + r) / 2;
  long long siz1 = mid - l + 1, siz2 = r - (mid + 1) + 1;
  S[x * 2].lazy = (S[x * 2].lazy + v) % 1000000007;
  S[x * 2].sumsq = (S[x * 2].sumsq + 2 * ((v * S[x * 2].sum) % 1000000007) +
                    (siz1 * ((v * v) % 1000000007)) % 1000000007) %
                   1000000007;
  S[x * 2].sum = (S[x * 2].sum + (siz1 * v) % 1000000007) % 1000000007;
  S[x * 2 + 1].lazy = (S[x * 2 + 1].lazy + v) % 1000000007;
  S[x * 2 + 1].sumsq =
      (S[x * 2 + 1].sumsq + 2 * ((v * S[x * 2 + 1].sum) % 1000000007) +
       (siz2 * ((v * v) % 1000000007)) % 1000000007) %
      1000000007;
  S[x * 2 + 1].sum = (S[x * 2 + 1].sum + (siz2 * v) % 1000000007) % 1000000007;
  S[x].lazy = 0;
}
void update(int x, int l, int r, int i, int j, long long v) {
  if ((j < l) or (r < i)) return;
  if ((i <= l) and (r <= j)) {
    S[x].lazy = (S[x].lazy + v) % 1000000007;
    long long siz = r - l + 1;
    S[x].sumsq = (S[x].sumsq + 2 * ((v * S[x].sum) % 1000000007) +
                  (siz * ((v * v) % 1000000007)) % 1000000007) %
                 1000000007;
    S[x].sum = (S[x].sum + (siz * v) % 1000000007) % 1000000007;
    return;
  }
  push(x, l, r);
  int mid = (l + r) / 2;
  update(x * 2, l, mid, i, j, v);
  update(x * 2 + 1, mid + 1, r, i, j, v);
  node Q1 = S[x * 2];
  node Q2 = S[x * 2 + 1];
  S[x].sum = (Q2.sum + Q1.sum) % 1000000007;
  S[x].sumsq = (Q2.sumsq + Q1.sumsq) % 1000000007;
}
node query(int x, int l, int r, int i, int j) {
  if ((j < l) or (r < i)) return ZERO;
  if ((i <= l) and (r <= j)) return S[x];
  push(x, l, r);
  int mid = (l + r) / 2;
  node Q1 = query(x * 2, l, mid, i, j);
  node Q2 = query(x * 2 + 1, mid + 1, r, i, j);
  Q2.sum = (Q2.sum + Q1.sum) % 1000000007;
  Q2.sumsq = (Q2.sumsq + Q1.sumsq) % 1000000007;
  return Q2;
}
void dfs0(int x, int pi, long long dist) {
  idx++;
  lft[x] = idx, rgt[x] = idx;
  update(1, 1, n, idx, idx, dist);
  sz[x] = 1;
  for (int j = (0); j < (G[x].size()); j++) {
    int y = G[x][j].first;
    long long w = G[x][j].second;
    if (y == pi) continue;
    dfs0(y, x, (dist + w) % 1000000007);
    lft[x] = (((lft[x]) < (lft[y])) ? (lft[x]) : (lft[y]));
    rgt[x] = (((rgt[x]) > (rgt[y])) ? (rgt[x]) : (rgt[y]));
    sz[x] += sz[y];
  }
}
void dfs1(int x, int pi) {
  node Q = query(1, 1, n, 1, n);
  for (int j = (0); j < (queries[x].size()); j++) {
    int y = queries[x][j];
    long long T = S[1].sumsq;
    node Q = query(1, 1, n, lft[y], rgt[y]);
    long long ans = (2 * Q.sumsq - T + 1000000007) % 1000000007;
    M[make_pair(x, y)] = ans;
  }
  for (int j = (0); j < (G[x].size()); j++) {
    int y = G[x][j].first;
    long long w = G[x][j].second;
    if (y == pi) continue;
    update(1, 1, n, 1, n, w);
    update(1, 1, n, lft[y], rgt[y], (2 * 1000000007 - 2 * w) % 1000000007);
    dfs1(y, x);
    update(1, 1, n, lft[y], rgt[y], (2 * w) % 1000000007);
    update(1, 1, n, 1, n, 1000000007 - w);
  }
}
int main() {
  ZERO.sum = 0;
  ZERO.sumsq = 0;
  int x, y, u, v;
  idx = 0;
  scanf("%d", &n);
  long long w;
  for (int j = (1); j <= (n - 1); j++) {
    scanf("%d %d %I64d", &x, &y, &w);
    G[x].push_back(make_pair(y, w));
    G[y].push_back(make_pair(x, w));
  }
  for (int j = (0); j < (4 * 100100); j++) {
    S[j].sum = 0;
    S[j].sumsq = 0;
  }
  dfs0(1, -1, 0);
  int q;
  cin >> q;
  for (int j = (1); j <= (q); j++) {
    scanf("%d %d", &uq[j], &vq[j]);
    queries[uq[j]].push_back(vq[j]);
  }
  dfs1(1, -1);
  for (int j = (1); j <= (q); j++) {
    printf("%I64d\n", M[make_pair(uq[j], vq[j])]);
  }
}
