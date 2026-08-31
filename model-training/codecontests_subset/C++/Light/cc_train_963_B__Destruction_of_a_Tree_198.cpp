#include <bits/stdc++.h>
using namespace std;
const int N = 200005;
vector<int> res;
vector<int> dz[N], levels[N];
set<int> visited;
int i, j, n, ojciec[N], w, siz[N], root;
void go(int w) {
  res.push_back(w);
  visited.insert(w);
  for (int i = 0; i < dz[w].size(); i++)
    if (visited.find(dz[w][i]) == visited.end()) go(dz[w][i]);
}
void countLevels(int w, int l) {
  levels[l].push_back(w);
  for (int i = 0; i < dz[w].size(); i++) countLevels(dz[w][i], l + 1);
}
int main() {
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    dz[i].clear();
    levels[i].clear();
  }
  for (i = 1; i <= n; i++) {
    scanf("%d", &ojciec[i]);
    if (ojciec[i] != 0)
      dz[ojciec[i]].push_back(i);
    else
      root = i;
  }
  visited.clear();
  countLevels(root, 0);
  for (i = 1; i <= n; i++) siz[i] = dz[i].size() + 1;
  siz[root]--;
  for (i = n; i >= 1; i--) {
    for (j = 0; j < levels[i].size(); j++) {
      w = levels[i][j];
      if (siz[w] % 2 == 0) {
        go(w);
        siz[ojciec[w]]--;
      }
    }
  }
  if (siz[root] % 2 == 0) {
    go(root);
    printf("YES\n");
    for (i = 0; i < res.size(); i++) printf("%d\n", res[i]);
  } else {
    printf("NO\n");
  }
  return 0;
}
