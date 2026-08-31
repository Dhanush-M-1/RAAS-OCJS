#include <bits/stdc++.h>
using namespace std;
const int N = 4e5 + 10;
int Begin[N], Next[N], to[N], e;
void add(int u, int v) { to[++e] = v, Next[e] = Begin[u], Begin[u] = e; }
int n, m, k, c;
int A[N], rk[N], st[N], vis[N];
void DFS(int o) {
  vis[o] = true;
  for (int& i = Begin[o]; i;) {
    int u = to[i];
    i = Next[i];
    DFS(u);
    st[++c] = o;
  }
}
bool cmp(int x, int y) { return A[x] < A[y]; }
int L[N], R[N], pos[N];
vector<int> seq[N], cyc[N];
struct Edge {
  int u, v, id;
  bool operator<(const Edge& E) const { return u != E.u ? u < E.u : v < E.v; }
};
multiset<Edge> S;
bool used[N];
int main() {
  scanf("%d%d", &n, &k);
  for (int i = 1; i <= n; i++) scanf("%d", &A[i]), rk[i] = i;
  sort(rk + 1, rk + n + 1, cmp);
  for (int i = 1; i <= n; i++) L[i] = A[rk[i]] == A[rk[i - 1]] ? L[i - 1] : i;
  for (int i = n; i >= 1; i--) R[i] = A[rk[i]] == A[rk[i + 1]] ? R[i + 1] : i;
  for (int i = 1; i <= n; i++)
    if (rk[i] >= L[i] && rk[i] <= R[i]) used[rk[i]] = true;
  for (int i = 1; i <= n; i++)
    if (L[i] == i) pos[i] = i;
  int ans = 0;
  for (int i = 1; i <= n; i++)
    if (rk[i] < L[i] || rk[i] > R[i])
      ++ans, add(L[rk[i]], L[i]), S.insert((Edge){L[rk[i]], L[i], rk[i]});
  if (ans > k) {
    puts("-1");
    return 0;
  }
  for (int i = 1; i <= n; i++)
    if (!vis[i] && Begin[i]) {
      c = 0;
      DFS(i);
      ++m;
      for (int j = c; j >= 1; j--) {
        int v = j == 1 ? st[c] : st[j - 1];
        auto it = S.lower_bound((Edge){st[j], v, 0});
        seq[m].push_back(it->id);
        S.erase(it);
      }
    }
  int p = 1;
  c = 0;
  if (k - ans > 2 && m > 2) {
    int pr = min(m, k - ans);
    c = 1;
    for (int i = 1; i <= pr; i++)
      for (int v : seq[i]) cyc[c].push_back(v);
    c = 2;
    for (int i = pr; i >= 1; i--) cyc[c].push_back(seq[i].front());
    p = pr + 1;
  }
  for (int i = p; i <= m; i++) cyc[++c] = seq[i];
  printf("%d\n", c);
  for (int i = 1; i <= c; i++) {
    printf("%lu\n", cyc[i].size());
    for (int v : cyc[i]) printf("%d%c", v, v == cyc[i].back() ? '\n' : ' ');
  }
  return 0;
}
