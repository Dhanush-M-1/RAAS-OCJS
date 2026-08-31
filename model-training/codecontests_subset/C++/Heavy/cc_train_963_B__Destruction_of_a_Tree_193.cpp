#include <bits/stdc++.h>
using namespace std;
vector<int> gr[200005], before[200005], after[200005];
int n, root;
bool go(int now, int prv) {
  for (int i = 0; i < gr[now].size(); i++) {
    int to = gr[now][i];
    if (to == prv) continue;
    if (go(to, now))
      after[now].push_back(to);
    else
      before[now].push_back(to);
  }
  return (after[now].size() % 2 == 0);
}
void dfs(int now) {
  for (int i = 0; i < before[now].size(); i++) dfs(before[now][i]);
  printf("%d\n", now);
  for (int i = 0; i < after[now].size(); i++) dfs(after[now][i]);
}
int main() {
  int i, j;
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%d", &j);
    if (j) {
      gr[i].push_back(j);
      gr[j].push_back(i);
    } else
      root = i;
  }
  if (go(root, -1)) {
    printf("YES\n");
    dfs(root);
  } else
    printf("NO\n");
}
