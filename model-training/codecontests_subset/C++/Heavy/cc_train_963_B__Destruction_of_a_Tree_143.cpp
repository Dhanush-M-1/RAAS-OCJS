#include <bits/stdc++.h>
using namespace std;
const int MAX = 2e5;
int n;
list<int> children[MAX];
vector<int> solution;
int degree[MAX];
int root;
void Init() {
  for (int i = 0; i < n; i++) {
    degree[i] = 0;
  }
}
void dfsd(int node) {
  solution.push_back(node);
  for (auto it = children[node].begin(); it != children[node].end();) {
    int child = *it;
    dfsd(child);
    it = children[node].erase(it);
  }
}
bool dfs(int node) {
  bool res = false;
  for (auto it = children[node].begin(); it != children[node].end();) {
    int child = *it;
    bool tmpres = dfs(child);
    if (tmpres) {
      it++;
      continue;
    }
    degree[node]--;
    it = children[node].erase(it);
  }
  if (degree[node] % 2 == 0) {
    dfsd(node);
  } else {
    res = true;
  }
  return res;
}
void Solve() {
  if (dfs(root)) {
    printf("NO");
  } else {
    printf("YES\n");
    for (int node : solution) {
      printf("%d\n", node + 1);
    }
  }
}
int main() {
  scanf("%d", &n);
  Init();
  for (int i = 0; i < n; i++) {
    int parent;
    scanf("%d", &parent);
    parent--;
    if (parent < 0) {
      root = i;
    } else {
      degree[i]++;
      degree[parent]++;
      children[parent].push_back(i);
    }
  }
  Solve();
  return 0;
}
