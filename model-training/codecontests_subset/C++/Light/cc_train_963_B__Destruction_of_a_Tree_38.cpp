#include <bits/stdc++.h>
using namespace std;
int n, root, p[200001];
vector<int> ans, ch[200001], before[200001], after[200001];
bool vis[200001], par[200001];
void dfs(int u) {
  if (ch[u].size() == 0) {
    par[u] = false;
    return;
  }
  for (int c : ch[u]) {
    dfs(c);
    if (par[c])
      before[u].push_back(c);
    else
      after[u].push_back(c);
  }
  par[u] = after[u].size() % 2;
}
void get_ans(int u) {
  for (int c : before[u]) get_ans(c);
  ans.push_back(u);
  for (int c : after[u]) get_ans(c);
}
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    ch[i] = vector<int>();
    before[i] = vector<int>();
    after[i] = vector<int>();
  }
  for (int i = 0; i < n; i++) {
    scanf("%d", &p[i]);
    p[i]--;
    if (p[i] >= 0)
      ch[p[i]].push_back(i);
    else
      root = i;
  }
  dfs(root);
  if (par[root]) {
    printf("NO\n");
    return 0;
  }
  ans = vector<int>();
  get_ans(root);
  printf("YES\n%d", ans[0] + 1);
  for (int i = 1; i < n; i++) printf(" %d", ans[i] + 1);
  printf("\n");
}
