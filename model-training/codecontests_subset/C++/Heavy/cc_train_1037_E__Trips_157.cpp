#include <bits/stdc++.h>
using std::queue;
const int N = 2e5 + 6;
template <class T>
inline void read(T &x) {
  T f = 1;
  x = 0;
  char s = getchar();
  while (s < '0' || s > '9') {
    if (s == '-') f = -1;
    s = getchar();
  }
  while (s >= '0' && s <= '9') {
    x = x * 10 + s - '0';
    s = getchar();
  }
  x *= f;
}
struct Edge {
  int u, v, id;
} e[N << 1];
int head[N], ecnt;
inline void addedge(int u, int v, int id) {
  e[++ecnt].v = v;
  e[ecnt].u = head[u];
  head[u] = ecnt;
  e[ecnt].id = id;
}
inline void add(int u, int v, int id) {
  addedge(u, v, id);
  addedge(v, u, id);
}
int n, m, k, du[N], a[N], b[N], del[N], u, ans, inq[N], Ans[N], len;
queue<int> q;
signed main() {
  read(n);
  read(m);
  read(k);
  for (int i = 1; i <= m; i++) {
    read(a[i]);
    read(b[i]);
    du[a[i]]++;
    du[b[i]]++;
    add(a[i], b[i], i);
  }
  for (int i = 1; i <= n; i++)
    if (du[i] < k) q.push(i), inq[i] = 1;
  ans = n;
  while (!q.empty()) {
    u = q.front();
    q.pop();
    ans--;
    du[u] = 0;
    for (int i = head[u], v; i && (v = e[i].v); i = e[i].u) {
      if (inq[v]) continue;
      if (del[e[i].id]) continue;
      du[v]--;
      del[e[i].id] = 1;
      if (du[v] < k) q.push(v), inq[v] = 1;
    }
  }
  for (int i = m; i >= 1; i--) {
    Ans[++len] = ans;
    if (del[i]) continue;
    du[a[i]]--;
    du[b[i]]--;
    del[i] = 1;
    if (!inq[a[i]] && du[a[i]] < k) q.push(a[i]), inq[a[i]] = 1;
    if (!inq[b[i]] && du[b[i]] < k) q.push(b[i]), inq[b[i]] = 1;
    while (!q.empty()) {
      u = q.front();
      q.pop();
      ans--;
      du[u] = 0;
      for (int i = head[u], v; i && (v = e[i].v); i = e[i].u) {
        if (inq[v]) continue;
        if (del[e[i].id]) continue;
        du[v]--;
        del[e[i].id] = 1;
        if (du[v] < k) q.push(v), inq[v] = 1;
      }
    }
  }
  for (int i = m; i >= 1; i--) printf("%d\n", Ans[i]);
}
