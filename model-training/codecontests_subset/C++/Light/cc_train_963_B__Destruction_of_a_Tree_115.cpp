#include <bits/stdc++.h>
using namespace std;
const int Nmax = 1000005;
int n, v[Nmax], degree[Nmax], solved[Nmax];
vector<int> L[Nmax], Depend[Nmax], Sol;
void deleteNode(int node) {
  solved[node] = 1;
  Sol.push_back(node);
  for (auto it : L[node]) --degree[it];
}
void clearNode(int node) {
  deleteNode(node);
  for (auto it : Depend[node]) clearNode(it);
}
void dfs(int node, int tata) {
  vector<int> Bad, Good;
  for (auto it : L[node]) {
    if (it == tata) continue;
    dfs(it, node);
    if (solved[it]) continue;
    Depend[node].push_back(it);
  }
  if (degree[node] % 2 == 0) clearNode(node);
}
int main() {
  scanf("%d", &n);
  int rad;
  for (int i = 1; i <= n; i++) {
    int x;
    scanf("%d", &x);
    if (x == 0)
      rad = i;
    else {
      L[x].push_back(i);
      L[i].push_back(x);
      degree[i]++;
      degree[x]++;
    }
  }
  dfs(rad, 0);
  if (Sol.size() < n) {
    cout << "NO\n";
    return 0;
  }
  cout << "YES\n";
  for (auto it : Sol) cout << it << "\n";
  return 0;
}
