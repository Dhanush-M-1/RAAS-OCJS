#include <bits/stdc++.h>
using namespace std;
inline long long readint() {
  long long a = 0;
  char c = getchar(), f = 1;
  for (; c < '0' || c > '9'; c = getchar())
    if (c == '-') f = -f;
  for (; '0' <= c && c <= '9'; c = getchar())
    a = (a << 3) + (a << 1) + (c ^ 48);
  return a * f;
}
template <class T>
void getMax(T &a, const T &b) {
  if (a < b) a = b;
}
const int MaxM = 1000005;
const int MaxN = 1005;
int n;
namespace UFS {
int fa[MaxN], val[MaxN];
void init() {
  for (int i = 1; i <= n; ++i) fa[i] = i, val[i] = 0;
}
int find(int a) {
  if (fa[a] == a) return a;
  int root = find(fa[a]);
  val[a] ^= val[fa[a]];
  return fa[a] = root;
}
int combine(int a, int b) {
  int x = find(a), y = find(b);
  if (x == y)
    if (val[a] ^ val[b])
      return 1;
    else
      return 0;
  fa[x] = y;
  val[x] = val[a] ^ val[b] ^ 1;
  return 2;
}
};  // namespace UFS
struct Edge {
  int from, to, val;
  Edge(int F = 0, int T = 0, int V = 0) { from = F, to = T, val = V; }
} e[MaxM];
void hebing(vector<int> &v, vector<int> &v1, vector<int> &v2) {
  int p = 0, len1 = v1.size();
  int q = 0, len2 = v2.size();
  int len = len1 + len2;
  v.resize(len);
  while (p < len1 || q < len2) {
    if (p < len1 && (q >= len2 || e[v1[p]].val > e[v2[q]].val))
      v[p + q] = v1[p], ++p;
    else
      v[p + q] = v2[q], ++q;
  }
  UFS::init();
  int delta = 0;
  for (int i = 0, llb; i + delta < len; ++i) {
    v[i] = v[i + delta];
    llb = UFS::combine(e[v[i]].from, e[v[i]].to);
    if (llb == 0) {
      len = i + 1 + delta;
      break;
    }
    if (llb == 1) ++delta, --i;
  }
  v.resize(len -= delta);
}
int m;
vector<int> v[MaxM << 1 | 1];
int __id(int l, int r) { return (l + r) | (l != r); }
void build(int l = 1, int r = m) {
  if (l == r) {
    v[__id(l, r)].resize(1);
    v[__id(l, r)][0] = l;
    return;
  }
  int t = (l + r) >> 1;
  build(l, t), build(t + 1, r);
  hebing(v[__id(l, r)], v[__id(l, t)], v[__id(t + 1, r)]);
}
void query(int ql, int qr, vector<int> &res, int l = 1, int r = m) {
  if (ql <= l && r <= qr) {
    res = v[__id(l, r)];
    return;
  }
  int t = (l + r) >> 1;
  if (qr <= t) return query(ql, qr, res, l, t);
  if (t < ql) return query(ql, qr, res, t + 1, r);
  vector<int> tmp[2];
  query(ql, qr, tmp[0], l, t);
  query(ql, qr, tmp[1], t + 1, r);
  hebing(res, tmp[0], tmp[1]);
}
vector<int> res;
int main() {
  n = readint(), m = readint();
  int q = readint();
  for (int i = 1; i <= m; ++i) {
    e[i].from = readint();
    e[i].to = readint();
    e[i].val = readint();
  }
  build();
  while (q--) {
    int l = readint();
    int r = readint();
    query(l, r, res);
    UFS::init();
    bool notAny = true;
    for (int i = 0, len = res.size(); i < len; ++i)
      if (UFS::combine(e[res[i]].from, e[res[i]].to) == 0) notAny = false;
    if (!notAny)
      printf("%d\n", e[res.back()].val);
    else
      printf("-1\n");
  }
  return 0;
}
