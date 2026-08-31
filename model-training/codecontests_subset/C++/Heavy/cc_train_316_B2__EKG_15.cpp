#include <bits/stdc++.h>
using namespace std;
int indeg[1024];
int adj[1024];
bool mark[1024];
int depth[1024];
int n, id, comp;
void dfs(int x, int d) {
  comp++;
  mark[x] = true;
  depth[x] = d;
  if (adj[x] != 0) {
    indeg[adj[x]]--;
    dfs(adj[x], d + 1);
  }
}
bool dp[1024][1024];
int main() {
  memset(indeg, 0, sizeof indeg);
  int front, back;
  cin >> n >> id;
  for (int i = 1; i <= n; i++) {
    cin >> front;
    indeg[front]++;
    adj[i] = front;
  }
  int myGroup = -1;
  memset(mark, 0, sizeof mark);
  vector<int> v;
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++)
      if (indeg[j] == 0 && mark[j] == false) {
        comp = 0;
        dfs(j, 1);
        if (mark[id] == true && myGroup == -1)
          myGroup = comp;
        else
          v.push_back(comp);
      }
  }
  if (v.size()) {
    memset(dp, 0, sizeof dp);
    dp[0][0] = true;
    dp[0][v[0]] = true;
    for (int i = 1; i < v.size(); i++) {
      for (int j = 0; j < 1024; j++) {
        dp[i][j] = dp[i - 1][j];
        if (j - v[i] >= 0) dp[i][j] |= dp[i - 1][j - v[i]];
      }
    }
  }
  int Left, Right;
  Left = depth[id] - 1;
  Right = myGroup - depth[id];
  dp[0][0] = true;
  for (int i = 1; i <= n; i++) {
    front = i - 1;
    back = n - i;
    back -= Left;
    front -= Right;
    int row = max((int)v.size() - 1, 0);
    if (front >= 0 && back >= 0 && dp[row][front]) cout << i << endl;
  }
  return 0;
}
