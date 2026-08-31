#include <bits/stdc++.h>
using namespace std;
int N;
vector<pair<int, int> > G[100005];
int Level[100005], D[100005];
int Sum[100005], Total[100005], Sz[100005], Left[100005], Right[100005], cnt;
int SumSq[100005], TotalSq[100005];
int Father[20][100005], Log[100005];
const int MOD = 1000000007;
inline void Add(int& x, int y) {
  x += y;
  if (x >= MOD) x -= MOD;
}
inline void Sub(int& x, int y) {
  x -= y;
  if (x < 0) x += MOD;
}
void Read() {
  scanf("%d", &N);
  for (int i = 1; i < N; i++) {
    int x, y, c;
    scanf("%d%d%d", &x, &y, &c);
    G[x].push_back(make_pair(y, c));
    G[y].push_back(make_pair(x, c));
  }
}
void DFS(int node, int father, int cost) {
  Father[0][node] = father;
  Level[node] = Level[father] + 1;
  D[node] = D[father] + cost;
  if (D[node] >= MOD) D[node] -= MOD;
  Left[node] = ++cnt;
  Sz[node] = 1;
  for (int i = 0; i < G[node].size(); i++) {
    int neighb = G[node][i].first, c = G[node][i].second;
    if (neighb == father) continue;
    DFS(neighb, node, c);
    Sz[node] += Sz[neighb];
    int val = Sum[neighb];
    Add(val, (1LL * c * Sz[neighb]) % MOD);
    Add(Sum[node], val);
    val = SumSq[neighb];
    int aux = (1LL * c * c) % MOD;
    Add(val, (1LL * aux * Sz[neighb]) % MOD);
    Add(val, (2LL * c * Sum[neighb]) % MOD);
    Add(SumSq[node], val);
  }
  Right[node] = cnt;
}
void DFS2(int node, int father, int cost) {
  if (node != 1) {
    Total[node] = Total[father];
    Add(Total[node], (1LL * (N - Sz[node]) * cost) % MOD);
    Sub(Total[node], (1LL * Sz[node] * cost) % MOD);
    TotalSq[node] = TotalSq[father];
    int val = (1LL * cost * cost) % MOD;
    val = (1LL * val * N) % MOD;
    int aux = Total[node];
    Sub(aux, Sum[node]);
    Sub(aux, (1LL * (N - Sz[node]) * cost) % MOD);
    Add(val, (2LL * (aux)*cost) % MOD);
    int aux2 = Sum[node];
    Add(aux2, (1LL * cost * Sz[node]) % MOD);
    Sub(val, (2LL * cost * aux2) % MOD);
    Add(TotalSq[node], val);
  }
  for (int i = 0; i < G[node].size(); i++) {
    int neighb = G[node][i].first, c = G[node][i].second;
    if (neighb == father) continue;
    DFS2(neighb, node, c);
  }
}
void precalcFather() {
  for (int i = 1; (1 << i) <= N; i++) {
    for (int j = 1; j <= N; j++) Father[i][j] = Father[i - 1][Father[i - 1][j]];
  }
}
void precalcLog() {
  for (int i = 2; i <= N; i++) Log[i] = Log[i / 2] + 1;
}
int F(int node, int dist) {
  while (dist > 0) {
    int k = Log[dist];
    node = Father[k][node];
    dist -= (1 << k);
  }
  return node;
}
int LCA(int x, int y) {
  if (Level[x] > Level[y]) swap(x, y);
  y = F(y, Level[y] - Level[x]);
  if (x == y) return x;
  for (int k = Log[N]; k >= 0; k--) {
    if (Father[k][x] != Father[k][y]) {
      x = Father[k][x];
      y = Father[k][y];
    }
  }
  return Father[0][x];
}
int Dist(int x, int y) {
  int lca = LCA(x, y);
  return (D[x] - D[lca] + D[y] - D[lca]) % MOD;
}
int Query(int u, int v) {
  int d = Dist(u, v);
  if (Left[u] >= Left[v] && Left[u] <= Right[v]) {
    int aux = d;
    d = (1LL * d * d) % MOD;
    int sumOut = (1LL * (N - Sz[v]) * d) % MOD;
    int val = Total[v];
    Sub(val, Sum[v]);
    Add(sumOut, (2LL * aux * val) % MOD);
    Add(sumOut, TotalSq[v]);
    Sub(sumOut, SumSq[v]);
    int sum = TotalSq[u];
    Sub(sum, (2LL * sumOut) % MOD);
    return sum;
  } else {
    int aux = d;
    d = (1LL * d * d) % MOD;
    int sumIn = (1LL * Sz[v] * d) % MOD;
    Add(sumIn, (2LL * aux * Sum[v]) % MOD);
    Add(sumIn, SumSq[v]);
    int sum = TotalSq[u];
    Sub(sum, (2LL * sumIn) % MOD);
    sum = MOD - sum;
    if (sum >= MOD) sum -= MOD;
    return sum;
  }
}
int main() {
  Read();
  precalcLog();
  DFS(1, 0, 0);
  precalcFather();
  for (int i = 1; i <= N; i++) {
    Add(Total[1], D[i]);
    Add(TotalSq[1], (1LL * D[i] * D[i]) % MOD);
  }
  DFS2(1, 0, 0);
  int Q;
  scanf("%d", &Q);
  for (int i = 1; i <= Q; i++) {
    int u, v;
    scanf("%d%d", &u, &v);
    int aux = Query(u, v);
    if (aux < 0) aux += MOD;
    if (aux >= MOD) aux -= MOD;
    printf("%d\n", aux);
  }
  return 0;
}
