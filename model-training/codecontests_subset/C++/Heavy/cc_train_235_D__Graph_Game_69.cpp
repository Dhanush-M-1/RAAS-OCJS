#include <bits/stdc++.h>
using namespace std;
int n;
vector<int> G[3005];
int stk[3005], tp, instk[3005];
vector<int> cyc;
int incyc[3005];
bool flag;
inline void findCycle(int u, int pa) {
  stk[++tp] = u;
  instk[u] = 1;
  for (int i = 0; i < G[u].size(); ++i) {
    int v = G[u][i];
    if (v == pa) continue;
    if (instk[v]) {
      while (stk[tp] != v) {
        cyc.push_back(stk[tp]);
        incyc[stk[tp]] = 1;
        instk[stk[tp]] = 0;
        --tp;
      }
      cyc.push_back(stk[tp]);
      incyc[stk[tp]] = 1;
      instk[stk[tp]] = 0;
      --tp;
      flag = 1;
    } else
      findCycle(v, u);
    if (flag) return;
  }
  instk[u] = 0;
  --tp;
}
int N;
int anc[3005];
inline void getAnc(int u, int pa, int rt) {
  anc[u] = rt;
  for (int i = 0; i < G[u].size(); ++i) {
    int v = G[u][i];
    if (v != pa && !incyc[v]) getAnc(v, u, rt);
  }
}
int dist[3005], len[3005];
double ans;
inline void dfsIn(int u, int pa, int rt) {
  dist[u] = dist[pa] + 1;
  ans += (double)1 / dist[u];
  for (int i = 0; i < G[u].size(); ++i) {
    int v = G[u][i];
    if (v != pa && (!incyc[v] || v == rt)) dfsIn(v, u, rt);
  }
}
inline void dfsOut(int u, int pa, int rt) {
  dist[u] = dist[pa] + 1;
  ans += (double)1 / (dist[u] + len[rt] - 1) +
         (double)1 / (dist[u] - len[rt] + N - 1) -
         (double)1 / (dist[u] + N - 2);
  for (int i = 0; i < G[u].size(); ++i) {
    int v = G[u][i];
    if (v != pa && !incyc[v]) dfsOut(v, u, rt);
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin >> n;
  for (int i = 1; i <= (n); ++i) {
    int u, v;
    cin >> u >> v;
    ++u, ++v;
    G[u].push_back(v);
    G[v].push_back(u);
  }
  findCycle(1, 0);
  N = cyc.size();
  for (int i = 0; i < (N); ++i) {
    int u = cyc[i];
    getAnc(u, 0, u);
  }
  for (int i = 1; i <= (n); ++i) {
    double prev = ans;
    int rt = anc[i];
    dfsIn(i, 0, rt);
    int pos = 0;
    for (int j = 0; j < (N); ++j)
      if (cyc[j] == rt) {
        pos = j;
        break;
      }
    for (int j = 0; j < (N); ++j)
      if (j != pos) {
        len[cyc[j]] = abs(j - pos);
        dfsOut(cyc[j], rt, cyc[j]);
      }
  }
  printf("%0.8lf", ans);
  return 0;
}
