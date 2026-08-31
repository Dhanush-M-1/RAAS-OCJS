#include <bits/stdc++.h>
using namespace std;
const int N = 200000 + 77, TOF = 100;
mt19937 RNG;
inline int GetRand(int l, int r) { return RNG() % (r - l + 1) + l; }
int n, m, st[N], en[N], d[N], P[N], tim;
bool M[N];
vector<int> adj[N];
bool valid, A[N];
pair<int, int> B[N];
void dfs(int v) {
  st[v] = tim++;
  M[v] = 1;
  for (int u : adj[v]) {
    valid &= ((!M[u]) || (st[u] <= st[v] && en[u] == 0));
    if (!M[u]) dfs(u);
  }
  en[v] = tim;
}
inline void Apply(int v, int u) {
  if (u == 0 || d[u] >= d[v]) return;
  if (B[v].second == 0 || d[B[v].second] > d[u]) B[v].second = u;
  if (B[v].first == 0 || d[B[v].first] > d[B[v].second])
    swap(B[v].first, B[v].second);
}
void dfscalc(int v) {
  M[v] = 1;
  for (int u : adj[v]) {
    if (M[u]) Apply(v, u);
    if (!M[u]) {
      d[u] = d[v] + 1;
      dfscalc(u);
      Apply(v, B[u].first);
      Apply(v, B[u].second);
    }
  }
}
inline void Test() {
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= n; ++i)
    adj[i].clear(), d[i] = 0, A[i] = 0, B[i] = make_pair(0, 0);
  for (int v, u, i = 1; i <= m; ++i)
    scanf("%d %d", &v, &u), adj[v].push_back(u);
  int tof = TOF;
  int vr = -1;
  while (tof--) {
    int root = GetRand(1, n);
    valid = 1;
    for (int i = 1; i <= n; ++i) M[i] = st[i] = en[i] = 0;
    tim = 1;
    dfs(root);
    if (valid) {
      vr = root;
      break;
    }
  }
  if (vr == -1) {
    printf("-1\n");
    return;
  }
  for (int i = 1; i <= n; ++i) M[i] = 0;
  dfscalc(vr);
  for (int i = 1; i <= n; ++i) P[i] = i;
  sort(P + 1, P + 1 + n, [&](int x, int y) { return d[x] < d[y]; });
  A[vr] = 1;
  for (int i = 2; i <= n; ++i) {
    int id = P[i];
    if (B[id].second > 0) continue;
    A[id] = A[B[id].first];
  }
  int cnt = 0;
  for (int i = 1; i <= n; ++i) cnt += A[i];
  if (cnt < (n + 4) / 5) {
    printf("-1\n");
    return;
  }
  for (int i = 1; i <= n; ++i)
    if (A[i]) printf("%d ", i);
  printf("\n");
}
int main() {
  RNG.seed(time(0));
  int T;
  scanf("%d", &T);
  while (T--) Test();
  return 0;
}
