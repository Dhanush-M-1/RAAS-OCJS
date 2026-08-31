#include <bits/stdc++.h>
using namespace std;
class Tree {
  int n;

 public:
  int *deg, *p;
  bool *EvenDeg, *erased;
  vector<int> *adj;
  Tree(int n);
  void AddEdge(int u, int v);
  void compEvenDeg(int x);
  void Dfs(int x);
};
int root;
Tree::Tree(int n) {
  this->n = n;
  deg = new int[n];
  p = new int[n];
  EvenDeg = new bool[n];
  erased = new bool[n];
  adj = new vector<int>[n];
  for (int i = 0; i < n; ++i) erased[i] = deg[i] = EvenDeg[i] = 0;
}
void Tree::AddEdge(int u, int v) {
  adj[u].push_back(v);
  ++deg[u];
  ++deg[v];
  p[v] = u;
}
void Tree::compEvenDeg(int u) {
  EvenDeg[u] = false;
  for (int v : adj[u]) {
    compEvenDeg(v);
    EvenDeg[u] |= (EvenDeg[v] | !(deg[v] % 2));
  }
}
void Tree::Dfs(int u) {
  bool ok = false;
  if ((deg[u] % 2 == 0) && !EvenDeg[u]) {
    erased[u] = true;
    ok = true;
    printf("%d\n", u + 1);
    if (u != root) --deg[p[u]];
  }
  for (int v : adj[u]) {
    if (erased[u]) --deg[v];
    if (!erased[v] && ((deg[v] % 2 == 0) || EvenDeg[v])) Dfs(v);
  }
  if (!erased[u] && (deg[u] % 2 == 0)) {
    erased[u] = true;
    printf("%d\n", u + 1);
    if (u != root) --deg[p[u]];
  }
  for (int v : adj[u]) {
    if (erased[u] && !ok) --deg[v];
    if (!erased[v]) Dfs(v);
  }
}
int deg[200002];
int main() {
  int n;
  scanf("%d", &n);
  if (n % 2) {
    printf("YES\n");
    Tree T(n);
    for (int u = 0, v; u < n; ++u) {
      scanf("%d", &v);
      --v;
      if (v == -1)
        root = u;
      else
        T.AddEdge(v, u);
    }
    T.compEvenDeg(root);
    T.Dfs(root);
  } else
    printf("NO\n");
  return 0;
}
