#include <bits/stdc++.h>
using namespace std;
vector<int> ans;
vector<int> edge[(int)2E5 + 10];
stack<int> sta;
int parent[(int)2E5 + 10];
int flag[(int)2E5 + 10];
int dge[(int)2E5 + 10];
void dfs(int p, int i) {
  parent[i] = p;
  sta.push(i);
  int len = edge[i].size();
  for (int j = 0; j < len; j++) {
    int r = edge[i][j];
    if (r == p) continue;
    dfs(i, r);
  }
}
void dfs2(int i) {
  if (dge[i] % 2 == 0) {
    ans.push_back(i);
    flag[i] = 1;
    for (int j = 0; j < edge[i].size(); j++) {
      int r = edge[i][j];
      dge[r]--;
      if (r == parent[i] || flag[r]) continue;
      dfs2(r);
    }
  } else {
    for (int j = 0; j < edge[i].size(); j++) {
      int r = edge[i][j];
      if (r == parent[i] || flag[r]) continue;
      dfs2(r);
    }
  }
}
int main() {
  int n, x, heap;
  while (~scanf("%d", &n)) {
    memset(flag, 0, sizeof(flag));
    memset(parent, 0, sizeof(parent));
    memset(dge, 0, sizeof(dge));
    for (int i = 1; i <= n; i++) {
      scanf("%d", &x);
      if (x) {
        edge[i].push_back(x);
        edge[x].push_back(i);
        dge[i]++;
        dge[x]++;
      } else
        heap = i;
    }
    dfs(0, heap);
    int len = sta.size();
    for (int i = 1; i <= len; i++) {
      int point = sta.top();
      sta.pop();
      if (dge[point] % 2 == 0) {
        dfs2(point);
      }
    }
    if (ans.size() == n) {
      printf("YES\n");
      for (int i = 0; i < n; i++) printf("%d\n", ans[i]);
    } else
      printf("NO\n");
    vector<int>().swap(ans);
    for (int i = 0; i <= n; i++) vector<int>().swap(edge[i]);
    while (!sta.empty()) sta.pop();
  }
}
