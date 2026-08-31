#include <bits/stdc++.h>
using namespace std;
const int MXN = 100005;
int N, loid[MXN], islolo[MXN];
int bln[MXN], dep[MXN];
vector<int> E[MXN];
vector<int> lolo;
int ins[MXN];
vector<int> stk;
long double ans;
bool DFS1(int u, int f) {
  ins[u] = 1;
  stk.push_back(u);
  for (auto v : E[u]) {
    if (v == f) continue;
    if (ins[v]) {
      while (stk.back() != v) {
        lolo.push_back(stk.back());
        stk.pop_back();
      }
      lolo.push_back(v);
      return 1;
    }
    if (DFS1(v, u)) return 1;
  }
  ins[u] = 0;
  stk.pop_back();
  return 0;
}
void DFS(int u, int f, int d, int bid) {
  dep[u] = d;
  bln[u] = bid;
  for (auto v : E[u]) {
    if (v == f) continue;
    if (islolo[v]) continue;
    DFS(v, u, d + 1, bid);
  }
}
void calc(int u, int f, int d) {
  ans += 1.0 / d;
  for (auto v : E[u]) {
    if (v == f) continue;
    if (islolo[v] and bln[u] != v) continue;
    calc(v, u, d + 1);
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  ;
  cin >> N;
  for (int i = 0; i < (N); i++) {
    int u, v;
    cin >> u >> v;
    E[u].push_back(v);
    E[v].push_back(u);
  }
  DFS1(0, 0);
  for (int i = 0; i < (((int)((lolo).size()))); i++) {
    int v = lolo[i];
    loid[v] = i;
    islolo[v] = 1;
  }
  for (auto v : lolo) DFS(v, v, 1, v);
  ans = 0;
  for (int i = 0; i < (N); i++) calc(i, i, 1);
  for (int i = 0; i < (N); i++)
    for (int j = 0; j < (N); j++) {
      if (i == j) continue;
      if (bln[i] == bln[j]) continue;
      int d1 = abs(loid[bln[i]] - loid[bln[j]]);
      int d2 = ((int)((lolo).size())) - d1;
      d1--;
      d2--;
      ans += 1.0 / (dep[i] + dep[j] + d1);
      ans += 1.0 / (dep[i] + dep[j] + d2);
      ans -= 1.0 / (dep[i] + dep[j] + d1 + d2);
    }
  cout << fixed << setprecision(10) << ans << endl;
  return 0;
}
