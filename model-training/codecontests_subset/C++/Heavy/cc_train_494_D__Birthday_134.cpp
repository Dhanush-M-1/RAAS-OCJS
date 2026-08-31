#include <bits/stdc++.h>
using namespace std;
template <class T>
inline bool getmin(T *a, const T &b) {
  if (b < *a) {
    *a = b;
    return true;
  }
  return false;
}
template <class T>
inline bool getmax(T *a, const T &b) {
  if (b > *a) {
    *a = b;
    return true;
  }
  return false;
}
template <class T>
inline void read(T *a) {
  char c;
  while (isspace(c = getchar())) {
  }
  bool flag = 0;
  if (c == '-')
    flag = 1, *a = 0;
  else
    *a = c - 48;
  while (isdigit(c = getchar())) *a = *a * 10 + c - 48;
  if (flag) *a = -*a;
}
const int mo = 1000000007;
template <class T>
T pow(T a, T b, int c = mo) {
  T res = 1;
  for (T i = 1; i <= b; i <<= 1, a = 1LL * a * a % c)
    if (b & i) res = 1LL * res * a % c;
  return res;
}
const int N = 101000;
struct node {
  int s0, s1, s2;
  int tg;
} tree[N * 4];
struct edge_node {
  int p, nextt, w;
} edge[N * 2];
int cnt;
int head[N];
void ae(int a, int b, int c) {
  edge[++cnt].p = b;
  edge[cnt].nextt = head[a];
  edge[cnt].w = c;
  head[a] = cnt;
}
int l[N], r[N], idx;
int n, m;
void add(node &A, int x) {
  A.tg = (A.tg + x) % mo;
  A.s2 =
      ((A.s2 + 1LL * x * x % mo * A.s0 % mo) % mo + 2LL * x * A.s1 % mo) % mo;
  A.s1 = (A.s1 + 1LL * x * A.s0 % mo) % mo;
}
void down(node &A, node &L, node &R) {
  if (A.tg) {
    add(L, A.tg);
    add(R, A.tg);
    A.tg = 0;
  }
}
void update(node &A, const node &L, const node &R) {
  A.s1 = (L.s1 + R.s1) % mo;
  A.s2 = (L.s2 + R.s2) % mo;
}
int ans[N];
vector<pair<int, int> > q[N];
void modify(int u, int L, int R, int l, int r, int p) {
  if (l <= L && r >= R) {
    add(tree[u], p);
    return;
  }
  down(tree[u], tree[u * 2], tree[u * 2 + 1]);
  int mid = (L + R) >> 1;
  if (r <= mid)
    modify(u * 2, L, mid, l, r, p);
  else if (l > mid)
    modify(u * 2 + 1, mid + 1, R, l, r, p);
  else
    modify(u * 2, L, mid, l, mid, p),
        modify(u * 2 + 1, mid + 1, R, mid + 1, r, p);
  update(tree[u], tree[u * 2], tree[u * 2 + 1]);
}
int ask(int u, int L, int R, int l, int r) {
  if (l <= L && r >= R) return tree[u].s2;
  down(tree[u], tree[u * 2], tree[u * 2 + 1]);
  int mid = (L + R) >> 1;
  if (r <= mid)
    return ask(u * 2, L, mid, l, r);
  else if (l > mid)
    return ask(u * 2 + 1, mid + 1, R, l, r);
  else
    return (ask(u * 2, L, mid, l, mid) +
            ask(u * 2 + 1, mid + 1, R, mid + 1, r)) %
           mo;
}
void dfs(int u, int fa, int d) {
  l[u] = ++idx;
  modify(1, 1, n, idx, idx, d);
  for (int k = head[(u)]; k; k = edge[k].nextt) {
    int v = edge[k].p;
    if (v != fa) dfs(v, u, (d + edge[k].w) % mo);
  }
  r[u] = idx;
}
void solve(int u, int fa) {
  for (int k = head[(u)]; k; k = edge[k].nextt) {
    int v = edge[k].p;
    if (v == fa) continue;
    modify(1, 1, n, 1, n, edge[k].w);
    modify(1, 1, n, l[v], r[v], 2LL * (mo - edge[k].w) % mo);
    solve(v, u);
    modify(1, 1, n, 1, n, mo - edge[k].w);
    modify(1, 1, n, l[v], r[v], 2LL * edge[k].w % mo);
  }
  for (int i = 0; i < q[u].size(); ++i) {
    int x = q[u][i].first, y = q[u][i].second;
    ans[y] =
        (2LL * ask(1, 1, n, l[x], r[x]) % mo - ask(1, 1, n, 1, n) + mo) % mo;
  }
}
void build(int u, int L, int R) {
  tree[u].s0 = R - L + 1;
  if (L == R) return;
  int mid = (L + R) >> 1;
  build(u * 2, L, mid);
  build(u * 2 + 1, mid + 1, R);
}
int main() {
  cin >> n;
  for (int i = (1); i <= (n - 1); ++i) {
    int x, y, z;
    read(&x);
    read(&y);
    read(&z);
    ae(x, y, z);
    ae(y, x, z);
  }
  build(1, 1, n);
  dfs(1, 0, 0);
  cin >> m;
  for (int i = (1); i <= (m); ++i) {
    int x, y;
    read(&x);
    read(&y);
    q[x].push_back(std::make_pair(y, i));
  }
  solve(1, 0);
  for (int i = (1); i <= (m); ++i) printf("%d\n", ans[i]);
  return 0;
}
