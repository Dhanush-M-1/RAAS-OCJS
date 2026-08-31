#include <bits/stdc++.h>
using namespace std;
int n, m, a[100005], b[100005], te[100005], dir[100005];
int summ[100005];
bool vis[100005];
vector<pair<int, int> > V[100005];
vector<int> res[100005];
void dfs(int id, int pv) {
  vis[id] = 1;
  for (int i = (0); i <= ((int)V[id].size() - 1); i++) {
    pair<int, int> to = V[id][i];
    if (to.first == pv || vis[to.first]) continue;
    te[to.second] = 1;
    dfs(to.first, id);
  }
  return;
}
void dfs2(int id, int pv, int fe) {
  for (int i = (0); i <= ((int)V[id].size() - 1); i++) {
    pair<int, int> to = V[id][i];
    if (to.first == pv || !te[to.second]) continue;
    dfs2(to.first, id, to.second);
  }
  if (summ[id] & 1) {
    dir[fe] = id;
    summ[id]++;
  } else if (fe != -1) {
    dir[fe] = a[fe] + b[fe] - id;
    summ[dir[fe]]++;
  }
  return;
}
int main() {
  scanf("%d %d", &n, &m);
  if (m & 1) {
    printf("No solution\n");
    return 0;
  }
  for (int i = (1); i <= (m); i++) {
    scanf("%d %d", &a[i], &b[i]);
    V[a[i]].push_back(make_pair(b[i], i));
    V[b[i]].push_back(make_pair(a[i], i));
  }
  dfs(1, -1);
  for (int i = (1); i <= (m); i++)
    if (!te[i]) summ[a[i]]++, dir[i] = a[i];
  dfs2(1, -1, -1);
  for (int i = (1); i <= (m); i++) res[dir[i]].push_back(a[i] + b[i] - dir[i]);
  for (int i = (1); i <= (n); i++) {
    for (int j = 0; j < res[i].size(); j += 2)
      printf("%d %d %d\n", res[i][j], i, res[i][j + 1]);
  }
  return 0;
}
