#include <bits/stdc++.h>
using namespace std;
int n, m, q;
int edges[566456][3];
const int S = 1 << 19;
vector<int> tree[2 * S];
vector<int> out;
pair<int, bool> parent[1234];
bool cmp(int i, int j) { return edges[i][2] > edges[j][2]; }
void cleaan() {
  for (int i = 1; i <= n; ++i) {
    parent[i] = make_pair(0, 0);
  }
}
pair<int, bool> finD(int no) {
  if (!parent[no].first) {
    return make_pair(no, 0);
  }
  auto tmp = finD(parent[no].first);
  parent[no] = make_pair(tmp.first, tmp.second ^ parent[no].second);
  return parent[no];
}
int unioN(int n1, int n2) {
  auto tmp1 = finD(n1);
  auto tmp2 = finD(n2);
  if (tmp1.first != tmp2.first) {
    parent[tmp1.first] = make_pair(tmp2.first, 1 ^ tmp1.second ^ tmp2.second);
    return 1;
  } else {
    if (tmp1.second != tmp2.second) {
      return 3;
    } else {
      return 2;
    }
  }
}
void loda() {
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 0; i < m; ++i) {
    scanf("%d%d%d", &edges[i][0], &edges[i][1], &edges[i][2]);
  }
}
int calc(vector<int>& inds) {
  sort(inds.begin(), inds.end(), cmp);
  cleaan();
  out.clear();
  for (int i = 0; i < inds.size(); ++i) {
    int tmp = unioN(edges[inds[i]][0], edges[inds[i]][1]);
    if (tmp == 1) {
      out.push_back(inds[i]);
    }
    if (tmp == 2) {
      out.push_back(inds[i]);
      return edges[inds[i]][2];
    }
  }
  return -1;
}
void build(int l, int r, int node) {
  vector<int> inds;
  for (int i = l; i <= min(m - 1, r); ++i) inds.push_back(i);
  calc(inds);
  tree[node] = out;
  if (l < r) {
    int s = (l + r) / 2;
    build(l, s, 2 * node);
    build(s + 1, r, 2 * node + 1);
  }
}
void zbieraj(int l, int r, int ll, int rr, int node, vector<int>& inds) {
  if (r < ll || rr < l) {
    return;
  }
  if (l <= ll && rr <= r) {
    for (int ind : tree[node]) {
      inds.push_back(ind);
    }
    return;
  }
  int ss = (ll + rr) / 2;
  zbieraj(l, r, ll, ss, 2 * node, inds);
  zbieraj(l, r, ss + 1, rr, 2 * node + 1, inds);
}
int query() {
  int l, r;
  scanf("%d%d", &l, &r);
  --l;
  --r;
  vector<int> inds;
  zbieraj(l, r, 0, S - 1, 1, inds);
  return calc(inds);
}
int main() {
  loda();
  build(0, S - 1, 1);
  for (int i = 0; i < q; ++i) {
    printf("%d\n", query());
  }
}
