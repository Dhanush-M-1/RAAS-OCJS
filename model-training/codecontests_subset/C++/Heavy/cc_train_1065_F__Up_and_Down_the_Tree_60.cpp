#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6 + 5, lg = 20;
vector<int> Front_Edge[maxn], Back_Edge[maxn], Component_Front[maxn];
int depth[maxn], Comp[maxn], Leaf_cnt[maxn], Comp_ASS[maxn], dp[maxn];
int par[lg][maxn];
int n, k, Comp_CNT = 1;
set<pair<int, int> > Topol_set;
stack<int> Rev;
void Add_edge(int v, int u) {
  Front_Edge[v].push_back(u);
  Back_Edge[u].push_back(v);
}
void input() {
  cin >> n >> k;
  for (int i = 1; i < n; i++) {
    cin >> par[0][i];
    par[0][i]--;
    Add_edge(par[0][i], i);
  }
}
void Update_parents() {
  for (int i = 1; i < lg; i++)
    for (int j = 0; j < n; j++) par[i][j] = par[i - 1][par[i - 1][j]];
}
void Basic_dfs(int v) {
  for (auto u : Front_Edge[v]) {
    depth[u] = depth[v] + 1;
    Basic_dfs(u);
  }
  Rev.push(v);
}
int Get_to_height(int v, int h) {
  for (int i = lg - 1; i > -1; i--)
    if (depth[par[i][v]] >= h) v = par[i][v];
  return v;
}
void Add_Extra_Edges() {
  for (int i = 1; i < n; i++)
    if (!Front_Edge[i].size()) Add_edge(i, Get_to_height(i, depth[i] - k));
}
void DFS_Back(int v) {
  for (auto u : Back_Edge[v]) {
    if (Comp[u]) continue;
    Comp[u] = Comp[v];
    DFS_Back(u);
  }
}
void Comp_Decomp() {
  while (Rev.size()) {
    int v = Rev.top();
    Rev.pop();
    if (!Comp[v]) {
      Comp[v] = Comp_CNT;
      DFS_Back(v);
      Comp_CNT++;
    }
  }
}
void Find_ans() {
  for (int i = 1; i < n; i++) {
    if (Front_Edge[i].size() == 1 and depth[Front_Edge[i][0]] < depth[i])
      Leaf_cnt[Comp[i]]++;
  }
}
void Add_Comp_Edge(int c1, int c2) {
  Component_Front[c1].push_back(c2);
  Comp_ASS[c2]++;
}
void Making_comp_tree() {
  for (int i = 0; i < n; i++)
    for (auto u : Front_Edge[i])
      if (Comp[i] != Comp[u]) Add_Comp_Edge(Comp[i], Comp[u]);
}
void Making_Topol_Set() {
  for (int i = 1; i < Comp_CNT; i++) {
    Topol_set.insert(make_pair(Comp_ASS[i], i));
  }
}
void Dec(int C) {
  auto A = Topol_set.find(make_pair(Comp_ASS[C], C));
  Topol_set.erase(A);
  Comp_ASS[C]--;
  Topol_set.insert(make_pair(Comp_ASS[C], C));
}
int Updating() {
  int Ans = 0;
  while (Topol_set.size()) {
    pair<int, int> P = *(Topol_set.begin());
    Topol_set.erase(Topol_set.begin());
    int c = P.second;
    dp[c] = max(dp[c], Leaf_cnt[c]);
    Ans = max(Ans, dp[c]);
    for (auto C : Component_Front[c]) {
      Dec(C);
      dp[C] = max(dp[C], Leaf_cnt[C] + dp[c]);
    }
  }
  return Ans;
}
void solve() {
  Update_parents();
  Basic_dfs(0);
  Add_Extra_Edges();
  Comp_Decomp();
  Find_ans();
  Making_comp_tree();
  Making_Topol_Set();
  cout << Updating();
}
int main() {
  ios::sync_with_stdio(false);
  cout.tie(0);
  cin.tie(0);
  input();
  solve();
}
