#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline bool maxit(T& a, const T& b) {
  if (a < b) {
    a = b;
    return true;
  }
  return false;
}
template <typename T>
inline bool minit(T& a, const T& b) {
  if (a > b) {
    a = b;
    return true;
  }
  return false;
}
inline long long gint() {
  char c = getchar();
  int f = 1;
  while (c < '0' || c > '9') {
    if (c == '-') {
      f = -1;
    }
    c = getchar();
  }
  long long a = c - '0';
  while ((c = getchar()) >= '0' && c <= '9') {
    a = a * 10 + c - '0';
  }
  return a * f;
}
const int maxn = 100010, MOD = int(1e9 + 7);
int head[maxn], en[maxn << 1], nxt[maxn << 1], pri[maxn << 1], tot;
inline void add(int u, int v, int w) {
  en[++tot] = v;
  nxt[tot] = head[u];
  head[u] = tot;
  pri[tot] = w;
}
int n;
struct SegTree {
  int A[maxn], sum1[maxn << 2], sum2[maxn << 2], add[maxn << 2];
  inline void up(int s) {
    sum1[s] = (sum1[s << 1] + sum1[s << 1 | 1]) % MOD;
    sum2[s] = (sum2[s << 1] + sum2[s << 1 | 1]) % MOD;
  }
  void build(int s, int l, int r) {
    if (l == r) {
      sum1[s] = A[l];
      sum2[s] = (long long)A[l] * A[l] % MOD;
      return;
    }
    int mid = (l + r) >> 1;
    build(s << 1, l, mid);
    build(s << 1 | 1, mid + 1, r);
    up(s);
  }
  int ql, qr, val;
  inline void inc(int s, int l, int r, int val) {
    add[s] = (add[s] + val) % MOD;
    sum2[s] = (sum2[s] + 2LL * val * sum1[s] % MOD +
               (r - l + 1LL) * val % MOD * val % MOD) %
              MOD;
    sum1[s] = (sum1[s] + (r - l + 1LL) * val) % MOD;
  }
  inline void down(int s, int l, int r) {
    if (add[s]) {
      int mid = (l + r) >> 1;
      inc(s << 1, l, mid, add[s]);
      inc(s << 1 | 1, mid + 1, r, add[s]);
      add[s] = 0;
    }
  }
  void update(int s, int l, int r) {
    if (ql <= l && r <= qr) {
      inc(s, l, r, val);
      return;
    }
    down(s, l, r);
    int mid = (l + r) >> 1;
    if (ql <= mid) {
      update(s << 1, l, mid);
    }
    if (mid < qr) {
      update(s << 1 | 1, mid + 1, r);
    }
    up(s);
  }
  void query(int s, int l, int r) {
    if (ql <= l && r <= qr) {
      val = (val + sum2[s]) % MOD;
      return;
    }
    down(s, l, r);
    int mid = (l + r) >> 1;
    if (ql <= mid) {
      query(s << 1, l, mid);
    }
    if (mid < qr) {
      query(s << 1 | 1, mid + 1, r);
    }
  }
  int range(int ql, int qr) {
    if (ql > qr) {
      return 0;
    }
    this->ql = ql;
    this->qr = qr;
    val = 0;
    query(1, 1, n);
    return val;
  }
  void change(int ql, int qr, int val) {
    if (ql > qr) {
      return;
    }
    this->ql = ql;
    this->qr = qr;
    this->val = val;
    update(1, 1, n);
  }
} seg;
int ls[maxn], le[maxn], dfs_clock;
int dis[maxn];
vector<pair<int, int> > Q[maxn];
int ans[maxn];
inline void moveroot(int u, int v, int w) {
  seg.change(ls[v], le[v], MOD - w);
  seg.change(1, ls[v] - 1, w);
  seg.change(le[v] + 1, n, w);
}
void dfstwo(int u, int fa) {
  int ALL = seg.range(1, n);
  for (typeof((Q[u]).begin()) it = (Q[u]).begin(), _end_ = (Q[u]).end();
       it != _end_; ++it) {
    int v = it->first;
    ans[it->second] = (seg.range(ls[v], le[v]) * 2LL - ALL + MOD) % MOD;
  }
  for (int k = head[u]; k; k = nxt[k]) {
    int v = en[k];
    if (v == fa) continue;
    moveroot(u, v, pri[k]);
    dfstwo(v, u);
    moveroot(u, v, MOD - pri[k]);
  }
}
void dfs(int u, int fa) {
  ls[u] = ++dfs_clock;
  for (int k = head[u]; k; k = nxt[k]) {
    int v = en[k];
    if (v == fa) continue;
    dis[v] = (dis[u] + pri[k]) % MOD;
    dfs(v, u);
  }
  le[u] = dfs_clock;
}
int q;
int main() {
  n = gint();
  for (int i = 1; i < n; i++) {
    int u = gint(), v = gint(), w = gint();
    add(u, v, w);
    add(v, u, w);
  }
  dfs(1, 0);
  for (int i = 1; i <= n; i++) {
    seg.A[ls[i]] = dis[i];
  }
  seg.build(1, 1, n);
  q = gint();
  for (int i = 0; i < q; i++) {
    int u = gint(), v = gint();
    Q[u].push_back(make_pair(v, i));
  }
  dfstwo(1, 0);
  for (int i = 0; i < q; i++) {
    printf("%d\n", ans[i]);
  }
  return 0;
}
