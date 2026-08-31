#include <bits/stdc++.h>
using namespace std;
int n, m, q;
int dad[300100], ran[300100], bst[300100];
int fin(int pos) {
  if (pos == dad[pos]) return pos;
  return dad[pos] = fin(dad[pos]);
}
void unir(int b1, int b2) {
  if (b1 == b2) return;
  int t1 = bst[b1] / 2 + (bst[b1] % 2);
  t1 += bst[b2] / 2 + (bst[b2] % 2) + 1;
  t1 = max(t1, max(bst[b1], bst[b2]));
  if (ran[b1] <= ran[b2]) {
    if (ran[b1] == ran[b2]) ran[b2]++;
    dad[b1] = dad[b2];
    bst[b2] = t1;
  } else {
    dad[b2] = dad[b1];
    bst[b1] = t1;
  }
}
bool vis[300100];
vector<int> adj[300100];
int sl, vl = 0;
void dfs(int pos, int dad, int lvl) {
  vis[pos] = true;
  if (lvl > vl) {
    sl = pos;
    vl = lvl;
  }
  for (int i = 0; i < adj[pos].size(); i++)
    if (adj[pos][i] != dad) {
      unir(fin(pos), fin(adj[pos][i]));
      dfs(adj[pos][i], pos, lvl + 1);
    }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> m >> q;
  for (int i = 1; i <= n; i++) dad[i] = i;
  int tip, t1, t2;
  for (int i = 0; i < m; i++) {
    cin >> t1 >> t2;
    adj[t1].push_back(t2);
    adj[t2].push_back(t1);
  }
  for (int i = 1; i <= n; i++)
    if (!vis[i]) {
      vl = 0;
      dfs(i, i, 0);
      vl = 0;
      dfs(sl, sl, 0);
      bst[fin(sl)] = vl;
    }
  while (q--) {
    cin >> tip >> t1;
    if (tip == 2) {
      cin >> t2;
      unir(fin(t1), fin(t2));
    } else
      cout << bst[fin(t1)] << "\n";
  }
  return 0;
}
